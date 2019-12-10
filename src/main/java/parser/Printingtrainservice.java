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
	logger();

	}


	@Override
	public void createnewgoodswagon(String id) {
		System.out.println("new personwagon "+id+" added cargo:  serialnr: ");
	}


	@Override
	public void createnewpersonwagon(String id) {

	}

	@Override
	public void createnewlocomotive(String id) {

	}
	public void logger(){
	for (String i: log) {
		System.out.println("[ " +i+" ]");
	}

	}
	public List<String> loglist(){
		return log;
	}

}
