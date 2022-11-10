/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class SalesSettlementVO implements Serializable {

	private String reserve_sdate;
	private String reserve_edate;
	private String room_name;
	private String actual_payment;
	private String payment_state;
	private String sales_state;
	private String payment_no;
	private String room_no;
	
	public SalesSettlementVO() {}

	public SalesSettlementVO(String reserve_sdate, String reserve_edate, String room_name, String actual_payment,
			String payment_state, String sales_state, String payment_no, String room_no) {
		super();
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.room_name = room_name;
		this.actual_payment = actual_payment;
		this.payment_state = payment_state;
		this.sales_state = sales_state;
		this.payment_no = payment_no;
		this.room_no = room_no;
	}

	public String getReserve_sdate() {
		return reserve_sdate;
	}

	public void setReserve_sdate(String reserve_sdate) {
		this.reserve_sdate = reserve_sdate;
	}

	public String getReserve_edate() {
		return reserve_edate;
	}

	public void setReserve_edate(String reserve_edate) {
		this.reserve_edate = reserve_edate;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getActual_payment() {
		return actual_payment;
	}

	public void setActual_payment(String actual_payment) {
		this.actual_payment = actual_payment;
	}

	public String getPayment_state() {
		return payment_state;
	}

	public void setPayment_state(String payment_state) {
		this.payment_state = payment_state;
	}

	public String getSales_state() {
		return sales_state;
	}

	public void setSales_state(String sales_state) {
		this.sales_state = sales_state;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	@Override
	public String toString() {
		return "SalesSettlementVO [reserve_sdate=" + reserve_sdate + ", reserve_edate=" + reserve_edate + ", room_name="
				+ room_name + ", actual_payment=" + actual_payment + ", payment_state=" + payment_state
				+ ", sales_state=" + sales_state + ", payment_no=" + payment_no + ", room_no=" + room_no + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actual_payment == null) ? 0 : actual_payment.hashCode());
		result = prime * result + ((payment_no == null) ? 0 : payment_no.hashCode());
		result = prime * result + ((payment_state == null) ? 0 : payment_state.hashCode());
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((room_no == null) ? 0 : room_no.hashCode());
		result = prime * result + ((sales_state == null) ? 0 : sales_state.hashCode());
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
		SalesSettlementVO other = (SalesSettlementVO) obj;
		if (actual_payment == null) {
			if (other.actual_payment != null)
				return false;
		} else if (!actual_payment.equals(other.actual_payment))
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
		if (reserve_edate == null) {
			if (other.reserve_edate != null)
				return false;
		} else if (!reserve_edate.equals(other.reserve_edate))
			return false;
		if (reserve_sdate == null) {
			if (other.reserve_sdate != null)
				return false;
		} else if (!reserve_sdate.equals(other.reserve_sdate))
			return false;
		if (room_name == null) {
			if (other.room_name != null)
				return false;
		} else if (!room_name.equals(other.room_name))
			return false;
		if (room_no == null) {
			if (other.room_no != null)
				return false;
		} else if (!room_no.equals(other.room_no))
			return false;
		if (sales_state == null) {
			if (other.sales_state != null)
				return false;
		} else if (!sales_state.equals(other.sales_state))
			return false;
		return true;
	}


}
