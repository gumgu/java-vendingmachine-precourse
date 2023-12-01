package vendingmachine.domain.item;

public class Name {

    private String name;

    public Name(String inputName) {
        this.name = inputName;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
