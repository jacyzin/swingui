import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private JButton btn1;
	private Toolbar toolbar;
	private FormPanel formPanel;

	public MainFrame() {
		super("SwingUI");
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new Toolbar();
		btn1 = new JButton("Click Me");
		formPanel = new FormPanel();
		
		toolbar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String text) {
				textPanel.append(text);
			}
			
		});
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCat();
				String empCat = e.getEmpCategory();
				
				textPanel.append(name + ": " + occupation + " : " + ageCat + " :" + empCat + " : " + e.getGender() + "\n");
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.append("Hello !!!!\n");
			}
		});
		
		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(btn1, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setVisible(true);

	}

}
