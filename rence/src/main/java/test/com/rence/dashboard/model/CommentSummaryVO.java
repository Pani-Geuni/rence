package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class CommentSummaryVO implements Serializable{

	private String comment_no;
	private String room_name;
	private Date comment_date;
	private String comment_content;
	
	public CommentSummaryVO() {}

	public CommentSummaryVO(String comment_no, String room_name, Date comment_date, String comment_content) {
		super();
		this.comment_no = comment_no;
		this.room_name = room_name;
		this.comment_date = comment_date;
		this.comment_content = comment_content;
	}

	public String getComment_no() {
		return comment_no;
	}

	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	@Override
	public String toString() {
		return "CommentSummaryVO [comment_no=" + comment_no + ", room_name=" + room_name + ", comment_date="
				+ comment_date + ", comment_content=" + comment_content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment_content == null) ? 0 : comment_content.hashCode());
		result = prime * result + ((comment_date == null) ? 0 : comment_date.hashCode());
		result = prime * result + ((comment_no == null) ? 0 : comment_no.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
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
		CommentSummaryVO other = (CommentSummaryVO) obj;
		if (comment_content == null) {
			if (other.comment_content != null)
				return false;
		} else if (!comment_content.equals(other.comment_content))
			return false;
		if (comment_date == null) {
			if (other.comment_date != null)
				return false;
		} else if (!comment_date.equals(other.comment_date))
			return false;
		if (comment_no == null) {
			if (other.comment_no != null)
				return false;
		} else if (!comment_no.equals(other.comment_no))
			return false;
		if (room_name == null) {
			if (other.room_name != null)
				return false;
		} else if (!room_name.equals(other.room_name))
			return false;
		return true;
	}
	
	
}
