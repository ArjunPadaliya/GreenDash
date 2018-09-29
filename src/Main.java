import javax.swing.JFrame;
import java.util.Properties;

public class Main {
	public static void main(String[] args)
	{
		JFrame main = new JFrame("GreenDash Client");
		
		Properties dbProperties = new Properties();
		
		ConnectorDialog inputDBInfo = new ConnectorDialog(main, "Database Info", dbProperties);
		inputDBInfo.setVisible(true);
		
		
		main.setSize(800,600);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
}
