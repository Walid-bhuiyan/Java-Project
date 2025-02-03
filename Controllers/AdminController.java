package Controllers;
import java.lang.*;
import Models.*;

public class AdminController
{
	public void insertAdmin(Admin a)
	{
		Admin admins[] = this.getAllAdmin();
		
		for(int i=0; i<admins.length; i++)
		{
			if(admins[i]== null)
			{
				admins[i]=a;
				break;
			}
		}
		this.write(admins);
	}
	
	
	public void updateAdmin(Admin a)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0; i<admins.length; i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(a.getUserId()))
				{
					admins[i]=a;
				}
			}	
		}
		this.write(admins);
	}
	
	
	public void deleteAdmin(String userId)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0; i<admins.length; i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(userId))
				{
					admins[i]=null;
				}
			}
		}
		this.write(admins);
	}
	
	
	public Admin searchAdmin(String userId)
	{
		Admin admins[]=this.getAllAdmin();
		for(int i=0; i<admins.length; i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(userId))
				{
					return admins[i];
				}
			}
		}
		return null;
	}
	
	
	public Admin[] getAllAdmin()
	{
		String fileName= "Controllers/Information/admins.txt";
		FileIO fio= new FileIO();
		String values[]= fio.readFile(fileName);
		
	    Admin admins[]= new Admin[100];
		Admin a= new Admin();
		
		for(int i=0; i<values.length; i++)
		{
			if(values[i]!=null)
			{
				if (admins[i]==null)
				{
					admins[i]=a.formAdmin(values[i]);
				}
			}
		}
		return admins;
	}
	
	
	public void write(Admin admins[])
	{
		String Information[]= new String[100];
		
		for(int i=0; i<Information.length; i++)
		{
			if(admins[i]!=null)
			{
				Information[i]=admins[i].toStringAdmin();
			}
		}
		
		String fileName="Controllers/Information/admins.txt";
		FileIO fio= new FileIO();
		fio.writeFile(fileName, Information);
	}

}