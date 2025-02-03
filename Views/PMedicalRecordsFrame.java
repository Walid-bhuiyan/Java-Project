package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PMedicalRecordsFrame extends JFrame implements ActionListener
{
	private JTable medicalTable;
	private JScrollPane medicalTableSP;
	private JButton backBtn;
	private JPanel panel;
	private User u;
	
	public PMedicalRecordsFrame(User u)
	{
		super("Medical Records Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(300,450,150,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		MedicalRecordController mrc= new MedicalRecordController();
		MedicalRecord [] medicalRecordList= mrc.getAllMedicalRecord();
		
		String medicalRecordInfo[][]= new String [medicalRecordList.length][3];
		for(int i=0; i<medicalRecordList.length; i++)
		{
			if(medicalRecordList[i]!= null)
			{
				System.out.println(medicalRecordList[i].toStringMedicalRecord());
				
				medicalRecordInfo[i][0]=medicalRecordList[i].getMedicalRecordId();
				medicalRecordInfo[i][1]=medicalRecordList[i].getPatient().toString();
				medicalRecordInfo[i][2]=medicalRecordList[i].getDetails();
			}
		}
		
		String head[] = {"Medical Record ID","Patient ID","Details"};
		this.medicalTable= new JTable(medicalRecordInfo,head);
		this.medicalTableSP= new JScrollPane(medicalTable);
		this.medicalTableSP.setBounds(80,100,650,300);
		this.medicalTable.setEnabled(false);
		this.panel.add(medicalTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
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