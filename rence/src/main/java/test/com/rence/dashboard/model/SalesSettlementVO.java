package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class SalesSettlementVO implements Serializable {

	private Date reserve_sdate;
	private Date reserve_edate;
	private String room_name;
	private String actual_total;
	private String payment_state;
	
	public SalesSettlementVO() {}

	public SalesSettlementVO(Date reserve_sdate, Date reserve_edate, String room_name, String actual_total,
			String payment_state) {
		super();
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.room_name = room_name;
		this.actual_total = actual_total;
		this.payment_state = payment_state;
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

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getActual_total() {
		return actual_total;
	}

	public void setActual_total(String actual_total) {
		this.actual_total = actual_total;
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
		result = prime * result + ((actual_total == null) ? 0 : actual_total.hashCode());
		result = prime * result + ((payment_state == null) ? 0 : payment_state.hashCode());
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
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
		SalesSettlementVO other = (SalesSettlementVO) obj;
		if (actual_total == null) {
			if (other.actual_total != null)
				return false;
		} else if (!actual_total.equals(other.actual_total))
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
		return true;
	}

	@Override
	public String toString() {
		return "SalesSettlementVO [reserve_sdate=" + reserve_sdate + ", reserve_edate=" + reserve_edate + ", room_name="
				+ room_name + ", actual_total=" + actual_total + ", payment_state=" + payment_state + "]";
	}
	
	
}
