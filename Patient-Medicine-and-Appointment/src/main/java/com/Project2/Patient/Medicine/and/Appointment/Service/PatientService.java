package com.Project2.Patient.Medicine.and.Appointment.Service;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Patient;
import com.Project2.Patient.Medicine.and.Appointment.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
        @SuppressWarnings("null")
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        return patientOptional.orElse(null);
    }

    @SuppressWarnings("null")
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long patientId, Patient patientDetails) {
        @SuppressWarnings("null")
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient existingPatient = patientOptional.get();
            existingPatient.setName(patientDetails.getName());
            existingPatient.setAge(patientDetails.getAge());
            existingPatient.setGender(patientDetails.getGender());

            return patientRepository.save(existingPatient);
        }
        return null;
    }

    @SuppressWarnings("null")
    public boolean deletePatient(Long patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
            return true;
        }
        return false;
    }

    public List<Patient> findPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> findPatientsByAge(int age) {
        return patientRepository.findByAge(age);
    }

    public List<Patient> findPatientsByGender(String gender) {
        return patientRepository.findByGender(gender);
    }
}