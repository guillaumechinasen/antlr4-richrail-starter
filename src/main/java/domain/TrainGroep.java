package domain;

import parser.LogTrainService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainGroep  implements Iterable<Train> {
        static List<Train> trainList = new ArrayList<>();
        private static TrainGroep uniequeInstance;
        private LogTrainService log = new LogTrainService();

        public TrainGroep() {

        }

        public void addTrain(Train train) {
            System.out.println(train);
            this.trainList.add(train);
<<<<<<< Updated upstream
            System.out.println(trainList);
           /* try {
                log.addObjectToList(train);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
=======
            System.out.println("add train list"+trainList);

>>>>>>> Stashed changes


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
