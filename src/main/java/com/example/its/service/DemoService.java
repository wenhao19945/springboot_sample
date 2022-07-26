package com.example.its.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.its.bean.dto.PageDTO;
import com.example.its.bean.model.DemoModel;
import com.example.its.bean.vo.DemoVO;
import com.example.its.bean.vo.HttpResultVO;
import com.example.its.bean.vo.PageVO;
import com.example.its.dao.IDemoDao;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: DemoService
 * @Author: wenhao
 * @Description: demo 业务处理类
 * @Date Created in 2020/12/24 14:36
 * @Modified By:
 */
@Slf4j
@Service
public class DemoService {

  @Value("${com.example.url.aliyun}")
  private String aliyunUrl;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private IDemoDao demoDao;

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  /**
   * 查询列表
   *
   * @param demoModel 请求对象
   * @return List 列表
   */
  public List<DemoVO> findObjects(DemoModel demoModel) {
    redisTemplate.opsForHash().put("db001", "key", "val");
    String val = redisTemplate.opsForHash().get("db001", "key").toString();
    redisTemplate.opsForValue().set("key-1", "abc", 10, TimeUnit.SECONDS);
    return demoDao.findObjects(demoModel);
  }

  /**
   * 分页
   *
   * @param pageDTO 分页请求参数
   * @param queryMap 查询条件
   */
  public PageVO page(PageDTO pageDTO, DemoModel queryMap) {
    PageHelper.startPage(pageDTO.getPage() + 1, pageDTO.getSize());

    PageInfo<DemoVO> appsPageInfo = new PageInfo<>(
        demoDao.findObjects(queryMap)
    );

    PageVO<DemoVO> pageVO = new PageVO();
    pageVO.setTotalElements(appsPageInfo.getTotal());
    pageVO.setContent(appsPageInfo.getList());
    return pageVO;
  }

  /**
   * 对象条件查询
   */
  public DemoVO findObjects2(String id, String name) {
    return demoDao.findObject(id, name);
  }

  /**
   * 保存对象
   */
  public int saveObject(DemoModel dm) {

    return demoDao.saveObject(dm);
  }

  /**
   * 修改对象
   */
  public int updateObject(DemoModel dm) {

    return demoDao.updateObject(dm);
  }

  /**
   * map 查询对象
   */
  public List<Map<String, Object>> findObjectsByMap(Map<String, Object> map) {
    return demoDao.findObjectsByMap(map);
  }

  /**
   * http 请求
   */
  public Object testRest() throws UnsupportedEncodingException {
    String encodeKey = URLEncoder.encode("中文", "UTF-8");

    String url = aliyunUrl + encodeKey;

    return HttpResultVO.ok(restTemplate.getForObject(url, String.class));
  }

  /**
   * 异步请求对象
   */
  @Async
  public void execAsyncFunc() {

    int s = (int) (1 + Math.random() * 10);

    try {
      Thread.sleep(s * 1000);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }

    log.info("模拟执行了{}秒", s);
  }
}
