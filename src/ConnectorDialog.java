import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectorDialog extends JDialog implements ActionListener {
	
	Properties dbProperties;
	
	JLabel hostLBL = new JLabel("Host");
	JTextField host = new JTextField();
	
	JLabel portLBL = new JLabel("Port");
	JTextField port = new JTextField();
	
	JLabel dbNameLBL = new JLabel("dbName");
	JTextField dbName = new JTextField();
	
	JLabel userLBL = new JLabel("User");
	JTextField user = new JTextField();
	
	JLabel passLBL = new JLabel("Password");
	JTextField pass = new JTextField();
	
	JButton submitBTN = new JButton("submit");
	JButton cancelBTN = new JButton("cancel");
	
	public ConnectorDialog(JFrame owner, String title, Properties p)
	{
		super(owner, title, true);
		
		setSize(400,400);
		
		JPanel dataPanel = new JPanel();
		
		dataPanel.setLayout(new GridLayout(5,2));
		
		dataPanel.add(hostLBL);
		dataPanel.add(host);
		
		dataPanel.add(portLBL);
		dataPanel.add(port);
		
		dataPanel.add(dbNameLBL);
		dataPanel.add(dbName);
		
		dataPanel.add(userLBL);
		dataPanel.add(user);
		
		dataPanel.add(passLBL);
		dataPanel.add(pass);
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(submitBTN);
		buttonPanel.add(cancelBTN);
		
		add(dataPanel,BorderLayout.NORTH);
		add(buttonPanel,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		
	}
}
