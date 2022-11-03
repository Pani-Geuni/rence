/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BackOfficeSelectVO implements Serializable{

	private String backoffice_no;
	private String owner_name;
	private String backoffice_id;
	private String backoffice_name;
	private String company_name;
	private String backoffice_pw;
	private String backoffice_tel;
	private String backoffice_email;
	private String zipcode;
	private String roadname_address;
	private String number_address;
	private String detail_address;
	private String backoffice_tag;
	private String backoffice_info;
	private String backoffice_option;
	private String backoffice_around;
	private String backoffice_image;
	private String host_image;
	private String backoffice_state;
	private String apply_date;
	private MultipartFile multipartFile_room;
	private MultipartFile multipartFile_host;
	private String backoffice_type;
	
	public BackOfficeSelectVO() {}

	public BackOfficeSelectVO(String backoffice_no, String owner_name, String backoffice_id, String backoffice_name,
			String company_name, String backoffice_pw, String backoffice_tel, String backoffice_email, String zipcode,
			String roadname_address, String number_address, String detail_address, String backoffice_tag,
			String backoffice_info, String backoffice_option, String backoffice_around, String backoffice_image,
			String host_image, String backoffice_state, String apply_date, MultipartFile multipartFile_room,
			MultipartFile multipartFile_host, String backoffice_type) {
		super();
		this.backoffice_no = backoffice_no;
		this.owner_name = owner_name;
		this.backoffice_id = backoffice_id;
		this.backoffice_name = backoffice_name;
		this.company_name = company_name;
		this.backoffice_pw = backoffice_pw;
		this.backoffice_tel = backoffice_tel;
		this.backoffice_email = backoffice_email;
		this.zipcode = zipcode;
		this.roadname_address = roadname_address;
		this.number_address = number_address;
		this.detail_address = detail_address;
		this.backoffice_tag = backoffice_tag;
		this.backoffice_info = backoffice_info;
		this.backoffice_option = backoffice_option;
		this.backoffice_around = backoffice_around;
		this.backoffice_image = backoffice_image;
		this.host_image = host_image;
		this.backoffice_state = backoffice_state;
		this.apply_date = apply_date;
		this.multipartFile_room = multipartFile_room;
		this.multipartFile_host = multipartFile_host;
		this.backoffice_type = backoffice_type;
	}

	public String getBackoffice_no() {
		return backoffice_no;
	}

	public void setBackoffice_no(String backoffice_no) {
		this.backoffice_no = backoffice_no;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getBackoffice_id() {
		return backoffice_id;
	}

	public void setBackoffice_id(String backoffice_id) {
		this.backoffice_id = backoffice_id;
	}

	public String getBackoffice_name() {
		return backoffice_name;
	}

	public void setBackoffice_name(String backoffice_name) {
		this.backoffice_name = backoffice_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getBackoffice_pw() {
		return backoffice_pw;
	}

	public void setBackoffice_pw(String backoffice_pw) {
		this.backoffice_pw = backoffice_pw;
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

	public String getBackoffice_tag() {
		return backoffice_tag;
	}

	public void setBackoffice_tag(String backoffice_tag) {
		this.backoffice_tag = backoffice_tag;
	}

	public String getBackoffice_info() {
		return backoffice_info;
	}

	public void setBackoffice_info(String backoffice_info) {
		this.backoffice_info = backoffice_info;
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

	public String getHost_image() {
		return host_image;
	}

	public void setHost_image(String host_image) {
		this.host_image = host_image;
	}

	public String getBackoffice_state() {
		return backoffice_state;
	}

	public void setBackoffice_state(String backoffice_state) {
		this.backoffice_state = backoffice_state;
	}

	public String getApply_date() {
		return apply_date;
	}

	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}

	public MultipartFile getMultipartFile_room() {
		return multipartFile_room;
	}

	public void setMultipartFile_room(MultipartFile multipartFile_room) {
		this.multipartFile_room = multipartFile_room;
	}

	public MultipartFile getMultipartFile_host() {
		return multipartFile_host;
	}

	public void setMultipartFile_host(MultipartFile multipartFile_host) {
		this.multipartFile_host = multipartFile_host;
	}

	public String getBackoffice_type() {
		return backoffice_type;
	}

	public void setBackoffice_type(String backoffice_type) {
		this.backoffice_type = backoffice_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apply_date == null) ? 0 : apply_date.hashCode());
		result = prime * result + ((backoffice_around == null) ? 0 : backoffice_around.hashCode());
		result = prime * result + ((backoffice_email == null) ? 0 : backoffice_email.hashCode());
		result = prime * result + ((backoffice_id == null) ? 0 : backoffice_id.hashCode());
		result = prime * result + ((backoffice_image == null) ? 0 : backoffice_image.hashCode());
		result = prime * result + ((backoffice_info == null) ? 0 : backoffice_info.hashCode());
		result = prime * result + ((backoffice_name == null) ? 0 : backoffice_name.hashCode());
		result = prime * result + ((backoffice_no == null) ? 0 : backoffice_no.hashCode());
		result = prime * result + ((backoffice_option == null) ? 0 : backoffice_option.hashCode());
		result = prime * result + ((backoffice_pw == null) ? 0 : backoffice_pw.hashCode());
		result = prime * result + ((backoffice_state == null) ? 0 : backoffice_state.hashCode());
		result = prime * result + ((backoffice_tag == null) ? 0 : backoffice_tag.hashCode());
		result = prime * result + ((backoffice_tel == null) ? 0 : backoffice_tel.hashCode());
		result = prime * result + ((backoffice_type == null) ? 0 : backoffice_type.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((detail_address == null) ? 0 : detail_address.hashCode());
		result = prime * result + ((host_image == null) ? 0 : host_image.hashCode());
		result = prime * result + ((multipartFile_host == null) ? 0 : multipartFile_host.hashCode());
		result = prime * result + ((multipartFile_room == null) ? 0 : multipartFile_room.hashCode());
		result = prime * result + ((number_address == null) ? 0 : number_address.hashCode());
		result = prime * result + ((owner_name == null) ? 0 : owner_name.hashCode());
		result = prime * result + ((roadname_address == null) ? 0 : roadname_address.hashCode());
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
		BackOfficeSelectVO other = (BackOfficeSelectVO) obj;
		if (apply_date == null) {
			if (other.apply_date != null)
				return false;
		} else if (!apply_date.equals(other.apply_date))
			return false;
		if (backoffice_around == null) {
			if (other.backoffice_around != null)
				return false;
		} else if (!backoffice_around.equals(other.backoffice_around))
			return false;
		if (backoffice_email == null) {
			if (other.backoffice_email != null)
				return false;
		} else if (!backoffice_email.equals(other.backoffice_email))
			return false;
		if (backoffice_id == null) {
			if (other.backoffice_id != null)
				return false;
		} else if (!backoffice_id.equals(other.backoffice_id))
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
		if (backoffice_name == null) {
			if (other.backoffice_name != null)
				return false;
		} else if (!backoffice_name.equals(other.backoffice_name))
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
		if (backoffice_pw == null) {
			if (other.backoffice_pw != null)
				return false;
		} else if (!backoffice_pw.equals(other.backoffice_pw))
			return false;
		if (backoffice_state == null) {
			if (other.backoffice_state != null)
				return false;
		} else if (!backoffice_state.equals(other.backoffice_state))
			return false;
		if (backoffice_tag == null) {
			if (other.backoffice_tag != null)
				return false;
		} else if (!backoffice_tag.equals(other.backoffice_tag))
			return false;
		if (backoffice_tel == null) {
			if (other.backoffice_tel != null)
				return false;
		} else if (!backoffice_tel.equals(other.backoffice_tel))
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
		if (host_image == null) {
			if (other.host_image != null)
				return false;
		} else if (!host_image.equals(other.host_image))
			return false;
		if (multipartFile_host == null) {
			if (other.multipartFile_host != null)
				return false;
		} else if (!multipartFile_host.equals(other.multipartFile_host))
			return false;
		if (multipartFile_room == null) {
			if (other.multipartFile_room != null)
				return false;
		} else if (!multipartFile_room.equals(other.multipartFile_room))
			return false;
		if (number_address == null) {
			if (other.number_address != null)
				return false;
		} else if (!number_address.equals(other.number_address))
			return false;
		if (owner_name == null) {
			if (other.owner_name != null)
				return false;
		} else if (!owner_name.equals(other.owner_name))
			return false;
		if (roadname_address == null) {
			if (other.roadname_address != null)
				return false;
		} else if (!roadname_address.equals(other.roadname_address))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BackOfficeSelectVO [backoffice_no=" + backoffice_no + ", owner_name=" + owner_name + ", backoffice_id="
				+ backoffice_id + ", backoffice_name=" + backoffice_name + ", company_name=" + company_name
				+ ", backoffice_pw=" + backoffice_pw + ", backoffice_tel=" + backoffice_tel + ", backoffice_email="
				+ backoffice_email + ", zipcode=" + zipcode + ", roadname_address=" + roadname_address
				+ ", number_address=" + number_address + ", detail_address=" + detail_address + ", backoffice_tag="
				+ backoffice_tag + ", backoffice_info=" + backoffice_info + ", backoffice_option=" + backoffice_option
				+ ", backoffice_around=" + backoffice_around + ", backoffice_image=" + backoffice_image
				+ ", host_image=" + host_image + ", backoffice_state=" + backoffice_state + ", apply_date=" + apply_date
				+ ", multipartFile_room=" + multipartFile_room + ", multipartFile_host=" + multipartFile_host
				+ ", backoffice_type=" + backoffice_type + "]";
	}

	
}
