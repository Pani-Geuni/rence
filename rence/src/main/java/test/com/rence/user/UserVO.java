package test.com.rence.user;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class UserVO implements Serializable{
	private String user_no; //사용자 고유번호
	private String user_image; //프로필 이미지
	private String user_id; //아이디
	private String user_pw; //패스워드
	private String user_name; //실명
	private String user_email; //이메일
	private String user_tel; //전화번호
//	@DateTimeFormat(pattern ="yyyyMMdd")
	private String user_birth; //생년월일
	private String user_state; //회원상태
	private String auth_no; // 인증고유번호
	private  MultipartFile multipartFile; //사진저장
	
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}


	public String getUser_image() {
		return user_image;
	}


	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	public String getUser_birth() {
		return user_birth;
	}


	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}


	public String getUser_state() {
		return user_state;
	}


	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}


	public String getAuth_no() {
		return auth_no;
	}


	public void setAuth_no(String auth_no) {
		this.auth_no = auth_no;
	}


	public MultipartFile getMultipartFile() {
		return multipartFile;
	}


	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth_no == null) ? 0 : auth_no.hashCode());
		result = prime * result + ((multipartFile == null) ? 0 : multipartFile.hashCode());
		result = prime * result + ((user_birth == null) ? 0 : user_birth.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_image == null) ? 0 : user_image.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_no == null) ? 0 : user_no.hashCode());
		result = prime * result + ((user_pw == null) ? 0 : user_pw.hashCode());
		result = prime * result + ((user_state == null) ? 0 : user_state.hashCode());
		result = prime * result + ((user_tel == null) ? 0 : user_tel.hashCode());
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
		UserVO other = (UserVO) obj;
		if (auth_no == null) {
			if (other.auth_no != null)
				return false;
		} else if (!auth_no.equals(other.auth_no))
			return false;
		if (multipartFile == null) {
			if (other.multipartFile != null)
				return false;
		} else if (!multipartFile.equals(other.multipartFile))
			return false;
		if (user_birth == null) {
			if (other.user_birth != null)
				return false;
		} else if (!user_birth.equals(other.user_birth))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_image == null) {
			if (other.user_image != null)
				return false;
		} else if (!user_image.equals(other.user_image))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_no == null) {
			if (other.user_no != null)
				return false;
		} else if (!user_no.equals(other.user_no))
			return false;
		if (user_pw == null) {
			if (other.user_pw != null)
				return false;
		} else if (!user_pw.equals(other.user_pw))
			return false;
		if (user_state == null) {
			if (other.user_state != null)
				return false;
		} else if (!user_state.equals(other.user_state))
			return false;
		if (user_tel == null) {
			if (other.user_tel != null)
				return false;
		} else if (!user_tel.equals(other.user_tel))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", user_image=" + user_image + ", user_id=" + user_id + ", user_pw="
				+ user_pw + ", user_name=" + user_name + ", user_email=" + user_email + ", user_tel=" + user_tel
				+ ", user_birth=" + user_birth + ", user_state=" + user_state + ", auth_no=" + auth_no
				+ ", multipartFile=" + multipartFile + "]";
	}


	

}
