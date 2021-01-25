package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String strId=request.getParameter("id");
        String strName=request.getParameter("name");
        String strEmail=request.getParameter("email");
        String strAge=request.getParameter("age");
        //创建spring的容器对象
//        String config="applicationContext.xml";
//        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        WebApplicationContext ctx=null;
        //获取ServletContext中的容器对象，创建好的容器对象，拿来就用（自己写的，后面使用框架写的来用）
//        String key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attr = getServletContext().getAttribute(key);
//        if(attr != null){
//            /*进行强转*/
//            ctx= (WebApplicationContext) attr;
//        }
//        容器对象的信息======org.springframework.context.support.ClassPathXmlApplicationContext@532b63df, started on Wed Jan 13 13:36:47 CST 2021

        //使用框架中的方法，获取容器对象
        ServletContext sc=getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println("容器对象的信息======"+ctx);

        //获取service
        StudentService service= (StudentService) ctx.getBean("studentService");
        Student student=new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.valueOf(strAge));
        service.addStudent(student);

        //给一个结果页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
