package com.Project2.Patient.Medicine.and.Appointment.Controller;


import com.Project2.Patient.Medicine.and.Appointment.Entity.Patient;
import com.Project2.Patient.Medicine.and.Appointment.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        if (patient != null) {
            return ResponseEntity.ok().body(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long patientId,
                                                 @RequestBody Patient patientDetails) {
        Patient updatedPatient = patientService.updatePatient(patientId, patientDetails);
        if (updatedPatient != null) {
            return ResponseEntity.ok().body(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable(value = "id") Long patientId) {
        boolean deleted = patientService.deletePatient(patientId);
        if (deleted) {
            return ResponseEntity.ok().body(Map.of("deleted", true));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Patient> searchPatientsByName(@RequestParam(value = "name") String name) {
        return patientService.findPatientsByName(name);
    }



}
