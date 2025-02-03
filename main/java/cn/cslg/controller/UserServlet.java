package cn.cslg.controller;
import cn.cslg.model.Parts;
import cn.cslg.model.User;
import cn.cslg.service.PartsService;
import cn.cslg.service.UserService;
import cn.cslg.service.impl.PartsServiceImpl;
import cn.cslg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        UserService  userService = new UserServiceImpl();
       if("login1".equals(action))
        {
            User user=new User();
            String sno=request.getParameter("sno");
            String password=request.getParameter("password");
            user= userService.getByid(sno);
            if(user!=null&&password.equals(user.getPassword()))
            {
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("usersno",sno);
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("1");
            }
            else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("2");
            }

        }
       else if("login2".equals(action))
       {
           User user=new User();
           String sno=request.getParameter("sno");
           String password=request.getParameter("password");
           user= userService.getByid(sno);
           if(user!=null&&password.equals(user.getPassword())&&user.getFlag()==1)
           {
               HttpSession session=request.getSession();
               session.setAttribute("user",user);
               session.setAttribute("usersno",user.getSno());
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"登录成功\");\n" +
                       "    window.location.href=\"index.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"登录失败，请检查用户名和密码！\");\n" +
                       "    window.location.href=\"login.html\";\n" +
                       "</script>");
           }
       }
       else if("register".equals(action))
       {
           String sno=request.getParameter("sno");
           String name=request.getParameter("name");
           String password=request.getParameter("password");
           if("".equals(sno)||"".equals(name)||"".equals(password)||sno==null||name==null||password==null)
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"请填写完整\");\n" +
                       "    window.location.href=\"index.jsp\";\n" +
                       "</script>");
           }
           else {
               User user=new User();
               user.setSno(sno);
               user.setName(name);
               user.setPassword(password);
               user.setFlag(0);
               user.setPartid(0);
               User user1=userService.getByid(sno);
               User user2=userService.getByid1(sno);
               if(user1==null&&user2==null)
               {
                   if(userService.saveUser1(user)>0){
                       response.setContentType("text/html;charset=utf-8");
                       PrintWriter out = response.getWriter();
                       out.write("<script>\n" +
                               "    alert(\"提交注册成功\");\n" +
                               "    window.location.href=\"index.jsp\";\n" +
                               "</script>");

                   }
                   else {
                       response.setContentType("text/html;charset=utf-8");
                       PrintWriter out = response.getWriter();
                       out.write("<script>\n" +
                               "    alert(\"提交注册失败\");\n" +
                               "    window.location.href=\"index.jsp\";\n" +
                               "</script>");
                   }
               }
               else {
                   response.setContentType("text/html;charset=utf-8");
                   PrintWriter out = response.getWriter();
                   out.write("<script>\n" +
                           "    alert(\"该账号已被注册，请重新注册\");\n" +
                           "    window.location.href=\"register.jsp\";\n" +
                           "</script>");
               }
           }


       }
       else if("shenqing".equals(action))
       {
           Integer partid=Integer.parseInt( request.getParameter("id"));
           HttpSession session=request.getSession();
           User user=(User) session.getAttribute("user");
           user.setPartid(partid);
           int row=userService.updateByid(user);
           if(row>0)
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"申请兼职成功，一次只能申请一个兼职，请等待管理员同意\");\n" +
                       "    window.location.href=\"index.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"申请兼职失败\");\n" +
                       "    window.location.href=\"index.jsp\";\n" +
                       "</script>");
           }
       }
       else if("exit".equals(action))
       {
           HttpSession session=request.getSession();
           session.removeAttribute("user");
           Cookie snocookie=new Cookie("snocookie","");
           Cookie pwdcookie=new Cookie("pwdcookie","");
           snocookie.setMaxAge(0);
           pwdcookie.setMaxAge(0);
           response.addCookie(snocookie);
           response.addCookie(pwdcookie);
           response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
       else if("update".equals(action))
       {
           String jianzhi=request.getParameter("jianzhi");
           Integer partid=(Integer) request.getSession().getAttribute("partid");
           if(jianzhi!=null&&jianzhi.equals("on"))
           {
               partid=0;
           }
           User user=new User();
           user.setSno(request.getParameter("sno"));
           user.setName(request.getParameter("name"));
           user.setPartid(partid);
           user.setPassword(request.getParameter("password"));
           user.setFlag((Integer) request.getSession().getAttribute("flag"));
           int row=userService.updateByid(user);
           if(row>0)
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               HttpSession session=request.getSession();
               user=userService.getByid(user.getSno());
               session.setAttribute("user",user);
               if(user.getPartid()==0)
               {
                   session.setAttribute("partname","暂未申请兼职");
               }
              else {
                  PartsService partsService=new PartsServiceImpl();
                  Parts parts=partsService.getById(user.getPartid());
                  session.setAttribute("partname",parts.getPartname());
               }
               out.write("<script>\n" +
                       "    alert(\"更新信息成功\");\n" +
                       "    window.location.href=\"myinfo.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"更新信息失败\");\n" +
                       "    window.location.href=\"myinfo.jsp\";\n" +
                       "</script>");
           }
       }
       else if("myinfo".equals(action))
       {
           HttpSession session=request.getSession();
           User user=(User)request.getSession().getAttribute("user");
           PartsService partsService=new PartsServiceImpl();
           Parts parts=partsService.getById(user.getPartid());
           if(parts==null)
           {
               session.setAttribute("partname","暂未申请兼职");
           }
           else {
               session.setAttribute("partname",parts.getPartname());
           }
           session.setAttribute("partid",user.getPartid());
           session.setAttribute("flag",user.getFlag());
           response.sendRedirect(request.getContextPath()+"/myinfo.jsp");
       }
       else if("adminreg".equals(action))
       {
           List<User> user;
           user=userService.showlist1();
           if(user!=null)
           {
               HttpSession session=request.getSession();
               session.setAttribute("userreg",user);
           }
           response.sendRedirect(request.getContextPath()+"/adminreg.jsp");
       }
       else if("tongyi".equals(action))
       {
           String sno=request.getParameter("sno");
           User  user=userService.getByid1(sno);
           user.setPartid(0);
           user.setFlag(0);
           int row=userService.saveUser(user);
           int row1=userService.deleteByid1(sno);
           List<User> user1;
           user1=userService.showlist1();
           if(user1!=null)
           {
               HttpSession session=request.getSession();
               session.setAttribute("userreg",user1);
           }
           if(row>0&&row1>0)
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"批准成功\");\n" +
                       "    window.location.href=\"adminreg.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"批准失败\");\n" +
                       "    window.location.href=\"adminreg.jsp\";\n" +
                       "</script>");
           }
       }
       else if("jujue".equals(action))
       {
           String sno=request.getParameter("sno");
           int row=userService.deleteByid1(sno);
           List<User> user;
           user=userService.showlist1();
           HttpSession session=request.getSession();
           session.setAttribute("userreg",user);
           if(row>0)
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"已成功拒绝\");\n" +
                       "    window.location.href=\"adminreg.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"拒绝失败\");\n" +
                       "    window.location.href=\"adminreg.jsp\";\n" +
                       "</script>");
           }
       }
       else if("adminuser".equals(action))
       {
           List<User> user;
           List<User> user1;
           String sno=(String) request.getSession().getAttribute("usersno");
           System.out.println(sno);
           user=userService.showlist2(sno);
           HttpSession session=request.getSession();
           session.setAttribute("adminuserlist",user);
           response.sendRedirect(request.getContextPath()+"/adminuser.jsp");
       }
       else if("xiangxi".equals(action))
       {
           String sno=request.getParameter("sno");
           User user=userService.getByid(sno);
           HttpSession session=request.getSession();
           PartsService partsService=new  PartsServiceImpl();
           Parts parts=partsService.getById(user.getPartid());
           if(parts!=null)
           {
               session.setAttribute("partname1",parts.getPartname());
           }
           else {
               session.setAttribute("partname1","该用户暂未申请兼职");
           }
           session.setAttribute("adminuser",user);
           session.setAttribute("partid1",user.getPartid());
           session.setAttribute("flag1",user.getFlag());
           response.sendRedirect(request.getContextPath()+"/adminuserinfo.jsp");
       }
       else if ("update1".equals(action))
       {
           String jianzhi1=request.getParameter("jianzhi1");
           Integer partid1=(Integer) request.getSession().getAttribute("partid1");
           if(jianzhi1!=null&&jianzhi1.equals("on"))
           {
               partid1=0;
           }
           HttpSession session=request.getSession();
           User user=new User();
           user.setSno(request.getParameter("sno"));
           user.setName(request.getParameter("name"));
           user.setPartid(partid1);
           user.setPassword(request.getParameter("password"));
           user.setFlag((Integer) request.getSession().getAttribute("flag1"));
           int row=userService.updateByid(user);
           if(row>0)
           {
               session.setAttribute("adminuser",user);
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"更新信息成功\");\n" +
                       "    window.location.href=\"adminuserinfo.jsp\";\n" +
                       "</script>");
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"更新信息失败\");\n" +
                       "    window.location.href=\"adminuserinfo.jsp\";\n" +
                       "</script>");
           }
       }
       else if("shanchu".equals(action))
       {
           HttpSession session=request.getSession();
           String sno=request.getParameter("sno");
           User user1=(User) request.getSession().getAttribute("user");
           int row=userService.deleteByid(sno);
           if(row>0)
           {
               List<User> userList=userService.showlist2(user1.getSno());
               session.setAttribute("adminuserlist",userList);
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"删除成功\");\n" +
                       "    window.location.href=\"adminuser.jsp\";\n" +
                       "</script>");
           }
           else
           {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"删除失败\");\n" +
                       "    window.location.href=\"adminuser.jsp\";\n" +
                       "</script>");
           }
       }
       else if("setadmin".equals(action))
       {
           HttpSession session=request.getSession();
           String sno=request.getParameter("sno");
           User user1=userService.getByid(sno);
           if(user1!=null)
           {
               user1.setFlag(1);
               int row=userService.updateByid(user1);
               if(row>0)
               {
                   List<User> userList=userService.showlist2(user1.getSno());
                   session.setAttribute("adminuserlist",userList);
                   response.setContentType("text/html;charset=utf-8");
                   PrintWriter out = response.getWriter();
                   out.write("<script>\n" +
                           "    alert(\"成功设为管理员\");\n" +
                           "    window.location.href=\"adminuser.jsp\";\n" +
                           "</script>");
               }
               else {
                   response.setContentType("text/html;charset=utf-8");
                   PrintWriter out = response.getWriter();
                   out.write("<script>\n" +
                           "    alert(\"设为管理员失败\");\n" +
                           "    window.location.href=\"adminuser.jsp\";\n" +
                           "</script>");
               }
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"设为管理员失败\");\n" +
                       "    window.location.href=\"adminuser.jsp\";\n" +
                       "</script>");
           }
       }
       else if("setuser".equals(action))
       {
           HttpSession session=request.getSession();
           String sno=request.getParameter("sno");
           User user1=userService.getByid(sno);
           if(user1!=null)
           {
               user1.setFlag(0);
               int row=userService.updateByid(user1);
               if(row>0)
               {
                   List<User> userList=userService.showlist2(user1.getSno());
                   session.setAttribute("adminuserlist",userList);
                   response.setContentType("text/html;charset=utf-8");
                   PrintWriter out = response.getWriter();
                   out.write("<script>\n" +
                           "    alert(\"成功设为会员\");\n" +
                           "    window.location.href=\"adminuser.jsp\";\n" +
                           "</script>");
               }
               else {
                   response.setContentType("text/html;charset=utf-8");
                   PrintWriter out = response.getWriter();
                   out.write("<script>\n" +
                           "    alert(\"设为会员失败\");\n" +
                           "    window.location.href=\"adminuser.jsp\";\n" +
                           "</script>");
               }
           }
           else {
               response.setContentType("text/html;charset=utf-8");
               PrintWriter out = response.getWriter();
               out.write("<script>\n" +
                       "    alert(\"设为会员失败\");\n" +
                       "    window.location.href=\"adminuser.jsp\";\n" +
                       "</script>");
           }
       }
       else if("autologin".equals(action))
       {
           User user=(User) request.getSession().getAttribute("user");
           if(user!=null)
           {
               Cookie snocookie=new Cookie("snocookie",user.getSno());
               Cookie pwdcookie=new Cookie("pwdcookie",user.getPassword());
               snocookie.setMaxAge(60*60*24*30);
               pwdcookie.setMaxAge(60*60*24*30);
               response.addCookie(snocookie);
               response.addCookie(pwdcookie);
           }
           response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
       else if("noautologin".equals(action))
       {
           Cookie snocookie=new Cookie("snocookie","");
           Cookie pwdcookie=new Cookie("pwdcookie","");
           snocookie.setMaxAge(0);
           pwdcookie.setMaxAge(0);
           response.addCookie(snocookie);
           response.addCookie(pwdcookie);
           response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
       else if("isautologin".equals(action))
       {
           String sno=null;
           String password=null;
           Cookie[] cookies = request.getCookies();
           if (cookies != null) {
               for (Cookie cookie : cookies) {
                   String name = cookie.getName();
                   String value = cookie.getValue();
                   if("snocookie".equals(name))
                   {
                       sno=value;
                   }
                   if ("pwdcookie".equals(name))
                   {
                       password=value;
                   }
               }
           }
           if(sno!=null&&password!=null)
           {
               User user=new User();
               user=userService.getByid(sno);
               HttpSession session=request.getSession();
               session.setAttribute("user",user);
               session.setAttribute("usersno",user.getSno());
           }
           response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}