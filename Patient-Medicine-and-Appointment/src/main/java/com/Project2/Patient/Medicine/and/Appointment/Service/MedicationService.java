package com.Project2.Patient.Medicine.and.Appointment.Service;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Medication;
import com.Project2.Patient.Medicine.and.Appointment.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    public Medication getMedicationById(Long id) {
        @SuppressWarnings("null")
        Optional<Medication> medicationOptional = medicationRepository.findById(id);
        return medicationOptional.orElse(null);
    }

    @SuppressWarnings("null")
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    @SuppressWarnings("null")
    public Medication updateMedication(Long id, Medication medicationDetails) {
        Optional<Medication> medicationOptional = medicationRepository.findById(id);
        if (medicationOptional.isPresent()) {
            Medication medication = medicationOptional.get();
            // Update fields as needed
            return medicationRepository.save(medication);
        } else {
            return null;
        }
    }

    @SuppressWarnings("null")
    public boolean deleteMedication(Long id) {
        Optional<Medication> medicationOptional = medicationRepository.findById(id);
        if (medicationOptional.isPresent()) {
            medicationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
