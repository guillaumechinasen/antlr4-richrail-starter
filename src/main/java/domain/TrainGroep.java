package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainGroep  implements Iterable<Train> {
        private List<Train> trainList = new ArrayList<>();
        private static TrainGroep uniequeInstance;

        public TrainGroep() {

        }

        public void addTrain(Train train){
            System.out.println(train);
            this.trainList.add(train);
            System.out.println(trainList);
        }

        private TrainGroep(List<Train> trainList) {
            this.trainList = trainList;
        }
        public static TrainGroep getInstance(){
            if(TrainGroep.uniequeInstance == null){
               TrainGroep.uniequeInstance = new TrainGroep();
            }
            return TrainGroep.uniequeInstance;
        }

        public Train getTrainById(String id) {
            System.out.println("last on"+trainList);
            for (Train t : trainList) {
                if(t.getTrainID().equals(id)){
                    return t;
                }
            }
            return null;
        }
        @Override
        public Iterator<Train> iterator() {
            return (Iterator<Train>) trainList;
        }
    }
