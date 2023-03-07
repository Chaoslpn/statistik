import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BalkenDiagrammDlg extends JDialog implements ActionListener
{
	private final BalkenPanel Panel;

	public BalkenDiagrammDlg(DefaultListModel<Double> dlm)
	{
		this.setTitle("Balkendiagramm");
		this.setModal(true);
		this.Panel = new BalkenPanel(dlm);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		this.Panel.setLayout(new FlowLayout());
		this.Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.Panel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.dispose();
	}
}
