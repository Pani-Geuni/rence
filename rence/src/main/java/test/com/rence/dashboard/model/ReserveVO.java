/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class ReserveVO implements Serializable {

	private String reserve_no;
	private Date reserve_sdate;
	private Date reserve_edate;
	private String reserve_state;
	private String room_name;
	private String user_name;
	private String user_tel;
	private String user_email;
	private String actual_payment;
	private String payment_state;
	
	public ReserveVO() {}

	public ReserveVO(String reserve_no, Date reserve_sdate, Date reserve_edate, String reserve_state, String room_name,
			String user_name, String user_tel, String user_email, String actual_payment, String payment_state) {
		super();
		this.reserve_no = reserve_no;
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.reserve_state = reserve_state;
		this.room_name = room_name;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.actual_payment = actual_payment;
		this.payment_state = payment_state;
	}

	public String getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
	}

	public Date getReserve_sdate() {
		return reserve_sdate;
	}

	public void setReserve_sdate(Date reserve_sdate) {
		this.reserve_sdate = reserve_sdate;
	}

	public Date getReserve_edate() {
		return reserve_edate;
	}

	public void setReserve_edate(Date reserve_edate) {
		this.reserve_edate = reserve_edate;
	}

	public String getReserve_state() {
		return reserve_state;
	}

	public void setReserve_state(String reserve_state) {
		this.reserve_state = reserve_state;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getactual_payment() {
		return actual_payment;
	}

	public void setactual_payment(String actual_payment) {
		this.actual_payment = actual_payment;
	}

	public String getPayment_state() {
		return payment_state;
	}

	public void setPayment_state(String payment_state) {
		this.payment_state = payment_state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payment_state == null) ? 0 : payment_state.hashCode());
		result = prime * result + ((actual_payment == null) ? 0 : actual_payment.hashCode());
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_no == null) ? 0 : reserve_no.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
		result = prime * result + ((reserve_state == null) ? 0 : reserve_state.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_tel == null) ? 0 : user_tel.hashCode());
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
		ReserveVO other = (ReserveVO) obj;
		if (payment_state == null) {
			if (other.payment_state != null)
				return false;
		} else if (!payment_state.equals(other.payment_state))
			return false;
		if (actual_payment == null) {
			if (other.actual_payment != null)
				return false;
		} else if (!actual_payment.equals(other.actual_payment))
			return false;
		if (reserve_edate == null) {
			if (other.reserve_edate != null)
				return false;
		} else if (!reserve_edate.equals(other.reserve_edate))
			return false;
		if (reserve_no == null) {
			if (other.reserve_no != null)
				return false;
		} else if (!reserve_no.equals(other.reserve_no))
			return false;
		if (reserve_sdate == null) {
			if (other.reserve_sdate != null)
				return false;
		} else if (!reserve_sdate.equals(other.reserve_sdate))
			return false;
		if (reserve_state == null) {
			if (other.reserve_state != null)
				return false;
		} else if (!reserve_state.equals(other.reserve_state))
			return false;
		if (room_name == null) {
			if (other.room_name != null)
				return false;
		} else if (!room_name.equals(other.room_name))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_tel == null) {
			if (other.user_tel != null)
				return false;
		} else if (!user_tel.equals(other.user_tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserve_no=" + reserve_no + ", reserve_sdate=" + reserve_sdate + ", reserve_edate="
				+ reserve_edate + ", reserve_state=" + reserve_state + ", room_name=" + room_name + ", user_name="
				+ user_name + ", user_tel=" + user_tel + ", user_email=" + user_email + ", actual_payment="
				+ actual_payment + ", payment_state=" + payment_state + "]";
	}
	
	
	
}
