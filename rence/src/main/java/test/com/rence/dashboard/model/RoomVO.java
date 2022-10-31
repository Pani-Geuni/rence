/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

public class RoomVO {
	private String room_no;
	private String room_type;
	private String room_name;
	private int room_price;
	private String backoffice_no;
	
	public RoomVO() {}

	public RoomVO(String room_no, String room_type, String room_name, int room_price, String backoffice_no) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.room_name = room_name;
		this.room_price = room_price;
		this.backoffice_no = backoffice_no;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public String getBackoffice_no() {
		return backoffice_no;
	}

	public void setBackoffice_no(String backoffice_no) {
		this.backoffice_no = backoffice_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backoffice_no == null) ? 0 : backoffice_no.hashCode());
		result = prime * result + ((room_name == null) ? 0 : room_name.hashCode());
		result = prime * result + ((room_no == null) ? 0 : room_no.hashCode());
		result = prime * result + room_price;
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
		RoomVO other = (RoomVO) obj;
		if (backoffice_no == null) {
			if (other.backoffice_no != null)
				return false;
		} else if (!backoffice_no.equals(other.backoffice_no))
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
		if (room_price != other.room_price)
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
		return "RoomVO [room_no=" + room_no + ", room_type=" + room_type + ", room_name=" + room_name + ", room_price="
				+ room_price + ", backoffice_no=" + backoffice_no + "]";
	}

}
