
public class Statistik
{
	public enum MittelwertTyp { ARITHMETISCH, GEOMETRISCH, HARMONISCH }
	
	public static double berechneMittelwert(double[] lst, MittelwertTyp type) throws MittelwertException
	{
		double avg = 0, save = 0, i;
		
		if(lst == null)
			throw new MittelwertException("Es wurden keine Zahlen übergeben");
		
		if(type == MittelwertTyp.ARITHMETISCH)
		{
			for(i = 0; i < lst.length; i++)
			{
				save += lst[(int) i];
			}
			avg = save / (i);
		}
		else if(type == MittelwertTyp.GEOMETRISCH)
		{
			save = 1;
			for(i = 0; i < lst.length; i++)
			{
				if(lst[(int) i] <= 0)
					throw new MittelwertException("Geometrischer Mittelwert: Alle Zahlen müssen positiv sein");
				
				save *= lst[(int) i];
			}
			avg = Math.pow(save, 1/i);
		}
		else if(type == MittelwertTyp.HARMONISCH)
		{
			for(i = 0; i < lst.length; i++)
			{
				if(lst[(int) i] == 0)
					throw new MittelwertException("Harmonischer Mittelwert: Division durch 0 nicht möglich");
				
				save += 1/lst[(int) i];
			}
			avg = i / save;
		}
		
		return avg;
	}
}
