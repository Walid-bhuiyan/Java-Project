package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PDoctorListFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable doctorTable;
	private JScrollPane doctorTableSP;
	private JPanel panel;
	private User u;
	
	public PDoctorListFrame(User u)
	{
		super("Doctor List Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		DoctorController dc= new DoctorController();
		Doctor [] doctorList= dc.getAllDoctor();
		
		String doctorInfo[][]= new String [doctorList.length][6];
		for(int i=0; i<doctorList.length; i++)
		{
			if(doctorList[i]!= null)
			{
				System.out.println(doctorList[i].toStringDoctor());
				
				doctorInfo[i][0]= doctorList[i].getUserId();
				doctorInfo[i][1]= doctorList[i].getName();
				doctorInfo[i][2]= doctorList[i].getEmail();
				doctorInfo[i][3]= doctorList[i].getContactNo();
				doctorInfo[i][4]= doctorList[i].getSpecialist();
				doctorInfo[i][5]= doctorList[i].getEducationalInformation();
			}
		}
		
		String head[] = {"ID","Name","Email","Contact NO","specialist","Educational Information"};
		this.doctorTable= new JTable(doctorInfo,head);
		this.doctorTableSP= new JScrollPane(doctorTable);
		this.doctorTableSP.setBounds(50,50,700,400);
		this.doctorTable.setEnabled(false);
		this.panel.add(doctorTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(300,500,120,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.add(panel);
		this.u= u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(command.equals(backBtn.getText()))
		{
			PatientHomeFrame phf=new PatientHomeFrame(u);
			this.setVisible(false);
			phf.setVisible(true);
		}
	}
}