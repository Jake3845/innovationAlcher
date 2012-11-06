package innovationAlcher.gui;

import innovationAlcher.container.Variables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;

public class Gui {

	public static JFrame frmInnovationalcherV;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmInnovationalcherV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInnovationalcherV = new JFrame();
		frmInnovationalcherV.setResizable(false);
		frmInnovationalcherV.setAlwaysOnTop(true);
		frmInnovationalcherV.setTitle("InnovationAlcher");
		frmInnovationalcherV.setBounds(100, 100, 315, 228);
		frmInnovationalcherV.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInnovationalcherV.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 309, 200);
		frmInnovationalcherV.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alchemy Settings", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCase = new JLabel("Cast:");
		lblCase.setBounds(137, 5, 46, 14);
		panel.add(lblCase);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setBounds(128, 48, 46, 14);
		panel.add(lblItemId);
		
		final JCheckBox chckbxDebug = new JCheckBox("Debug");
		chckbxDebug.setBounds(115, 85, 97, 23);
		panel.add(chckbxDebug);
		
		final JButton btnStart = new JButton("Start");
		btnStart.setBounds(105, 112, 89, 23);
		panel.add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(89, 65, 127, 20);
		panel.add(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 24, 127, 20);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Low Alchemy", "High Alchemy"}));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("AntiBan Settings", null, panel_1, null);
		panel_1.setLayout(null);
		
		final JCheckBox chckbxRotateScreen = new JCheckBox("Rotate Screen");
		chckbxRotateScreen.setToolTipText("Rotates your screen while alching randomly.");
		chckbxRotateScreen.setBounds(93, 30, 149, 23);
		panel_1.add(chckbxRotateScreen);
		
		JLabel lblNewLabel = new JLabel("AntiBan Settings:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 0, 177, 32);
		panel_1.add(lblNewLabel);
		
		final JCheckBox chckbxCheckXp = new JCheckBox("Check XP");
		chckbxCheckXp.setToolTipText("Hovers over the Magic skill to check your EXP");
		chckbxCheckXp.setBounds(93, 56, 97, 23);
		panel_1.add(chckbxCheckXp);
		
		final JCheckBox chckbxRandomWaits = new JCheckBox("Random Waits");
		chckbxRandomWaits.setToolTipText("Will randomly stop alching for 10-30 seconds randomly");
		chckbxRandomWaits.setBounds(93, 82, 119, 23);
		panel_1.add(chckbxRandomWaits);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isInteger = Pattern.matches("^\\d*$", textField.getText());
				
				if (btnStart.getText().equals("Start")) {
					if (isInteger && !textField.getText().isEmpty()) {
						if (comboBox.getSelectedItem().equals("High Alchemy")) {
							Variables.highAlch = true;
						} else {
							Variables.highAlch = false;
						}
						if (chckbxDebug.isSelected()) {
							Variables.debug = true; 
						} else {
							Variables.debug = false;
						}
						if (chckbxRotateScreen.isSelected()) {
							Variables.rotateScreen = true;
						} else {
							Variables.rotateScreen = false;
						}
						if (chckbxCheckXp.isSelected()) {
							Variables.hoverOverSkill = true;
						} else {
							Variables.hoverOverSkill = false;
						}
						if (chckbxRandomWaits.isSelected()) {
							Variables.randomWait = true;
						} else {
							Variables.randomWait = false;
						}
						Variables.runScript = true;
						Variables.ALCH_ITEM = Integer.parseInt(textField.getText());
						System.out.println("Starting up script: " + Variables.runScript + "; Alching item ID: " + Variables.ALCH_ITEM + "; Using spell: " + comboBox.getSelectedItem() + "; Debugging: " + Variables.debug);
						System.out.println("AntiBan: 'RotateScreen' is: " + Variables.rotateScreen + "; 'HoverOverSkill' is: " + Variables.hoverOverSkill + "; Random wait: " + Variables.randomWait + ".");
						btnStart.setText("Update");
					} else {
						JOptionPane.showMessageDialog(null, "Please enter in a valid number in the textfield box.");
					}
				} else {
					if (isInteger && !textField.getText().isEmpty()) {
						if (comboBox.getSelectedItem().equals("High Alchemy")) {
							Variables.highAlch = true;
						} else {
							Variables.highAlch = false;
						}
						if (chckbxDebug.isSelected()) {
							Variables.debug = true;
						} else {
							Variables.debug = false;
						}
						if (chckbxRotateScreen.isSelected()) {
							Variables.rotateScreen = true;
						} else {
							Variables.rotateScreen = false;
						}
						if (chckbxCheckXp.isSelected()) {
							Variables.hoverOverSkill = true;
						} else {
							Variables.hoverOverSkill = false;
						}
						if (chckbxRandomWaits.isSelected()) {
							Variables.randomWait = true;
						} else {
							Variables.randomWait = false;
						}
						Variables.ALCH_ITEM = Integer.parseInt(textField.getText());
						System.out.println("Updating alching item to: " + Variables.ALCH_ITEM + "; And spell to: " + comboBox.getSelectedItem() + "; Debugging: " + Variables.debug);
					} else {
						JOptionPane.showMessageDialog(null, "Please enter in a valid number in the textfield box.");
					}
				}
				
			}
		});
	}
}
