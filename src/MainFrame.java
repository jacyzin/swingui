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

	public MainFrame() {
		super("SwingUI 1");
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new Toolbar();
		btn1 = new JButton("Click Me");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.append("Hello !!!!\n");
			}
		});
		
		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(btn1, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);

	}

}
