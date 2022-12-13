package com.example.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DB.UserDAO;
import com.example.DB.UserDTO;


@Controller
public class LoginController {
	@RequestMapping(value = "/signinCheck")
	public String signinCheck(HttpServletRequest request, Model model) {
		System.out.println("login check");
		model.addAttribute("request", request);

		int result = execute(model);

		if (1 == result) {
			return "/home2";
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
			request.setAttribute("url", "index");
		}

		return "/alert";
	}
	
	@Autowired
	private UserDAO dao;

	public int execute(Model model) {
		System.out.println("SignCheck");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		int result = dao.signinCheck(id, pw);
		if (1 == result) {
			System.out.println("login success");

			List<UserDTO> dto = dao.signInInfo(id);
			for (UserDTO user : dto) {
				session.setAttribute("u_id", user.getU_id());
				session.setAttribute("u_uid", user.getU_uid());
				session.setAttribute("u_pw", user.getU_pw());
				session.setAttribute("u_mode", user.getU_mode());
			}
		} else {
			System.out.println("Login Fail");
		}
		return result;
	}
}