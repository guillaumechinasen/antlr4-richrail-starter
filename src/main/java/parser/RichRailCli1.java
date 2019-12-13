package parser;

import domain.*;
import parser.RichRailBaseListener;
import parser.RichRailParser;
import parser.Trainservice;


public class RichRailCli1 extends RichRailBaseListener {
    private Trainservice trainservice;
    private TrainBuilderInterface train = new TrainBuilder();
    private ComponentGroep groep = ComponentGroep.getInstance();

    public RichRailCli1(Trainservice trainservice) {
        super();
        this.trainservice = trainservice;
    }

    @Override
    public void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
        super.enterNewtraincommand(ctx);
        String trainid = ctx.TrainID().getSymbol().getText();
        train.setTrainId(trainid);
        train.build();
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
        System.out.println("this object: "+g);
        TrainBuilderInterface trainBuilder = new TrainBuilder();
        trainBuilder.setTrainId("tr1");
        trainBuilder.addComponent(g);
        trainBuilder.build();
        System.out.println(trainBuilder);

    }
}


