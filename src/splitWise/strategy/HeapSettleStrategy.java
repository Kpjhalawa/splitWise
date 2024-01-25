package splitWise.strategy;

import splitWise.dtos.Transection;
import splitWise.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSettleStrategy implements SettelupStrategy{
    @Override
    public List<Transection> settelUpUsers(Map<User, Integer> map) {
        PriorityQueue<Pair> reciver = new PriorityQueue<>();
        PriorityQueue<Pair> givers = new PriorityQueue<>();

        List<Transection> transections = new ArrayList<>();
        for(User user : map.keySet()){
            Integer amount = map.get(user);
            if(amount<0){
                givers.add(new Pair(-1*amount,user));
            }
            else if(amount > 0){
                reciver.add(new Pair(amount,user));
            }
        }
        while(reciver.size() > 0 && givers.size() > 0){
            Pair giver = givers.poll();
            Pair recive = reciver.poll();
            transections.add(new Transection(giver.user.getName(),recive.user.getName(),giver.amount));
            if(giver.amount < recive.amount){
                reciver.add(new Pair(recive.amount - giver.amount,recive.user));
            }
        }

        return  transections;
    }

    private class Pair implements Comparable{
        int amount;
        User user;

        public Pair(int amount, User user) {
            this.amount = amount;
            this.user = user;
        }

        @Override
        public int compareTo(Object o) {
            Pair other = (Pair)o;
            if(this.amount <= other.amount){
                return -1;
            }
            return 1;
        }
    }
}
