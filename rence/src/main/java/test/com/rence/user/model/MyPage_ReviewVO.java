package test.com.rence.user.model;

public class MyPage_ReviewVO {
	String review_no;
	String review_content;
	int review_point;
	String review_date;
	String room_name;
	String company_name;
	String user_no;
	
	
	public MyPage_ReviewVO() { }


	public MyPage_ReviewVO(String review_no, String review_content, int review_point, String review_date, String room_name,
			String company_name, String user_no) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_point = review_point;
		this.review_date = review_date;
		this.room_name = room_name;
		this.company_name = company_name;
		this.user_no = user_no;
	}


	public String getReview_no() {
		return review_no;
	}


	public void setReview_no(String review_no) {
		this.review_no = review_no;
	}


	public String getReview_content() {
		return review_content;
	}


	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}


	public int getReview_point() {
		return review_point;
	}


	public void setReview_point(int review_point) {
		this.review_point = review_point;
	}


	public String getReview_date() {
		return review_date;
	}


	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((review_content == null) ? 0 : review_content.hashCode());
		result = prime * result + ((review_date == null) ? 0 : review_date.hashCode());
		result = prime * result + ((review_no == null) ? 0 : review_no.hashCode());
		result = prime * result + review_point;
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((user_no == null) ? 0 : user_no.hashCode());
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
		MyPage_ReviewVO other = (MyPage_ReviewVO) obj;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (review_content == null) {
			if (other.review_content != null)
				return false;
		} else if (!review_content.equals(other.review_content))
			return false;
		if (review_date == null) {
			if (other.review_date != null)
				return false;
		} else if (!review_date.equals(other.review_date))
			return false;
		if (review_no == null) {
			if (other.review_no != null)
				return false;
		} else if (!review_no.equals(other.review_no))
			return false;
		if (review_point != other.review_point)
			return false;
		if (room_name == null) {
			if (other.room_name != null)
				return false;
		} else if (!room_name.equals(other.room_name))
			return false;
		if (user_no == null) {
			if (other.user_no != null)
				return false;
		} else if (!user_no.equals(other.user_no))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReviewVO [review_no=" + review_no + ", review_content=" + review_content + ", review_point="
				+ review_point + ", review_date=" + review_date + ", room_name=" + room_name + ", company_name="
				+ company_name + ", user_no=" + user_no + "]";
	}
	
}
