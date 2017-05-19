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
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//�����������
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
				msg = "��ϲ�㣬��ӭ"+userName+"����!";				
			}else{
				msg = "�Բ����û����������벻��ȷ";	
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
