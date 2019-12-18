import domain.GoodsWagon;
import domain.Locomotive;
import domain.PersonWagon;
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
        Locomotive lc = new Locomotive("lc3","diesel");
        Train tr = new Train("tr5");
        PersonWagon p = new PersonWagon("papri",622);
        t.AddComponentToList(g);
        tr.AddComponentToList(lc);
        tr.AddComponentToList(p);
        LogTrainService l = new LogTrainService();
        try {
            l.addObjectToList(t);
            l.addObjectToList(tr);
            l.WriteJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}