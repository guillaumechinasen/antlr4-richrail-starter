package parser;

public class TrainServiceProvider  {
    private  Trainservice trainservice ;

    public Trainservice getTrainservice(){
        if(trainservice != null){
             trainservice = new Printingtrainservice();
        }
        return trainservice;
    }
}