package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class ReviewVO implements Serializable {
	private String review_no;
	private String review_content;
	private float review_point;
	private Date review_date;
	private String user_image;
	private String user_name;
	
	public ReviewVO() {}

	public ReviewVO(String review_no, String review_content, float review_point, Date review_date, String user_image,
			String user_name) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_point = review_point;
		this.review_date = review_date;
		this.user_image = user_image;
		this.user_name = user_name;
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

	public float getReview_point() {
		return review_point;
	}

	public void setReview_point(float review_point) {
		this.review_point = review_point;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((review_content == null) ? 0 : review_content.hashCode());
		result = prime * result + ((review_date == null) ? 0 : review_date.hashCode());
		result = prime * result + ((review_no == null) ? 0 : review_no.hashCode());
		result = prime * result + Float.floatToIntBits(review_point);
		result = prime * result + ((user_image == null) ? 0 : user_image.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		if (Float.floatToIntBits(review_point) != Float.floatToIntBits(other.review_point))
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
		return true;
	}

	@Override
	public String toString() {
		return "ReviewVO [review_no=" + review_no + ", review_content=" + review_content + ", review_point="
				+ review_point + ", review_date=" + review_date + ", user_image=" + user_image + ", user_name="
				+ user_name + "]";
	}
	
	
}
