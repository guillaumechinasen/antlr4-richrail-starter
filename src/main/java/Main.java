//import parser.RichRailCli1;
import domain.GoodsWagon;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import domain.Locomotive;
>>>>>>> Stashed changes
=======
import domain.Locomotive;
>>>>>>> Stashed changes
import domain.Train;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Train t = new Train("tr3");
        GoodsWagon g = new GoodsWagon("wg1","bol");
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        t.AddComponentToList(g);
        LogTrainService l = new LogTrainService();
        try {
            l.addObjectToList(t);
=======
=======
>>>>>>> Stashed changes
        Locomotive lc = new Locomotive("lc3","diesel");
        Train tr = new Train("tr5");
        t.AddComponentToList(g);
        tr.AddComponentToList(lc);
        LogTrainService l = new LogTrainService();
        try {
            l.addObjectToList(t);
            l.addObjectToList(tr);
            l.WriteJson();
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
