package edu.citytech.cst.securities.s23356435;

import org.w3c.dom.Element;

public class DataLogic {

	public static String get(Element element) {
		//nice

		String exchange = element.getAttribute("exchange");
		String favorite = element.getAttribute("favorite");
		String sector = element.getAttribute("sector");
		String industry = element.getAttribute("industry");
		Element stockNode = (Element) element.getElementsByTagName("name").item(0);
		String stockName = stockNode.getTextContent();
		String stockSymbol = stockNode.getAttribute("symbol");
		Element stockNode2 = (Element) element.getElementsByTagName("price").item(0);
		String stockPrice = stockNode2.getTextContent();
		String stockYield = stockNode2.getAttribute("yield");
		String payoutRatio = stockNode2.getAttribute("payout-ratio");
		Element stockNode3 = (Element) element.getElementsByTagName("market-cap").item(0);
		String stockMarketCap = stockNode3.getTextContent();
		String numberRepresentation = stockNode3.getAttribute("number-representation");
		// number-representation
		String stockPayDate = stockNode3.getAttribute("pay-date");

		// columns[0] columns[1]

		return exchange + "|" + favorite + "|" + stockName + "|" + stockSymbol + "|" + sector + "|" + industry + "|"
				+ stockPrice + "|" + stockYield + "|" + payoutRatio + "|" + stockMarketCap + "|" + stockPayDate + "|"
				+ numberRepresentation;
	}

	public static MyStocks getModel(String row) {
		MyStocks stock = new MyStocks();
		String columns[] = row.split("\\|");
		String test = columns[10];
		String[] integerStrings = test.split(",");
		Integer[] payDates = new Integer[integerStrings.length];
		for (int i = 0; i < payDates.length; i++) {
			payDates[i] = Integer.parseInt(integerStrings[i]);
		}
		stock.setExchange(columns[0]);
		stock.setSymbol(columns[3]);
		stock.setName(columns[2]);
		stock.setFavorite(columns[1]);
		stock.setSector(columns[4]);
		stock.setIndustry(columns[5]);
		stock.setPrice(Float.parseFloat(columns[6]));
		stock.setYield(Float.parseFloat(columns[7]));
		stock.setPayoutRatio(Float.parseFloat(columns[8]));
		String numberRepresentation = columns[11];
		float marketCapInBillions = Float.parseFloat(columns[9]);
		marketCapInBillions = numberRepresentation.equals("t") ? marketCapInBillions * 1000 : marketCapInBillions;
		stock.setMarketCapInBillions(marketCapInBillions); // stock-video folder video #6 explains how to fix this
															// problem

		stock.setPayDates(payDates);

		return stock;
	}
}
