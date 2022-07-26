package com.sutpc.its.bean.model;

import com.sutpc.its.bean.model.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: DemoModel
 * @Author: lixin
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
