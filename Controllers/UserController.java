package Controllers;
import java.lang.*;
import Models.*;

public class UserController
{
	public void insertUser(User u)
	{
		User users[] = this.getAllUser();
		for(int i=0;i<100;i++)
		{
			if(users[i]==null)
			{
				users[i]=u;
				break;
			}
		}
		this.write(users);
	}
	
	public void updateUser(User u)
	{
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(u.getUserId()))
				{
					users[i]=u;
				}					
			}
		}
		this.write(users);
	}
	public void deleteUser(String userId)
	{
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(userId))
				{
					users[i]=null;
				}
			}
		}
		this.write(users);
	}
	public User searchUser(String userId)
	{
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if (users[i]!=null)
			{
				if(users[i].getUserId().equals(userId))
				{
					return users[i];
				}
			}
		}
		return null;
	}
	public User[] getAllUser()
    {
		String fileName="Controllers/Information/users.txt";
		FileIO fio=new FileIO();
		String values[]=fio.readFile(fileName);
		
		User users[]=new User[100];
		User u=new User();
		
		for(int i=0;i<values.length;i++)
		{
			if(values[i]!=null)
			{
				if (users[i]==null)
				{
					users[i]=u.formUser(values[i]);
				}
			}
		}
		
		return users;	
	}
	
	public void write(User users[])
	{
		String Information[]=new String[100];
		for(int i=0;i<Information.length;i++)
		{
			if(users[i]!=null)
			{
				Information[i]=users[i].toStringUser();
			}
		}
		String fileName="Controllers/Information/users.txt";
	    FileIO fio=new FileIO();
		fio.writeFile(fileName,Information);
	}
	
}