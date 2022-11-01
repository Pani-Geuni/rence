package test.com.rence.user.model;

public class QuestionVO {
	String comment_no;
	String state;
	String room_name;
	String comment_content;
	String answer_content;
	String comment_date;
	String answer_date;
	
	
	public QuestionVO() { }


	public QuestionVO(String comment_no, String state, String room_name, String comment_content, String answer_content,
			String comment_date, String answer_date) {
		super();
		this.comment_no = comment_no;
		this.state = state;
		this.room_name = room_name;
		this.comment_content = comment_content;
		this.answer_content = answer_content;
		this.comment_date = comment_date;
		this.answer_date = answer_date;
	}


	public String getComment_no() {
		return comment_no;
	}


	public void setComment_no(String comment_no) {
		this.comment_no = comment_no;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}


	public String getComment_content() {
		return comment_content;
	}


	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}


	public String getAnswer_content() {
		return answer_content;
	}


	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}


	public String getComment_date() {
		return comment_date;
	}


	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}


	public String getAnswer_date() {
		return answer_date;
	}


	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_content == null) ? 0 : answer_content.hashCode());
		result = prime * result + ((answer_date == null) ? 0 : answer_date.hashCode());
		result = prime * result + ((comment_content == null) ? 0 : comment_content.hashCode());
		result = prime * result + ((comment_date == null) ? 0 : comment_date.hashCode());
		result = prime * result + ((comment_no == null) ? 0 : comment_no.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		QuestionVO other = (QuestionVO) obj;
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "QuestionVO [comment_no=" + comment_no + ", state=" + state + ", room_name=" + room_name
				+ ", comment_content=" + comment_content + ", answer_content=" + answer_content + ", comment_date="
				+ comment_date + ", answer_date=" + answer_date + "]";
	}

}
