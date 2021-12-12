package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import vendingmachine.utill.RandomCoinGenerator;

public class Coins {
	private final LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

	public Coins() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	public void generateCoins(int machineMoney) {
		while (machineMoney != 0) {
			int coin = RandomCoinGenerator.generateRandomCoin(getCoinTypes());
			if (coin <= machineMoney) {
				machineMoney -= coin;
				addCoin(coin);
			}
		}
	}

	private List<Integer> getCoinTypes() {
		List<Integer> coinTypes = new ArrayList<>();

		for (Coin coin : Coin.values()) {
			coinTypes.add(coin.getAmount());
		}

		return coinTypes;
	}

	private void addCoin(int coin) {
		Coin coinValue = Coin.matchValue(coin);
		coins.put(coinValue, coins.get(coinValue) + 1);
	}
}
