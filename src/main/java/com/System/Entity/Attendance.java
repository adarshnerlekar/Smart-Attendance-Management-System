package com.System.Entity;

import java.time.LocalDate;

import com.System.AttendanceStatus2;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
		   name = "attendance",
		   uniqueConstraints = {
		     @UniqueConstraint(columnNames = {"student_id", "date"})
		   }
		)
public class Attendance {
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
     
	    private LocalDate date;

	    @Enumerated(EnumType.STRING)
	    private AttendanceStatus2 status;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

}
