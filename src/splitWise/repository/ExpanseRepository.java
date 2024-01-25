package splitWise.repository;

import splitWise.models.Expanse;

import java.util.ArrayList;
import java.util.List;

public class ExpanseRepository {
    private List<Expanse> expanses = new ArrayList<>();

    public List<Expanse> getExpanses() {
        return expanses;
    }

    public void setExpanses(List<Expanse> expanses) {
        this.expanses = expanses;
    }
}
