package cn.edu.zhku.zheng.user.Service;

import cn.edu.zhku.zheng.user.User;
import cn.edu.zhku.zheng.user.Dao.LoginDao;

public class LoginService {
	
	
    public boolean checkUserNameAndPassword(User user) throws Exception{
    	LoginDao ld = new LoginDao();
    	
    	boolean result = false;
    	User newUser = new User();
    	
    	newUser = ld.getUserByName(user);
    	
    	//�������ֵ��Ϊ�գ���ʾ���Եõ�һ���û�����������ƥ���ֵ
    	if( newUser.getUserName() != null){
    		result = true;
    	}
    	
    	return result;
    }
    
    
    public static void main(String[] args) {
    	
    	LoginDao ld = new LoginDao();
    	
		try {
			if(ld.judge("zheng", "jianhua")){
				System.out.println("��¼�ɹ���");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
