package com.yanglei.restfulcrud.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: loginHandlerInterceptor
 * @Description: TODO 登陆检查
 * @Author: Yanglei
 * @Date: 2020/7/5 15:28
 * @Version: V1.0
 */
@Component
public class loginHandlerInterceptor implements HandlerInterceptor {
    /**
    * @Description TODO 方法执行之前
    * @Date 15:31 2020/7/5
    * @Param [request, response, handler]
    * @return boolean
    **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginuser");
        if (user == null){
            request.setAttribute("Exception", "没有权限访问，请先登录！");
            //取到转发器
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
