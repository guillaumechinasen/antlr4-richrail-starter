package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PersonWagonGroup implements Iterable<PersonWagon>{
    private List<PersonWagon> PersonsWagonsList = new ArrayList<>();

    public void addPersonWagon(PersonWagon personWagon) {
        this.PersonsWagonsList.add(personWagon);
    }

    @Override
    public Iterator<PersonWagon> iterator() {
        return this.PersonsWagonsList.iterator();
    }
}
