package test.com.rence.backoffice;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class OperatingTime {

	public BackOfficeOperationgTimeVO operatingTime(BackOfficeOperationgTimeVO ovo) {
		
		//운영시간
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		 
		 String s_mon = formatter.format(ovo.getMon_stime());
		 java.sql.Date mon_date = java.sql.Date.valueOf(s_mon);
		 ovo.setMon_stime(mon_date);
		 
		 String e_mon = formatter.format(ovo.getMon_etime());
		 java.sql.Date mon_date2 = java.sql.Date.valueOf(e_mon);
		 ovo.setMon_etime(mon_date2);
		 
		 String s_tue = formatter.format(ovo.getTue_stime());
		 java.sql.Date tue_date = java.sql.Date.valueOf(s_tue);
		 ovo.setTue_stime(tue_date);
		 
		 String e_tue = formatter.format(ovo.getTue_etime());
		 java.sql.Date tue_date2 = java.sql.Date.valueOf(e_tue);
		 ovo.setTue_etime(tue_date2);
		 
		 String s_wed = formatter.format(ovo.getWed_stime());
		 java.sql.Date wed_date = java.sql.Date.valueOf(s_wed);
		 ovo.setWed_stime(wed_date);
		 
		 String e_wed = formatter.format(ovo.getWed_etime());
		 java.sql.Date wed_date2 = java.sql.Date.valueOf(e_wed);
		 ovo.setWed_etime(wed_date2);
		 
		 String s_thu = formatter.format(ovo.getThu_stime());
		 java.sql.Date thu_date = java.sql.Date.valueOf(s_thu);
		 ovo.setThu_stime(thu_date);
		 
		 String e_thu = formatter.format(ovo.getThu_etime());
		 java.sql.Date thu_date2 = java.sql.Date.valueOf(e_thu);
		 ovo.setThu_etime(thu_date2);
		 
		 String s_fri = formatter.format(ovo.getFri_stime());
		 java.sql.Date fri_date = java.sql.Date.valueOf(s_fri);
		 ovo.setFri_stime(fri_date);
		 
		 String e_fri = formatter.format(ovo.getFri_etime());
		 java.sql.Date fri_date2 = java.sql.Date.valueOf(e_fri);
		 ovo.setFri_etime(fri_date2);
		 
		 String s_sat = formatter.format(ovo.getSat_stime());
		 java.sql.Date sat_date = java.sql.Date.valueOf(s_sat);
		 ovo.setSat_stime(sat_date);
		 
		 String e_sat = formatter.format(ovo.getSat_etime());
		 java.sql.Date sat_date2 = java.sql.Date.valueOf(e_sat);
		 ovo.setSat_etime(sat_date2);
		 
		 String s_sun = formatter.format(ovo.getSun_stime());
		 java.sql.Date sun_date = java.sql.Date.valueOf(s_sun);
		 ovo.setSun_stime(sun_date);
		 
		 String e_sun = formatter.format(ovo.getSun_etime());
		 java.sql.Date sun_date2 = java.sql.Date.valueOf(e_sun);
		 ovo.setSun_etime(sun_date2);
		 
		 
		return ovo;
		
	}
}
