/**
 * 
 */
package com.sg.tools.win;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.sg.swing.component.JMIPV4AddressField;

import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;

/**
 * 功能描述：
 *
 * @category: com.sg.tools.win.MainWindow
 * @author ia
 *
 */
public class MainWindow {

	private JFrame frame;
	
	private JPanel httpPanel;
	
	private JTextField urlField;
	
	private JMIPV4AddressField ipv4Field;
	
	private JComboBox addrComboBox;
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public void setFrameVisible() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 641, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		httpPanel = new JPanel();
		httpPanel.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("HTTP", null, httpPanel, null);
		httpPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("254dlu:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		addrComboBox = new JComboBox();
		addrComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectItem = addrComboBox.getSelectedItem().toString();
				if ("IP".equals(selectItem)) {
					httpPanel.remove(urlField);
					ipv4Field.setIpAddress("");
					httpPanel.add(ipv4Field, "5, 2, left, default");
					httpPanel.repaint();
					httpPanel.updateUI();
				} else {
					httpPanel.remove(ipv4Field);
					urlField.setText("");
					urlField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
					httpPanel.add(urlField, "5, 2, left, default");
					httpPanel.repaint();
					httpPanel.updateUI();

				}
			}
		});
		addrComboBox.setMaximumRowCount(10);
		addrComboBox.setModel(new DefaultComboBoxModel(new String[] {"URL", "IP"}));
		httpPanel.add(addrComboBox, "3, 2, fill, fill");
		
		urlField = new JTextField();
		urlField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		httpPanel.add(urlField, "5, 2, left, default");
		urlField.setColumns(30);
		
		ipv4Field = new JMIPV4AddressField();
		
		JLabel lblNewLabel = new JLabel("New label");
		httpPanel.add(lblNewLabel, "3, 4, right, default");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);

		httpPanel.add(panel, "5, 4, left, top");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton_1);

		httpPanel.updateUI();
	}

}
