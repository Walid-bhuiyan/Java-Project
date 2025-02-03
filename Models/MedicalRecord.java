package Models;
import java.lang.*;

public class MedicalRecord
{
	private String medicalRecordId;
	private Patient patient;
	private String details;
	
	public MedicalRecord()
	{
		
	}
	
	public MedicalRecord(String medicalRecordId,Patient patient, String details)
	{
		this.medicalRecordId= medicalRecordId;
		this.patient= patient;
		this.details= details;
	}
	
	public void setMedicalRecordId(String medicalRecordId)
	{
		this.medicalRecordId= medicalRecordId;
	}
	
	public void setPatient(Patient patient)
	{
		this.patient= patient;
	}
	
	public void setDetails(String details)
	{
		this.details= details;
	}
	
	public String getMedicalRecordId()
	{
		return this.medicalRecordId;
	}
	
	public Patient getPatient()
	{
		return this.patient;
	}
	
	public String getDetails()
	{
		return this.details;
	}
	
	public String toStringMedicalRecord()
	{
		String str= this.medicalRecordId+","+this.patient.toStringPatient()+","+this.details+"\n";
		return str;
	}
	
	public MedicalRecord formMedicalRecord(String str)
	{
		String information[]= str.split(",");
		
		if(information.length>=3)
		{
			MedicalRecord mr= new MedicalRecord();
			mr.setMedicalRecordId(information[0]);
			Patient patient= new Patient(information[1],information[2],information[3],information[4],information[5],Integer.parseInt(information[6]),information[7],Integer.parseInt(information[8]),information[9]);
			mr.setPatient(patient);
			mr.setDetails(information[10]);
			return mr;
		}
		else
		{
			return null;
		}
		
	}
}