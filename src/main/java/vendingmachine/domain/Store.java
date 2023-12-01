package vendingmachine.domain;

import vendingmachine.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Item> itemCatalog = new ArrayList<>();

    public Store(List<String[]> inputItems) {
        for (String[] inputItem : inputItems) {
            validateDuplicateName(inputItem[0]);

            Item item = new Item(inputItem);
            itemCatalog.add(item);
        }
    }

    public boolean checkPurchasePossibility(Integer money) {
        return itemCatalog.stream()
                .anyMatch(item -> item.isPossiblePurchase(money));
    }

    public Integer purchaseItemAndGetPrice(String purchaseItemName) {
        validateItemPresence(purchaseItemName);
        Item item = getItem(purchaseItemName);

        Integer price = item.reduceQuantityAndGetPrice();
        return price;
    }

    private boolean hasSameName(String inputName) {
        return itemCatalog.stream()
                .anyMatch(item -> item.compareName(inputName));
    }

    private Item getItem(String name) {
        return itemCatalog.stream()
                .filter(item -> item.compareName(name))
                .findFirst()
                .get();
    }

    private void validateDuplicateName(String inputName) {
        boolean anyMatchWithInput = hasSameName(inputName);

        if (anyMatchWithInput) {
            throw new IllegalArgumentException("[ERROR] 상품의 이름이 중복됩니다.");
        }
    }

    private void validateItemPresence(String purchaseItemName) {
        if (!hasSameName(purchaseItemName)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }
    }

}
