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

	}


	@Override
	public void createnewpersonwagon(String id) {

	}

	@Override
	public void createnewlocomotive(String id) {
		String locolog = "new locomotive "+id+" created";
		log.add(locolog);

	}
	public List<String> loglist(){
		return log;
	}

}
