package Controllers;
import java.lang.*;
import Models.*;

public class PatientController
{
	public void insertPatient(Patient p)
	{
		Patient patients[]= this.getAllPatient();
		
		for(int i=0; i<patients.length; i++)
		{
			if(patients[i]== null)
			{
				patients[i]= p;
				break;
			}
		}
		
		this.write(patients);
	}
	
	
	public void updatePatient(Patient p)
	{
		Patient patients[]= this.getAllPatient();
		
		for(int i=0; i<patients.length; i++)
		{
			if(patients[i]!= null)
			{
				if(patients[i].getUserId().equals(p.getUserId()))
				{
					patients[i]= p;
				}
			}
		}
		
		this.write(patients);
	}
	
	
	public void deletePatient(String userId)
	{
		Patient patients[]= this.getAllPatient();
		
		for(int i=0; i<patients.length; i++)
		{
			if(patients[i]!= null)
			{
				if(patients[i].getUserId().equals(userId))
				{
					patients[i]= null;
				}
			}
		}
		
		this.write(patients);
	}
	
	
	public Patient searchPatient(String userId)
	{
		Patient patients[]= this.getAllPatient();
		
		for(int i=0; i<patients.length; i++)
		{
			if(patients[i]!= null)
			{
				if(patients[i].getUserId().equals(userId))
				{
					return patients[i];
				}
			}
		}
		
		return null;
	}
	
	
	public Patient[] getAllPatient()
	{
		String fileName= "Controllers/Information/patients.txt";
		
		FileIO fio= new FileIO();
		String values[]= fio.readFile(fileName);
		
		Patient patients[]= new Patient[100];
		Patient p= new Patient();
		
		for(int i=0; i<values.length; i++)
		{
			if(values[i]!= null)
			{
				if(patients[i]== null)
				{
					patients[i]= p.formPatient(values[i]);
				}
			}
		}
		
		return patients;
	}
	
	
	public void write(Patient patients[])
	{
		String Information[]= new String[100];
		
		for(int i=0; i<Information.length; i++)
		{
			if(patients[i]!= null)
			{
				Information[i]= patients[i].toStringPatient();
			}
		}
		
		String fileName= "Controllers/Information/patients.txt";
		FileIO fio= new FileIO();
		fio.writeFile(fileName, Information);
	}
}