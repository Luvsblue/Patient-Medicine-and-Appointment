package com.Project2.Patient.Medicine.and.Appointment.Repository;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByName(String name);

    List<Patient> findByAge(int age);

    List<Patient> findByGender(String gender);
}
