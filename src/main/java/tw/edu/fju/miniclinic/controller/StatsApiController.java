package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.edu.fju.miniclinic.model.AppointmentRepository;
import tw.edu.fju.miniclinic.model.DoctorRepository;
import tw.edu.fju.miniclinic.model.PatientRepository;

import java.util.Map;

@RestController
public class StatsApiController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping("/api/stats")
    public Map<String, Object> getStats() {
        return Map.of(
            "totalDoctors", doctorRepo.count(),
            "totalPatients", patientRepo.count(),
            "totalAppointments", appointmentRepo.count(),
            "byStatus", Map.of(
                "BOOKED", appointmentRepo.countByStatus("BOOKED"),
                "COMPLETED", appointmentRepo.countByStatus("COMPLETED"),
                "CANCELLED", appointmentRepo.countByStatus("CANCELLED")
            )
        );
    }
}
