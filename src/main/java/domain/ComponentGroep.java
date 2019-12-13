package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentGroep implements Iterable<Component> {
    private List<Component> componentList = new ArrayList<>();
    private static ComponentGroep uniequeInstance;

    public ComponentGroep() {

    }

    public void AddComponent(Component component){
        System.out.println(component);
        this.componentList.add(component);
        System.out.println(componentList);
    }

    private ComponentGroep(List<Component> componentList) {
        this.componentList = componentList;
    }
    public static ComponentGroep getInstance(){
        if(ComponentGroep.uniequeInstance == null){
            ComponentGroep.uniequeInstance = new ComponentGroep();
        }
        return ComponentGroep.uniequeInstance;
    }

    public Component GetComponentById(String id) {
        System.out.println("last on"+componentList);
        for (Component c : componentList){
            if (c.getId()  == id) {

                return null;
            }
            else{
                System.out.println("totot");
                return c;
            }
        }
        return null;
    }
    @Override
    public Iterator<Component> iterator() {
        return (Iterator<Component>) componentList;
    }
}
