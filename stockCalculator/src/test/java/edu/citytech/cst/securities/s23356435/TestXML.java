package edu.citytech.cst.securities.s23356435;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import edu.citytech.ds.stocks.jbbwebsolutions.model.IStockMetaData;

public class TestXML {

	Path path = Paths.get("/Users/tahsinahmed/Desktop/CST3650/Assignment#9/public/stocks.xml");

	@Test
	void t2() {
		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);
		var actual = service.topStocks().size();
		boolean condition = actual > 18;
		assertTrue(condition);

	}

	@Test
	void t3_topStocks() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);

		service.topStocks().forEach(System.out::println);

	}

	@Test
	void t4_worstStocks() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);

		service.worstStocks().forEach(System.out::println);

	}

	@Test
	void t5_topStockMarketValue() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);
		float expected = 2020f;
		float actual = service.topStockMarketValue().getMarketCapInBillions();
		System.out.println(service.topStockMarketValue());
		assertEquals(expected, actual);

	}

	@Test
	void t6_lowestStockMarketValue() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);
		float expected = 1.67f;
		float actual = service.lowestStockMarketValue().getMarketCapInBillions();
		System.out.println(service.lowestStockMarketValue());
		assertEquals(expected, actual);
		

	}

	@Test
	void t7_topStockByPayoutRatio() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);
		float expected = 2.8011f;
		float actual = service.topStockByPayoutRatio().getPayoutRatio();
		assertEquals(expected, actual);
		System.out.println(service.topStockByPayoutRatio());

	}

	@Test
	void t8_lowestStockByPayoutRatio() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);
		float expected = 0.2082f;
		float actual = service.lowestStockByPayoutRatio().getPayoutRatio();
		assertEquals(expected, actual);
		System.out.println(service.lowestStockByPayoutRatio());

	}

	@Test
	void t9_displayAllStocks() {

		IStockMetaData<MyStocks> service = new StockCalculator();
		service.initialize(path);

		int expected = 4;
		int actual = service.displayAllStocks().size();
		service.displayAllStocks().forEach(System.out::println);
		assertEquals(expected, actual);

	}
}
