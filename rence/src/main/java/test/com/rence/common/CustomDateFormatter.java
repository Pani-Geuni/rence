package test.com.rence.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormatter {
	
	public CustomDateFormatter() {
		// TODO Auto-generated constructor stub
	}
	
	// st = String Time 
	// dt = Date Time
	
	// String으로 받은 시간 값 (HH:mm 형식)을
	// Date로 형변환 시켜주는 함수.
	// 단, 이 함수는 HH:mm 형식만 됨.
	public Date hourFormmatter(String st) {
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date dt = null;	// simple date
		
		try {
			// String st를 Date dt로 변환.
			dt = df.parse(st);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dt;
	}
}
