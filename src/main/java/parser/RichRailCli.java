package parser;

public class RichRailCli extends RichRailBaseListener {
    private Trainservice trainservice;
    public RichRailCli(Trainservice trainservice) {
        super();
        this.trainservice = trainservice;
    }

    @Override
    public void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
        super.enterNewtraincommand(ctx);
        String trainid = ctx.ID().getSymbol().getText();
        this.trainservice.createnewtrain(trainid);
    }

    @Override
    public void enterNewgoodswagoncommand(RichRailParser.NewgoodswagoncommandContext ctx) {
        super.enterNewgoodswagoncommand(ctx);
        String id = ctx.GoodsID().getSymbol().getText();
        //String gid = ctx.NUMBER().getSymbol().getText();
        //String cargo = ctx.STRING().getSymbol().getText();
        this.trainservice.createnewgoodswagon(id);
    }
}
