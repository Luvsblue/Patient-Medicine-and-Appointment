package com.Project2.Patient.Medicine.and.Appointment.Repository;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
