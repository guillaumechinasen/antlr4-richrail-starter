package parser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import domain.RichRailCli1;
import parser.RichRailLexer;
import parser.RichRailListener;
import parser.RichRailParser;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;

public class JavaFXTest extends Application {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Richrail GUI");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label namelabel = new Label("Command");
        GridPane.setConstraints(namelabel, 0,0);

        TextField name = new TextField();
        GridPane.setConstraints(name, 1,0);

        Button btn2 = new Button();
        GridPane.setConstraints(btn2, 0,1);
        btn2.setText("execute");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String cmd = name.getText();
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
            }
        }	);



        grid.getChildren().addAll(namelabel,name,btn2);

        Scene scene = new Scene(grid,320,400);


        window.setScene(scene);
        window.show();
    }}