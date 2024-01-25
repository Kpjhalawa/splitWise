package splitWise.models;

public class Expanse {
    private String description;
    private int amount;
    private ExpanseType expanseType;

    public Expanse(String description, int amount, ExpanseType expanseType) {
        this.description = description;
        this.amount = amount;
        this.expanseType = expanseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ExpanseType getExpanseType() {
        return expanseType;
    }

    public void setExpanseType(ExpanseType expanseType) {
        this.expanseType = expanseType;
    }
}
