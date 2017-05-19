package cn.edu.zhku.zheng.user.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.zheng.Util.ConnectionManager;
import cn.edu.zhku.zheng.user.User;

public class LoginDao {

	

	public  boolean judge(String userName, String userPassword)
			throws Exception {

		boolean flag = false;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库

		// 通过反射机制动态的引入应用的数据库的驱动
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zheng",
				"root", "");

		String sqlQuery = "Select * from user_list where user_name = ? && user_password = ?";
		ps = conn.prepareStatement(sqlQuery);

		ps.setString(1, userName);
		ps.setString(2, userPassword);

		rs = ps.executeQuery();

		// while(true){
		// boolean re = rs.next();
		// if(re==false)
		// break;
		//		   
		// String name = rs.getString("user_name");
		// String pwd = rs.getString("user_password");
		//		   
		// System.out.println(name+"-"+pwd);
		// //bianl rs
		// }
		if (rs.next()) {
			String name = rs.getString("user_name");
			String pwd = rs.getString("user_password");
			System.out.println(name + "-" + pwd);
			
			flag =true;
		}

		// boolean result = rs.next();
		//		
		// if(result == false){
		// return newUser;
		// }
		//		

		return flag;

	}

	public User getUserByName(User user) throws Exception {
		User newUser = new User();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库
		conn = ConnectionManager.getConnection();

		if (conn == null) {
			throw new Exception("数据库连接不成功！");
		}

		String sqlQuery = "Select user_name,user_password from user_list where user_name = ? && user_password = ?";
		ps = conn.prepareStatement(sqlQuery);

		ps.setString(1, user.getUserName());
		ps.setString(2, user.getUserPassword());

		rs = ps.executeQuery();
		boolean result = rs.next();

		if (result == false) {
			return newUser;
		}

		String userName = rs.getString("user_name");
		String userPassword = rs.getString("user_password");
		newUser.setUserName(userName);
		newUser.setUserPassword(userPassword);

		return newUser;
	}

}
