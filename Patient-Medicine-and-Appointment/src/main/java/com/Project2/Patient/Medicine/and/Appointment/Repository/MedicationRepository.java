package com.Project2.Patient.Medicine.and.Appointment.Repository;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
