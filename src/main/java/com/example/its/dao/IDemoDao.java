package com.example.its.dao;

import com.example.its.bean.model.DemoModel;
import com.example.its.bean.vo.DemoVO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @ClassName: IDemoDao
 * @Author: karen
 * @Description: dao orm操作接口
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Mapper
@Component
public interface IDemoDao {

  /**
   * 查询列表
   * @param map 查询参数
   * @return List
   */
  List<Map<String, Object>> findObjectsByMap(Map<String, Object> map);

  /**
   * 返回list
   * @param dm 查询参数
   * @return
   */
  List<DemoVO> findObjects(DemoModel dm);

  /**
   * 保存 对象
   * @param dm 保存对象参数
   * @return int
   */
  int saveObject(DemoModel dm);

  /**
   * 修改
   * @param dm 修改对象参数
   * @return int
   */
  int updateObject(DemoModel dm);

  /**
   * 查询对象
   * @param id id
   * @param name 名称
   * @return DemoVO demo 实体对象
   */
  DemoVO findObject(@Param("id") String id, @Param("name") String name);
}
