package com.System.Rest;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.System.AttendanceStatus2;
import com.System.MonthlyAttendanceResponse;
import com.System.Entity.Attendance;
import com.System.Service.AttendanceService;
import com.System.Service.StudentService;

@RestController
public class AttendanceRest 
{
	@Autowired
	AttendanceService service;
	
		@PostMapping("markAttendance/{id}")
		public ResponseEntity<Attendance> markattendance(@PathVariable Integer id,@RequestParam AttendanceStatus2 Status)
		{
			Attendance markAttendance = service.markAttendance(id, Status);
			System.out.println("Status = " + Status);
			return new ResponseEntity<Attendance>(markAttendance,HttpStatus.ACCEPTED);	
		}
		
		@GetMapping("GetAttendance/{id}")
		public ResponseEntity<Attendance> getAttendence(@PathVariable Integer id,@RequestParam LocalDate date)
		{
			Attendance studentAttendance = service.getStudentAttendance(id, date);
			return new ResponseEntity<Attendance>(studentAttendance,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("StudentReport/{id}")
		public ResponseEntity<MonthlyAttendanceResponse> getStudentReport(@PathVariable Integer id,@RequestParam int month,@RequestParam int year)
		{
		    MonthlyAttendanceResponse monthlyAttendance = service.getMonthlyAttendance(id, month, year);
		    return new ResponseEntity<MonthlyAttendanceResponse>(monthlyAttendance,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("StudentMonthReport/{id}")
		public ResponseEntity<Map<String, Object>> getMonthreport(@PathVariable Integer id,@RequestParam int month,@RequestParam int year)
		{
			Map<String, Object> monthlyAttendance = service.MonthlyAttendance(id, month, year);
			return new ResponseEntity<Map<String, Object>>(monthlyAttendance,HttpStatus.OK);
		}
}
