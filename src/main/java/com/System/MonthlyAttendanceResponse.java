package com.System;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyAttendanceResponse 
{
	    private Integer id;
	    private int month;
	    private int year;
	    private long totalDays;
	    private long presentDays;
	    private double attendancePercentage;
}
