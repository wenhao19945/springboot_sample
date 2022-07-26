package com.example.its.bean.dto;

import com.example.its.bean.model.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: DemoDTO
 * @Author: lixin
 * @Description: demo实体
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Setter
@Getter
@ToString
@ApiModel("Demo请求对象")
public class DemoDTO extends BaseModel {

  @ApiModelProperty(value = "id")
  private String id;

  @ApiModelProperty(value = "邮箱")
  private String mail;

  @ApiModelProperty(value = "名称")
  private String name;
}
