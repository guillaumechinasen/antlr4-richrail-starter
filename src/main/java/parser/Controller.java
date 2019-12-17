package parser;

import domain.Train;
import domain.TrainGroep;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller extends TrainServiceProvider{
    ObservableList<String> names = FXCollections.observableArrayList(getTrainNames());
    private String text;
    @FXML
    private TextField command;
    @FXML
    private TextField newTrainName;
    @FXML
    private ChoiceBox<String> dropDownTrain;
    @FXML
    private ChoiceBox<String> dropDownWagon;
    @FXML
    private TextField idDeleteWagon;
    @FXML
    private TextField idAddWagon;
    @FXML
    private ListView console;
    @FXML
    private ListView output;
    private ObservableList<String> logs = FXCollections.observableArrayList();
    private ObservableList<String> outputlogs = FXCollections.observableArrayList();
    private List<Train> trainArrayList =  TrainGroep.getInstance().getTrainList();
    private List<String> outlog = new ArrayList<>();
    private List<String> log  = LogTrainService.Logger;
    private boolean trainDoesNotExist;
    //public GraphicsContext gc = createTrainConfig();


    private GraphicsContext createTrainConfig() {
        Stage window = new Stage();
        Group root = new Group();
        Canvas canvas = new Canvas(900, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        window.setScene((new Scene(root)));
        window.toFront();
        window.show();

        return gc;
    }

    private void drawTrain(GraphicsContext gc) {
        gc.clearRect(0, 0, 900, 600);
        gc.setFill(Color.BLACK);
        gc.fillRect(30, 80, 80, 40);
        gc.fillRect(80, 60, 30, 30);
        gc.setStroke(Color.BLACK);
        gc.fillRoundRect(35, 120, 20, 20, 20, 20);
        gc.fillRoundRect(80, 120, 20, 20, 20, 20);
    }

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
            // Create Pars eTreeWalker and Custom Listener
            ParseTreeWalker walker = new ParseTreeWalker();
            RichRailListener listener = new RichRailCli1(trainservice);


            // Walk over ParseTree using Custom Listener that listens to enter/exit events
            walker.walk(listener, tree);
            return true;

        }catch (Exception e){
            return false;

        }

    }
    public void save(ActionEvent event){
        LogTrainService l = new LogTrainService();
        try {
            l.WriteJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void commandLine(ActionEvent event) throws IOException {
        String cmd = command.getText();
        if(setText(cmd)){
            for(String i: log) {
                console.setItems(logs);
                logs.add(i);
            }
        }
        log.clear();
        setoutputlogs();
    }

    public void setoutputlogs(){
        outputlogs.clear();
        for(Train t: trainArrayList){
            String o = t.toString();
            outlog.add(o);
            for(String i: outlog){
                output.setItems(outputlogs);
                outputlogs.add(i);

            }
            outlog.clear();
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

    @FXML
    void selectTrain(ActionEvent event) {
        System.out.println("selectTrain");
        /*String trainName = dropDownTrain.getValue();
        for (Train train : trainList) {
            if (train.getName().equals(trainName)) {
                selectedTrain = train;
            }
        }*/
    }

    @FXML
    void selectType(ActionEvent event) {
        System.out.println("selectType");
        /*String trainName = dropDownTrain.getValue();
        for (Train train : trainList) {
            if (train.getName().equals(trainName)) {
                selectedTrain = train;
            }
        }*/
    }

    @FXML
    void createBtn(ActionEvent event) {
        System.out.println("create btn");
        /*String trainName = dropDownTrain.getValue();
        for (Train train : trainList) {
            if (train.getName().equals(trainName)) {
                selectedTrain = train;
            }
        }*/
    }

    private void drawWagon(GraphicsContext gc, int iteratorNumber) {
        int wagonOffset = iteratorNumber * 100;

        gc.fillRect(120 + wagonOffset, 80, 80, 40);
        gc.fillRoundRect(125 + wagonOffset, 120, 20, 20, 20, 20);
        gc.fillRoundRect(165 + wagonOffset, 120, 20, 20, 20, 20);

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
    public void dropDownWagon(ActionEvent event){System.out.println("dropDownWagon");}
    public void dropDownTrain(ActionEvent event){
        names = FXCollections.observableArrayList(getTrainNames());
        dropDownTrain.setItems(names);
        System.out.println("dropDownTrain");
    }
    private ArrayList<String> getTrainNames() {
        ArrayList<String> trainNames = new ArrayList<String>();
        //json read.
        return trainNames;
    }




}
