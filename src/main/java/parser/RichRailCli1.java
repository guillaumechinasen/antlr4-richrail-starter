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
    }

    @Override
    public void enterNewlocomotivecommand(RichRailParser.NewlocomotivecommandContext ctx) {
        super.enterNewlocomotivecommand(ctx);
        String locoid = ctx.LocoID().getSymbol().getText();
        String fueltype = ctx.STRING().getSymbol().getText();

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
        groep.RemoveComponentFromList(g);
        System.out.println(t);
    }

    @Override
    public void enterRemgoodswagoncommand(RichRailParser.RemgoodswagoncommandContext ctx) {
        super.enterRemgoodswagoncommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String goodsid = ctx.GoodsID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
        GoodsWagon g = (GoodsWagon) t.RemoveComponentFromList(goodsid);
        groep.AddComponent(g);
        System.out.println("after remove\n"+t);
    }

    @Override
    public void enterRempersonwagoncommand(RichRailParser.RempersonwagoncommandContext ctx) {
        super.enterRempersonwagoncommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String personid = ctx.PersonID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
        PersonWagon p = (PersonWagon) groep.GetComponentById(personid);
        t.RemoveComponentFromList(personid);
    }

    @Override
    public void enterRemlocomotivecommand(RichRailParser.RemlocomotivecommandContext ctx) {
        super.enterRemlocomotivecommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        String locoid = ctx.LocoID().getSymbol().getText();
        Train t =trainGroep.getTrainById(trainid);
        Locomotive l = (Locomotive) groep.GetComponentById(locoid);
        t.RemoveComponentFromList(locoid);
    }

    @Override
    public void enterDelpersonwagoncommand(RichRailParser.DelpersonwagoncommandContext ctx) {
        super.enterDelpersonwagoncommand(ctx);
    }

    @Override
    public void enterDelgoodswagoncommand(RichRailParser.DelgoodswagoncommandContext ctx) {
        super.enterDelgoodswagoncommand(ctx);
        String goodsid = ctx.GoodsID().getSymbol().getText();
        GoodsWagon g = (GoodsWagon) groep.GetComponentById(goodsid);
        groep.RemoveComponentFromList(g);


    }

    @Override
    public void enterDellocomotivecommand(RichRailParser.DellocomotivecommandContext ctx) {
        super.enterDellocomotivecommand(ctx);
    }
}


