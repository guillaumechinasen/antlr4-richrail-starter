package parser;

import parser.RichRailBaseListener;
import parser.RichRailParser;
import parser.Trainservice;


/*
public class RichRailCli1 extends RichRailBaseListener {
    private Trainservice trainservice;
    private TrainBuilderInterface train = new TrainBuilder();
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
        RollingComponentFactory f = new RollingComponentFactory("Goodswagon");
        f.setId(goodsid);
        f.setCargo(cargo);
        f.createRollingcomponent();
        this.trainservice.createnewgoodswagon(goodsid);
    }

    @Override
    public void enterNewpersonwagoncommand(RichRailParser.NewpersonwagoncommandContext ctx) {
        super.enterNewpersonwagoncommand(ctx);
        String personid = ctx.PersonID().getSymbol().getText();
        int seats = Integer.parseInt(ctx.NUMBER().getSymbol().getText());
        RollingComponentFactory f = new RollingComponentFactory("Personwagon");
        f.setId(personid);
        f.setSeats(seats);
        f.createRollingcomponent();
    }

    @Override
    public void enterNewlocomotivecommand(RichRailParser.NewlocomotivecommandContext ctx) {
        super.enterNewlocomotivecommand(ctx);
        String locoid = ctx.LocoID().getSymbol().getText();
        String fueltype = ctx.STRING().getSymbol().getText();
        System.out.println(locoid+" "+fueltype);
        RollingComponentFactory f= new RollingComponentFactory("Locomotive");
        this.trainservice.createnewlocomotive(locoid);
        f.setId(locoid);
        f.setFueltype(fueltype);
        f.createRollingcomponent();

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
    }
*/
