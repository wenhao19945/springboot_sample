package com.example.its.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: PageDTO
 * @Author: karen
 * @Description: 分页插件
 * @Date Created in 2020/12/24 14:23
 * @Modified By:
 */
@Setter
@Getter
@ToString
public class PageDTO {

  @ApiModelProperty(value = "起始页码(从0开始)", example = "0")
  private Integer page;

  @ApiModelProperty(value = "每页数量", example = "5")
  private Integer size;

}
