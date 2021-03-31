package cn.seeyourface.bootvue.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO 异常处理
 * @Author: Yanglei
 * @Date: 2021/3/31 11:48
 * @Version: V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("errorPage");
        mv.addObject("url", req.getRequestURL());
        mv.addObject("exception", e);
        return mv;
    }
}
