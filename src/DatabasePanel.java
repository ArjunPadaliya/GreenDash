import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DatabasePanel extends JPanel {
	
	JTextField sqlInput = new JTextField();
	
	JButton executeBTN = new JButton("Execute Query");
	
	JTable table = new JTable();
	
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	
	Connector conn;
	
	public DatabasePanel(Connector conn)
	{
		this.conn = conn;
		
		setLayout(new GridLayout(3,1));
		
		add(sqlInput);
		
		executeBTN.addActionListener(this::execute);
		
		add(executeBTN);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		
		add(tableScrollPane);
	}
	
	private void execute(ActionEvent e)
	{
		resetTable();
		
		String query = sqlInput.getText();
		try {
			ResultSet resultSet = conn.executeQuery(query);
			
			ResultSetMetaData data = resultSet.getMetaData();
			
			for(int i=1; i<data.getColumnCount(); i++)
			{
				model.addColumn(data.getColumnName(i));
			}
			
			while(resultSet.next())
			{
				String[] gottenData = new String[data.getColumnCount()];
				for(int i=0; i<data.getColumnCount(); i++)
				{
					gottenData[i] = resultSet.getString(i+1);
				}
				model.addRow(gottenData);
			}
		}
		catch(SQLException exep)
		{
			exep.printStackTrace();
		}
	}
	
	private void resetTable()
	{
		model.setColumnCount(0);
		model.setRowCount(0);
	}
}
