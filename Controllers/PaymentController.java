package Controllers;
import java.lang.*;
import Models.*;

public class PaymentController
{
	public void insertPayment(Payment pa)
	{
		Payment payments[] = this.getAllPayment();
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] == null)
			{
				payments[i] = pa;
				break;
			}
		}
		this.write(payments);
	}
	
	public void updatePayment(Payment pa)
	{
		Payment payments[] = this.getAllPayment();
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] != null)
			{
				if(payments[i].getPaymentId().equals(pa.getPaymentId()))
				{
					payments[i] = pa;
				}
			}
		}
		this.write(payments);
	}
	
	public void deletePayment(String paymentId)
	{
		Payment payments[] = this.getAllPayment();
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] != null)
			{
				if(payments[i].getPaymentId().equals(paymentId))
				{
					payments[i] = null;
				}
			}
		}
		this.write(payments);
	}
	
	public Payment searchPayment(String paymentId)
	{
		Payment payments[] = this.getAllPayment();
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] != null)
			{
				if(payments[i].getPaymentId().equals(paymentId))
				{
					return payments[i];
				}
			}
		}
		return null;
	}
	
	
	public Payment[] searchPaymentByDoctorId(Doctor doctor)
	{
		Payment payments[] = this.getAllPayment();
		Payment targetPayments[] = new Payment[100];
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] != null)
			{
				if(payments[i].getDoctor().equals(doctor))
				{
					targetPayments[i] = payments[i];
				}
			}
		}
		return targetPayments;
	}
	
	
	public Payment[] searchPaymentByPatientId(Patient patient)
	{
		Payment payments[] = this.getAllPayment();
		Payment targetPayments[] = new Payment[100];
		
		for(int i = 0; i < payments.length; i++)
		{
			if(payments[i] != null)
			{
				if(payments[i].getPatient().equals(patient))
				{
					targetPayments[i] = payments[i];
				}
			}
		}
		return targetPayments;
	}
	
	
	public Payment[] getAllPayment()
	{
		String fileName = "Controllers/Information/payments.txt";
		FileIO fio = new FileIO();
		String values[] = fio.readFile(fileName);
		
		Payment payments[] = new Payment[100];
		Payment pa = new Payment();
		
		for(int i = 0; i < values.length; i++)
		{
			if(values[i] != null)
			{
				if(payments[i] == null)
				{
					payments[i] = pa.formPayment(values[i]);
				}
			}
		}
		return payments;
	}
	
	public void write(Payment payments[])
	{
		String Information[] = new String[100];
		for(int i = 0; i < Information.length; i++)
		{
			if(payments[i] != null)
			{
				Information[i] = payments[i].toStringPayment();
			}
		}
		String fileName = "Controllers/Information/payments.txt";
		FileIO fio = new FileIO();
		fio.writeFile(fileName, Information);
	}
}
