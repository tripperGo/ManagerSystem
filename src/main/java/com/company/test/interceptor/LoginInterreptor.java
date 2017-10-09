package com.company.test.interceptor;

import com.company.test.model.SysUser;
import com.company.test.utils.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhaochuanzhen
 * @desc 登录拦截器
 * @time 21:39 2017/10/9
 */
public class LoginInterreptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        //获取访问URL
        String url = request.getRequestURI();
        List<String> openUrls = ResourcesUtil.gekeyList("anonymousURL");
        //放行公开地址
        for (String openUrl : openUrls) {
            if (url.indexOf(openUrl) >= 0) {
                return true;
            }
        }
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
