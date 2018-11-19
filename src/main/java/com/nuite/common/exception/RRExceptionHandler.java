package com.nuite.common.exception;

import com.nuite.common.utils.ResultData;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public ResultData handleRRException(RRException e){
		ResultData resultData = new ResultData();
		resultData.put("code", e.getCode());
		resultData.put("msg", e.getMessage());

		return resultData;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResultData handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return ResultData.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResultData handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return ResultData.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public ResultData handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResultData.error();
	}
}
