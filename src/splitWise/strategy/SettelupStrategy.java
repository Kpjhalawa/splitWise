package splitWise.strategy;

import splitWise.dtos.Transection;
import splitWise.models.User;

import java.util.List;
import java.util.Map;

public interface SettelupStrategy {
    public List<Transection> settelUpUsers(Map<User,Integer> map);
}
