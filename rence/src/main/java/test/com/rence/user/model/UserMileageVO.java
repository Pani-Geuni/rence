/**
 * @author 강경석
 * userinfo 테이블 - mileage 테이블 조인 뷰(user_mypage_view)
 * 유저 마일리지 상세페이지 데이터 VO 
 */


//	Map<String, String> map = new HashMap<String, String>();
//		map.put("mileage_no", no);
//		map.put("mileage_state", state);
//		map.put("mileage_change", mileage);
//		map.put("company_name", room);
//		map.put("payment_date", date);
//		map.put("user_no", user_no);


package test.com.rence.user.model;

import java.sql.Date;

public class UserMileageVO {
	private int mileage_total;
	private String no; // mileage_no
	private String user_no; // 
	private String state; //mileage_state
	private String mileage; //mileage_change
	private String room; //company_name;
	private Date date; // payment_date
	
	
	public UserMileageVO() {
		// TODO Auto-generated constructor stub
	}


	public UserMileageVO(int mileage_total, String no, String user_no, String state, String mileage, String room,
			Date date) {
		super();
		this.mileage_total = mileage_total;
		this.no = no;
		this.user_no = user_no;
		this.state = state;
		this.mileage = mileage;
		this.room = room;
		this.date = date;
	}


	public int getMileage_total() {
		return mileage_total;
	}


	public void setMileage_total(int mileage_total) {
		this.mileage_total = mileage_total;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getMileage() {
		return mileage;
	}


	public void setMileage(String mileage) {
		this.mileage = mileage;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime * result + mileage_total;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		UserMileageVO other = (UserMileageVO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		if (mileage_total != other.mileage_total)
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
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
		return "UserMileageVO [mileage_total=" + mileage_total + ", no=" + no + ", user_no=" + user_no + ", state="
				+ state + ", mileage=" + mileage + ", room=" + room + ", date=" + date + "]";
	}


	
}//end class

  