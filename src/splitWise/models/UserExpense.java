package splitWise.models;

public class UserExpense {
    private User user;
    private Expanse expanse;
    private int amount;
    private UserExpenseType userExpenseType;

    public UserExpense(User user, Expanse expanse, int amount, UserExpenseType userExpenseType) {
        this.user = user;
        this.expanse = expanse;
        this.amount = amount;
        this.userExpenseType = userExpenseType;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Expanse getExpanse() {
        return expanse;
    }

    public void setExpanse(Expanse expanse) {
        this.expanse = expanse;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UserExpenseType getUserExpenseType() {
        return userExpenseType;
    }

    public void setUserExpenseType(UserExpenseType userExpenseType) {
        this.userExpenseType = userExpenseType;
    }
}
