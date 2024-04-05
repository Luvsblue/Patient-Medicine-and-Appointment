package com.Project2.Patient.Medicine.and.Appointment.Controller;

import com.Project2.Patient.Medicine.and.Appointment.Entity.Medication;
import com.Project2.Patient.Medicine.and.Appointment.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping("/")
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable(value = "id") Long medicationId) {
        Medication medication = medicationService.getMedicationById(medicationId);
        if (medication != null) {
            return ResponseEntity.ok().body(medication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication createdMedication = medicationService.createMedication(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable(value = "id") Long medicationId,
                                                       @RequestBody Medication medicationDetails) {
        Medication updatedMedication = medicationService.updateMedication(medicationId, medicationDetails);
        if (updatedMedication != null) {
            return ResponseEntity.ok().body(updatedMedication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedication(@PathVariable(value = "id") Long medicationId) {
        boolean deleted = medicationService.deleteMedication(medicationId);
        if (deleted) {
            return ResponseEntity.ok().body(Map.of("deleted", true));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
