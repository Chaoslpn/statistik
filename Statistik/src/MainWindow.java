import java.awt.EventQueue;

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
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class MainWindow extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JLabel lblValue;
	private JLabel lblValues;
	private JTextField txtValue;
	private JList<Double> lstValues;
	private DefaultListModel<Double> lst = new DefaultListModel<Double>();
	private JButton btnAdd;
	private JButton btnDeleteSingle;
	private JButton btnDeleteList;
	private JButton btnClose;
	private JButton btnAverage;
	private JLabel lblErrors;
	private JButton btnDiagram;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow()
	{
		initGUI();
	}
	private void initGUI() {
		setTitle("Statistische Berechnung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 250);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{70, 171, 135, 0};
		gbl_contentPane.rowHeights = new int[]{29, 71, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.lblValue = new JLabel("Wert:");
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 0;
		this.contentPane.add(this.lblValue, gbc_lblValue);
		
		this.lblValues = new JLabel("Werte:");
		GridBagConstraints gbc_lblValues = new GridBagConstraints();
		gbc_lblValues.insets = new Insets(0, 0, 5, 5);
		gbc_lblValues.gridx = 1;
		gbc_lblValues.gridy = 0;
		this.contentPane.add(this.lblValues, gbc_lblValues);
		
		this.txtValue = new JTextField();
		GridBagConstraints gbc_txtValue = new GridBagConstraints();
		gbc_txtValue.anchor = GridBagConstraints.NORTH;
		gbc_txtValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValue.gridx = 0;
		gbc_txtValue.gridy = 1;
		this.contentPane.add(this.txtValue, gbc_txtValue);
		this.txtValue.setColumns(10);
		
		this.lstValues = new JList<Double>(this.lst);
		GridBagConstraints gbc_lstValues = new GridBagConstraints();
		gbc_lstValues.gridheight = 4;
		gbc_lstValues.insets = new Insets(0, 0, 0, 5);
		gbc_lstValues.fill = GridBagConstraints.BOTH;
		gbc_lstValues.gridx = 1;
		gbc_lstValues.gridy = 1;
		this.contentPane.add(this.lstValues, gbc_lstValues);
		
		this.lblErrors = new JLabel("");
		GridBagConstraints gbc_lblErrors = new GridBagConstraints();
		gbc_lblErrors.fill = GridBagConstraints.BOTH;
		gbc_lblErrors.insets = new Insets(0, 0, 5, 0);
		gbc_lblErrors.gridx = 2;
		gbc_lblErrors.gridy = 1;
		this.contentPane.add(this.lblErrors, gbc_lblErrors);
		
		this.btnAdd = new JButton("\u00DCbernehmen");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 2;
		this.contentPane.add(this.btnAdd, gbc_btnAdd);
		this.btnAdd.setActionCommand("Add");
		this.btnAdd.addActionListener(this);
		
		this.btnDiagram = new JButton("Diagramm");
		GridBagConstraints gbc_btnDiagram = new GridBagConstraints();
		gbc_btnDiagram.fill = GridBagConstraints.BOTH;
		gbc_btnDiagram.insets = new Insets(0, 0, 5, 0);
		gbc_btnDiagram.gridx = 2;
		gbc_btnDiagram.gridy = 2;
		this.contentPane.add(this.btnDiagram, gbc_btnDiagram);
		this.btnDiagram.addActionListener(this);
		
		this.btnDeleteSingle = new JButton("Entfernen");
		GridBagConstraints gbc_btnDeleteSingle = new GridBagConstraints();
		gbc_btnDeleteSingle.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteSingle.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteSingle.gridx = 0;
		gbc_btnDeleteSingle.gridy = 3;
		this.contentPane.add(this.btnDeleteSingle, gbc_btnDeleteSingle);
		this.btnDeleteSingle.setActionCommand("DeleteSingle");
		this.btnDeleteSingle.addActionListener(this);
		
		this.btnAverage = new JButton("Mittelwert");
		GridBagConstraints gbc_btnAverage = new GridBagConstraints();
		gbc_btnAverage.fill = GridBagConstraints.BOTH;
		gbc_btnAverage.insets = new Insets(0, 0, 5, 0);
		gbc_btnAverage.gridx = 2;
		gbc_btnAverage.gridy = 3;
		this.contentPane.add(this.btnAverage, gbc_btnAverage);
		this.btnAverage.setActionCommand("Average");
		this.btnAverage.addActionListener(this);
		
		this.btnDeleteList = new JButton("Liste l\u00F6schen");
		GridBagConstraints gbc_btnDeleteList = new GridBagConstraints();
		gbc_btnDeleteList.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteList.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteList.gridx = 0;
		gbc_btnDeleteList.gridy = 4;
		this.contentPane.add(this.btnDeleteList, gbc_btnDeleteList);
		this.btnDeleteList.setActionCommand("DeleteList");
		this.btnDeleteList.addActionListener(this);
		
		this.btnClose = new JButton("Beenden");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.fill = GridBagConstraints.BOTH;
		gbc_btnClose.gridx = 2;
		gbc_btnClose.gridy = 4;
		this.contentPane.add(this.btnClose, gbc_btnClose);
		this.btnClose.setActionCommand("Beenden");
		this.btnClose.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Beenden"))
		{
			this.dispose();
		}
		else if(e.getActionCommand().equals("Add"))
		{
			if(this.txtValue.getText().trim().isEmpty())
				this.lblErrors.setText("Eingabefeld darf nicht leer sein");
			else
			{
				try
				{
					this.lst.addElement(Double.parseDouble(this.txtValue.getText()));
				}
				catch(Exception ex)
				{
					this.lblErrors.setText("Es wurden keine Zahlen eingegeben");
				}
			}
		}
		else if(e.getActionCommand().equals("Average"))
		{
			AverageWindow aw = new AverageWindow();
			aw.setVisible(true);
			double ar = 0, go = 0, hr = 0;
			
			try
			{
				double[] lst = new double[this.lst.getSize()];
				for(int i = 0; i < this.lst.getSize(); i++)
					lst[i] = this.lst.elementAt(i);
				
				ar = Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.ARITHMETISCH);
				go = Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.GEOMETRISCH);
				hr = Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.HARMONISCH);
			}
			catch (MittelwertException mwe)
			{
				this.lblErrors.setText(mwe.getMessage());
			}
			
			aw.txtArithmetic.setText(String.valueOf(ar));
			aw.txtGeometric.setText(String.valueOf(go));
			aw.txtHarmonic.setText(String.valueOf(hr));
		}
		else if(e.getActionCommand().equals("DeleteSingle"))
		{
			this.lst.remove(this.lstValues.getSelectedIndex());
		}
		else if(e.getActionCommand().equals("DeleteList"))
		{
			this.lst.removeAllElements();
		}
		else if(e.getActionCommand().equals(this.btnDiagram.getActionCommand()))
		{
			BalkenDiagrammDlg dlg = new BalkenDiagrammDlg(this.lst);
			dlg.setVisible(true);
		}
	}
}
