/**
 * @author 강경석
 * userinfo 테이블 - mileage 테이블 조인 뷰(user_mypage_view)
 * 유저 마일리지 상세페이지 데이터 VO 
 */


package test.com.rence.user;

import java.sql.Date;

public class UserMileageVO {
	private int mileage_total;
	private String mileage_no; // mileage_no
	private String mileage_state;
	private String mileage_change;
	private String company_name;
	private Date payment_date;
	
	
	public UserMileageVO() {
		// TODO Auto-generated constructor stub
	}


	public UserMileageVO(int mileage_total, String mileage_no, String mileage_state, String mileage_change,
			String company_name, Date payment_date) {
		super();
		this.mileage_total = mileage_total;
		this.mileage_no = mileage_no;
		this.mileage_state = mileage_state;
		this.mileage_change = mileage_change;
		this.company_name = company_name;
		this.payment_date = payment_date;
	}


	public int getMileage_total() {
		return mileage_total;
	}


	public void setMileage_total(int mileage_total) {
		this.mileage_total = mileage_total;
	}


	public String getMileage_no() {
		return mileage_no;
	}


	public void setMileage_no(String mileage_no) {
		this.mileage_no = mileage_no;
	}


	public String getMileage_state() {
		return mileage_state;
	}


	public void setMileage_state(String mileage_state) {
		this.mileage_state = mileage_state;
	}


	public String getMileage_change() {
		return mileage_change;
	}


	public void setMileage_change(String mileage_change) {
		this.mileage_change = mileage_change;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public Date getPayment_date() {
		return payment_date;
	}


	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((mileage_change == null) ? 0 : mileage_change.hashCode());
		result = prime * result + ((mileage_no == null) ? 0 : mileage_no.hashCode());
		result = prime * result + ((mileage_state == null) ? 0 : mileage_state.hashCode());
		result = prime * result + mileage_total;
		result = prime * result + ((payment_date == null) ? 0 : payment_date.hashCode());
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
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (mileage_change == null) {
			if (other.mileage_change != null)
				return false;
		} else if (!mileage_change.equals(other.mileage_change))
			return false;
		if (mileage_no == null) {
			if (other.mileage_no != null)
				return false;
		} else if (!mileage_no.equals(other.mileage_no))
			return false;
		if (mileage_state == null) {
			if (other.mileage_state != null)
				return false;
		} else if (!mileage_state.equals(other.mileage_state))
			return false;
		if (mileage_total != other.mileage_total)
			return false;
		if (payment_date == null) {
			if (other.payment_date != null)
				return false;
		} else if (!payment_date.equals(other.payment_date))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserMileage [mileage_total=" + mileage_total + ", mileage_no=" + mileage_no + ", mileage_state="
				+ mileage_state + ", mileage_change=" + mileage_change + ", company_name=" + company_name
				+ ", payment_date=" + payment_date + "]";
	}
	
	
	
	
	
}//end class

  