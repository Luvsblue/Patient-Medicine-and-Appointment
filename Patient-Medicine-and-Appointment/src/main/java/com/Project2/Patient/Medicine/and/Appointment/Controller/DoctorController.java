package com.Project2.Patient.Medicine.and.Appointment.Controller;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Appointment;
import com.Project2.Patient.Medicine.and.Appointment.Entity.Doctor;
import com.Project2.Patient.Medicine.and.Appointment.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor != null) {
            return ResponseEntity.ok().body(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") Long doctorId,
                                               @RequestBody Doctor doctorDetails) {
        Doctor updatedDoctor = doctorService.updateDoctor(doctorId, doctorDetails);
        if (updatedDoctor != null) {
            return ResponseEntity.ok().body(updatedDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable(value = "id") Long doctorId) {
        boolean deleted = doctorService.deleteDoctor(doctorId);
        if (deleted) {
            return ResponseEntity.ok().body(Map.of("deleted", true));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable(value = "id") Long doctorId) {
        List<Appointment> appointments = doctorService.getDoctorAppointments(doctorId);
        if (appointments != null) {
            return ResponseEntity.ok().body(appointments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
