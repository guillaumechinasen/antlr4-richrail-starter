package parser;

import parser.RichRailCli1;
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

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Controller extends TrainServiceProvider{
    private String text;
    @FXML
    private TextField command;
    @FXML
    private TextField newTrainName;
    @FXML
    private TextField idDeleteWagon;
    @FXML
    private TextField idAddWagon;
    @FXML
    private ListView console;
    private ObservableList<String> logs = FXCollections.observableArrayList();
    private List<String> log1 = Printingtrainservice.log1;
    private boolean trainDoesNotExist;

    public boolean trainCheck(String trainId) throws FileNotFoundException {
        boolean train = true;
        //opening the file and writing the strings into the file.
        File file = new File("src/main/java/parser/test.txt");
        try {
            Scanner scanner = new Scanner(file);
            boolean trainDoesNotExists = true;
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (line.contains(trainId)) {
                    trainDoesNotExists = false;
                    System.out.println("Deze trein bestaat al!");
                    break;
                }
            }
        } catch (Exception e){
        } return train;
    }

    public boolean setText(String str) throws IOException{
        try {
            CharStream lineStream = CharStreams.fromString(str);

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
            return true;

        }catch (Exception e){
            return false;

        }

    }
    public void commandLine(ActionEvent event) throws IOException {
        String cmd = command.getText();
        if(setText(cmd)){
            for(String i: log1) {
                System.out.println("before");
                logger();
                console.setItems(logs);
                logs.add(i);
                System.out.println("after");
                logger();
            }
        }
        log1.clear();
    }


    public void logger(){
        for (String i: log1) {
            System.out.println("[ " +i+" ]");
        }
    }


    public void makeNewTrain(ActionEvent event) throws IOException {
        //getting text from the gui
        String name = newTrainName.getText();
        System.out.println(name);

        //opening the file and writing the strings into the file.
        File file = new File("src/main/java/parser/test.txt");
        try{
            Scanner scanner = new Scanner(file);
            boolean trainDoesNotExists = true;
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (line.contains(name)) {
                    trainDoesNotExists = false;
                    System.out.println("Deze trein bestaat al!");
                    break;
                }
            }
            if (trainDoesNotExists){
                FileWriter fw = new FileWriter(file, true);
                PrintWriter pw = new PrintWriter(fw);
                //TrainBuilder(trainId='tr1', components=[GoodsWagon(id='wg3', cargo='fruit')])
                this.text = "new train " + name;
                if (setText(this.text)) {
                    pw.write("\ntrainId='" + name + "',");
                    pw.flush();
                    pw.close();
                }
            }
        }catch(IOException e){
            System.out.println("error");
        }



    }
    public void deleteSelectedTrain(ActionEvent event){
        System.out.println("deleteSelectedTrain");
    }
    public void deleteSelectedWagon(ActionEvent event){
        System.out.println("deleteSelectedWagon");
    }
    public void addSelectedWagon(ActionEvent event){
        System.out.println("addSelectedWagon");
    }
    public void dropDownWagon(ActionEvent event){
        System.out.println("dropDownWagon");
    }
    public void dropDownTrain(ActionEvent event){
        System.out.println("dropDownTrain");
    }




}
