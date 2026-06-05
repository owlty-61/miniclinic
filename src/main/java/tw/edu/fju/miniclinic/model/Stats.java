package tw.edu.fju.miniclinic.model;

import java.util.List;

public class Stats {

    private long doctorCount;
    private long patientCount;
    private long appointmentCount;
    private List<Object[]> deptStats;

    public Stats() {}

    public Stats(long doctorCount, long patientCount, long appointmentCount, List<Object[]> deptStats) {
        this.doctorCount = doctorCount;
        this.patientCount = patientCount;
        this.appointmentCount = appointmentCount;
        this.deptStats = deptStats;
    }

    public long getDoctorCount() { return doctorCount; }
    public long getPatientCount() { return patientCount; }
    public long getAppointmentCount() { return appointmentCount; }
    public List<Object[]> getDeptStats() { return deptStats; }

    public void setDoctorCount(long doctorCount) { this.doctorCount = doctorCount; }
    public void setPatientCount(long patientCount) { this.patientCount = patientCount; }
    public void setAppointmentCount(long appointmentCount) { this.appointmentCount = appointmentCount; }
    public void setDeptStats(List<Object[]> deptStats) { this.deptStats = deptStats; }
}
