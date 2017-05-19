package cn.edu.zhku.zheng.user.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.zheng.user.User;
import cn.edu.zhku.zheng.user.Service.LoginService;

public class LoginCtrl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginService ls = new LoginService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//获得输入数据
		User user  = new User();
		
		String userName = (String)request.getParameter("userName");
		String userPassword =(String) request.getParameter("userPassword");
		
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		
		boolean checkResult = false ;
		String msg = null;
		RequestDispatcher rd = null;
		
		try{
			checkResult = ls.checkUserNameAndPassword(user);
			if(checkResult == true){
				msg = "恭喜你，欢迎"+userName+"光临!";				
			}else{
				msg = "对不起，用户名或者密码不正确";	
				System.out.println(msg);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			rd = request.getRequestDispatcher("../result.jsp");
			request.setAttribute("MSG", msg);
			rd.forward(request, response);
			
		}
		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
