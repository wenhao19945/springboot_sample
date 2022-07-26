package com.sutpc.its.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: DemoVO
 * @Author: lixin
 * @Description:
 * @Date Created in 2020/12/24 14:33
 * @Modified By:
 */
@Setter
@Getter
@ToString
@ApiModel("Demo返回对象")
public class DemoVO {

  @ApiModelProperty(value = "id")
  private String id;

  @ApiModelProperty(value = "邮箱")
  private String mail;

  @ApiModelProperty(value = "名称")
  private String name;

}
