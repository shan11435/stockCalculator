package edu.citytech.cst.securities.s23356435;

import java.util.Arrays;

import edu.citytech.ds.stocks.jbbwebsolutions.model.BaseStock;

public class MyStocks extends BaseStock implements Comparable<MyStocks> {

	/*
	 * 1. Companies with a market value over 500 million dollars will be assigned -
	 * 10 points 2. Companies with a market value over 1 billion dollars will be
	 * assigned - 15 points 3. Companies with a market value over 100 billion
	 * dollars will be assigned - 20 points 4. Companies with a market value over
	 * 500 billion dollars will be assigned - 25 points 5. Companies with a market
	 * value over 900 billion dollars will be assigned - 35 points
	 * 
	 * 1. Payout ratio equal to 100 percent or higher is assigned a value of - 5
	 * points 2. Payout ratio over 60 percent is assigned a value of - 10 points 3.
	 * Payout ratio over between 50 and 60 percent assigned a value of - 20 points
	 * 4. Payout ratio under 50 but over 30 percent is assigned a value of – 25
	 * points. 5. Payout ratio under 30 percent is assigned a value of - 30 points
	 * 
	 * 1. Yield over 8% a value of - 30 points are assigned to the stock 2. Yield
	 * over 5% a value of - 25 points are assigned to the Stock 3. Yield over 3% a
	 * value of - 20 points are assigned to the stock 4. Yield over 2% a value of -
	 * 15 points are assigned to the stock 5. Yield over 1% a value of - 10 points
	 * are assigned to the stock 6. Yield over 0% a value of - 5 points are assigned
	 * to the stock
	 * 
	 * 
	 */
	public float getPoints() {
		float points1 = 0;
		float points2 = 0;
		float points3 = 0;

		if (marketCapInBillions > .5) {
			points1 = 10;
		}

		if (marketCapInBillions > 1) {
			points1 = 15;
		}

		if (marketCapInBillions > 100) {
			points1 = 20;
		}

		if (marketCapInBillions > 500) {
			points1 = 25;
		}

		if (marketCapInBillions > 900) {
			points1 = 35;
		}

		if (payoutRatio >= 1.00) {
			points2 = 5;
		}

		else if (payoutRatio > 0.6) {
			points2 = 10;
		}

		else if (payoutRatio > 0.5 && payoutRatio < 0.6) {
			points2 = 20;
		}

		else if (payoutRatio > 0.3 && payoutRatio < 0.5) {
			points2 = 25;
		}

		else if (payoutRatio < 0.6) {
			points2 = 30;
		}

		if (yield > 0.08) {
			points3 = 30;
		}

		else if (yield > 0.05) {
			points3 = 25;
		}

		else if (yield > 0.03) {
			points3 = 20;
		}

		else if (yield > 0.02) {
			points3 = 15;
		}

		else if (yield > 0.01) {
			points3 = 10;
		}

		else if (yield > 0.00) {
			points3 = 5;
		}

		return points1 + points2 + points3;
	}

	@Override
	public String toString() {
		return "MyStocks [exchange=" + exchange + ", industry=" + industry + ", symbol=" + symbol + ", name=" + name
				+ ", price=" + price + ", yield=" + yield + ", payoutRatio=" + payoutRatio + ", marketCapInBillions="
				+ marketCapInBillions + ", payDates=" + Arrays.toString(payDates) + ", favorite=" + favorite
				+ ", sector=" + sector + ", getPoints()=" + getPoints() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyStocks other = (MyStocks) obj;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		return true;
	}

	@Override
	public int compareTo(MyStocks stock) {
		int status = Float.compare(this.getPoints(), stock.getPoints()) * -1;
		return status;
	}

}
