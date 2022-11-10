/**
 * @author 전판근
 */

package test.com.rence.office.model;

import java.io.Serializable;
import java.util.List;

public class OfficeInfoVO implements Serializable {
	private String backoffice_no;
	private String company_name;
	private String backoffice_info;
	private String backoffice_type;
	private int avg_rating;
	
	private String zipcode;
	private String roadname_address;
	private String number_address;
	private String detail_address;
	private String short_roadname_address;
	 
	private String backoffice_tag;
	private String backoffice_option;
	private String backoffice_around;
	private String backoffice_image;
	
	public OfficeInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public OfficeInfoVO(String backoffice_no, String company_name, String backoffice_info, String backoffice_type,
			int avg_rating, String zipcode, String roadname_address, String number_address, String detail_address,
			String short_roadname_address, String backoffice_tag, String backoffice_option, String backoffice_around,
			String backoffice_image) {
		super();
		this.backoffice_no = backoffice_no;
		this.company_name = company_name;
		this.backoffice_info = backoffice_info;
		this.backoffice_type = backoffice_type;
		this.avg_rating = avg_rating;
		this.zipcode = zipcode;
		this.roadname_address = roadname_address;
		this.number_address = number_address;
		this.detail_address = detail_address;
		this.short_roadname_address = short_roadname_address;
		this.backoffice_tag = backoffice_tag;
		this.backoffice_option = backoffice_option;
		this.backoffice_around = backoffice_around;
		this.backoffice_image = backoffice_image;
	}

	public String getBackoffice_no() {
		return backoffice_no;
	}

	public void setBackoffice_no(String backoffice_no) {
		this.backoffice_no = backoffice_no;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getBackoffice_info() {
		return backoffice_info;
	}

	public void setBackoffice_info(String backoffice_info) {
		this.backoffice_info = backoffice_info;
	}

	public String getBackoffice_type() {
		return backoffice_type;
	}

	public void setBackoffice_type(String backoffice_type) {
		this.backoffice_type = backoffice_type;
	}

	public int getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoadname_address() {
		return roadname_address;
	}

	public void setRoadname_address(String roadname_address) {
		this.roadname_address = roadname_address;
	}

	public String getNumber_address() {
		return number_address;
	}

	public void setNumber_address(String number_address) {
		this.number_address = number_address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getShort_roadname_address() {
		return short_roadname_address;
	}

	public void setShort_roadname_address(String short_roadname_address) {
		this.short_roadname_address = short_roadname_address;
	}

	public String getBackoffice_tag() {
		return backoffice_tag;
	}

	public void setBackoffice_tag(String backoffice_tag) {
		this.backoffice_tag = backoffice_tag;
	}

	public String getBackoffice_option() {
		return backoffice_option;
	}

	public void setBackoffice_option(String backoffice_option) {
		this.backoffice_option = backoffice_option;
	}

	public String getBackoffice_around() {
		return backoffice_around;
	}

	public void setBackoffice_around(String backoffice_around) {
		this.backoffice_around = backoffice_around;
	}

	public String getBackoffice_image() {
		return backoffice_image;
	}

	public void setBackoffice_image(String backoffice_image) {
		this.backoffice_image = backoffice_image;
	}

	@Override
	public String toString() {
		return "OfficeInfoVO [backoffice_no=" + backoffice_no + ", company_name=" + company_name + ", backoffice_info="
				+ backoffice_info + ", backoffice_type=" + backoffice_type + ", avg_rating=" + avg_rating + ", zipcode="
				+ zipcode + ", roadname_address=" + roadname_address + ", number_address=" + number_address
				+ ", detail_address=" + detail_address + ", short_roadname_address=" + short_roadname_address
				+ ", backoffice_tag=" + backoffice_tag + ", backoffice_option=" + backoffice_option
				+ ", backoffice_around=" + backoffice_around + ", backoffice_image=" + backoffice_image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avg_rating;
		result = prime * result + ((backoffice_around == null) ? 0 : backoffice_around.hashCode());
		result = prime * result + ((backoffice_image == null) ? 0 : backoffice_image.hashCode());
		result = prime * result + ((backoffice_info == null) ? 0 : backoffice_info.hashCode());
		result = prime * result + ((backoffice_no == null) ? 0 : backoffice_no.hashCode());
		result = prime * result + ((backoffice_option == null) ? 0 : backoffice_option.hashCode());
		result = prime * result + ((backoffice_tag == null) ? 0 : backoffice_tag.hashCode());
		result = prime * result + ((backoffice_type == null) ? 0 : backoffice_type.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((detail_address == null) ? 0 : detail_address.hashCode());
		result = prime * result + ((number_address == null) ? 0 : number_address.hashCode());
		result = prime * result + ((roadname_address == null) ? 0 : roadname_address.hashCode());
		result = prime * result + ((short_roadname_address == null) ? 0 : short_roadname_address.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		OfficeInfoVO other = (OfficeInfoVO) obj;
		if (avg_rating != other.avg_rating)
			return false;
		if (backoffice_around == null) {
			if (other.backoffice_around != null)
				return false;
		} else if (!backoffice_around.equals(other.backoffice_around))
			return false;
		if (backoffice_image == null) {
			if (other.backoffice_image != null)
				return false;
		} else if (!backoffice_image.equals(other.backoffice_image))
			return false;
		if (backoffice_info == null) {
			if (other.backoffice_info != null)
				return false;
		} else if (!backoffice_info.equals(other.backoffice_info))
			return false;
		if (backoffice_no == null) {
			if (other.backoffice_no != null)
				return false;
		} else if (!backoffice_no.equals(other.backoffice_no))
			return false;
		if (backoffice_option == null) {
			if (other.backoffice_option != null)
				return false;
		} else if (!backoffice_option.equals(other.backoffice_option))
			return false;
		if (backoffice_tag == null) {
			if (other.backoffice_tag != null)
				return false;
		} else if (!backoffice_tag.equals(other.backoffice_tag))
			return false;
		if (backoffice_type == null) {
			if (other.backoffice_type != null)
				return false;
		} else if (!backoffice_type.equals(other.backoffice_type))
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (detail_address == null) {
			if (other.detail_address != null)
				return false;
		} else if (!detail_address.equals(other.detail_address))
			return false;
		if (number_address == null) {
			if (other.number_address != null)
				return false;
		} else if (!number_address.equals(other.number_address))
			return false;
		if (roadname_address == null) {
			if (other.roadname_address != null)
				return false;
		} else if (!roadname_address.equals(other.roadname_address))
			return false;
		if (short_roadname_address == null) {
			if (other.short_roadname_address != null)
				return false;
		} else if (!short_roadname_address.equals(other.short_roadname_address))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	
}
