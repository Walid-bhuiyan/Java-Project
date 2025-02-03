package Models;
import java.lang.*;

public class Payment
{
	private String paymentId;
	private Doctor doctor;
	private Patient patient;
	private double amount;
	
	public Payment()
	{
		
	}
	
	public Payment(String paymentId, Doctor doctor, Patient patient, double amount)
	{
		this.paymentId= paymentId;
		this.doctor= doctor;
		this.patient= patient;
		this.amount= amount;
	}
	
	public void setPaymentId(String paymentId)
	{
		this.paymentId= paymentId;
	}
	
	public void setDoctor(Doctor doctor)
	{
		this.doctor= doctor;
	}
	
	public void setPatient(Patient patient)
	{
		this.patient= patient;
	}
	
	public void setAmount(double amount)
	{
		this.amount= amount;
	}
	
	public String getPaymentId()
	{
		return this.paymentId;
	}
	
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public Patient getPatient()
	{
		return this.patient;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public String toStringPayment()
	{
		String str= this.paymentId+","+this.doctor.toStringDoctor()+","+this.patient.toStringPatient()+","+this.amount+"\n";
		return str;
	}
	
	public Payment formPayment(String str)
	{
		String information[]= str.split(",");
		
		if(information.length>=3)
		{
			Payment pa= new Payment();
			pa.setPaymentId(information[0]);
			Doctor doctor= new Doctor(information[1],information[2],information[3],information[4],information[5],Integer.parseInt(information[6]),information[7],information[8]);
			pa.setDoctor(doctor);
			Patient patient= new Patient(information[9],information[10],information[11],information[12],information[13],Integer.parseInt(information[14]),information[15],Integer.parseInt(information[16]),information[17]);
			pa.setPatient(patient);
			pa.setAmount(Double.parseDouble(information[18]));
			return pa;
		}
		else
		{
			return null;
		}
		
	}
}