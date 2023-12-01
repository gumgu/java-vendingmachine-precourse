package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.SalesPerson;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinMaker;
import vendingmachine.domain.Store;
import vendingmachine.ui.InputView;
import vendingmachine.ui.OutputView;

import java.util.Map;

public class VendingMachine {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    CoinMaker coinMaker;
    SalesPerson salesPerson;

    public void doVendingMachine() {
        coinMaker = setCoinMaker();
        outputView.printCoins(coinMaker.getCoins());

        Store store = setStore();

        Money money = getMoney();
        outputView.printMoney(money.getMoney());

        salesPerson = new SalesPerson(store, money);

        // 구매 가능여부 확인
        while (salesPerson.isPurchasePossible()) {
            salesPerson.purchase(getPurchaseItemName());
            Integer moneyAmount = salesPerson.getMoneyAmount();
            outputView.printMoney(moneyAmount);
        }

        // 잔돈 반환 진행
        Integer returnMoney = salesPerson.getMoneyAmount();
        Map<Coin, Integer> returnCoins = coinMaker.calculateReturnCoin(returnMoney);
        outputView.printReturnCoins(returnCoins);


    }

    private String getPurchaseItemName() {
        while(true) {
            try {
                return inputView.readPurchaseItemName();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


    private Money getMoney() {
        while(true) {
            try {
                return new Money(inputView.readMoney());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Store setStore() {
        while(true) {
            try {
                return new Store(inputView.readItem());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private CoinMaker setCoinMaker() {
        while(true) {
            try {
                return new CoinMaker(inputView.readRetainMoney());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}