package Views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import Models.*;
import Controllers.*;

public class DoctorHomeFrame extends JFrame
{
	
	private JPanel panel;
	
	public DoctorHomeFrame(User u)
	{
		super("Doctor Home Frame");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.add(panel);
	}
}