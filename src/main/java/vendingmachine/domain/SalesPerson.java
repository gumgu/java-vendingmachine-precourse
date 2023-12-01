package vendingmachine.domain;

public class SalesPerson {

    private Store store;
    private Money money;

    public SalesPerson(Store store, Money money) {
        this.store = store;
        this.money = money;
    }

    public void purchase(String purchaseItemName) {
        Integer price = store.purchaseItemAndGetPrice(purchaseItemName);
        money.reduceMoney(price);
    }

    public boolean isPurchasePossible() {
        return store.checkPurchasePossibility(money.getMoney());
    }

    public Integer getMoneyAmount() {
        return money.getMoney();
    }

}
