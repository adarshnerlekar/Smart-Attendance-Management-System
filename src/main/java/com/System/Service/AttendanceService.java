package com.System.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.System.AttendanceStatus2;
import com.System.MonthlyAttendanceResponse;
import com.System.Entity.Attendance;
import com.System.Entity.Student;
import com.System.Repositry.AttendanceRepositry;
import com.System.Repositry.StudentRepositry;

@Service
public class AttendanceService
{

	@Autowired
	AttendanceRepositry attendanceRepositry;
	
	@Autowired
	StudentRepositry studentRepositry;
	
	public Attendance getStudentAttendance(Integer id,LocalDate date)
	{
		Optional<Attendance> byStudentIdAndDate = attendanceRepositry.findByStudentIdAndDate(id,date);
		if(byStudentIdAndDate.isPresent())
		{
			Attendance attendance = byStudentIdAndDate.get();
			return attendance;
		}
		throw new RuntimeException("Attendance Bagu pahila");
	}
	

	public Attendance markAttendance(int id,AttendanceStatus2 status)
	{
		 Student student = studentRepositry.findById(id)
		            .orElseThrow(() -> new RuntimeException("Student Not Found"));

		    LocalDate today = LocalDate.now();

		    if (attendanceRepositry.existsByStudentAndDate(student, today)) {
		        throw new RuntimeException("Attendance already marked for today");
		    }

		    Attendance attendance = new Attendance();
		    attendance.setStudent(student);
		    attendance.setDate(today);
		    attendance.setStatus(status);

		   return  attendanceRepositry.save(attendance);
	}
	
	public MonthlyAttendanceResponse getMonthlyAttendance(
	        Integer id, int month, int year) {

	    LocalDate start = LocalDate.of(year, month, 1);
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

	    List<Attendance> records =
	        attendanceRepositry.findByStudentIdAndDateBetween(
	        		id, start, end);

	    long present = records.stream()
	        .filter(a -> a.getStatus() == AttendanceStatus2.PRESENT)
	        .count();

	    long total = records.size();

	    double percentage = total == 0 ? 0 :
	            (present * 100.0) / total;

	    return new MonthlyAttendanceResponse(id, month, year, total, present, percentage);
	}
	
	public Map<String, Object> MonthlyAttendance(int studentId, int month, int year) {

	    LocalDate start = LocalDate.of(year, month, 1);
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

	    List<Attendance> attendanceList =
	           attendanceRepositry.findByStudentIdAndDateBetween(studentId, start, end);

	    long totalDays = attendanceList.size();
	    long presentDays = attendanceList.stream()
	            .filter(a -> a.getStatus() == AttendanceStatus2.PRESENT)
	            .count();

	    double percentage = totalDays == 0 ? 0 :
	            (presentDays * 100.0) / totalDays;

	    Map<String, Object> response = new HashMap<>();

	    response.put("studentId", studentId);
	    response.put("month", month);
	    response.put("year", year);

	    response.put("summary", Map.of(
	            "totalDays", totalDays,
	            "presentDays", presentDays,
	            "attendancePercentage", percentage
	    ));

	    response.put("dailyAttendance", attendanceList);

	    return response;
	}

	
}
