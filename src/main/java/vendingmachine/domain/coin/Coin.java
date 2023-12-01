package vendingmachine.domain.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Integer getRandomCoin() {
        return Randoms.pickNumberInList(getAmounts());
    }

    public static Coin getCoinByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        return null;
    }

    private static List<Integer> getAmounts() {
        return Arrays.asList(
                COIN_500.amount,
                COIN_100.amount,
                COIN_50.amount,
                COIN_10.amount
        );
    }

    public int getAmount() {
        return amount;
    }
}
