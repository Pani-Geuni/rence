/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class PaymentVO implements Serializable {

	private String payment_no;
	private int payment_total;
	private int add_mileage;
	private int use_mileage;
	private int actual_payment;
	private String payment_state;
	private Date payment_date;
	private String room_no;
	private String user_no;
	private String mileage_no;
	private String reserve_no;
	
	public PaymentVO() {}
	
	public PaymentVO(String payment_no, int payment_total, int add_mileage, int use_mileage, int actual_payment,
			String payment_state, Date payment_date, String room_no, String user_no, String mileage_no,
			String reserve_no) {
		super();
		this.payment_no = payment_no;
		this.payment_total = payment_total;
		this.add_mileage = add_mileage;
		this.use_mileage = use_mileage;
		this.actual_payment = actual_payment;
		this.payment_state = payment_state;
		this.payment_date = payment_date;
		this.room_no = room_no;
		this.user_no = user_no;
		this.mileage_no = mileage_no;
		this.reserve_no = reserve_no;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public int getPayment_total() {
		return payment_total;
	}

	public void setPayment_total(int payment_total) {
		this.payment_total = payment_total;
	}

	public int getAdd_mileage() {
		return add_mileage;
	}

	public void setAdd_mileage(int add_mileage) {
		this.add_mileage = add_mileage;
	}

	public int getUse_mileage() {
		return use_mileage;
	}

	public void setUse_mileage(int use_mileage) {
		this.use_mileage = use_mileage;
	}

	public int getActual_payment() {
		return actual_payment;
	}

	public void setActual_payment(int actual_payment) {
		this.actual_payment = actual_payment;
	}

	public String getPayment_state() {
		return payment_state;
	}

	public void setPayment_state(String payment_state) {
		this.payment_state = payment_state;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getMileage_no() {
		return mileage_no;
	}

	public void setMileage_no(String mileage_no) {
		this.mileage_no = mileage_no;
	}

	public String getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actual_payment;
		result = prime * result + add_mileage;
		result = prime * result + ((mileage_no == null) ? 0 : mileage_no.hashCode());
		result = prime * result + ((payment_date == null) ? 0 : payment_date.hashCode());
		result = prime * result + ((payment_no == null) ? 0 : payment_no.hashCode());
		result = prime * result + ((payment_state == null) ? 0 : payment_state.hashCode());
		result = prime * result + payment_total;
		result = prime * result + ((reserve_no == null) ? 0 : reserve_no.hashCode());
		result = prime * result + ((room_no == null) ? 0 : room_no.hashCode());
		result = prime * result + use_mileage;
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
		PaymentVO other = (PaymentVO) obj;
		if (actual_payment != other.actual_payment)
			return false;
		if (add_mileage != other.add_mileage)
			return false;
		if (mileage_no == null) {
			if (other.mileage_no != null)
				return false;
		} else if (!mileage_no.equals(other.mileage_no))
			return false;
		if (payment_date == null) {
			if (other.payment_date != null)
				return false;
		} else if (!payment_date.equals(other.payment_date))
			return false;
		if (payment_no == null) {
			if (other.payment_no != null)
				return false;
		} else if (!payment_no.equals(other.payment_no))
			return false;
		if (payment_state == null) {
			if (other.payment_state != null)
				return false;
		} else if (!payment_state.equals(other.payment_state))
			return false;
		if (payment_total != other.payment_total)
			return false;
		if (reserve_no == null) {
			if (other.reserve_no != null)
				return false;
		} else if (!reserve_no.equals(other.reserve_no))
			return false;
		if (room_no == null) {
			if (other.room_no != null)
				return false;
		} else if (!room_no.equals(other.room_no))
			return false;
		if (use_mileage != other.use_mileage)
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
		return "PaymentVO [payment_no=" + payment_no + ", payment_total=" + payment_total + ", add_mileage="
				+ add_mileage + ", use_mileage=" + use_mileage + ", actual_payment=" + actual_payment
				+ ", payment_state=" + payment_state + ", payment_date=" + payment_date + ", room_no=" + room_no
				+ ", user_no=" + user_no + ", mileage_no=" + mileage_no + ", reserve_no=" + reserve_no + "]";
	}
	
	
	
}
