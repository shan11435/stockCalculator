package edu.citytech.cst.securities.s23356435;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import edu.citytech.ds.stocks.jbbwebsolutions.model.IStockMetaData;

public class StockCalculator implements IStockMetaData<MyStocks> {

	private List<MyStocks> list;

	@Override
	public void initialize(Path pfileName) {
		String fileName = pfileName.toString();
		String mainElement = "stock";

		Stream<String> stockdata = XMLUtility.process(fileName, mainElement, DataLogic::get);
		var stocks = stockdata.map(DataLogic::getModel);
		list = stocks.collect(Collectors.toList());

	}

	@Override
	public List<MyStocks> topStocks() {

		return list.stream().sorted().collect(Collectors.toList());

	}

	@Override
	public List<MyStocks> worstStocks() {
		return list.stream().sorted(Comparator.comparing(MyStocks::getPoints)).collect(Collectors.toList());
	}

	@Override
	public MyStocks topStockMarketValue() {
		// TODO Auto-generated method stub
		return list.stream().sorted(Comparator.comparing(MyStocks::getMarketCapInBillions).reversed())
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public MyStocks lowestStockMarketValue() {
		return list.stream().sorted(Comparator.comparing(MyStocks::getMarketCapInBillions)).collect(Collectors.toList())
				.get(0);

	}

	@Override
	public MyStocks topStockByPayoutRatio() {
		return list.stream().sorted(Comparator.comparing(MyStocks::getPayoutRatio).reversed())
				.collect(Collectors.toList()).get(0);

	}

	@Override
	public MyStocks lowestStockByPayoutRatio() {
		return list.stream().sorted(Comparator.comparing(MyStocks::getPayoutRatio)).collect(Collectors.toList()).get(0);

	}

	@Override
	public Set<MyStocks> displayAllStocks() {

		Set<MyStocks> stocks = new HashSet<>();
		// list.stream().forEach(stocks::add);
		for (MyStocks row : list) {
			stocks.add(row);
		}

		return stocks;
	}

}
