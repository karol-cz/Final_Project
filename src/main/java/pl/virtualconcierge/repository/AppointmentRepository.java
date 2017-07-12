package pl.virtualconcierge.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.virtualconcierge.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	List<Appointment> findByUserId(Long id);
	List<Appointment> findByCompanyId(Long id);
	List<Appointment> findByCompanyIdAndDate(Long id, LocalDate date);

}
