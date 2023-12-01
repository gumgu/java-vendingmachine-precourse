package vendingmachine.ui;

import vendingmachine.domain.coin.Coin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COIN_DELIMITER = " - ";
    private static final String COUNT_UNIT = "개";

    Map<Coin, String> coinMessage = new HashMap<>();

    public OutputView() {
        coinMessage.put(Coin.COIN_500, "500원");
        coinMessage.put(Coin.COIN_100, "100원");
        coinMessage.put(Coin.COIN_50, "50원");
        coinMessage.put(Coin.COIN_10, "10원");
    }

    public void printCoins(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        List<Map.Entry<Coin, Integer>> sortedCoins = getSortedCoinList(coins);

        for (Map.Entry<Coin, Integer> coin : sortedCoins) {
            System.out.println(coinMessage.get(coin.getKey())
                    + COIN_DELIMITER
                    + coin.getValue()
                    + COUNT_UNIT
            );
        }
    }

    private List<Map.Entry<Coin, Integer>> getSortedCoinList(Map<Coin, Integer> coins) {
        return coins.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
    }

    public void printMoney(Integer money) {
        System.out.println("투입 금액: " + money + "원");
    }

    public void printReturnCoins(Map<Coin, Integer> returnCoins) {
        System.out.println("잔돈");
        List<Map.Entry<Coin, Integer>> sortedCoins = getSortedCoinList(returnCoins);

        for (Map.Entry<Coin, Integer> coin : sortedCoins) {
            System.out.println(coinMessage.get(coin.getKey())
                    + COIN_DELIMITER
                    + coin.getValue()
                    + COUNT_UNIT
            );
        }
    }

}
