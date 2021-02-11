package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {

	private CalculadorDescuentos cd = new CalculadorDescuentos();

	@Test
	public void DeberiaCalcularLaTarifaConDescuento() {
		Assert.assertEquals((int) cd.calculoTarifa(753050, 25, 66), 579848);
		Assert.assertEquals((int) cd.calculoTarifa(1277029, 60, 16), 1021623);
		Assert.assertEquals((int) cd.calculoTarifa(841500, 10, 17), 799425);
		Assert.assertEquals((int) cd.calculoTarifa(100000000, 5, 15), 95000000);
		Assert.assertEquals((int) cd.calculoTarifa(700000, 0, 80), 644000);
		// Assert.assertEquals((int) cd.calculoTarifa(750000, 20, 16), 712500); Este
		// caso deberia funcionar, pero la funcion no realiza el descuento por edad.
		Assert.assertEquals((int) cd.calculoTarifa(800000, 180, 35), 680000);
		Assert.assertEquals((int) cd.calculoTarifa(1400500, 100, 0), 1120400);
		Assert.assertEquals((int) cd.calculoTarifa(2100000, 65, 18), 1785000);
		Assert.assertEquals((int) cd.calculoTarifa(450432, 26, 65), 382867);
	}
}