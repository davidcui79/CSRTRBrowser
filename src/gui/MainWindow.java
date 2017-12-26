package gui;

import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;




public class MainWindow extends JFrame implements MainWindowAdapter {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	File file = null;

	private JPanel centerPane;
	
	/**
	 * This method initializes centerPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCenterPane() {
		if (centerPane == null) {
			centerPane = new JPanel();
			centerPane.setLayout(new CardLayout());
			MainPanel sourcePane = new MainPanel();
			//sourcePane.addPropertyChangeListener(this);
			centerPane.add(sourcePane, "Step 1");

		}
		return centerPane;
	}


	public static void initGlobalFontSetting(Font fnt){
		FontUIResource fontRes = new FontUIResource(fnt);
		for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();){
		Object key = keys.nextElement();
		Object value = UIManager.get(key);
		if(value instanceof FontUIResource)
		UIManager.put(key, fontRes);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initGlobalFontSetting(new Font("Dialog",Font.PLAIN,14)); 
		JFrame.setDefaultLookAndFeelDecorated(true);
		//JDialog.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow thisClass = new MainWindow();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setSize(400, 200);
				thisClass.setVisible(true);
				Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
				thisClass.setLocation(screenSize.width/2 - thisClass.getWidth()/2, screenSize.height/2 - thisClass.getHeight()/2);

			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MainWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/asset/tree.png")));
		//this.setJMenuBar(getAppMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("CSR&TR Browser");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getCenterPane(), BorderLayout.CENTER);
			//jContentPane.add(getToolBar(), BorderLayout.NORTH);
		}
		return jContentPane;
	}




	@Override
	public void fileOpenActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void exitActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void aboutActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void searchNextActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void searchPrevActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}





}
