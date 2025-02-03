package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PatientHomeFrame extends JFrame implements ActionListener
{
	private JButton doctorBtn,patientBtn,updateProfileBtn,viewProfileBtn,appointmentBtn,medicalBtn,payBtn,resetPasswordBtn,logoutBtn;
	private JPanel panel;
	private User u;
	
	public PatientHomeFrame(User u)
	{
		super("Patient Home Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.doctorBtn= new JButton("Doctor List");
		this.doctorBtn.setBounds(50,50,300,30);
		this.doctorBtn.addActionListener(this);
		this.panel.add(doctorBtn);
		
		this.patientBtn= new JButton("Patient List");
		this.patientBtn.setBounds(400,50,300,30);
		this.patientBtn.addActionListener(this);
		this.panel.add(patientBtn);
		
		this.updateProfileBtn= new JButton("Update Profile");
		this.updateProfileBtn.setBounds(50,150,300,30);
		this.updateProfileBtn.addActionListener(this);
		this.panel.add(updateProfileBtn);
		
		this.viewProfileBtn= new JButton("View Profile");
		this.viewProfileBtn.setBounds(400,150,300,30);
		this.viewProfileBtn.addActionListener(this);
		this.panel.add(viewProfileBtn);
		
		this.appointmentBtn= new JButton("Appointment");
		this.appointmentBtn.setBounds(50,250,150,30);
		this.appointmentBtn.addActionListener(this);
		this.panel.add(appointmentBtn);
		
		this.medicalBtn= new JButton("Medical Records");
		this.medicalBtn.setBounds(250,250,200,30);
		this.medicalBtn.addActionListener(this);
		this.panel.add(medicalBtn);
		
		this.payBtn= new JButton("Payment");
		this.payBtn.setBounds(500,250,150,30);
		this.payBtn.addActionListener(this);
		this.panel.add(payBtn);
	
		this.resetPasswordBtn= new JButton("Reset Password");
		this.resetPasswordBtn.setBounds(220,350,300,30);
		this.resetPasswordBtn.addActionListener(this);
		this.panel.add(resetPasswordBtn);
		
		this.logoutBtn= new JButton("Log Out");
		this.logoutBtn.setBounds(220,450,300,30);
		this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);
		
		this.add(panel);
		this.u= u;
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(doctorBtn.getText().equals(command))
		{
			PDoctorListFrame pdlf= new PDoctorListFrame(u);
			this.setVisible(false);
			pdlf.setVisible(true);
		}
		
		if(patientBtn.getText().equals(command))
		{
			PPatientListFrame pplf= new PPatientListFrame(u);
			this.setVisible(false);
			pplf.setVisible(true);
		}
		
		if(updateProfileBtn.getText().equals(command))
		{
			PUpdateProfileFrame pupf= new PUpdateProfileFrame(u);
			this.setVisible(false);
			pupf.setVisible(true);
		}
		
		if(viewProfileBtn.getText().equals(command))
		{
			PViewProfileFrame pvpf= new PViewProfileFrame(u);
			this.setVisible(false);
			pvpf.setVisible(true);
		}
		
		if(appointmentBtn.getText().equals(command))
		{
			PAppointmentFrame papf= new PAppointmentFrame(u);
			this.setVisible(false);
			papf.setVisible(true);
		}
		
		if(medicalBtn.getText().equals(command))
		{
			PMedicalRecordsFrame pmrf= new PMedicalRecordsFrame(u);
			this.setVisible(false);
			pmrf.setVisible(true);
		}
		
		if(payBtn.getText().equals(command))
		{
			PPaymentFrame ppf= new PPaymentFrame(u);
			this.setVisible(false);
			ppf.setVisible(true);
		}
		
		if(resetPasswordBtn.getText().equals(command))
		{
			PResetPasswordFrame prpf= new PResetPasswordFrame(u);
			this.setVisible(false);
			prpf.setVisible(true);
		}
		
		if(logoutBtn.getText().equals(command))
		{
			LoginFrame lf= new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
}