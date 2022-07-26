package com.example.its.controller;

import com.example.its.bean.dto.DemoDTO;
import com.example.its.bean.dto.PageDTO;
import com.example.its.bean.model.DemoModel;
import com.example.its.bean.vo.DemoVO;
import com.example.its.bean.vo.HttpResultVO;
import com.example.its.bean.vo.PageVO;
import com.example.its.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IDemoDao
 * @Author: lixin
 * @Description: dao orm操作接口
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/demo")
@Api(tags = "Demo接口测试")
public class DemoController {

  private static final Integer TEN = 10;

  @Autowired
  private DemoService dmService;

  @PostMapping(value = "/findObjects")
  @ApiOperation(value = "Demo列表返回", notes = "列表返回")
  public HttpResultVO<DemoVO> findObjects(DemoDTO demoDTO) {

    // 给model 对象赋值
    DemoModel demoModel = new DemoModel();
    BeanUtils.copyProperties(demoDTO, demoModel);

    //统一结果返回
    return HttpResultVO.ok(dmService.findObjects(demoModel));
  }

  @PostMapping(value = "/findObjectsByPage")
  @ApiOperation(value = "Demo多条件查询列表分页", notes = "多条件查询列表分页")
  public HttpResultVO<PageVO<DemoVO>> findObjectsByPage(PageDTO pm, DemoDTO demoDTO) {

    // 给model 对象赋值
    DemoModel demoModel = new DemoModel();
    BeanUtils.copyProperties(demoDTO, demoModel);

    return HttpResultVO.ok(dmService.page(pm, demoModel));

  }

  @ApiOperation(value = "Demo列表返回2", notes = "列表返回2")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户ID", dataType = "String"),
      @ApiImplicitParam(name = "name", value = "名字", dataType = "String")
  })
  @PostMapping(value = "/findObjects2")
  public HttpResultVO findObjects2(@RequestParam(defaultValue = "1") String id, String name) {

    return HttpResultVO.ok(dmService.findObjects2(id, name));
  }

  @PostMapping(value = "/saveObject")
  @ApiOperation(value = "Demo保存数据", notes = "保存数据")
  public HttpResultVO<Integer> saveObject(@RequestBody DemoDTO demoDTO) {

    // 给model 对象赋值
    DemoModel demoModel = new DemoModel();
    BeanUtils.copyProperties(demoDTO, demoModel);

    return HttpResultVO.ok(dmService.saveObject(demoModel));
  }

  @PostMapping(value = "/updateObject")
  @ApiOperation(value = "Demo更新数据", notes = "更新数据")
  public HttpResultVO<DemoModel> updateObject(@RequestBody DemoDTO demoDTO) {

    // 给model 对象赋值
    DemoModel demoModel = new DemoModel();
    BeanUtils.copyProperties(demoDTO, demoModel);

    return HttpResultVO.ok(dmService.updateObject(demoModel));
  }

  @ApiOperation(value = "经典Map查询（Swagger暂不支持）", notes = "经典Map查询")
  @PostMapping(value = "/findObjectsByMap")
  public HttpResultVO<List<Map<String, Object>>> findObjectsByMap(@RequestParam Map<String, Object> map) {
    return HttpResultVO.ok(dmService.findObjectsByMap(map));
  }

  @PostMapping(value = "/testRest")
  @ApiOperation(value = "DemoHttp请求发送")
  public HttpResultVO testRest() throws UnsupportedEncodingException {

    Object obj = dmService.testRest();

    return HttpResultVO.ok(obj);
  }


  @PostMapping(value = "/testException")
  @ApiOperation(value = "Demo统一异常", notes = "统一异常")
  public void testException() throws Exception {

    throw new Exception("测试统一异常返回");
  }


  @GetMapping(value = "/testAsync")
  @ApiOperation(value = "Demo异步方法")
  public HttpResultVO testAsync() {

    for (int i = 0; i < TEN; i++) {
      dmService.execAsyncFunc();
    }
    return HttpResultVO.ok();
  }

}
