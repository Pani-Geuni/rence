package test.com.rence;

public class ListVO {
	String backoffice_no;
	String company_name;
	String roadname_address;
	String backoffice_tag;
	String backoffice_image;
	String min_room_price;
	int avg_rating;
	
	
	public ListVO() { }


	public ListVO(String backoffice_no, String company_name, String roadname_address, String backoffice_tag,
			String backoffice_image, String min_room_price, int avg_rating) {
		super();
		this.backoffice_no = backoffice_no;
		this.company_name = company_name;
		this.roadname_address = roadname_address;
		this.backoffice_tag = backoffice_tag;
		this.backoffice_image = backoffice_image;
		this.min_room_price = min_room_price;
		this.avg_rating = avg_rating;
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


	public String getRoadname_address() {
		return roadname_address;
	}


	public void setRoadname_address(String roadname_address) {
		this.roadname_address = roadname_address;
	}


	public String getBackoffice_tag() {
		return backoffice_tag;
	}


	public void setBackoffice_tag(String backoffice_tag) {
		this.backoffice_tag = backoffice_tag;
	}


	public String getBackoffice_image() {
		return backoffice_image;
	}


	public void setBackoffice_image(String backoffice_image) {
		this.backoffice_image = backoffice_image;
	}


	public String getMin_room_price() {
		return min_room_price;
	}


	public void setMin_room_price(String min_room_price) {
		this.min_room_price = min_room_price;
	}


	public int getAvg_rating() {
		return avg_rating;
	}


	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avg_rating;
		result = prime * result + ((backoffice_image == null) ? 0 : backoffice_image.hashCode());
		result = prime * result + ((backoffice_no == null) ? 0 : backoffice_no.hashCode());
		result = prime * result + ((backoffice_tag == null) ? 0 : backoffice_tag.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((min_room_price == null) ? 0 : min_room_price.hashCode());
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
		ListVO other = (ListVO) obj;
		if (avg_rating != other.avg_rating)
			return false;
		if (backoffice_image == null) {
			if (other.backoffice_image != null)
				return false;
		} else if (!backoffice_image.equals(other.backoffice_image))
			return false;
		if (backoffice_no == null) {
			if (other.backoffice_no != null)
				return false;
		} else if (!backoffice_no.equals(other.backoffice_no))
			return false;
		if (backoffice_tag == null) {
			if (other.backoffice_tag != null)
				return false;
		} else if (!backoffice_tag.equals(other.backoffice_tag))
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (min_room_price == null) {
			if (other.min_room_price != null)
				return false;
		} else if (!min_room_price.equals(other.min_room_price))
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
		return "ListVO [backoffice_no=" + backoffice_no + ", company_name=" + company_name + ", roadname_address="
				+ roadname_address + ", backoffice_tag=" + backoffice_tag + ", backoffice_image=" + backoffice_image
				+ ", min_room_price=" + min_room_price + ", avg_rating=" + avg_rating + "]";
	}
	
}
