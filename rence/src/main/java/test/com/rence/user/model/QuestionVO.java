package test.com.rence.user.model;

public class QuestionVO {
	String comment_no;
	String state;
	String room_name;
	String comment_content;
	String comment_date;
	String answerDate;
	
	
	public QuestionVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionVO(String comment_no, String state, String room_name, String comment_content, String comment_date,
			String answerDate) {
		super();
		this.comment_no = comment_no;
		this.state = state;
		this.room_name = room_name;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.answerDate = answerDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerDate == null) ? 0 : answerDate.hashCode());
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
		if (answerDate == null) {
			if (other.answerDate != null)
				return false;
		} else if (!answerDate.equals(other.answerDate))
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
				+ ", comment_content=" + comment_content + ", comment_date=" + comment_date + ", answerDate="
				+ answerDate + "]";
	}
	
}
