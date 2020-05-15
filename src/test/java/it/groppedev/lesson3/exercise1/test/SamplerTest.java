package it.groppedev.lesson3.exercise1.test;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.groppedev.lesson3.exercise1.model.BatterioEnterococco;
import it.groppedev.lesson3.exercise1.model.BatterioEnum;
import it.groppedev.lesson3.exercise1.model.BatterioEscherichiaColi;
import it.groppedev.lesson3.exercise1.model.BatterioFactory;
import it.groppedev.lesson3.exercise1.model.Sampler;
import it.groppedev.lesson3.exercise1.model.WaterQuality;

/**
 * Valori soglia letti tramite le seguenti proprietà di sistema
 * 
 * 	System.getProperty("enterococco.max", "500");
 *	System.getProperty("enterococco.medium", "50");
 *	System.getProperty("enterococco.min", "5");
 *
 *	System.getProperty("escherichiacoli.max", "1000");
 *	System.getProperty("escherichiacoli.medium", "100");
 *	System.getProperty("escherichiacoli.min", "10");
 *		
 * @author GROMAS
 */
public class SamplerTest
{
	@Test
	public void waterQuality_Eccellente_Test()
	{
		// 1) Fixture di test
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(1, 1);
		// 2) Esecuzione del test
		WaterQuality quality = sampler.analyze().getWaterQuality();
		// 3) Asserzioni
		Assertions.assertEquals(WaterQuality.ECCELLENTE, quality);
	}
	
	@Test
	public void waterQuality_Buona_Test()
	{
		// 1) Fixture di test
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(1, 20);
		// 2) Esecuzione del test
		WaterQuality quality = sampler.analyze().getWaterQuality();
		// 3) Asserzioni
		Assertions.assertEquals(WaterQuality.BUONA, quality);
	}
	
	@Test
	public void waterQuality_Sufficiente_Test()
	{
		// 1) Fixture di test
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(100, 20);
		// 2) Esecuzione del test
		WaterQuality quality = sampler.analyze().getWaterQuality();
		// 3) Asserzioni
		Assertions.assertEquals(WaterQuality.SUFFICIENTE, quality);
	}
	
	@Test
	public void isBalneabile_500x1000_2x_LowValue_Test()
	{
		// 1) Fixture di test
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(10, 20);
		// 2) Esecuzione del test
		boolean swimming = sampler.analyze().isSwimming();
		// 3) Asserzioni
		Assertions.assertTrue(swimming);
	}
	
	@Test
	public void isBalneabile_200x400_2x_LowValue_Test()
	{
		// 1) Fixture di test
		balneabilitaThreshold(15, 25);
		Sampler sampler = todaySampler(10, 20);
		// 2) Esecuzione del test
		boolean swimming = sampler.analyze().isSwimming();
		// 3) Asserzioni
		Assertions.assertTrue(swimming);
	}
	
	@Test
	public void isBalneabile_500x1000_2x_HighValue_Test()
	{
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(10, 20);
		boolean swimming = sampler.analyze().isSwimming();
		Assertions.assertTrue(swimming);
	}
	
	@Test
	public void isNotBalneabile_500x1000_1st_HighValue_Test()
	{
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(550, 50);
		boolean swimming = sampler.analyze().isSwimming();
		Assertions.assertFalse(swimming);
	}
	
	@Test
	public void isNotBalneabile_500x1000_2nd_HighValue_Test()
	{
		balneabilitaThreshold(500, 1000);
		Sampler sampler = todaySampler(60, 1100);
		boolean swimming = sampler.analyze().isSwimming();
		Assertions.assertFalse(swimming);
	}
	
	
	private static Sampler todaySampler(int enterococcoValue, int escherichiacoliValue)
	{
		Sampler sampler = new Sampler(new Date());
		sampler.addBatterio(BatterioFactory.newBatterioByName(BatterioEnum.ENTEROCOCCO, enterococcoValue));
		sampler.addBatterio(BatterioFactory.newBatterioByName(BatterioEnum.ESCHERICHIACOLI, escherichiacoliValue));
		return sampler;
	}
	
	private static void balneabilitaThreshold(int enterococcoValue, int escherichiacoliValue)
	{
		BatterioEnterococco.LIMIT_MAX = enterococcoValue;
		BatterioEscherichiaColi.LIMIT_MAX = escherichiacoliValue;
	}
}
