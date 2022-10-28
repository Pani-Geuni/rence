/**
 * @author 강경석
 * userinfo 테이블 - mileage 테이블 조인 뷰(user_mypage_view)
 * 유저 마이페이지필요 데이터 VO
 * 
 */

package test.com.rence.user;

import java.util.Date;

public class UserMypageVO {
	
	private String user_no; //사용자 고유번호
	private String user_image; //프로필 이미지
	private String user_id; //아이디
	private String user_name; //실명
	private String user_email; //이메일
	private String user_tel; //전화번호
	private Date user_birth; //생년월일
	private int mileage_total; // 총 마일리지
	
	public UserMypageVO() {
		// TODO Auto-generated constructor stub
	}

	public UserMypageVO(String user_no, String user_image, String user_id, String user_name, String user_email,
			String user_tel, Date user_birth, int mileage_total) {
		super();
		this.user_no = user_no;
		this.user_image = user_image;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_birth = user_birth;
		this.mileage_total = mileage_total;
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

	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}

	public int getMileage_total() {
		return mileage_total;
	}

	public void setMileage_total(int mileage_total) {
		this.mileage_total = mileage_total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mileage_total;
		result = prime * result + ((user_birth == null) ? 0 : user_birth.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_image == null) ? 0 : user_image.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_no == null) ? 0 : user_no.hashCode());
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
		UserMypageVO other = (UserMypageVO) obj;
		if (mileage_total != other.mileage_total)
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
		if (user_tel == null) {
			if (other.user_tel != null)
				return false;
		} else if (!user_tel.equals(other.user_tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserMypageVO [user_no=" + user_no + ", user_image=" + user_image + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", user_email=" + user_email + ", user_tel=" + user_tel + ", user_birth="
				+ user_birth + ", mileage_total=" + mileage_total + "]";
	}

	
	
	
	
	
	
	
}//end class
