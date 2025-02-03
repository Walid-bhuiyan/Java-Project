package Controllers;
import java.lang.*;
import Models.*;

public class MedicalRecordController
{
	public void insertMedicalRecord(MedicalRecord mr)
	{
		MedicalRecord medicalRecords[] = this.getAllMedicalRecord();
		
		for(int i = 0; i < medicalRecords.length; i++)
		{
			if(medicalRecords[i] == null)
			{
				medicalRecords[i] = mr;
				break;
			}
		}
		
		this.write(medicalRecords);
	}
	
	
	public void updateMedicalRecord(MedicalRecord mr)
	{
		MedicalRecord medicalRecords[] = this.getAllMedicalRecord();
		
		for(int i = 0; i < medicalRecords.length; i++)
		{
			if(medicalRecords[i] != null)
			{
				if(medicalRecords[i].getMedicalRecordId().equals(mr.getMedicalRecordId()))
				{
					medicalRecords[i] = mr;
				}
			}
		}
		
		this.write(medicalRecords);
	}
	
	
	public void deleteMedicalRecord(String medicalRecordId)
	{
		MedicalRecord medicalRecords[] = this.getAllMedicalRecord();
		
		for(int i = 0; i < medicalRecords.length; i++)
		{
			if(medicalRecords[i] != null)
			{
				if(medicalRecords[i].getMedicalRecordId().equals(medicalRecordId))
				{
					medicalRecords[i] = null;
				}
			}
		}
		
		this.write(medicalRecords);
	}
	
	
	public MedicalRecord searchMedicalRecord(String medicalRecordId)
	{
		MedicalRecord medicalRecords[] = this.getAllMedicalRecord();
		
		for(int i = 0; i < medicalRecords.length; i++)
		{
			if(medicalRecords[i] != null)
			{
				if(medicalRecords[i].getMedicalRecordId().equals(medicalRecordId))
				{
					return medicalRecords[i];
				}
			}
		}
		return null;
	}
	
	
	public MedicalRecord[] searchMedicalRecordByPatientId(Patient patient)
	{
		MedicalRecord medicalRecords[] = this.getAllMedicalRecord();
		MedicalRecord targetMedicalRecords[] = new MedicalRecord[100];
		
		for(int i = 0; i < medicalRecords.length; i++)
		{
			if(medicalRecords[i] != null)
			{
				if(medicalRecords[i].getPatient().equals(patient))
				{
					targetMedicalRecords[i] = medicalRecords[i];
				}
			}
		}
		return targetMedicalRecords;
	}
	
	
	public MedicalRecord[] getAllMedicalRecord()
	{
		String fileName = "Controllers/Information/medicalRecords.txt";
		FileIO fio = new FileIO();
		String values[] = fio.readFile(fileName);
		
		MedicalRecord medicalRecords[] = new MedicalRecord[100];
		MedicalRecord mr = new MedicalRecord();
		
		for(int i = 0; i < values.length; i++)
		{
			if(values[i] != null)
			{
				if(medicalRecords[i] == null)
				{
					medicalRecords[i] = mr.formMedicalRecord(values[i]);
				}
			}
		}
		return medicalRecords;
	}
	
	public void write(MedicalRecord medicalRecords[])
	{
		String Information[] = new String[100];
		for(int i = 0; i < Information.length; i++)
		{
			if(medicalRecords[i] != null)
			{
				Information[i] = medicalRecords[i].toStringMedicalRecord();
			}
		}
		String fileName = "Controllers/Information/medicalRecords.txt";
		FileIO fio = new FileIO();
		fio.writeFile(fileName, Information);
	}
}