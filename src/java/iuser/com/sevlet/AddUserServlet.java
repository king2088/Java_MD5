/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuser.com.sevlet;

import iuser.com.db.User;
import iuser.com.md5.Md5Salt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AddUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            User User=new User();
            
            String uname = request.getParameter("uname");
            if(!"".equals(uname)){
            
            String pwd =  request.getParameter("pwd");
            //pwd混淆加密
            String keya="@#$&*1029we";
            String keyb="})*vbks!1214";
            String str =keya+uname+pwd+keyb;
            String cpwd="%^&*@#"+Md5Salt.getMD5(str.getBytes())+"673!8@3$9&2";
            String password = "//*"+Md5Salt.encodeBase64(cpwd.getBytes()).replaceAll("X","8").replaceAll("==","*//").replaceAll("R","|").replaceAll("r","|").replaceAll("W","-").replaceAll("2","e").replaceAll("m","c").replaceAll("J","Es").replaceAll("6","*").replaceAll("N","*");
            
            
            
            String sex = request.getParameter("sex");
            String tel = request.getParameter("tel");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            
            
            User.setUname(uname);
            User.setPwd(password);
            User.setSex(sex);
            User.setTel(tel);
            User.setAddress(address);
            User.setEmail(email);
            if(User.add())
            {
                out.println("<h1>用户注册成功</h1>");
                out.println("注册信息如下<br>"+"用户名："+uname+"<br>密码："+pwd+"<br>性别："+sex+"<br>地址："+address+"<br>email："+email+"<br>电话："+tel);
            }
            else
            {
                out.println("注册失败，请重试"+uname+password+sex+tel+address+email);  
            }
            
            
            
            }else{
            out.println("用户名不能为空"+uname);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
