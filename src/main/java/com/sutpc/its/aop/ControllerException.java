package com.sutpc.its.aop;

import com.sutpc.its.bean.vo.HttpResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ControllerException
 * @Author: lixin
 * @Description: 统一异常处理类
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@ControllerAdvice
public class ControllerException {
	
	//统一异常

	private Logger logger = LoggerFactory.getLogger(ControllerException.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public HttpResultVO errorHandler(Exception ex) {

		logger.error(ex.getMessage()+getStackMsg(ex));		

		return HttpResultVO.error("系统异常");
	}

	private String getStackMsg(Exception e) {

		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stackArray = e.getStackTrace();
		for (int i = 0; i < stackArray.length; i++) {
			StackTraceElement element = stackArray[i];
			sb.append(element.toString() + "\n");
		}
		return sb.toString();
	}
	
/*
	private String getStackMsg(Throwable e) {  
  
        StringBuffer sb = new StringBuffer();  
        StackTraceElement[] stackArray = e.getStackTrace();  
        for (int i = 0; i < stackArray.length; i++) {  
            StackTraceElement element = stackArray[i];  
            sb.append(element.toString() + "\n");  
        }  
        return sb.toString(); 
        
	}
*/
	
}
