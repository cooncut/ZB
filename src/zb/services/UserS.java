package zb.services;

import zb.models.User;

/**
 * 用户业务操作
 * 
 * @author wenjizou
 * 
 */
public class UserS {

	private static final User dao = User.dao;

	public User findUser(String username, String password) {
		String sql = "select * from t_user where email = ? and password = ?";
		return dao.findFirst(sql, username, password);
	}

}
