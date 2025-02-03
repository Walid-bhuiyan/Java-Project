package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class AMedicalRecordsFrame extends JFrame implements ActionListener
{
	private JLabel medicalIdLabel,patientIdLabel,detailsLabel;
	private JTextField medicalIdTF,patientIdTF,detailsTF;
	private JButton addBtn,editBtn,backBtn;
	private JTable medicalTable;
	private JScrollPane medicalTableSP;
	private JPanel panel;
	private User u;
	
	public AMedicalRecordsFrame(User u)
	{
		super("Medical Records Frame");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.medicalIdLabel= new JLabel("Medical Record ID:");
		this.medicalIdLabel.setBounds(80,80,100,30);
		this.panel.add(medicalIdLabel);
		
		this.medicalIdTF= new JTextField();
		this.medicalIdTF.setBounds(190,80,180,30);
		this.panel.add(medicalIdTF);
		
		this.patientIdLabel= new JLabel("Patient ID:");
		this.patientIdLabel.setBounds(80,130,100,30);
		this.panel.add(patientIdLabel);
		
		this.patientIdTF= new JTextField();
		this.patientIdTF.setBounds(190,130,180,30);
		this.panel.add(patientIdTF);
		
		this.detailsLabel= new JLabel("Details:");
		this.detailsLabel.setBounds(80,180,100,30);
		this.panel.add(detailsLabel);
		
		this.detailsTF= new JTextField();
		this.detailsTF.setBounds(190,180,180,30);
		this.panel.add(detailsTF);
		
		this.addBtn= new JButton("Add Medical Records");
		this.addBtn.setBounds(80,250,250,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.editBtn= new JButton("Edit Medical Records");
		this.editBtn.setBounds(400,250,250,30);
		this.editBtn.addActionListener(this);
		this.panel.add(editBtn);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(200,300,250,30);
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
		this.medicalTableSP.setBounds(80,350,650,400);
		this.medicalTable.setEnabled(false);
		this.panel.add(medicalTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		this.u= u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!medicalIdTF.getText().isEmpty() && !patientIdTF.getText().isEmpty() && !detailsTF.getText().isEmpty())
			{
				MedicalRecordController mrc= new MedicalRecordController();
				MedicalRecord mr= mrc.searchMedicalRecord(medicalIdTF.getText());
				
				if(mr!= null)
				{
					JOptionPane.showMessageDialog(this,"This Medical ID is Already Used");
				}
				else
				{
					String medicalIdValue= medicalIdTF.getText();
					String patientIdValue= patientIdTF.getText();
					String detailsValue= detailsTF.getText();
					
					PatientController pc = new PatientController();
					Patient patient = pc.searchPatient(patientIdValue);

					if (patient == null) 
					{
						JOptionPane.showMessageDialog(this, "Invalid Patient ID");
						return;
					}
					
					MedicalRecord mr1= new MedicalRecord(medicalIdValue,patient,detailsValue);
					mrc.insertMedicalRecord(mr1);
					JOptionPane.showMessageDialog(this, "Add Successfully");
					
					AMedicalRecordsFrame amrf= new AMedicalRecordsFrame(u);
					this.setVisible(false);
					amrf.setVisible(true);
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Fill Up All The Field Properly");
			}
		}
		
		if(command.equals(editBtn.getText()))
		{
			if(!medicalIdTF.getText().isEmpty() && !patientIdTF.getText().isEmpty() && !detailsTF.getText().isEmpty())
			{
				MedicalRecordController mrc= new MedicalRecordController();
				MedicalRecord mr= mrc.searchMedicalRecord(medicalIdTF.getText());
				
				if(mr!= null)
				{
					String medicalIdValue= medicalIdTF.getText();
					String patientIdValue= patientIdTF.getText();
					String detailsValue= detailsTF.getText();
					
					mr.setDetails(detailsValue);
					
					JOptionPane.showMessageDialog(this, "Edit Successfully");
					
					AMedicalRecordsFrame amrf= new AMedicalRecordsFrame(u);
					this.setVisible(false);
					amrf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Medical Records Does Not Exist");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill Up All The Field Properly");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			AdminHomeFrame ahf=new AdminHomeFrame(u);
			ahf.setVisible(true);
		}
	}

}