/**
 * 
 * @author 최진실
 * 운영시간 타입 변환
 *
 */
package test.com.rence.backoffice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatingTime {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatingTime.class);


	public BackOfficeOperationgTimeVO_datetype operatingTime(BackOfficeOperationgTimeVO ovo, BackOfficeOperationgTimeVO_datetype ovo2) {
		
		//Date mon_stime = customDateFormatter.hourFormmatter(ovo.getMon_stime());
		
		 //운영시간
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

		 String s_mon_format = formatter.format(ovo.getMon_stime());
		 java.sql.Date mon_sdate = java.sql.Date.valueOf(s_mon_format);
		 ovo2.setMon_stime(mon_sdate);
		 
		 String e_mon_format = formatter.format(ovo.getMon_etime());
		 java.sql.Date mon_edate = java.sql.Date.valueOf(e_mon_format);
		 ovo2.setMon_etime(mon_edate);
		 
		 String s_tue_format = formatter.format(ovo.getTue_stime());
		 java.sql.Date tue_sdate = java.sql.Date.valueOf(s_tue_format);
		 ovo2.setTue_stime(tue_sdate);
		 
		 String e_tue_format = formatter.format(ovo.getTue_etime());
		 java.sql.Date tue_edate = java.sql.Date.valueOf(e_tue_format);
		 ovo2.setTue_etime(tue_edate);
		 
		 String s_wed_format = formatter.format(ovo.getWed_stime());
		 java.sql.Date wed_sdate = java.sql.Date.valueOf(s_wed_format);
		 ovo2.setWed_stime(wed_sdate);
		 
		 String e_wed_format = formatter.format(ovo.getWed_etime());
		 java.sql.Date wed_edate = java.sql.Date.valueOf(e_wed_format);
		 ovo2.setWed_etime(wed_edate);
		 
		 String s_thu_format = formatter.format(ovo.getThu_stime());
		 java.sql.Date thu_sdate = java.sql.Date.valueOf(s_thu_format);
		 ovo2.setThu_stime(thu_sdate);
		 
		 String e_thu_format = formatter.format(ovo.getThu_etime());
		 java.sql.Date thu_edate = java.sql.Date.valueOf(e_thu_format);
		 ovo2.setThu_etime(thu_edate);
		 
		 String s_fri_format = formatter.format(ovo.getFri_stime());
		 java.sql.Date fri_sdate = java.sql.Date.valueOf(s_fri_format);
		 ovo2.setFri_stime(fri_sdate);
		 
		 String e_fri_format = formatter.format(ovo.getFri_etime());
		 java.sql.Date fri_edate = java.sql.Date.valueOf(e_fri_format);
		 ovo2.setFri_etime(fri_edate);
		 
		 String s_sat_format = formatter.format(ovo.getSat_stime());
		 java.sql.Date sat_sdate = java.sql.Date.valueOf(s_sat_format);
		 ovo2.setSat_stime(sat_sdate);
		 
		 String e_sat_format = formatter.format(ovo.getSat_etime());
		 java.sql.Date sat_edate = java.sql.Date.valueOf(e_sat_format);
		 ovo2.setSat_etime(sat_edate);
		 
		 String s_sun_format = formatter.format(ovo.getSun_stime());
		 java.sql.Date sun_sdate = java.sql.Date.valueOf(s_sun_format);
		 ovo2.setSun_stime(sun_sdate);
		 
		 String e_sun_format = formatter.format(ovo.getSun_etime());
		 java.sql.Date sun_edate = java.sql.Date.valueOf(e_sun_format);
		 ovo2.setSun_etime(sun_edate);
		 
		 
		return ovo2;
		
	}
}
