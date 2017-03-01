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
public class Login extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            User User=new User();
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            //pwd混淆加密
            String keya="@#$&*1029we";
            String keyb="})*vbks!1214";
            String str =keya+uname+pwd+keyb;
            String cpwd="%^&*@#"+Md5Salt.getMD5(str.getBytes())+"673!8@3$9&2";
            String password = "//*"+Md5Salt.encodeBase64(cpwd.getBytes()).replaceAll("X","8").replaceAll("==","*//").replaceAll("R","|").replaceAll("r","|").replaceAll("W","-").replaceAll("2","e").replaceAll("m","c").replaceAll("J","Es").replaceAll("6","*").replaceAll("N","*");
            
            
            
            User.setUname(uname);
            User.setPwd(password);
            
            if(User.valid()){
                out.println("<h1>登录成功</h1>");
                out.print("已经获得您的注册信息"+"用户名："+User.uname+"<br>性别："+User.sex+"<br>地址："+User.address+"<br>email："+User.email+"<br>电话："+User.tel);
            }
            else{
                out.println("登录失败");
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
