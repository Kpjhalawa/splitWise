package splitWise.runner;

import splitWise.dtos.Transection;
import splitWise.models.*;
import splitWise.repository.ExpanseRepository;
import splitWise.repository.GroupRepository;
import splitWise.repository.UserExpanseRepository;
import splitWise.repository.UserRepository;
import splitWise.services.UserService;
import splitWise.strategy.HeapSettleStrategy;
import splitWise.userController.UserController;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 1. create user
        User chataniya = new User("chataniya","1234","4321");
        User amit = new User("amit","1234","4321");
        User sundar = new User("sundar","1234","4321");
        User ramesh = new User("ramesh","1234","4321");

        List<User> goaGuys = new ArrayList<>();

        // 2. create the group and add these users to the group
        Group goaTrip = new Group("GoaTrip");
        goaTrip.setUsers(goaGuys);

        // They went for goa. Go to dinner
        // 3. create Expanses
        Expanse dinnerExpanse = new Expanse("Dinner",5000, ExpanseType.REGULAR);

        // 4. add the expanse share of everyone
        UserExpense chataniyaShare =
                new UserExpense(chataniya,dinnerExpanse, 1000, UserExpenseType.HAD_TO_PAY);

        UserExpense amitShare =
                new UserExpense(amit, dinnerExpanse, 1000, UserExpenseType.HAD_TO_PAY);

        UserExpense sundarShare =
                new UserExpense(sundar, dinnerExpanse, 1000, UserExpenseType.HAD_TO_PAY);

        UserExpense rameshShare =
                new UserExpense(ramesh, dinnerExpanse, 2000, UserExpenseType.HAD_TO_PAY);

       // 5.capture who paid what
        UserExpense paidByChataniya =
                new UserExpense(chataniya, dinnerExpanse, 4000, UserExpenseType.PAID_BY);
        UserExpense paidByRamesh =
                new UserExpense(ramesh, dinnerExpanse, 1000, UserExpenseType.PAID_BY);

        //Manually add all these details to the database/repositories.

        UserRepository userRepository = new UserRepository();
        GroupRepository groupRepository = new GroupRepository();
        UserExpanseRepository userExpanseRepository = new UserExpanseRepository();
        ExpanseRepository expanseRepository = new ExpanseRepository();

        userRepository.setUsers(goaGuys);
        goaTrip.getExpanses().add(dinnerExpanse);
        groupRepository.getGroups().add(goaTrip);
        expanseRepository.getExpanses().add(dinnerExpanse);

        userExpanseRepository.getUserExpenses().add(chataniyaShare);
        userExpanseRepository.getUserExpenses().add(amitShare);
        userExpanseRepository.getUserExpenses().add(sundarShare);
        userExpanseRepository.getUserExpenses().add(rameshShare);

        userExpanseRepository.getUserExpenses().add(paidByChataniya);
        userExpanseRepository.getUserExpenses().add(paidByRamesh);

        UserController userController = new UserController(
                new UserService(groupRepository,userExpanseRepository,new HeapSettleStrategy()));
        List<Transection> userTransection = userController.settleUser("chataniya","GoaTrip");

        for(Transection transection : userTransection){
            System.out.println(transection.getFrom() + "-> "+ transection.getTo()+" : " + transection.getAmount());
        }
    }
}










