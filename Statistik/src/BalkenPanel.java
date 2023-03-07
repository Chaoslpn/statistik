import java.awt.Color;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class BalkenPanel extends JPanel
{
	private DefaultListModel<Double> list;
	private int ymin;
	private int ymax;
	private int xmin;
	private int xmax;
	private double zmax;
	private double zmin;
	
	public BalkenPanel(DefaultListModel<Double> dlm)
	{
		this.list = dlm;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		this.ymin = 25;
		this.ymax = this.getHeight() - 25;
		this.xmin = 25;
		this.xmax = this.getWidth() - 25;
		
		this.zmax = this.list.firstElement();
		this.zmin = this.list.firstElement();
		for(int i = 0; i < this.list.getSize(); i++)
		{
			if(this.zmax < this.list.getElementAt(i))
				this.zmax = this.list.getElementAt(i) / 2;
			if(this.zmin > this.list.getElementAt(i))
				this.zmin = this.list.getElementAt(i) / 2;
		}
		
		int	y0 = this.getHeight() / 2;
		
		// X-Achse
		g.drawLine(xmin, y0, xmax, y0);
		
		// Y-Achse
		g.drawLine(xmin, ymin, xmin, ymax);
		
		// Pfeil X-Achse
		g.drawLine(xmax, y0, xmax - 10, y0 - 5);
		g.drawLine(xmax, y0, xmax - 10, y0 + 5);
		
		// Pfeil Y-Achse
		g.drawLine(xmin, ymin, xmin - 5, ymin + 10);
		g.drawLine(xmin, ymin, xmin + 5, ymin + 10);
		
		// Balken Zeichnen
		for(int i = 1; (i-1) < this.list.getSize(); i++)
		{
			if(this.list.getElementAt(i-1).intValue() > 0)
			{
				g.setColor(Color.GREEN);
				g.drawRect(50*i, y0 - this.list.getElementAt(i-1).intValue(), xmin, this.list.getElementAt(i-1).intValue());
				g.fillRect(50*i, y0 - this.list.getElementAt(i-1).intValue(), xmin, this.list.getElementAt(i-1).intValue());
				g.setColor(Color.BLACK);
				g.drawString(this.list.getElementAt(i-1).toString(), 50*i, y0 - this.list.getElementAt(i-1).intValue() + 10);
			}
			else
			{
				g.setColor(Color.RED);
				g.drawRect(50*i, y0, 20, this.list.getElementAt(i-1).intValue() * (-1));
				g.fillRect(50*i, y0, 20, this.list.getElementAt(i-1).intValue() * (-1));
				g.setColor(Color.BLACK);
				g.drawString(this.list.getElementAt(i-1).toString(), 50*i, y0 - this.list.getElementAt(i-1).intValue());
			}
		}
	}
}
