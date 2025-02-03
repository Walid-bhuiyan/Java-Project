package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class AAppointmentDetailsFrame extends JFrame implements ActionListener
{
	private JLabel appointmentIdLabel,doctorIdLabel,patientIdLabel,dateLabel,statusLabel;
	private JTextField appointmentIdTF,doctorIdTF,patientIdTF,dateTF,statusTF;
	private JButton rescheduleBtn,cancelBtn,backBtn;
	private JTable appointmentTable;
	private JScrollPane appointmentTableSP;
	private JPanel panel;
	private User u;
	
	public AAppointmentDetailsFrame(User u)
	{
		super("Appointment Details Frame");
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
		
		this.rescheduleBtn= new JButton("Reschedule Appointment");
		this.rescheduleBtn.setBounds(80,350,250,30);
		this.rescheduleBtn.addActionListener(this);
		this.panel.add(rescheduleBtn);
		
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
		String command= ae.getActionCommand();
		
		if(command.equals(rescheduleBtn.getText()))
		{
			if(!appointmentIdTF.getText().isEmpty())
			{
				AppointmentController apc= new AppointmentController();
				Appointment ap= apc.searchAppointment(appointmentIdTF.getText());
				
				if(ap!= null)
				{
					String appointmentIdValue= appointmentIdTF.getText();
					
					appointmentIdTF.setEnabled(false);
					doctorIdTF.setText(ap.getDoctor().toString());
					doctorIdTF.setEnabled(false);
					patientIdTF.setText(ap.getPatient().toString());
					patientIdTF.setEnabled(false);
					dateTF.setText(ap.getDate());
					String dateValue= dateTF.getText();
					ap.setDate(dateValue);
					statusTF.setText(ap.getStatus());
					statusTF.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No Appointment");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Provide an ID");
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
			AdminHomeFrame ahf=new AdminHomeFrame(u);
			ahf.setVisible(true);
		}
	}
}