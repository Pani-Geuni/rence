/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;
import java.util.Date;

public class ReserveVO implements Serializable {

	private String reserve_no;
	private Date reserve_stime;
	private Date reserve_etime;
	private Date reserve_sdate;
	private Date reserve_edate;
	private String reserve_state;
	private String room_no;
	private String user_no;
	private String backoffice_no;
	
	public ReserveVO() {}
	
	public ReserveVO(String reserve_no, Date reserve_stime, Date reserve_etime, Date reserve_sdate, Date reserve_edate,
			String reserve_state, String room_no, String user_no, String backoffice_no) {
		super();
		this.reserve_no = reserve_no;
		this.reserve_stime = reserve_stime;
		this.reserve_etime = reserve_etime;
		this.reserve_sdate = reserve_sdate;
		this.reserve_edate = reserve_edate;
		this.reserve_state = reserve_state;
		this.room_no = room_no;
		this.user_no = user_no;
		this.backoffice_no = backoffice_no;
	}

	public String getReserve_no() {
		return reserve_no;
	}

	public void setReserve_no(String reserve_no) {
		this.reserve_no = reserve_no;
	}

	public Date getReserve_stime() {
		return reserve_stime;
	}

	public void setReserve_stime(Date reserve_stime) {
		this.reserve_stime = reserve_stime;
	}

	public Date getReserve_etime() {
		return reserve_etime;
	}

	public void setReserve_etime(Date reserve_etime) {
		this.reserve_etime = reserve_etime;
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

	public String getReserve_state() {
		return reserve_state;
	}

	public void setReserve_state(String reserve_state) {
		this.reserve_state = reserve_state;
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
		result = prime * result + ((reserve_edate == null) ? 0 : reserve_edate.hashCode());
		result = prime * result + ((reserve_etime == null) ? 0 : reserve_etime.hashCode());
		result = prime * result + ((reserve_no == null) ? 0 : reserve_no.hashCode());
		result = prime * result + ((reserve_sdate == null) ? 0 : reserve_sdate.hashCode());
		result = prime * result + ((reserve_state == null) ? 0 : reserve_state.hashCode());
		result = prime * result + ((reserve_stime == null) ? 0 : reserve_stime.hashCode());
		result = prime * result + ((room_no == null) ? 0 : room_no.hashCode());
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
		ReserveVO other = (ReserveVO) obj;
		if (backoffice_no == null) {
			if (other.backoffice_no != null)
				return false;
		} else if (!backoffice_no.equals(other.backoffice_no))
			return false;
		if (reserve_edate == null) {
			if (other.reserve_edate != null)
				return false;
		} else if (!reserve_edate.equals(other.reserve_edate))
			return false;
		if (reserve_etime == null) {
			if (other.reserve_etime != null)
				return false;
		} else if (!reserve_etime.equals(other.reserve_etime))
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
		if (reserve_state == null) {
			if (other.reserve_state != null)
				return false;
		} else if (!reserve_state.equals(other.reserve_state))
			return false;
		if (reserve_stime == null) {
			if (other.reserve_stime != null)
				return false;
		} else if (!reserve_stime.equals(other.reserve_stime))
			return false;
		if (room_no == null) {
			if (other.room_no != null)
				return false;
		} else if (!room_no.equals(other.room_no))
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
		return "ReserveVO [reserve_no=" + reserve_no + ", reserve_stime=" + reserve_stime + ", reserve_etime="
				+ reserve_etime + ", reserve_sdate=" + reserve_sdate + ", reserve_edate=" + reserve_edate
				+ ", reserve_state=" + reserve_state + ", room_no=" + room_no + ", user_no=" + user_no
				+ ", backoffice_no=" + backoffice_no + "]";
	}
	
}
