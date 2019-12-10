package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LocomotiveGroup implements Iterable<Locomotive>{
    private List<Locomotive> locomotieveList = new ArrayList<>();

    public void addLocomotief(Locomotive locomotive) {
        this.locomotieveList.add(locomotive);
    }

    @Override
    public Iterator<Locomotive> iterator() {
        return this.locomotieveList.iterator();
    }
}
