package splitWise.repository;

import splitWise.models.Expanse;
import splitWise.models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    public List<Expanse> findExpanseByGroup(String groupName){
        for(Group group: groups){
            if(groupName.equals(group.getName())){
                return group.getExpanses();
            }
        }
        return new ArrayList<>();
    }
}
