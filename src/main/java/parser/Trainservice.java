package parser;

public interface Trainservice {
void createnewtrain(String id);
void createnewgoodswagon(String id);
void createnewpersonwagon(String id);
void createnewlocomotive(String id) ;
void addComponent(String trainid,String goodsid);
void removeComponent(String trainid, String goodsid);
void deleteComponent(String goodsid);


}
