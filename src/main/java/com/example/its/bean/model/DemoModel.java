package com.example.its.bean.model;

import com.example.its.bean.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: DemoModel
 * @Author: karen
 * @Description: demo实体
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Setter
@Getter
@ToString
public class DemoModel extends BaseModel {

  private String mail;

  private String name;

}
