import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
		
		setJMenuBar(createMenuBar());

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

				textPanel.append(
						name + ": " + occupation + " : " + ageCat + " :" + empCat + " : " + e.getGender() + "\n");
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

	private JMenuBar createMenuBar() {
		JMenuBar menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data..");
		JMenuItem importDataItem = new JMenuItem("Import Data..");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		final JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menu.add(fileMenu);
		menu.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				
				formPanel.setVisible(menuItem.isSelected());
			}
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return menu;
	}

}
