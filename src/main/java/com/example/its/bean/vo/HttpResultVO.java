package com.example.its.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: ControllerException
 * @Author: lixin
 * @Description: 接口统一返回结果
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Getter
@Setter
@ToString
@ApiModel("接口统一返回结果")
public class HttpResultVO<T> {
	
	@ApiModelProperty(value = "返回码")
	private String code;

	@ApiModelProperty(value = "附加消息")
	private String msg;

	@ApiModelProperty(value = "附加数据")
	private T data;
	
	
	public HttpResultVO() {
		code = "200" ;
		msg = "success";
	}
	
	public static HttpResultVO ok() {
		HttpResultVO r = new HttpResultVO();
		return r;
	}
	public static HttpResultVO ok(Object data) {
		HttpResultVO r = new HttpResultVO();
		r.setData(data);
		return r;
	}
	public static HttpResultVO ok(Object data, String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setData(data);
		r.setMsg(msg);
		return r;
	}
	public static HttpResultVO ok(String code, Object data, String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setCode(code);
		r.setData(data);
		r.setMsg(msg);
		return r;
	}
	
	public static HttpResultVO error() {
		HttpResultVO r = new HttpResultVO();
		r.setCode("500");
		r.setMsg("未知异常，请联系管理员");
		return r;
	}
	public static HttpResultVO error(String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setCode("500");
		r.setMsg(msg);
		return r;
	}
	public static HttpResultVO error(Object data, String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setCode("500");
		r.setData(data);
		r.setMsg(msg);
		return r;
	}
	public static HttpResultVO error(String code, Object data, String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setCode(code);
		r.setData(data);
		r.setMsg(msg);
		return r;
	}

}
