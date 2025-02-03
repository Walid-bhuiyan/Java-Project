package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class AdminHomeFrame extends JFrame implements ActionListener
{
	private JButton adminBtn,doctorBtn,patientBtn,appointmentBtn,medicalBtn,viewProfileBtn, updateProfileBtn, logoutBtn,resetPasswordBtn;
	private JPanel panel;
	private User u;
	
	public AdminHomeFrame(User u)
	{
		super("Admin Home Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.adminBtn= new JButton("Admin Dashboard");
		this.adminBtn.setBounds(50,50,200,30);
		this.adminBtn.addActionListener(this);
		this.panel.add(adminBtn);
		
		this.doctorBtn= new JButton("Doctor Dashboard");
		this.doctorBtn.setBounds(300,50,200,30);
		this.doctorBtn.addActionListener(this);
		this.panel.add(doctorBtn);
		
		this.patientBtn= new JButton("Patient Dashboard");
		this.patientBtn.setBounds(550,50,200,30);
		this.patientBtn.addActionListener(this);
		this.panel.add(patientBtn);
		
		this.appointmentBtn= new JButton("Appointment Details");
		this.appointmentBtn.setBounds(50,150,325,30);
		this.appointmentBtn.addActionListener(this);
		this.panel.add(appointmentBtn);
		
		this.medicalBtn= new JButton("Medical Records");
		this.medicalBtn.setBounds(425,150,325,30);
		this.medicalBtn.addActionListener(this);
		this.panel.add(medicalBtn);
		
		this.viewProfileBtn= new JButton("View Profile");
		this.viewProfileBtn.setBounds(50,250,325,30);
		this.viewProfileBtn.addActionListener(this);
		this.panel.add(viewProfileBtn);
		
		this.updateProfileBtn= new JButton("Update Profile");
		this.updateProfileBtn.setBounds(425,250,325,30);
		this.updateProfileBtn.addActionListener(this);
		this.panel.add(updateProfileBtn);
		
		this.resetPasswordBtn= new JButton("Reset Password");
		this.resetPasswordBtn.setBounds(220,350,325,30);
		this.resetPasswordBtn.addActionListener(this);
		this.panel.add(resetPasswordBtn);
		
		this.logoutBtn= new JButton("Log Out");
		this.logoutBtn.setBounds(220,450,325,30);
		this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);
		
		this.add(panel);
		this.u= u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(adminBtn.getText().equals(command))
		{
			AAdminDashboardFrame aadf= new AAdminDashboardFrame(u);
			this.setVisible(false);
			aadf.setVisible(true);
		}
		
		if(doctorBtn.getText().equals(command))
		{
			ADoctorDashboardFrame addf= new ADoctorDashboardFrame(u);
			this.setVisible(false);
			addf.setVisible(true);
		}
		
		if(patientBtn.getText().equals(command))
		{
			APatientDashboardFrame apdf= new APatientDashboardFrame(u);
			this.setVisible(false);
			apdf.setVisible(true);
		}
		
		if(appointmentBtn.getText().equals(command))
		{
			AAppointmentDetailsFrame aapdf= new AAppointmentDetailsFrame(u);
			this.setVisible(false);
			aapdf.setVisible(true);
		}
		
		if(medicalBtn.getText().equals(command))
		{
			AMedicalRecordsFrame amrf= new AMedicalRecordsFrame(u);
			this.setVisible(false);
			amrf.setVisible(true);
		}
		
		if(viewProfileBtn.getText().equals(command))
		{
			AViewProfileFrame avpf= new AViewProfileFrame(u);
			this.setVisible(false);
			avpf.setVisible(true);
		}
		
		if(updateProfileBtn.getText().equals(command))
		{
			AUpdateProfileFrame aupf= new AUpdateProfileFrame(u);
			this.setVisible(false);
			aupf.setVisible(true);
		}
		
		if(resetPasswordBtn.getText().equals(command))
		{
			AResetPasswordFrame arpf= new AResetPasswordFrame(u);
			this.setVisible(false);
			arpf.setVisible(true);
		}
		
		if(logoutBtn.getText().equals(command))
		{
			LoginFrame lf= new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
	}
}