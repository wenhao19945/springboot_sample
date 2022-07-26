package com.sutpc.its.controller;

import com.sutpc.its.bean.dto.DemoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: HtmlController
 * @Author: lixin
 * @Description: 访问页面数据
 * @Date Created in 2020/12/24 15:51
 * @Modified By:
 */
@Controller
@RequestMapping("/")
@Api(tags = "thymeleaf html 页面显示")
public class HtmlController {

  @GetMapping(value = "/index")
  @ApiOperation(value = "返回静态页面", notes = "返回静态页面")
  public String index(DemoDTO demoDTO) {

    return "index";
  }

}
