package test.com.rence.office.model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeInfoDAOImpl implements OfficeInfoDAO {

	private static final Logger logger = LoggerFactory.getLogger(OfficeInfoDAOImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
	
		OfficeInfoVO vo = sqlSession.selectOne("SQL_SELECT_ONE_OFFICE_INFO", backoffice_no);
		
		return vo;
	}

	@Override
	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no) {
		
		OfficeOperatingTimeVO_date vo = sqlSession.selectOne("SQL_SELECT_ONE_OPERATING_TIME", backoffice_no);
		
		return vo;
	}

	@Override
	public List<OfficeRoomVO> select_all_room(String backoffice_no) {
		
		List<OfficeRoomVO> list = sqlSession.selectList("SQL_SELECT_ALL_ROOM_INFO", backoffice_no);
		
		if (list != null) {
			for (OfficeRoomVO vo : list) {
				DecimalFormat dc = new DecimalFormat("###,###,###,###");
				vo.setRoom_price(dc.format(Integer.parseInt(vo.getRoom_price())));
			}
		}
		
		return list;
	}
	
	@Override
	public List<OfficeCommentsVO> select_all_comment(String backoffice_no) {
		
		List<OfficeCommentsVO> list = sqlSession.selectList("SQL_SELECT_ALL_COMMENTS_INFO", backoffice_no);
		
		return list;
	}

	@Override
	public List<OfficeReviewVO> select_all_review(String backoffice_no) {
		
		List<OfficeReviewVO> list = sqlSession.selectList("SQL_SELECT_ALL_REVIEW_INFO", backoffice_no);
		
		
		return list;
	}

	@Override
	public int check_reserve(OfficeReserveVO vo) throws ParseException {
		
		int flag = 0;
		
		logger.info("check_reserve()...");
		
		OfficeOperatingTimeVO ovo = sqlSession.selectOne("SQL_SELECT_ONE_OPERATING_TIME_STRING", vo.getBackoffice_no());
		
		logger.info("check_reserve()... ovo :: {}", ovo);		
		logger.info("check_reserve()... vo :: {}", vo);
		String reserve_room_no = vo.getRoom_no();
		
		// 1. 휴무일 체크
		// s_split~~, rs_hour, rs_minute : 사용자에게 받은 체크인 시간
		// e_split~~, re_hour, re_minute : 사용자에게 받은 체크아웃 시간
		String[] s_splitDate = vo.getReserve_stime().split(" ");
		String[] s_splitDate2 = s_splitDate[0].split("/");
		String[] s_splitTime = s_splitDate[1].split(":");
		
		String[] e_splitDate = vo.getReserve_etime().split(" ");
		String[] e_splitDate2 = e_splitDate[0].split("/");
		String[] e_splitTime = e_splitDate[1].split(":");
		
		int rs_year = Integer.parseInt(s_splitDate2[0]);
		int rs_month = Integer.parseInt(s_splitDate2[1]);
		int rs_day = Integer.parseInt(s_splitDate2[2]);
		
		int re_year = Integer.parseInt(e_splitDate2[0]);
		int re_month = Integer.parseInt(e_splitDate2[1]);
		int re_day = Integer.parseInt(e_splitDate2[2]);
		
		// 받은 체크인 시간
		int rs_hour = Integer.parseInt(s_splitTime[0]);
		int rs_minute = Integer.parseInt(s_splitTime[1]); 
		
		// 받은 체크아웃 시간
		int re_hour = Integer.parseInt(e_splitTime[0]);
		int re_minute = Integer.parseInt(e_splitTime[1]); 
		
		if (rs_hour > re_hour) return flag;

		// 1.1 요일 구하기 1 ~ 7 (월 ~ 일)
		LocalDate date = LocalDate.of(rs_year, rs_month, rs_day);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int rs_dayOfWeekNumber = dayOfWeek.getValue();
		
		date = LocalDate.of(re_year, re_month, re_day);
		dayOfWeek = date.getDayOfWeek();
//		int re_dayOfWeekNumber = dayOfWeek.getValue();
		
		switch(rs_dayOfWeekNumber) {
		// 월
		case 1:
			// 체크인 예약 날짜가 휴무일 때.
			if (ovo.getMon_dayoff().equals("T")) return flag;
			else {
				// 영업을 할 때
				String[] splitStartDate = ovo.getMon_stime().split(" ");	
				String[] splitStartTime = splitStartDate[1].split(":");
				
				String[] splitEndDate = ovo.getMon_etime().split(" ");		 
				String[] splitEndTime = splitEndDate[1].split(":");
				
				int os_hour = Integer.parseInt(splitStartTime[0]);		// 공간 영업 시작 시간			
				int oe_hour = Integer.parseInt(splitEndTime[0]);		// 공간 영업 마감 시간
				
				// 1.1.1 예약 체크인 시간 혹은 예약 체크아웃 시간이 영업시간과 맞지 않을 때
				List<Integer> operatingTimeList = new ArrayList<Integer>();
				List<Integer> reserveTimeList = new ArrayList<Integer>();
				
				// 1.1.2 예약 시간이 운영 시간과 맞지 않을 때
				if (os_hour > rs_hour || rs_hour - oe_hour >= 0 || oe_hour < re_hour) {			
					return flag;
				} else {
					// 1.1.3 예약 시간이 운영 시간과 맞을 때
					// 운영 시간
					for (int shour = os_hour; shour <= oe_hour; shour++)
						operatingTimeList.add(shour);
					
					// 사용자 예약 시간
					for (int shour = rs_hour; shour <= re_hour; shour++)
						reserveTimeList.add(shour);
					
					String sql_like_date = "%" + s_splitDate2[1] + "/" + s_splitDate2[2] + "%";
					
					Map<String, String> reserve_map = new HashMap<String, String>();
					reserve_map.put("sql_like_date", sql_like_date);
					reserve_map.put("room_no", reserve_room_no);
					
					// 이미 예약된 리스트 불러오기
					List<OfficeReserveVO> reserve_list = sqlSession.selectList("SQL_CHECK_RESERVE", reserve_map);
					List<Integer> reserved_time = new ArrayList<Integer>();
					
					logger.info("operatingTimeList : {}", operatingTimeList);
					logger.info("reserveTimeList : {}", reserveTimeList);
					
					for(OfficeReserveVO orvo : reserve_list) {
						splitStartDate = orvo.getReserve_stime().split(" ");	
						splitStartTime = splitStartDate[1].split(":");
						
						splitEndDate = orvo.getReserve_etime().split(" ");		 
						splitEndTime = splitEndDate[1].split(":");
						
						int s_hour = Integer.parseInt(splitStartTime[0]);		// 공간 영업 시작 시간			
						int e_hour = Integer.parseInt(splitEndTime[0]);			// 공간 영업 마감 시간
								
						for (int hour = s_hour; hour < e_hour; hour++)
							reserved_time.add(hour);
						
						for (int time : reserved_time)
							operatingTimeList.remove(Integer.valueOf(time));
						
						logger.info("orvo :: {}", orvo);
						System.out.println(s_hour + " " + e_hour);
						logger.info("reserved_time :: {}", reserved_time);
						logger.info("operatingTimeList ::: {}", operatingTimeList);
					}
					
					logger.info("=====================");
//					logger.info("reserve_list : {}", reserve_list);
//					logger.info("reserved_time : {}", reserved_time);
//					logger.info("operatingTimeList :: {}", operatingTimeList);
					logger.info("=====================");
					
					Boolean reserve_flag = true;
					for (int time : reserveTimeList) {
						reserve_flag = operatingTimeList.remove(Integer.valueOf(time));
						logger.info("reserve_flag ***:: {}", reserve_flag);
						
						if (reserve_flag == false) {
							flag = 0;
							return flag;
						}
					}
					
					logger.info("new operatingTimeList :::: {}", operatingTimeList);
					logger.info("reserve_flag {}", reserve_flag);
					if (reserve_flag) {
						
						String stime =  Integer.toString(rs_year) + "/" + Integer.toString(rs_month) + "/" + Integer.toString(rs_day) + " " + 
												Integer.toString(rs_hour) + ":" + Integer.toString(rs_minute) + ":00";
						String etime =  Integer.toString(re_year) + "/" + Integer.toString(re_month) + "/" + Integer.toString(re_day) + " " + 
								Integer.toString(re_hour) + ":" + Integer.toString(re_minute) + ":00";
		
						
						SimpleDateFormat formmater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date reserve_stime = formmater.parse(stime);
						Date reserve_etime = formmater.parse(etime);
						
						OfficeRoomVO orvo = sqlSession.selectOne("SQL_SELECT_ONE_ROOM_TYPE", vo.getRoom_no());
						String room_no = orvo.getRoom_no();
						
						OfficeReserveVO_date rvo_d = new OfficeReserveVO_date();
						
						rvo_d.setReserve_stime(reserve_stime);
						rvo_d.setReserve_etime(reserve_etime);
						rvo_d.setReserve_sdate(reserve_stime);
						rvo_d.setReserve_edate(reserve_etime);
						rvo_d.setRoom_no(room_no);
						rvo_d.setUser_no(vo.getUser_no());
						rvo_d.setBackoffice_no(vo.getBackoffice_no());
						rvo_d.setRoom_type(orvo.getRoom_type());
						
						logger.info("final vo :: {}", vo);
						logger.info("final rvo_d :: {}", rvo_d);
						
//						flag = 1;
						flag = sqlSession.insert("SQL_INSERT_RESERVE", rvo_d);						
					}
				}
			}
			break;
		
		}
		
		
		
		return flag; 
	}

	

}
