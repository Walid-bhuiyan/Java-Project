package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PAppointmentFrame extends JFrame implements ActionListener
{
	private JLabel appointmentIdLabel,doctorIdLabel,patientIdLabel,dateLabel,statusLabel;
	private JTextField appointmentIdTF,doctorIdTF,patientIdTF,dateTF,statusTF;
	private JButton bookBtn,cancelBtn,backBtn;
	private JTable appointmentTable;
	private JScrollPane appointmentTableSP;
	private JPanel panel;
	private User u;
	
	public PAppointmentFrame(User u)
	{
		super("Appointment Frame");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.appointmentIdLabel= new JLabel("Appointment ID:");
		this.appointmentIdLabel.setBounds(80,80,100,30);
		this.panel.add(appointmentIdLabel);
		
		this.appointmentIdTF= new JTextField();
		this.appointmentIdTF.setBounds(190,80,180,30);
		this.panel.add(appointmentIdTF);
		
		this.doctorIdLabel= new JLabel("Doctor ID:");
		this.doctorIdLabel.setBounds(80,130,100,30);
		this.panel.add(doctorIdLabel);
		
		this.doctorIdTF= new JTextField();
		this.doctorIdTF.setBounds(190,130,180,30);
		this.panel.add(doctorIdTF);
		
		this.patientIdLabel= new JLabel("Patient ID:");
		this.patientIdLabel.setBounds(80,180,100,30);
		this.panel.add(patientIdLabel);
		
		this.patientIdTF= new JTextField();
		this.patientIdTF.setBounds(190,180,180,30);
		this.panel.add(patientIdTF);
		
		this.dateLabel= new JLabel("Date:");
		this.dateLabel.setBounds(80,230,100,30);
		this.panel.add(dateLabel);
		
		this.dateTF= new JTextField();
		this.dateTF.setBounds(190,230,180,30);
		this.panel.add(dateTF);
		
		this.statusLabel= new JLabel("Status:");
		this.statusLabel.setBounds(80,280,100,30);
		this.panel.add(statusLabel);
		
		this.statusTF= new JTextField();
		this.statusTF.setBounds(190,280,180,30);
		this.panel.add(statusTF);
		
		this.bookBtn= new JButton("Book Appointment");
		this.bookBtn.setBounds(80,350,250,30);
		this.bookBtn.addActionListener(this);
		this.panel.add(bookBtn);
		
		this.cancelBtn= new JButton("Cancel Appointment");
		this.cancelBtn.setBounds(400,350,250,30);
		this.cancelBtn.addActionListener(this);
		this.panel.add(cancelBtn);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(230,400,250,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		AppointmentController apc= new AppointmentController();
		Appointment [] appointmentList= apc.getAllAppointment();
		
		String appointmentInfo[][]= new String [appointmentList.length][5];
		for(int i=0; i<appointmentList.length; i++)
		{
			if(appointmentList[i]!= null)
			{
				System.out.println(appointmentList[i].toStringAppointment());
				
				appointmentInfo[i][0]=appointmentList[i].getAppointmentId();
				appointmentInfo[i][1]=appointmentList[i].getDoctor().toString();
				appointmentInfo[i][2]=appointmentList[i].getPatient().toString();
				appointmentInfo[i][3]=appointmentList[i].getDate();
				appointmentInfo[i][4]=appointmentList[i].getStatus();
			}
		}
		
		String head[] = {"Appointment ID","Doctor ID","Patient ID","Date","Status"};
		this.appointmentTable= new JTable(appointmentInfo,head);
		this.appointmentTableSP= new JScrollPane(appointmentTable);
		this.appointmentTableSP.setBounds(80,450,650,300);
		this.appointmentTable.setEnabled(false);
		this.panel.add(appointmentTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		
		this.add(panel);
		this.u= u;
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(bookBtn.getText()))
		{
			if(!appointmentIdTF.getText().isEmpty() && !doctorIdTF.getText().isEmpty() && !patientIdTF.getText().isEmpty() && !dateTF.getText().isEmpty() && !statusTF.getText().isEmpty())
			{
				DoctorController dc= new DoctorController();
				PatientController pc= new PatientController();
				AppointmentController apc= new AppointmentController();
				Appointment ap= apc.searchAppointment(appointmentIdTF.getText());
				
				if(ap!= null)
				{
					JOptionPane.showMessageDialog(this,"This Appointment ID is Already Used");
				}
				else
				{
					String appointmentIdValue= appointmentIdTF.getText();
					String doctorIdValue= doctorIdTF.getText();
					String patientIdValue= patientIdTF.getText();
					String dateValue= dateTF.getText();
					String statusValue= statusTF.getText();
					Doctor doctor = dc.searchDoctor(doctorIdValue);
					Patient patient = pc.searchPatient(patientIdValue);
					if (doctor == null) 
					{
						JOptionPane.showMessageDialog(this, "Invalid Doctor ID");
						return;
					}

					if (patient == null) 
					{
						JOptionPane.showMessageDialog(this, "Invalid Patient ID");
						return;
					}
					
					Appointment ap1= new Appointment(appointmentIdValue,doctor,patient,dateValue,statusValue);
					
					apc.insertAppointment(ap1);
					JOptionPane.showMessageDialog(this, "Appointment Book Successfully");
					
					
					PAppointmentFrame papf= new PAppointmentFrame(u);
					this.setVisible(false);
					papf.setVisible(true);
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Fill Up All The Field Properly");
			}
		}
		
		if(command.equals(cancelBtn.getText()))
		{
			appointmentIdTF.setEnabled(true);
			appointmentIdTF.setText("");
			doctorIdTF.setText("");
			patientIdTF.setText("");
			dateTF.setText("");
			statusTF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			PatientHomeFrame phf=new PatientHomeFrame(u);
			phf.setVisible(true);
		}
	}
	
}