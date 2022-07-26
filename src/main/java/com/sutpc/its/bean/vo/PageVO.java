package com.sutpc.its.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: PageVo
 * @Author: lixin
 * @Description: 分页返回对象
 * @Date Created in 2020/12/24 15:22
 * @Modified By:
 */
@Getter
@Setter
@ToString
public class PageVO<T> {

  @ApiModelProperty(value = "总页数")
  private Long totalElements;

  @ApiModelProperty(value = "分页数据")
  private List<T> content;
}
