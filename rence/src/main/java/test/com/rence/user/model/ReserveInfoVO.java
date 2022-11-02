package test.com.rence.user.model;

public class ReserveInfoVO {
	String reserve_no;
	String company_name;
	String room_type;
	String reserve_sdate;
	String reserve_edate;
	String room_name;
	String room_price;
	String backoffice_name;
	String full_address;
	String backoffice_tel;
	String backoffice_email;
	String payment_total;
	String actual_payment;
	String mileage_change;
	
	
	public ReserveInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReserveInfoVO(String reserve_no, String company_name, String room_type, String reserve_sdate,
			String reserve_edate, String room_name, String room_price, String backoffice_name, String full_address,
			String backoffice_tel, String backoffice_email, String payment_total, String actual_payment,
			String mileage_change) {
		super();
		this.reserve_no = reserve_no;
		this.company_name = company_name;
		this.room_type = room_type;
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.room_name = room_name;
		this.room_price = room_price;
		this.backoffice_name = backoffice_name;
		this.full_address = full_address;
		this.backoffice_tel = backoffice_tel;
		this.backoffice_email = backoffice_email;
		this.payment_total = payment_total;
		this.actual_payment = actual_payment;
		this.mileage_change = mileage_change;
	}


	public String getReserve_no() {
		return reserve_no;
	}


	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
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


	public String getRoom_price() {
		return room_price;
	}


	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}


	public String getBackoffice_name() {
		return backoffice_name;
	}


	public void setBackoffice_name(String backoffice_name) {
		this.backoffice_name = backoffice_name;
	}


	public String getFull_address() {
		return full_address;
	}


	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}


	public String getBackoffice_tel() {
		return backoffice_tel;
	}


	public void setBackoffice_tel(String backoffice_tel) {
		this.backoffice_tel = backoffice_tel;
	}


	public String getBackoffice_email() {
		return backoffice_email;
	}


	public void setBackoffice_email(String backoffice_email) {
		this.backoffice_email = backoffice_email;
	}


	public String getPayment_total() {
		return payment_total;
	}


	public void setPayment_total(String payment_total) {
		this.payment_total = payment_total;
	}


	public String getActual_payment() {
		return actual_payment;
	}


	public void setActual_payment(String actual_payment) {
		this.actual_payment = actual_payment;
	}


	public String getMileage_change() {
		return mileage_change;
	}


	public void setMileage_change(String mileage_change) {
		this.mileage_change = mileage_change;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actual_payment == null) ? 0 : actual_payment.hashCode());
		result = prime * result + ((backoffice_email == null) ? 0 : backoffice_email.hashCode());
		result = prime * result + ((backoffice_name == null) ? 0 : backoffice_name.hashCode());
		result = prime * result + ((backoffice_tel == null) ? 0 : backoffice_tel.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((full_address == null) ? 0 : full_address.hashCode());
		result = prime * result + ((mileage_change == null) ? 0 : mileage_change.hashCode());
		result = prime * result + ((payment_total == null) ? 0 : payment_total.hashCode());
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_no == null) ? 0 : reserve_no.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((room_price == null) ? 0 : room_price.hashCode());
		result = prime * result + ((room_type == null) ? 0 : room_type.hashCode());
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
		ReserveInfoVO other = (ReserveInfoVO) obj;
		if (actual_payment == null) {
			if (other.actual_payment != null)
				return false;
		} else if (!actual_payment.equals(other.actual_payment))
			return false;
		if (backoffice_email == null) {
			if (other.backoffice_email != null)
				return false;
		} else if (!backoffice_email.equals(other.backoffice_email))
			return false;
		if (backoffice_name == null) {
			if (other.backoffice_name != null)
				return false;
		} else if (!backoffice_name.equals(other.backoffice_name))
			return false;
		if (backoffice_tel == null) {
			if (other.backoffice_tel != null)
				return false;
		} else if (!backoffice_tel.equals(other.backoffice_tel))
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (full_address == null) {
			if (other.full_address != null)
				return false;
		} else if (!full_address.equals(other.full_address))
			return false;
		if (mileage_change == null) {
			if (other.mileage_change != null)
				return false;
		} else if (!mileage_change.equals(other.mileage_change))
			return false;
		if (payment_total == null) {
			if (other.payment_total != null)
				return false;
		} else if (!payment_total.equals(other.payment_total))
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
		if (room_name == null) {
			if (other.room_name != null)
				return false;
		} else if (!room_name.equals(other.room_name))
			return false;
		if (room_price == null) {
			if (other.room_price != null)
				return false;
		} else if (!room_price.equals(other.room_price))
			return false;
		if (room_type == null) {
			if (other.room_type != null)
				return false;
		} else if (!room_type.equals(other.room_type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReserveInfoVO [reserve_no=" + reserve_no + ", company_name=" + company_name + ", room_type=" + room_type
				+ ", reserve_sdate=" + reserve_sdate + ", reserve_edate=" + reserve_edate + ", room_name=" + room_name
				+ ", room_price=" + room_price + ", backoffice_name=" + backoffice_name + ", full_address="
				+ full_address + ", backoffice_tel=" + backoffice_tel + ", backoffice_email=" + backoffice_email
				+ ", payment_total=" + payment_total + ", actual_payment=" + actual_payment + ", mileage_change="
				+ mileage_change + "]";
	}
	
	
}
