package splitWise.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> users;
    private List<Expanse> expanses;

    public Group(String name) {
        this.expanses = new ArrayList<>();
        this.users = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expanse> getExpanses() {
        return expanses;
    }

    public void setExpanses(List<Expanse> expanses) {
        this.expanses = expanses;
    }
}
