import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AverageWindow extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JLabel lblArithmetic;
	private JLabel lblGeometric;
	private JLabel lblHarmonic;
	public JTextField txtArithmetic;
	public JTextField txtGeometric;
	public JTextField txtHarmonic;
	private JButton btnOK;

	public AverageWindow()
	{
		initGUI();
	}
	private void initGUI() {
		setTitle("Mittelwerte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.lblArithmetic = new JLabel("Arithmetisch:");
		GridBagConstraints gbc_lblArithmetic = new GridBagConstraints();
		gbc_lblArithmetic.anchor = GridBagConstraints.EAST;
		gbc_lblArithmetic.insets = new Insets(0, 0, 5, 5);
		gbc_lblArithmetic.gridx = 0;
		gbc_lblArithmetic.gridy = 0;
		this.contentPane.add(this.lblArithmetic, gbc_lblArithmetic);
		
		this.txtArithmetic = new JTextField();
		this.txtArithmetic.setEditable(false);
		GridBagConstraints gbc_txtArithmetic = new GridBagConstraints();
		gbc_txtArithmetic.insets = new Insets(0, 0, 5, 0);
		gbc_txtArithmetic.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArithmetic.gridx = 1;
		gbc_txtArithmetic.gridy = 0;
		this.contentPane.add(this.txtArithmetic, gbc_txtArithmetic);
		this.txtArithmetic.setColumns(10);
		
		this.lblGeometric = new JLabel("Geometrisch:");
		GridBagConstraints gbc_lblGeometric = new GridBagConstraints();
		gbc_lblGeometric.anchor = GridBagConstraints.EAST;
		gbc_lblGeometric.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeometric.gridx = 0;
		gbc_lblGeometric.gridy = 1;
		this.contentPane.add(this.lblGeometric, gbc_lblGeometric);
		
		this.txtGeometric = new JTextField();
		this.txtGeometric.setEditable(false);
		GridBagConstraints gbc_txtGeometric = new GridBagConstraints();
		gbc_txtGeometric.insets = new Insets(0, 0, 5, 0);
		gbc_txtGeometric.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGeometric.gridx = 1;
		gbc_txtGeometric.gridy = 1;
		this.contentPane.add(this.txtGeometric, gbc_txtGeometric);
		this.txtGeometric.setColumns(10);
		
		this.lblHarmonic = new JLabel("Harmonisch:");
		GridBagConstraints gbc_lblHarmonic = new GridBagConstraints();
		gbc_lblHarmonic.anchor = GridBagConstraints.EAST;
		gbc_lblHarmonic.insets = new Insets(0, 0, 5, 5);
		gbc_lblHarmonic.gridx = 0;
		gbc_lblHarmonic.gridy = 2;
		this.contentPane.add(this.lblHarmonic, gbc_lblHarmonic);
		
		this.txtHarmonic = new JTextField();
		this.txtHarmonic.setEditable(false);
		GridBagConstraints gbc_txtHarmonic = new GridBagConstraints();
		gbc_txtHarmonic.insets = new Insets(0, 0, 5, 0);
		gbc_txtHarmonic.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHarmonic.gridx = 1;
		gbc_txtHarmonic.gridy = 2;
		this.contentPane.add(this.txtHarmonic, gbc_txtHarmonic);
		this.txtHarmonic.setColumns(10);
		
		this.btnOK = new JButton("OK");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.fill = GridBagConstraints.BOTH;
		gbc_btnOK.gridx = 1;
		gbc_btnOK.gridy = 3;
		this.contentPane.add(this.btnOK, gbc_btnOK);
		this.btnOK.setActionCommand("OK");
		this.btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("OK"))
		{
			this.dispose();
		}
	}
}
