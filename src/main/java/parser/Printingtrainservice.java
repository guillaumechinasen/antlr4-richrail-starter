package parser;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Printingtrainservice implements Trainservice {
	static List<String> log= new ArrayList<>();

	@Override
	public void createnewtrain(String id) {
		//System.out.print("new train "+id+" created \n");
		String trainlog = "new train "+id+" created";
		log.add(trainlog);
	}


	@Override
	public void createnewgoodswagon(String id) {
		String loger = "new goodswagon "+id+" created";
		log.add(loger);
	}


	@Override
	public void createnewpersonwagon(String id) {
		String loger = "new personwagon "+id+" created";
		log.add(loger);
	}

	@Override
	public void createnewlocomotive(String id) {
		String loger = "new locomotive "+id+" created";
		log.add(loger);

	}

	@Override
	public void addgoodswagon(String trainid, String goodsid) {
		log.add("goodswagon "+goodsid+" to train "+trainid);
	}

	public List<String> loglist(){
		return log;
	}

}
