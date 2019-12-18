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
        this.trainservice.createnewtrain(trainid);
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
        this.trainservice.createnewgoodswagon(goodsid);
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
        this.trainservice.createnewpersonwagon(personid);
    }

    @Override
    public void enterNewlocomotivecommand(RichRailParser.NewlocomotivecommandContext ctx) {
        super.enterNewlocomotivecommand(ctx);
        String locoid = ctx.LocoID().getSymbol().getText();
        String fuelType = ctx.STRING().getSymbol().getText();
        ComponentFactory f = new ComponentFactory();
        f.setId(locoid);
        f.setFueltype(fuelType);
        Component locomotive = f.CreateComponents("Locomotive");
        groep.AddComponent(locomotive);
        this.trainservice.createnewlocomotive(locoid);

    }

    @Override
    public void enterAddgoodswagoncommand(RichRailParser.AddgoodswagoncommandContext ctx) {
        super.enterAddgoodswagoncommand(ctx);
        String goodsid = ctx.GoodsID().getSymbol().getText();
        String trainid = ctx.TrainID().getSymbol().getText();
        GoodsWagon g = (GoodsWagon) groep.GetComponentById(goodsid);
        Train t = trainGroep.getTrainById(trainid);

        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(g);
        trainBuilder.setTrain(t);
        trainBuilder.build();

        groep.RemoveComponentFromList(g);
        System.out.println(t);
        this.trainservice.addComponent(trainid,goodsid);
    }
    @Override
    public void enterAddpersonwagoncommand(RichRailParser.AddpersonwagoncommandContext ctx) {
        super.enterAddpersonwagoncommand(ctx);
        String personId = ctx.PersonID().getSymbol().getText();
        String trainId = ctx.TrainID().getSymbol().getText();
        PersonWagon personWagon = (PersonWagon) groep.GetComponentById(personId);
        Train train = trainGroep.getTrainById(trainId);
        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(personWagon);
        trainBuilder.setTrain(train);
        trainBuilder.build();
        this.trainservice.addComponent(trainId,personId);

    }

    @Override
    public void enterAddlocomotivecommand(RichRailParser.AddlocomotivecommandContext ctx) {
        super.enterAddlocomotivecommand(ctx);
        String locomotiveId = ctx.LocoID().getSymbol().getText();
        String trainId = ctx.TrainID().getSymbol().getText();
        Locomotive l = (Locomotive) groep.GetComponentById(locomotiveId);
        Train train = trainGroep.getTrainById(trainId);
        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.addComponent(l);
        trainBuilder.setTrain(train);
        trainBuilder.build();
        this.trainservice.addComponent(trainId,locomotiveId);
    }

    @Override
    public void enterRemgoodswagoncommand(RichRailParser.RemgoodswagoncommandContext ctx) {
        super.enterRemgoodswagoncommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String goodsid = ctx.GoodsID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
        GoodsWagon g = (GoodsWagon) t.RemoveComponentFromList(goodsid);
        groep.AddComponent(g);
        this.trainservice.removeComponent(trainid,goodsid);
    }

    @Override
    public void enterRempersonwagoncommand(RichRailParser.RempersonwagoncommandContext ctx) {
        super.enterRempersonwagoncommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String personid = ctx.PersonID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
       PersonWagon p = (PersonWagon) t.RemoveComponentFromList(personid);
       groep.AddComponent(p);
       this.trainservice.removeComponent(trainid,personid);
    }

    @Override
    public void enterRemlocomotivecommand(RichRailParser.RemlocomotivecommandContext ctx) {
        super.enterRemlocomotivecommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String locoid = ctx.LocoID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
       Locomotive l = (Locomotive) t.RemoveComponentFromList(locoid);
       groep.AddComponent(l);
       this.trainservice.removeComponent(trainid,locoid);
    }

    @Override
    public void enterDelpersonwagoncommand(RichRailParser.DelpersonwagoncommandContext ctx) {
        super.enterDelpersonwagoncommand(ctx);
        String personWagonId = ctx.PersonID().getSymbol().getText();
        PersonWagon personWagon = (PersonWagon) groep.GetComponentById(personWagonId);
        groep.RemoveComponentFromList(personWagon);
        this.trainservice.deleteComponent(personWagonId);
    }

    @Override
    public void enterDelgoodswagoncommand(RichRailParser.DelgoodswagoncommandContext ctx) {
        super.enterDelgoodswagoncommand(ctx);
        String goodsid = ctx.GoodsID().getSymbol().getText();
        GoodsWagon g = (GoodsWagon) groep.GetComponentById(goodsid);
        groep.RemoveComponentFromList(g);
        this.trainservice.deleteComponent(goodsid);

    }

    @Override
    public void enterDellocomotivecommand(RichRailParser.DellocomotivecommandContext ctx) {
        super.enterDellocomotivecommand(ctx);
        String locomotiveId = ctx.LocoID().getSymbol().getText();
        Locomotive locomotive = (Locomotive) groep.GetComponentById(locomotiveId);
        groep.RemoveComponentFromList(locomotive);
        this.trainservice.deleteComponent(locomotiveId);
    }


}


