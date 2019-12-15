package parser;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Printingtrainservice implements Trainservice {


	static List<String> logger33= new ArrayList<>();
	private LogTrainService logger = new LogTrainService();

	@Override
	public void createnewtrain(String id) {
		//System.out.print("new train "+id+" created \n");
		String trainlog = "new train "+id+" created";
		logger.addToList(trainlog);
	}


	@Override
	public void createnewgoodswagon(String id) {
		String loger = "new goodswagon "+id+" created";
		logger.addToList(loger);
		logger33.add(loger);
	}


	@Override
	public void createnewpersonwagon(String id) {
		String loger = "new personwagon "+id+" created";
		logger.addToList(loger);
		logger33.add(loger);
	}

	@Override
	public void createnewlocomotive(String id) {
		String loger = "new locomotive "+id+" created";
		logger.addToList(loger);
		logger33.add(loger);

	}

	@Override
	public void addComponent(String trainid, String goodsid) {
		String addlog = "Component "+goodsid+" added to train "+trainid;
		logger.addToList(addlog);

	}

	@Override
	public void removeComponent(String trainid, String goodsid) {
		String removelog = "Component "+goodsid+" added to train "+trainid;
		logger.addToList(removelog);

	}

	@Override
	public void deleteComponent( String goodsid) {
		String dellog = "Component "+goodsid+" deleted";
		logger.addToList(dellog);
	}



}
