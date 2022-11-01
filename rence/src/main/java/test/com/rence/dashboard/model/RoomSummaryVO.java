package test.com.rence.dashboard.model;

import java.io.Serializable;

public class RoomSummaryVO implements Serializable {

	private float review_point;
	private int comment_no;
	private int review_no;
	private int reserve_no;
	
	public RoomSummaryVO() {}
	
	public RoomSummaryVO(float review_point, int comment_no, int review_no, int reserve_no) {
		super();
		this.review_point = review_point;
		this.comment_no = comment_no;
		this.review_no = review_no;
		this.reserve_no = reserve_no;
	}

	public float getReview_point() {
		return review_point;
	}

	public void setReview_point(float review_point) {
		this.review_point = review_point;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public int getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comment_no;
		result = prime * result + reserve_no;
		result = prime * result + review_no;
		result = prime * result + Float.floatToIntBits(review_point);
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
		RoomSummaryVO other = (RoomSummaryVO) obj;
		if (comment_no != other.comment_no)
			return false;
		if (reserve_no != other.reserve_no)
			return false;
		if (review_no != other.review_no)
			return false;
		if (Float.floatToIntBits(review_point) != Float.floatToIntBits(other.review_point))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoomSummaryVO [review_point=" + review_point + ", comment_no=" + comment_no + ", review_no=" + review_no
				+ ", reserve_no=" + reserve_no + "]";
	}
	
}
