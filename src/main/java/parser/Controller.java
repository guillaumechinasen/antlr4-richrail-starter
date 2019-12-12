package parser;

import domain.RichRailCli1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class Controller extends TrainServiceProvider{
    @FXML
    private TextField command;
    @FXML
    private ListView console;
    private ObservableList<String> logs = FXCollections.observableArrayList();
    private List<String> log = Printingtrainservice.log;

    public void testbtn(ActionEvent event){
        String cmd = command.getText();
        CharStream lineStream = CharStreams.fromString(cmd);

        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();
        Trainservice trainservice = new Printingtrainservice();
        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailListener listener = new RichRailCli1(trainservice);


        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);
        for(String i: log){
            System.out.println("before\n");
            logger();
            console.setItems(logs);
            logs.add(i);
            System.out.println("after\n");
            logger();
        }
        log.clear();




    }
    public void logger(){
        for (String i: log) {
            System.out.println("[ " +i+" ]");
        }
    }

}
