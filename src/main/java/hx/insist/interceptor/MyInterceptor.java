package hx.insist.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        String Uri = request.getRequestURI();
        System.out.println("访问地址是:"+Uri);

        if(Uri.indexOf("/user")>0){
            //如果是加载首页或者分页信息
            if(Uri.indexOf("/user/index")>0 ){
                return true;
            }else{
                //存在user登录信息
                if(session.getAttribute("user")!=null){
                    return true;
                }else{
                    request.getRequestDispatcher("/fitting/index").forward(request,response);
                    return false;
                }
            }
        }
        if(Uri.indexOf("/admin")>0){
            //存在admin登录信息
            if(session.getAttribute("admin")!=null){
                return true;
            }else{
                request.getRequestDispatcher("/fitting/index").forward(request,response);
                return false;
            }
        }
        if(Uri.indexOf("/superadmin")>0){
            //存在superadmin登录信息
            if(session.getAttribute("superadmin")!=null){
                return true;
            }else{
                request.getRequestDispatcher("/fitting/index").forward(request,response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
