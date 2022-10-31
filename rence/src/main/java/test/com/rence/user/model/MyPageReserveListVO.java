package test.com.rence.user.model;

import java.sql.Timestamp;

public class MyPageReserveListVO {
	String reserve_no;
	String reserve_sdate;
	String reserve_edate;
	String company_name;
	String roadname_address;
	String backoffice_image;
	String payment_total;
	
	
	public MyPageReserveListVO() {
	}


	public MyPageReserveListVO(String reserve_no, String reserve_sdate, String reserve_edate, String company_name,
			String roadname_address, String backoffice_image, String payment_total) {
		super();
		this.reserve_no = reserve_no;
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.company_name = company_name;
		this.roadname_address = roadname_address;
		this.backoffice_image = backoffice_image;
		this.payment_total = payment_total;
	}


	public String getReserve_no() {
		return reserve_no;
	}


	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
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


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getRoadname_address() {
		return roadname_address;
	}


	public void setRoadname_address(String roadname_address) {
		this.roadname_address = roadname_address;
	}


	public String getBackoffice_image() {
		return backoffice_image;
	}


	public void setBackoffice_image(String backoffice_image) {
		this.backoffice_image = backoffice_image;
	}


	public String getPayment_total() {
		return payment_total;
	}


	public void setPayment_total(String payment_total) {
		this.payment_total = payment_total;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backoffice_image == null) ? 0 : backoffice_image.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((payment_total == null) ? 0 : payment_total.hashCode());
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_no == null) ? 0 : reserve_no.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
		result = prime * result + ((roadname_address == null) ? 0 : roadname_address.hashCode());
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
		MyPageReserveListVO other = (MyPageReserveListVO) obj;
		if (backoffice_image == null) {
			if (other.backoffice_image != null)
				return false;
		} else if (!backoffice_image.equals(other.backoffice_image))
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
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
		if (roadname_address == null) {
			if (other.roadname_address != null)
				return false;
		} else if (!roadname_address.equals(other.roadname_address))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MyPageReserveListVO [reserve_no=" + reserve_no + ", reserve_sdate=" + reserve_sdate + ", reserve_edate="
				+ reserve_edate + ", company_name=" + company_name + ", roadname_address=" + roadname_address
				+ ", backoffice_image=" + backoffice_image + ", payment_total=" + payment_total + "]";
	}
	
}
