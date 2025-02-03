package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel,emailLabel,contactLabel,genderLabel,ageLabel,addressLabel;
	private JTextField userIdTF,nameTF,emailTF,contactTF,genderTF,ageTF,addressTF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Patient p;
	
	public PUpdateProfileFrame(User u)
	{
		super("Update Profile Frame");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		PatientController pc= new PatientController();
		this.p= pc.searchPatient(u.getUserId());
		
		this.userIdLabel= new JLabel("User Id:");
		this.userIdLabel.setBounds(80,80,80,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF= new JTextField();
		this.userIdTF.setBounds(170,80,180,30);
		this.userIdTF.setText(p.getUserId());
		this.userIdTF.setEditable(false);
		this.panel.add(userIdTF);
		
		this.nameLabel= new JLabel("Name:");
		this.nameLabel.setBounds(80,130,80,30);
		this.panel.add(nameLabel);
		
		this.nameTF= new JTextField();
		this.nameTF.setBounds(170,130,180,30);
		this.nameTF.setText(p.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.emailLabel= new JLabel("Email:");
		this.emailLabel.setBounds(80,180,80,30);
		this.panel.add(emailLabel);
		
		this.emailTF= new JTextField();
		this.emailTF.setBounds(170,180,180,30);
		this.emailTF.setText(p.getEmail());
		this.panel.add(emailTF);
		
		this.contactLabel= new JLabel("Contact No:");
		this.contactLabel.setBounds(80,230,80,30);
		this.panel.add(contactLabel);
		
		this.contactTF= new JTextField();
		this.contactTF.setBounds(170,230,180,30);
		this.contactTF.setText(p.getContactNo());
		this.panel.add(contactTF);
		
		this.genderLabel= new JLabel("Gender:");
		this.genderLabel.setBounds(80,280,80,30);
		this.panel.add(genderLabel);
		
		this.genderTF= new JTextField();
		this.genderTF.setBounds(170,280,180,30);
		this.genderTF.setText(p.getGender());
		this.genderTF.setEditable(false);
		this.panel.add(genderTF);
		
		this.ageLabel= new JLabel("Age:");
		this.ageLabel.setBounds(80,330,80,30);
		this.panel.add(ageLabel);
		
		this.ageTF= new JTextField();
		this.ageTF.setBounds(170,330,180,30);
		this.ageTF.setText(String.valueOf(p.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		this.addressLabel= new JLabel("Address:");
		this.addressLabel.setBounds(80,380,80,30);
		this.panel.add(addressLabel);
		
		this.addressTF= new JTextField();
		this.addressTF.setBounds(170,380,180,30);
		this.addressTF.setText(p.getAddress());
		this.panel.add(addressTF);
		
		this.updateBtn= new JButton("Update");
		this.updateBtn.setBounds(80,450,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(230,450,120,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.add(panel);
		
		this.u= u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(updateBtn.getText()))
		{
			if((!emailTF.getText().isEmpty()) && (!contactTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				p.setEmail(emailTF.getText());
				p.setContactNo(contactTF.getText());
				p.setAddress(addressTF.getText());
				PatientController pc=new PatientController();
				pc.updatePatient(p);
				JOptionPane.showMessageDialog(this,"Patient Updated Successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			PatientHomeFrame phf=new PatientHomeFrame(u);
			this.setVisible(false);
			phf.setVisible(true);
		}
	}
	
}