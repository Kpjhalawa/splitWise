package splitWise.services;

import splitWise.dtos.Transection;
import splitWise.models.*;
import splitWise.repository.GroupRepository;
import splitWise.repository.UserExpanseRepository;
import splitWise.repository.UserRepository;
import splitWise.strategy.SettelupStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private GroupRepository groupRepository;
    private UserExpanseRepository userExpanseRepository;
    private SettelupStrategy settelupStrategy;

    public UserService(GroupRepository groupRepository, UserExpanseRepository userExpanseRepository, SettelupStrategy settelupStrategy) {
        this.groupRepository = groupRepository;
        this.userExpanseRepository = userExpanseRepository;
        this.settelupStrategy = settelupStrategy;
    }

    public List<Transection> settleUser(String userName, String groupName) {
        /*
        We do following steps to create service
        1. Get all expanses of  a group
        2. Filter only regular expenses -> expanse
        3. for every expanse -> find userEccxpanse list
        4. we Itrerate over all the userExpanse
        calculae the extra amount for every user

        Map of extra amount -> Map <User ,Integer>
        Data : {A:2000,B:-1000}
        if the type of userExpanse is paidBy , extra amount -= amount;
                           WhoHadToPay,extra_amount -= amount;
        5. Pass this map to another class , which will use heaps and gets me the transaxtions list.
         */
        Map<User , Integer> extraAmpuntMap = new HashMap<>();

        List<Expanse> expanses  = groupRepository.findExpanseByGroup(groupName);

        for(Expanse expanse : expanses){
            if(expanse.getExpanseType() == ExpanseType.REGULAR){
                List<UserExpense> userExpenseList =
                        userExpanseRepository.findUserExpansesByExpanse(expanse.getDescription());
                for(UserExpense userExpense : userExpenseList ){
                    User user = userExpense.getUser();
                    if(!extraAmpuntMap.containsKey(user)){
                        extraAmpuntMap.put(user,0);
                    }

                    Integer amount = extraAmpuntMap.get(user);
                if(userExpense.getUserExpenseType() == UserExpenseType.PAID_BY){
                  amount += userExpense.getAmount();
                  }
                else{
                    amount -= userExpense.getAmount();
                }
                extraAmpuntMap.put(user, amount );
                }
            }
        }
        //  finding the transadctions using extra amount for every user.
        List<Transection> groupTransactions = settelupStrategy.settelUpUsers(extraAmpuntMap);
        List<Transection> userTransactions  = new ArrayList<>();

        for(Transection transection : groupTransactions){
            if(transection.getFrom().equals(userName)  ||
            transection.getTo().equals(userName)){
                userTransactions.add(transection);
            }
        }

        return userTransactions;
    }
}

