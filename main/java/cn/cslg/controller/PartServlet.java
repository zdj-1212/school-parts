package cn.cslg.controller;

import cn.cslg.model.Parts;
import cn.cslg.service.PartcommentService;
import cn.cslg.service.PartsService;
import cn.cslg.service.impl.PartcommentServiceImpl;
import cn.cslg.service.impl.PartsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PartServlet")
public class PartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if("show".equals(action))
        {
            HttpSession session = request.getSession();
            PartsService  partsService = new PartsServiceImpl();
            List<Parts> partsList = partsService.showList();
            session.setAttribute("partsList",partsList);
        }
        else if("issuee".equals(action))
        {
            String partname = request.getParameter("partname");
            String message=request.getParameter("message");
            if(partname!=null&&message!=null)
            {
                PartsService partsService = new PartsServiceImpl();
                List<Parts> partsList = partsService.showList();
                int zid=1;
                for(Parts p:partsList)
                {
                    if(p.getId()!=zid)
                    {
                        break;
                    }
                    else {
                        zid++;
                    }
                }
                if(zid<=partsList.size())
                {
                    Parts parts=new Parts();
                    parts.setId(zid);
                    parts.setPartname(partname);
                    parts.setMessage(message);
                    int row=partsService.savePart(parts);
                    if(row>0)
                    {
                        List<Parts> partsList1 = partsService.showList();
                        HttpSession session = request.getSession();
                        session.setAttribute("partsList",partsList1);
                        response.setContentType("text/html;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("<script>\n" +
                                "    alert(\"成功新增一个兼职\");\n" +
                                "    window.location.href=\"issuepart.jsp\";\n" +
                                "</script>");
                    }
                    else {
                        response.setContentType("text/html;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("<script>\n" +
                                "    alert(\"新增一个兼职失败\");\n" +
                                "    window.location.href=\"issuepart.jsp\";\n" +
                                "</script>");
                    }
                }
                else if(zid>=partsList.size())
                {

                    Parts parts=new Parts();
                    parts.setId(zid);
                    parts.setPartname(partname);
                    parts.setMessage(message);
                    int row=partsService.savePart(parts);
                    if(row>0)
                    {
                        List<Parts> partsList1 = partsService.showList();
                        HttpSession session = request.getSession();
                        session.setAttribute("partsList",partsList1);
                        response.setContentType("text/html;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("<script>\n" +
                                "    alert(\"成功新增一个兼职\");\n" +
                                "    window.location.href=\"issuepart.jsp\";\n" +
                                "</script>");
                    }
                    else {
                        response.setContentType("text/html;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("<script>\n" +
                                "    alert(\"新增一个兼职失败\");\n" +
                                "    window.location.href=\"issuepart.jsp\";\n" +
                                "</script>");
                    }

                }
                else {
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write("<script>\n" +
                            "    alert(\"请输入要添加的兼职\");\n" +
                            "    window.location.href=\"issuepart.jsp\";\n" +
                            "</script>");
                }
            }

        }
        else if("shanchu".equals(action))
        {
            Integer id=Integer.parseInt(request.getParameter("id"));
            PartsService partsService=new PartsServiceImpl();
            int row=partsService.deleteById(id);
            PartcommentService partcommentService=new PartcommentServiceImpl();
            partcommentService.deleteBybid(id);
            if(row>0)
            {
                List<Parts> partsList=partsService.showList();
                request.getSession().setAttribute("partsList",partsList);
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("<script>\n" +
                        "    alert(\"成功删除该兼职\");\n" +
                        "    window.location.href=\"index.jsp\";\n" +
                        "</script>");
            }
            else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("<script>\n" +
                        "    alert(\"删除该兼职失败\");\n" +
                        "    window.location.href=\"index.jsp\";\n" +
                        "</script>");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}