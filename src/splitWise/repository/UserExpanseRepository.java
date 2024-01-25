package splitWise.repository;

import splitWise.models.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class UserExpanseRepository {
    private List<UserExpense> userExpenses = new ArrayList<>();

    public List<UserExpense> getUserExpenses() {
        return userExpenses;
    }

    public void setUserExpenses(List<UserExpense> userExpenses) {
        this.userExpenses = userExpenses;
    }

    public List<UserExpense> findUserExpansesByExpanse(String description){
        List<UserExpense> userExpensesList = new ArrayList<>();
        for(UserExpense userExpense : userExpenses){
            if(description.equals(userExpense.getExpanse().getDescription())){
                userExpensesList.add(userExpense);
            }
        }

        return userExpensesList;
    }
}
