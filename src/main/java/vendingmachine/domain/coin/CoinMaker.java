package vendingmachine.domain.coin;

import vendingmachine.domain.coin.Coin;
import vendingmachine.ui.util.Number;

import java.util.*;
import java.util.stream.Collectors;

public class CoinMaker {

    public static final Integer MINIMUM_BANKNOTE = 1000;
    public static final Integer MINIMUM_RETAIN_MONEY_AMOUNT = 10;

    final Map<Coin, Integer> coins;

    public CoinMaker(String inputValue) {
        Integer retainMoney = getRetainMoney(inputValue);
        validateRetainMoneyMinimum(retainMoney);

        retainMoney = removeBanknotes(retainMoney);
        coins = makeRandomCoins(retainMoney);
    }

    private Integer removeBanknotes(Integer retainMoney) {
        return retainMoney % MINIMUM_BANKNOTE;
    }

    private Map<Coin, Integer> makeRandomCoins(Integer retainMoney) {
        final Map<Coin, Integer> coins = new HashMap<>();

        while (retainMoney != 0) {
            Integer randomCoinAmount = Coin.getRandomCoin();

            if (retainMoney >= randomCoinAmount) {
                int count = retainMoney / randomCoinAmount;
                retainMoney %= randomCoinAmount;
                coins.put(Coin.getCoinByAmount(randomCoinAmount), count);
            }

        }

        return coins;
    }

    public Map<Coin, Integer> calculateReturnCoin(Integer remainingAmount) {
        List<Map.Entry<Coin, Integer>> sortedCoins = sortedCoinsByAmount();
        final Map<Coin, Integer> returnCoins = new LinkedHashMap<>();

        for (Map.Entry<Coin, Integer> entry : sortedCoins) {
            Coin coin = entry.getKey();
            Integer count = entry.getValue();

            while (count > 0 && remainingAmount >= coin.getAmount()) {
                returnCoins.put(coin, returnCoins.getOrDefault(coin, 0) + 1);
                remainingAmount -= coin.getAmount();
                count--;
            }
        }

        return returnCoins;
    }

    private List<Map.Entry<Coin, Integer>> sortedCoinsByAmount() {
        return coins.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
    }

    private Integer getRetainMoney(String inputValue) {
        Number number = new Number(inputValue);
        return number.getNumericValue();
    }

    private void validateRetainMoneyMinimum(Integer retainMoney) {
        if (retainMoney < MINIMUM_RETAIN_MONEY_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 10원보다 작은 금액은 입력할 수 없습니다.");
        }
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }
}
