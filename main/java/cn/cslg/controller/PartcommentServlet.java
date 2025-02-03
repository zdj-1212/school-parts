package cn.cslg.controller;

import cn.cslg.model.Partcomment;
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

@WebServlet("/PartcommentServlet")
public class PartcommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String action=request.getParameter("action");
        if("pro1".equals(action))
        {
            String pro=request.getParameter("pro");
            if(pro==null||"".equals(pro)||"null".equals(pro))
            {
                out.print("<script>\n" +
                        "    alert(\"评论不能为空\")\n" +
                        "    window.location.href=\"index.jsp\"\n" +
                        "</script>");
            }
            else {
                Integer id=Integer.parseInt( request.getParameter("id"));
                Partcomment partcomment=new Partcomment();
                partcomment.setComment(pro);
                partcomment.setBid(id);
                PartcommentService partcommentService=new PartcommentServiceImpl();
                List<Partcomment> list=partcommentService.showList();
                int zid=1;
                for(Partcomment p:list)
                {
                    if(p.getId()!=zid)
                    {
                        break;
                    }
                    else {
                        zid++;
                    }
                }
                partcomment.setId(zid);
                Integer row= partcommentService.savePartcomment(partcomment);
                if(row>0)
                {
                    out.print("<script>\n" +
                            "    alert(\"评论成功\")\n" +
                            "    window.location.href=\"index.jsp\"\n" +
                            "</script>");
                }
                else
                {
                    out.print("<script>\n" +
                            "    alert(\"评论失败\")\n" +
                            "    window.location.href=\"index.jsp\"\n" +
                            "</script>");
                }
            }


        }
        else if("pro2".equals(action))
        {
            Integer id=Integer.parseInt( request.getParameter("id"));
            PartcommentService partcommentService=new PartcommentServiceImpl();
            List<Partcomment>  partcommentList=partcommentService.getByid(id);
            HttpSession session=request.getSession();
            session.setAttribute("partcommentList",partcommentList);
            response.sendRedirect(request.getContextPath()+"/partcom.jsp");
        }
        else if("shanchu".equals(action))
        {
            Integer id=Integer.parseInt(request.getParameter("id")) ;
            Integer bid=Integer.parseInt(request.getParameter("bid")) ;
            PartcommentService partcommentService=new PartcommentServiceImpl();
            int row=partcommentService.deleteByid(id);
            if(row>0)
            {
                List<Partcomment>  partcommentList=partcommentService.getByid(bid);
                HttpSession session=request.getSession();
                session.setAttribute("partcommentList",partcommentList);
                out.print("<script>\n" +
                    "    alert(\"删除成功\")\n" +
                    "    window.location.href=\"partcom.jsp\"\n" +
                    "</script>");
            }
            else {
                out.print("<script>\n" +
                        "    alert(\"删除失败\")\n" +
                        "    window.location.href=\"partcom.jsp\"\n" +
                        "</script>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}