package test.com.rence.user.model;

public class ReviewVO {
	String review_no;
	String review_content;
	int review_point;
	String review_date;
	String room_no;
	String backoffice_no;
	String user_no;
	
	
	public ReviewVO() { }


	public ReviewVO(String review_no, String review_content, int review_point, String review_date, String room_no,
			String backoffice_no, String user_no) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_point = review_point;
		this.review_date = review_date;
		this.room_no = room_no;
		this.backoffice_no = backoffice_no;
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


	public String getRoom_no() {
		return room_no;
	}


	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}


	public String getBackoffice_no() {
		return backoffice_no;
	}


	public void setBackoffice_no(String backoffice_no) {
		this.backoffice_no = backoffice_no;
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
		result = prime * result + ((backoffice_no == null) ? 0 : backoffice_no.hashCode());
		result = prime * result + ((review_content == null) ? 0 : review_content.hashCode());
		result = prime * result + ((review_date == null) ? 0 : review_date.hashCode());
		result = prime * result + ((review_no == null) ? 0 : review_no.hashCode());
		result = prime * result + review_point;
		result = prime * result + ((room_no == null) ? 0 : room_no.hashCode());
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
		ReviewVO other = (ReviewVO) obj;
		if (backoffice_no == null) {
			if (other.backoffice_no != null)
				return false;
		} else if (!backoffice_no.equals(other.backoffice_no))
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
		if (room_no == null) {
			if (other.room_no != null)
				return false;
		} else if (!room_no.equals(other.room_no))
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
				+ review_point + ", review_date=" + review_date + ", room_no=" + room_no + ", backoffice_no="
				+ backoffice_no + ", user_no=" + user_no + "]";
	}

}
