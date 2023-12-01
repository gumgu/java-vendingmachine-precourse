package vendingmachine.domain.item;

public class Item {

    private static final Integer ITEM_DETAILS_COUNT = 3;

    private final Name name;
    private final Price price;
    private final Quantity quantity;

    public Item(String[] inputValue) {
        validateItemDetailsCount(inputValue.length);

        this.name = new Name(inputValue[0]);
        this.price = new Price(inputValue[1]);
        this.quantity = new Quantity(inputValue[2]);
    }

    public Integer reduceQuantityAndGetPrice() {
        quantity.minusQuantity();
        return price.getPrice();
    }

    public boolean isPossiblePurchase(Integer money) {
        return price.isPurchaseAffordable(money) && quantity.hasStock();
    }

    private void validateItemDetailsCount(int inputValueCount) {
        if (inputValueCount != ITEM_DETAILS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 입력한 정보가 올바르지 않습니다.");
        }
    }

    public boolean compareName(String compareName) {
        return name.isSameName(compareName);
    }

}
