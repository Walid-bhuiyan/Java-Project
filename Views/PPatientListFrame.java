package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PPatientListFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable patientTable;
	private JScrollPane patientTableSP;
	private JPanel panel;
	private User u;
	
	public PPatientListFrame(User u)
	{
		super("Patient List Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		PatientController pc= new PatientController();
		Patient [] patientList= pc.getAllPatient();
		
		String patientInfo[][]= new String [patientList.length][7];
		for(int i=0; i<patientList.length; i++)
		{
			if(patientList[i]!= null)
			{
				System.out.println(patientList[i].toStringPatient());
				
				patientInfo[i][0]= patientList[i].getUserId();
				patientInfo[i][1]= patientList[i].getName();
				patientInfo[i][2]= patientList[i].getEmail();
				patientInfo[i][3]= patientList[i].getContactNo();
				patientInfo[i][4]= patientList[i].getGender();
				patientInfo[i][5]= String.valueOf(patientList[i].getAge());
				patientInfo[i][6]= patientList[i].getAddress();
			}
		}
		
		String head[] = {"ID","Name","Email","Contact NO","Gender","Age","Address"};
		this.patientTable= new JTable(patientInfo,head);
		this.patientTableSP= new JScrollPane(patientTable);
		this.patientTableSP.setBounds(50,50,700,400);
		this.patientTable.setEnabled(false);
		this.panel.add(patientTableSP);
		
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