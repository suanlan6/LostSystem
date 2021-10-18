package com.lostsearch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public  Result bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：",e.getErrorMsg());
        return Result.fail(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public  Result exceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e){
        logger.error("发生验证错误！原因是：",e);
        BindingResult br = e.getBindingResult();
        ObjectError objectError = br.getAllErrors().stream().findFirst().get();
        return Result.fail(objectError.getDefaultMessage());
    }

    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return Result.fail(CommonEnum.BODY_NOT_MATCH);
    }


    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("其他异常！原因是:",e);
        return Result.fail(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
