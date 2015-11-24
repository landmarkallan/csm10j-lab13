import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.NumberFormatException;

public class Program extends JFrame
{
	private JTextField singleTF;
	
	private xxxListener xxListener;
	
	public Program()
	{
		this.setTitle("Oval Drawing Application");
		this.setSize(400,600);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setup()
	{
		this.xxxListener = new xxxListener();
		
		singleTF = new JTextField("Click me", SwingConstants.CENTER);
		
		this.singleTF.setEditable(false);
		
		this.singleTF.addActionListener(xxxListener);
		
		Container pane = this.getContentPane();
		
		pane.setLayout(new GridLayout(1,1));
	}
	
	private class xxxListener implements MouseListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			for (int index = 0; index < numInt; index++)
			{
				
			}
		}
	}
	
	public static void main(String[] args)
	{
		Program p = new Program();
		p.setup();
		p.setSize(400,400);
		p.setVisible(true);
		
		String numStr;
		
		int numInt = 0;
		
		boolean flag = true;
		
		while (flag) //Credit goes to users of stackoverflow.com for this design
		{
			try
			{
				numStr = JOptionPane.showInputDialog("Enter the " +
					"number of Ovals to draw (1-20) and press the [OK] button");
				
				if (numStr == null)
				{
					System.exit(0);
				}
				else
				{	
					numInt = Integer.parseInt(numStr);
					
					if (numInt < 0)
					{
						numInt = 1;
						System.out.printf("\n\nThe defaulted number is: %d\n\n",
							numInt);
					}
					else if (numInt > 20)
					{
						numInt = 20;
						System.out.printf("\n\nThe defaulted number is: %d\n\n",
							numInt);
					}
					else if (numInt == 0)
					{
						if (singleTF.getText != "Click me")
						{
							singleTF.setText("Click me");
						}
					}
					else
					{
						System.out.printf("\n\nThe number you entered: %d\n\n",
							numInt);
					}
				}
				
				flag = false;
			}
			catch (NumberFormatException nfe)
			{
				System.out.print("\n\nWrong input, try again, typing in only " +
				"numbers\n\n");
			
				JOptionPane.showMessageDialog(p, "Wrong input, try again, " +
					"typing in only numbers", "Error: Bad Input",
					JOptionPane.ERROR_MESSAGE);
			}
		}
		
		System.exit(0);
	}
}
