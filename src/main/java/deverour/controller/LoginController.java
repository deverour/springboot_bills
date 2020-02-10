package deverour.controller;


import deverour.domain.User;
import deverour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private UserService UserService;
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) throws Exception {
        System.out.println("controller:login");
        String username = request.getParameterValues("username")[0];
        String password = request.getParameterValues("password")[0];
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = UserService.login(user);
        if(loginUser != null){
            //登录成功
            //将用户存入session
            request.setAttribute("login_msg","");
            httpSession.setAttribute("user",loginUser);
            System.out.println("登录成功");
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/bills/list.html");
        }else{
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录页面
            response.sendRedirect(request.getContextPath());
            //request.getRequestDispatcher(request.getContextPath()+"/bills/login.html").forward(request,response);
        }
    }




}
