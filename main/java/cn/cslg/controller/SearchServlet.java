package cn.cslg.controller;

import cn.cslg.model.Parts;
import cn.cslg.service.PartsService;
import cn.cslg.service.impl.PartsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String search= request.getParameter("search");
        if(search==null||search.equals(""))
        {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>\n" +
                    "    alert(\"请输入要查找的关键字\");\n" +
                    "    window.location.href=\"index.jsp\";\n" +
                    "</script>");
        }
        else {
            PartsService partsService=new PartsServiceImpl();
            List<Parts> partsList=partsService.showListByName(search);
            HttpSession session=request.getSession();
            session.setAttribute("searchpartsList",partsList);
            response.sendRedirect(request.getContextPath()+"/seachParts.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}