package com.example.DB;

import java.util.HashMap;
import java.util.List;

import com.example.DB.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {


	// Sign In Check
	public int signinCheck(String id, String pw) {
		System.out.println("login check");
		System.out.println("ID : " + id + ", PW : " + pw);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("u_uid", id);
		map.put("u_pw", pw);

		int result = 1;
		System.out.println("Result : " + result);

		return result;
	}
	
	// SignIn Information
		public List<UserDTO> signInInfo(String u_uid) {
			System.out.println("user info : " + u_uid);

			return sqlSession.selectList("UserMapper.signInInfo", u_uid);
		}

	// ID Duplicate Check
	public int idDupCheck(String id) {
		System.out.println("ID duplicate check");
		System.out.println("ID : " + id);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("u_uid", id);

		return sqlSession.selectOne("UserMapper.idDupCheck", map);
	}

	// Sign Up Check
	public int signUpCheck(String id, String pw, String name, int age, String phone) {
		System.out.println("signup check");
		System.out
				.println("ID : " + id + ", PW : " + pw + ", Name : " + name + ", Age : " + age + ", Phone : " + phone);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("u_id", id);
		map.put("u_pw", pw);

		int result = 0;
		try {
			result = sqlSession.insert("UserMapper.signUp", map);
		} catch (Exception e) {
			e.printStackTrace();

			return -1;
		}
		return result;
	}

	// User List
	public List<UserDTO> userList() {
		System.out.println("========== User List ==========");
		System.out.println(sqlSession.getConfiguration());
		System.out.println(sqlSession.getConnection());

		System.out.println(sqlSession.selectList("UserMapper.userList"));
		return sqlSession.selectList("UserMapper.userList");
	}

	// Unregistered User List
	public List<UserDTO> unregUserList() {
		System.out.println("========== Unregistered User List ==========");

		return sqlSession.selectList("UserMapper.unregUserList");
	}

	// Rejection User List
	public List<UserDTO> rejUserList() {
		System.out.println("========== Rejection User List ==========");

		return sqlSession.selectList("UserMapper.rejUserList");
	}

	// User Approval
	public int userApp(String u_id) {
		System.out.println("========== User " + u_id + " is Approval ==========");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("u_id", u_id);

		int result = 0;
		try {
			result = sqlSession.update("UserMapper.userApp", map);
		} catch (Exception e) {
			e.printStackTrace();

			return -1;
		}

		return result;
	}

	// User Rejection
	public int userRej(String u_id) {
		System.out.println("========== User " + u_id + " is Rejection ==========");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("u_id", u_id);

		int result = 0;
		try {
			result = sqlSession.update("UserMapper.userBan", map);
		} catch (Exception e) {
			e.printStackTrace();

			return -1;
		}

		return result;
	}

	// User Information
	public List<UserDTO> userInfo(int u_id) {
		System.out.println("========== User Information : " + u_id + " ==========");

		return sqlSession.selectList("UserMapper.userInfo", u_id);
	}

	// Update User
	public int updateUser(String u_id, String u_pw) {
		System.out.println("========== Update User ID : " + u_id + " ==========");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("u_uid", u_id);
		map.put("u_pw", u_pw);

		return sqlSession.update("UserMapper.userUpdate", map);
	}
}