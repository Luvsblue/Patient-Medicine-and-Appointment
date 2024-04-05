package com.Project2.Patient.Medicine.and.Appointment.Repository;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
