import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MittelwertTest
{

	@Test
	void berechneMittelwertArithmetischTest() throws MittelwertException
	{
		double[] lst = new double[] {1,2};
		assertEquals(1.5, Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.ARITHMETISCH));
	}
	@Test
	void berechneMittelwertGeometrischTest() throws MittelwertException
	{
		double[] lst = new double[] {1,2};
		assertEquals(1.4142135623730951, Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.GEOMETRISCH));
	}
	@Test
	void berechneMittelwertHarmonischTest() throws MittelwertException
	{
		double[] lst = new double[] {1,2};
		assertEquals(1.3333333333333333, Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.HARMONISCH));
	}
	@Test
	void berechneMittelwertArithmetischMessageTest() throws MittelwertException
	{
		double[] lst = null;
		MittelwertException ex = assertThrows(MittelwertException.class, () -> Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.ARITHMETISCH));
		assertEquals("Keine Werte übergeben", ex.getMessage());
	}
	@Test
	void berechneMittelwertGeometrischMessageTest() throws MittelwertException
	{
		double[] lst = null;
		MittelwertException ex = assertThrows(MittelwertException.class, () -> Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.GEOMETRISCH));
		assertEquals("Keine Werte übergeben", ex.getMessage());
	}
	@Test
	void berechneMittelwertHarmonischMessageTest() throws MittelwertException
	{
		double[] lst = null;
		MittelwertException ex = assertThrows(MittelwertException.class, () -> Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.HARMONISCH));
		assertEquals("Keine Werte übergeben", ex.getMessage());
	}
	@Test
	void berechneMittelwertHarmonischDivision0Test() throws MittelwertException
	{
		double[] lst = new double[] {0,2};
		MittelwertException ex = assertThrows(MittelwertException.class, () -> Statistik.berechneMittelwert(lst, Statistik.MittelwertTyp.HARMONISCH));
		assertEquals("Division durch 0 nicht möglich", ex.getMessage());
	}
}
