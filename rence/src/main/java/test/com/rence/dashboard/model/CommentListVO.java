/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class CommentListVO implements Serializable {
	private String comment_no;
	private String answer_no;
	private String user_no;
	private String romm_name;
	private String comment_date;
	private String comment_content;
	private String answer_date;
	private String answer_content;
	private String comment_state;

	
	public CommentListVO() {}


	public CommentListVO(String comment_no, String answer_no, String user_no, String romm_name, String comment_date,
			String comment_content, String answer_date, String answer_content, String comment_state) {
		super();
		this.comment_no = comment_no;
		this.answer_no = answer_no;
		this.user_no = user_no;
		this.romm_name = romm_name;
		this.comment_date = comment_date;
		this.comment_content = comment_content;
		this.answer_date = answer_date;
		this.answer_content = answer_content;
		this.comment_state = comment_state;
	}


	public String getComment_no() {
		return comment_no;
	}


	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}


	public String getAnswer_no() {
		return answer_no;
	}


	public void setAnswer_no(String answer_no) {
		this.answer_no = answer_no;
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}


	public String getRomm_name() {
		return romm_name;
	}


	public void setRomm_name(String romm_name) {
		this.romm_name = romm_name;
	}


	public String getComment_date() {
		return comment_date;
	}


	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}


	public String getComment_content() {
		return comment_content;
	}


	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}


	public String getAnswer_date() {
		return answer_date;
	}


	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}


	public String getAnswer_content() {
		return answer_content;
	}


	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}


	public String getComment_state() {
		return comment_state;
	}


	public void setComment_state(String comment_state) {
		this.comment_state = comment_state;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_content == null) ? 0 : answer_content.hashCode());
		result = prime * result + ((answer_date == null) ? 0 : answer_date.hashCode());
		result = prime * result + ((answer_no == null) ? 0 : answer_no.hashCode());
		result = prime * result + ((comment_content == null) ? 0 : comment_content.hashCode());
		result = prime * result + ((comment_date == null) ? 0 : comment_date.hashCode());
		result = prime * result + ((comment_no == null) ? 0 : comment_no.hashCode());
		result = prime * result + ((comment_state == null) ? 0 : comment_state.hashCode());
		result = prime * result + ((romm_name == null) ? 0 : romm_name.hashCode());
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
		CommentListVO other = (CommentListVO) obj;
		if (answer_content == null) {
			if (other.answer_content != null)
				return false;
		} else if (!answer_content.equals(other.answer_content))
			return false;
		if (answer_date == null) {
			if (other.answer_date != null)
				return false;
		} else if (!answer_date.equals(other.answer_date))
			return false;
		if (answer_no == null) {
			if (other.answer_no != null)
				return false;
		} else if (!answer_no.equals(other.answer_no))
			return false;
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
		if (comment_state == null) {
			if (other.comment_state != null)
				return false;
		} else if (!comment_state.equals(other.comment_state))
			return false;
		if (romm_name == null) {
			if (other.romm_name != null)
				return false;
		} else if (!romm_name.equals(other.romm_name))
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
		return "CommentListVO [comment_no=" + comment_no + ", answer_no=" + answer_no + ", user_no=" + user_no
				+ ", romm_name=" + romm_name + ", comment_date=" + comment_date + ", comment_content=" + comment_content
				+ ", answer_date=" + answer_date + ", answer_content=" + answer_content + ", comment_state="
				+ comment_state + "]";
	}


}
