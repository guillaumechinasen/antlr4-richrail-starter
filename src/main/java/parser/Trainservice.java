package parser;

public interface Trainservice {
void createnewtrain(String id);
void createnewgoodswagon(String id);
void createnewpersonwagon(String id);
void createnewlocomotive(String id) ;
void addgoodswagon(String trainid,String goodsid);
}
