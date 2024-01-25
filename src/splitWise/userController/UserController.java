package splitWise.userController;

import splitWise.dtos.Transection;
import splitWise.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    public List<Transection> settleUser(String userName, String groupName){
        return userService.settleUser(userName , groupName);


    }
}
