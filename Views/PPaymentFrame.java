package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class PPaymentFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JPanel panel;
	private User u;
	
	public PPaymentFrame(User u)
	{
		super("Payment Frame");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(150,350,120,30);
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