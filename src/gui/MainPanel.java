package gui;

import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import util.Hyperlink;

import java.awt.Insets;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JLabel trLabel = null;
	private JLabel csrLabel = null;
	private JTextField trNumTxtField = null;
	private JTextField csrNumTxtField = null;
	private JButton trBrowserBut = null;
	private JButton csrBrowserBut = null;
	private JButton trLinkBut = null;
	private JButton csrLinkBut = null;
	
	/**
	 * This is the default constructor
	 */
	public MainPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraintsTRBrowser = new GridBagConstraints();
		gridBagConstraintsTRBrowser.gridx = 2;
		gridBagConstraintsTRBrowser.insets = new Insets(0, 0, 0, 10);
//		gridBagConstraintsTRBrowser.gridwidth = 30;
//		gridBagConstraintsTRBrowser.ipadx = 100;
		gridBagConstraintsTRBrowser.gridy = 0;
		
		GridBagConstraints gridBagConstraintsTRNum = new GridBagConstraints();
		gridBagConstraintsTRNum.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsTRNum.gridy = 0;
		gridBagConstraintsTRNum.weightx = 1.0;
		gridBagConstraintsTRNum.gridx = 1;
		
		GridBagConstraints gridBagConstraintsCSRNum = new GridBagConstraints();
		gridBagConstraintsCSRNum.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsCSRNum.gridy = 1;
		gridBagConstraintsCSRNum.weightx = 1.0;
		gridBagConstraintsCSRNum.gridx = 1;
		
		GridBagConstraints gridBagConstraintsCSRBrowser = new GridBagConstraints();
		gridBagConstraintsCSRBrowser.gridx = 2;
		gridBagConstraintsCSRBrowser.insets = new Insets(0, 0, 0, 10);
//		gridBagConstraintsCSRBrowser.ipadx = 100;
		gridBagConstraintsCSRBrowser.gridy = 1;
		
		GridBagConstraints gridBagConstraintsTRLabel = new GridBagConstraints();
		gridBagConstraintsTRLabel.gridx = 0;
		gridBagConstraintsTRLabel.insets = new Insets(0, 10, 0, 0);
		gridBagConstraintsTRLabel.gridy = 0;
		
		GridBagConstraints gridBagConstraintsCSRLabel = new GridBagConstraints();
		gridBagConstraintsCSRLabel.gridx = 0;
		gridBagConstraintsCSRLabel.insets = new Insets(0, 10, 0, 0);
		gridBagConstraintsCSRLabel.gridy = 1;
		
		GridBagConstraints gridBagConstraintsTRLink = new GridBagConstraints();
		gridBagConstraintsTRLink.gridx = 3;
		gridBagConstraintsTRLink.insets = new Insets(0, 0, 0, 0);
		gridBagConstraintsTRLink.gridy = 0;
		
		GridBagConstraints gbCSRLink = new GridBagConstraints();
		gbCSRLink.gridx = 3;
		gbCSRLink.insets = new Insets(0, 0, 0, 0);
		gbCSRLink.gridy = 1;
		
		trLabel = new JLabel();
		trLabel.setText("TR: ");
		
		csrLabel = new JLabel();
		csrLabel.setText("CSR: ");
		
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		
		this.add(trLabel, gridBagConstraintsTRLabel);		
		this.add(getTRNumTxtField(), gridBagConstraintsTRNum);
		this.add(getTRBroswerBut(), gridBagConstraintsTRBrowser);
		
		this.add(csrLabel, gridBagConstraintsCSRLabel);
		this.add(getCSRNumTxtField(), gridBagConstraintsCSRNum);
	    this.add(getCSRBroswerBut(), gridBagConstraintsCSRBrowser);
	    
	    this.add(getTRLinkBut(), gridBagConstraintsTRLink);
	    this.add(getCSRLinkBut(), gbCSRLink);
	}

	/**
	 * This method initializes fileTxtField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTRNumTxtField() {
		if (trNumTxtField == null) {
			trNumTxtField = new JTextField();
			trNumTxtField.setEditable(true);
			trNumTxtField.addKeyListener(this);
		}
		return trNumTxtField;
	}
	
	/**
	 * This method initializes fileTxtField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCSRNumTxtField() {
		if (csrNumTxtField == null) {
			csrNumTxtField = new JTextField();
			csrNumTxtField.setEditable(true);
			csrNumTxtField.addKeyListener(this);
		}
		return csrNumTxtField;
	}
	

	/**
	 * This method initializes browseBut	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getTRBroswerBut() {
		if (trBrowserBut == null) {
			trBrowserBut = new JButton();
			trBrowserBut.setText("Browse TR");
			trBrowserBut.setSize(50, 20);
			trBrowserBut.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
						openTRBrowser();
					}
			});
		}
		return trBrowserBut;
	}
	
	private JButton getCSRBroswerBut() {
		if (csrBrowserBut == null) {
			csrBrowserBut = new JButton();
			csrBrowserBut.setText("Browse CSR");
			csrBrowserBut.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
						openCSRBrowser();
					}
			});
		}
		return csrBrowserBut;
	}
	
	private JButton getTRLinkBut() {
		if (trLinkBut == null) {
			trLinkBut = new JButton();
			trLinkBut.setText("Copy Link");
			trLinkBut.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					copyTRLink();
				}
			});
		}
		return trLinkBut;
	}
	
	private JButton getCSRLinkBut() {
		if (csrLinkBut == null) {
			csrLinkBut = new JButton();
			csrLinkBut.setText("Copy Link");
			csrLinkBut.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					copyCSRLink();
				}
			});
		}
		return csrLinkBut;
	}
	protected void openTRBrowser(){
		System.out.println("TRBrowse button clicked");
		if(Desktop.isDesktopSupported())
		{
		  try {
			Desktop.getDesktop().browse(new URI("https://mhweb.ericsson.se/TREditWeb/faces/oo/object.xhtml?eriref=" + trNumTxtField.getText().trim()));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
	}
	
	protected void openCSRBrowser(){
		System.out.println("CSRBrowse button clicked");
		if(Desktop.isDesktopSupported())
		{
		  try {
			Desktop.getDesktop().browse(new URI("https://p40wd.ss.sw.ericsson.se/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=450&crm-ui-action=b&crm-object-type=CRM_SRQM_INCIDENT&crm-object-keyname=OBJECT_ID&crm-object-value=" + csrNumTxtField.getText().trim()));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
	}
	
	protected void copyTRLink(){
		String url;
		url = "<a href=\"https://mhweb.ericsson.se/TREditWeb/faces/oo/object.xhtml?eriref=" + trNumTxtField.getText().trim() + "\">";
		url += trNumTxtField.getText().trim().toUpperCase();
		url += "</a>";
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new Hyperlink(url.toString()), null);
	}
	
	protected void copyCSRLink(){
		String url;
		url = "<a href=\"https://p40wd.ss.sw.ericsson.se/sap/bc/bsp/sap/crm_ui_start/default.htm?sap-client=450&crm-ui-action=b&crm-object-type=CRM_SRQM_INCIDENT&crm-object-keyname=OBJECT_ID&crm-object-value=" + csrNumTxtField.getText().trim() + "\">";
		url += csrNumTxtField.getText().trim();
		url += "</a>";
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new Hyperlink(url.toString()), null);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("keyPressed " + e.toString());
		
		if(e.getSource() == trNumTxtField){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("TR num Enter pressed, trigger Browse button click");
				openTRBrowser();
				e.consume();
			}
		}
		
		if(e.getSource() == csrNumTxtField){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("CSR num Enter pressed, trigger Browse button click");
				openCSRBrowser();
				e.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
