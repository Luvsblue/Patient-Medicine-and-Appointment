package com.Project2.Patient.Medicine.and.Appointment.Service;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Appointment;
import com.Project2.Patient.Medicine.and.Appointment.Entity.Doctor;
import com.Project2.Patient.Medicine.and.Appointment.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        @SuppressWarnings("null")
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        return doctorOptional.orElse(null);
    }

    @SuppressWarnings("null")
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        @SuppressWarnings("null")
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.setName(doctorDetails.getName());
            // Set other fields as needed
            return doctorRepository.save(doctor);
        } else {
            return null;
        }
    }

    @SuppressWarnings("null")
    public boolean deleteDoctor(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public List<Appointment> getDoctorAppointments(Long doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            return doctor.getAppointments();
        }
        return null;
    }


}
