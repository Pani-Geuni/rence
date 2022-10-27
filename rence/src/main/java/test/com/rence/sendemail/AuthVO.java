package test.com.rence.sendemail;

import java.util.Date;

public class AuthVO {
	
	private String auth_no;
	private String user_email;
	private String auth_code;
	private Date auth_stime;
	private Date auth_etime;

	private String reciver;
	private String subject;
	private String content;
	
	
	public AuthVO() {
		// TODO Auto-generated constructor stub
	}
	


	public AuthVO(String auth_no, String user_email, String auth_code, Date auth_stime, Date auth_etime, String reciver,
			String subject, String content) {
		super();
		this.auth_no = auth_no;
		this.user_email = user_email;
		this.auth_code = auth_code;
		this.auth_stime = auth_stime;
		this.auth_etime = auth_etime;
		this.reciver = reciver;
		this.subject = subject;
		this.content = content;
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


	public Date getAuth_etime() {
		return auth_etime;
	}


	public void setAuth_etime(Date auth_etime) {
		this.auth_etime = auth_etime;
	}


	public String getReciver() {
		return reciver;
	}


	public void setReciver(String reciver) {
		this.reciver = reciver;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "AuthVO [auth_no=" + auth_no + ", user_email=" + user_email + ", auth_code=" + auth_code
				+ ", auth_stime=" + auth_stime + ", auth_etime=" + auth_etime + ", reciver=" + reciver + ", subject="
				+ subject + ", content=" + content + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth_code == null) ? 0 : auth_code.hashCode());
		result = prime * result + ((auth_etime == null) ? 0 : auth_etime.hashCode());
		result = prime * result + ((auth_no == null) ? 0 : auth_no.hashCode());
		result = prime * result + ((auth_stime == null) ? 0 : auth_stime.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((reciver == null) ? 0 : reciver.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		if (auth_etime == null) {
			if (other.auth_etime != null)
				return false;
		} else if (!auth_etime.equals(other.auth_etime))
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (reciver == null) {
			if (other.reciver != null)
				return false;
		} else if (!reciver.equals(other.reciver))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		return true;
	}
	
	
	
}
