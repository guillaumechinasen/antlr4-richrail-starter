package parser;

import domain.*;
import parser.RichRailBaseListener;
import parser.RichRailParser;
import parser.Trainservice;


public class RichRailCli1 extends RichRailBaseListener {
    private Trainservice trainservice;
    private TrainBuilderInterface train = new TrainBuilder();
    private ComponentGroep groep = ComponentGroep.getInstance();
    private TrainGroep trainGroep = TrainGroep.getInstance();

    public RichRailCli1(Trainservice trainservice) {
        super();
        this.trainservice = trainservice;
    }

    @Override
    public void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
        super.enterNewtraincommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        Train t = train.setTrainId(trainid);
        trainGroep.addTrain(t);
        train.toString();
    }

    @Override
    public void enterNewgoodswagoncommand(RichRailParser.NewgoodswagoncommandContext ctx) {
        super.enterNewgoodswagoncommand(ctx);
        String goodsid = ctx.GoodsID().getSymbol().getText();
        String cargo = ctx.STRING().getSymbol().getText();
        ComponentFactory f = new ComponentFactory();
        f.setId(goodsid);
        f.setCargo(cargo);
        Component goodswagon = f.CreateComponents("Goodswagon");
        groep.AddComponent(goodswagon);
    }

    @Override
    public void enterNewpersonwagoncommand(RichRailParser.NewpersonwagoncommandContext ctx) {
        super.enterNewpersonwagoncommand(ctx);
        String personid = ctx.PersonID().getSymbol().getText();
        int seats = Integer.parseInt(ctx.NUMBER().getSymbol().getText());
        ComponentFactory f = new ComponentFactory();
        f.setId(personid);
        f.setSeats(seats);
        Component personWagon = f.CreateComponents("Personwagon");
        groep.AddComponent(personWagon);
    }

    @Override
    public void enterNewlocomotivecommand(RichRailParser.NewlocomotivecommandContext ctx) {
        super.enterNewlocomotivecommand(ctx);
        String locoId = ctx.LocoID().getSymbol().getText();
        String fuelType = ctx.STRING().getSymbol().getText();
        ComponentFactory f = new ComponentFactory();
        f.setId(locoId);
        f.setFueltype(fuelType);
        Component locomotive = f.CreateComponents("Locomotive");
        groep.AddComponent(locomotive);

    }

    @Override
    public void enterAddgoodswagoncommand(RichRailParser.AddgoodswagoncommandContext ctx) {
        super.enterAddgoodswagoncommand(ctx);
        String goodsid = ctx.GoodsID().getSymbol().getText();
        String trainid = ctx.TrainID().getSymbol().getText();

        this.trainservice.addgoodswagon(goodsid,trainid);
        train.setTrainId(trainid);
        train.build();
        train.toString();
        GoodsWagon g = (GoodsWagon) groep.GetComponentById(goodsid);
        Train t = trainGroep.getTrainById(trainid);

        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(g);
        trainBuilder.setTrain(t);
        trainBuilder.build();
    }

    @Override
    public void enterAddpersonwagoncommand(RichRailParser.AddpersonwagoncommandContext ctx) {
        super.enterAddpersonwagoncommand(ctx);
        String personId = ctx.PersonID().getSymbol().getText();
        String trainId = ctx.TrainID().getSymbol().getText();

        this.trainservice.addgoodswagon(personId,trainId);
        train.setTrainId(trainId);
        train.build();
        train.toString();
        PersonWagon personWagon = (PersonWagon) groep.GetComponentById(personId);
        Train train = trainGroep.getTrainById(trainId);

        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(personWagon);
        trainBuilder.setTrain(train);
        trainBuilder.build();

    }

    @Override
    public void enterAddlocomotivecommand(RichRailParser.AddlocomotivecommandContext ctx) {
        super.enterAddlocomotivecommand(ctx);
        String locomotiveId = ctx.LocoID().getSymbol().getText();
        String trainId = ctx.TrainID().getSymbol().getText();

        this.trainservice.addgoodswagon(locomotiveId,trainId);
        train.setTrainId(trainId);
        train.build();
        train.toString();
        PersonWagon personWagon = (PersonWagon) groep.GetComponentById(locomotiveId);
        Train train = trainGroep.getTrainById(trainId);

        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(personWagon);
        trainBuilder.setTrain(train);
        trainBuilder.build();
    }
}


