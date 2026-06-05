package tw.edu.fju.miniclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.edu.fju.miniclinic.model.AppointmentRepository;
import tw.edu.fju.miniclinic.model.DoctorRepository;
import tw.edu.fju.miniclinic.model.PatientRepository;

@Controller
public class StatsController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping("/stats")
    public String getAppointmentStats(Model model) {
        long doctorTotalCount = doctorRepo.count();
        model.addAttribute("doctorTotalCount", doctorTotalCount); // 醫師總數

        long patientTotalCount = patientRepo.count();
        model.addAttribute("patientTotalCount", patientTotalCount); // 病人總數

        long appointmentTotalCount = appointmentRepo.count();
        model.addAttribute("appointmentTotalCount", appointmentTotalCount); // 預約總數

        //依科別分組的掛號數
        List<Object[]> deptStats = appointmentRepo.countAppointmentsByDepartment();
        model.addAttribute("deptStats", deptStats);

        return "stats";
    }
}