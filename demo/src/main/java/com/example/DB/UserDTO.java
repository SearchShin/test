package com.example.DB;

public class UserDTO {

	private int u_id;
	private String u_uid;
	private String u_pw;
	private int u_mode;

	public UserDTO(int u_id, String u_uid, String u_pw, int u_mode) {
		this.u_id = u_id;
		this.u_uid = u_uid;
		this.u_pw = u_pw;
		this.u_mode = u_mode;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_uid() {
		return u_uid;
	}

	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public int getU_mode() {
		return u_mode;
	}

	public void setU_mode(int u_mode) {
		this.u_mode = u_mode;
	}

}