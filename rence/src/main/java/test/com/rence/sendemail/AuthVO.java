package test.com.rence.sendemail;

import java.util.Date;

public class AuthVO {
	
	private String auth_no;
	private String user_email;
	private String auth_code;
	private Date auth_stime;
	
	
	public AuthVO() {
		// TODO Auto-generated constructor stub
	}


	public AuthVO(String auth_no, String user_email, String auth_code, Date auth_stime) {
		super();
		this.auth_no = auth_no;
		this.user_email = user_email;
		this.auth_code = auth_code;
		this.auth_stime = auth_stime;
	}


	public String getAuth_no() {
		return auth_no;
	}


	public void setAuth_no(String auth_no) {
		this.auth_no = auth_no;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getAuth_code() {
		return auth_code;
	}


	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}


	public Date getAuth_stime() {
		return auth_stime;
	}


	public void setAuth_stime(Date auth_stime) {
		this.auth_stime = auth_stime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth_code == null) ? 0 : auth_code.hashCode());
		result = prime * result + ((auth_no == null) ? 0 : auth_no.hashCode());
		result = prime * result + ((auth_stime == null) ? 0 : auth_stime.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthVO other = (AuthVO) obj;
		if (auth_code == null) {
			if (other.auth_code != null)
				return false;
		} else if (!auth_code.equals(other.auth_code))
			return false;
		if (auth_no == null) {
			if (other.auth_no != null)
				return false;
		} else if (!auth_no.equals(other.auth_no))
			return false;
		if (auth_stime == null) {
			if (other.auth_stime != null)
				return false;
		} else if (!auth_stime.equals(other.auth_stime))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AuthVO [auth_no=" + auth_no + ", user_email=" + user_email + ", auth_code=" + auth_code
				+ ", auth_stime=" + auth_stime + "]";
	}



	
}
