package Models;
import java.lang.*;

public class Appointment
{
	private String appointmentId;
	private Doctor doctor;
	private Patient patient;
	private String date;
	private String status;
	
	public Appointment()
	{
		
	}
	
	public Appointment(String appointmentId, Doctor doctor, Patient patient, String date, String status)
	{
		this.appointmentId= appointmentId;
		this.doctor= doctor;
		this.patient= patient;
		this.date= date;
		this.status= status;
	}
	
	public void setAppointmentId(String appointmentId)
	{
		this.appointmentId= appointmentId;
	}
	
	public void setDoctor(Doctor doctor)
	{
		this.doctor= doctor;
	}
	
	public void setPatient(Patient patient)
	{
		this.patient= patient;
	}
	
	public void setDate(String date)
	{
		this.date= date;
	}
	
	public void setStatus(String status)
	{
		this.status= status;
	}
	
	public String getAppointmentId()
	{
		return this.appointmentId;
	}
	
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public Patient getPatient()
	{
		return this.patient;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public String toStringAppointment()
	{
		String str= this.appointmentId+","+this.doctor.toStringDoctor()+","+this.patient.toStringPatient()+","+this.date+","+this.status+"\n";
		return str;
	}
	
	public Appointment formAppointment(String str)
	{
		String information[]= str.split(",");
		
		if(information.length>=3)
		{
			Appointment ap= new Appointment();
			ap.setAppointmentId(information[0]);
			Doctor doctor= new Doctor(information[1],information[2],information[3],information[4],information[5],Integer.parseInt(information[6]),information[7],information[8]);
			ap.setDoctor(doctor);
			Patient patient= new Patient(information[9],information[10],information[11],information[12],information[13],Integer.parseInt(information[14]),information[15],Integer.parseInt(information[16]),information[17]);
			ap.setPatient(patient);
			ap.setDate(information[18]);
			ap.setStatus(information[19]);
			return ap;
		}
		else
		{
			return null;
		}
		
	}
}