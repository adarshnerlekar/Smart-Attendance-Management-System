package com.System.Repositry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.System.Entity.Attendance;
import com.System.Entity.Student;


@Repository
public interface AttendanceRepositry  extends JpaRepository<Attendance, Long>
{
	boolean existsByStudentAndDate(Student student, LocalDate date);
	
    Optional<Attendance>findByStudentIdAndDate(Integer id,LocalDate date );
    
    List<Attendance>findByStudentIdAndDateBetween(Integer studentId, LocalDate startDate,LocalDate endDate);
    
}
