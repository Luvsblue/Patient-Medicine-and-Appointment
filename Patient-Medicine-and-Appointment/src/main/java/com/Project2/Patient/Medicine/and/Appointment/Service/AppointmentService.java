package com.Project2.Patient.Medicine.and.Appointment.Service;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Appointment;
import com.Project2.Patient.Medicine.and.Appointment.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        @SuppressWarnings("null")
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        return appointmentOptional.orElse(null);
    }

    @SuppressWarnings("null")
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * @param id
     * @param appointmentDetails
     * @return
     */
    @SuppressWarnings("null")
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            return appointmentRepository.save(appointment);
        } else {
            return null;
        }
    }

    @SuppressWarnings("null")
    public boolean deleteAppointment(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
