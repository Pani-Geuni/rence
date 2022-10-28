/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import java.io.Serializable;

public class MasterVO implements Serializable{

	private String master_no;
	private String master_id;
	private String master_pw;
	
	public MasterVO() {}

	public MasterVO(String master_no, String master_id, String master_pw) {
		super();
		this.master_no = master_no;
		this.master_id = master_id;
		this.master_pw = master_pw;
	}

	public String getMaster_no() {
		return master_no;
	}

	public void setMaster_no(String master_no) {
		this.master_no = master_no;
	}

	public String getMaster_id() {
		return master_id;
	}

	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}

	public String getMaster_pw() {
		return master_pw;
	}

	public void setMaster_pw(String master_pw) {
		this.master_pw = master_pw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((master_id == null) ? 0 : master_id.hashCode());
		result = prime * result + ((master_no == null) ? 0 : master_no.hashCode());
		result = prime * result + ((master_pw == null) ? 0 : master_pw.hashCode());
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
		MasterVO other = (MasterVO) obj;
		if (master_id == null) {
			if (other.master_id != null)
				return false;
		} else if (!master_id.equals(other.master_id))
			return false;
		if (master_no == null) {
			if (other.master_no != null)
				return false;
		} else if (!master_no.equals(other.master_no))
			return false;
		if (master_pw == null) {
			if (other.master_pw != null)
				return false;
		} else if (!master_pw.equals(other.master_pw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MasterVO [master_no=" + master_no + ", master_id=" + master_id + ", master_pw=" + master_pw + "]";
	}
	
	
}
