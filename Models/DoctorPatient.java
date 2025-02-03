package Models;
import java.lang.*;

public class DoctorPatient
{
	private String doctorPatientId;
	private Doctor doctor;
	private Patient patient;
	
	public DoctorPatient()
	{
		
	}
	
	public DoctorPatient(String doctorPatientId, Doctor doctor, Patient patient)
	{
		this.doctorPatientId= doctorPatientId;
		this.doctor= doctor;
		this.patient= patient;
	}
	
	public void setDoctorPatientId(String doctorPatientId)
	{
		this.doctorPatientId= doctorPatientId;
	}
	
	public void setDoctor(Doctor doctor)
	{
		this.doctor= doctor;
	}
	
	public void setPatient(Patient patient)
	{
		this.patient= patient;
	}
	
	public String getDoctorPatientId()
	{
		return this.doctorPatientId;
	}
	
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public Patient getPatient()
	{
		return this.patient;
	}
	
	public String toStringDoctorPatient()
	{
		String str= this.doctorPatientId+","+this.doctor.toStringDoctor()+","+this.patient.toStringPatient()+"\n";
		return str;
	}
	
	public DoctorPatient formDoctorPatient(String str)
	{
		String information[]= str.split(",");
		
		if(information.length>=3)
		{
			DoctorPatient dp= new DoctorPatient();
			dp.setDoctorPatientId(information[0]);
			Doctor doctor= new Doctor(information[1],information[2],information[3],information[4],information[5],Integer.parseInt(information[6]),information[7],information[8]);
			dp.setDoctor(doctor);
			Patient patient= new Patient(information[9],information[10],information[11],information[12],information[13],Integer.parseInt(information[14]),information[15],Integer.parseInt(information[16]),information[17]);
			dp.setPatient(patient);
			return dp;
		}
		else
		{
			return null;
		}
		
	}
}