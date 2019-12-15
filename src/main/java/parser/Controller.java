package parser;

import domain.Train;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    //ObservableList<String> exisitingTrainNames = FXCollections.observableArrayList(getTrainNames());
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
    private ListView console;
    private ArrayList<Train> trainList = new ArrayList<Train>();
    private Train selectedTrain;
    private ObservableList<String> logs = FXCollections.observableArrayList();
    private List<String> log = Printingtrainservice.logger33;
    private boolean trainDoesNotExist;
    public GraphicsContext gc = createTrainConfig();


    private GraphicsContext createTrainConfig() {
        Stage window = new Stage();
        Group root = new Group();
        Canvas canvas = new Canvas(600, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        window.setScene((new Scene(root)));
        window.toFront();
        window.show();

        return gc;
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
    public void commandLine(ActionEvent event) throws IOException {
        String cmd = command.getText();
        if(setText(cmd)){
            for(String i: log) {
                System.out.println("before");
                logger();
                console.setItems(logs);
                logs.add(i);
                System.out.println("after");
                logger();
            }
        }
        log.clear();
    }


    public void logger(){
        for (String i: log) {
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
   /* @FXML
    void selectTrain(ActionEvent event) {
        String trainName = dropDownTrain.getValue();
        for (Train train : trainList) {
            if (train.getName().equals(trainName)) {
                selectedTrain = train;
            }
        }
    }

    @FXML
    private void updateTrainList() {
        exisitingTrainNames = FXCollections.observableArrayList(getTrainNames());
        dropDownTrain.setItems(exisitingTrainNames);
    }

    public void deleteSelectedTrain(ActionEvent event){
        String name = dropDownTrain.getValue();
        System.out.println("deleteSelectedTrain");
        System.out.println(name);
    }


    public void deleteSelectedWagon(ActionEvent event){
        String name = dropDownWagon.getValue();
        System.out.println("deleteSelectedWagon");
        System.out.println(name);
    }

   *//* private void updateGUI() {
        gc.clearRect(0, 0, 600, 500);
        if (selectedTrain != null) {
            drawTrain(gc);
            ArrayList<Wagon> wagonList = selectedTrain.getWagons();
            int iteratorNumber = 0;
            for (Wagon wagon : wagonList) {
                drawWagon(gc, iteratorNumber);
                iteratorNumber++;
            }
        }
    }*//*

    private void drawWagon(GraphicsContext gc, int iteratorNumber) {
        int wagonOffset = iteratorNumber * 100;

        gc.fillRect(120 + wagonOffset, 80, 80, 40);
        gc.fillRoundRect(125 + wagonOffset, 120, 20, 20, 20, 20);
        gc.fillRoundRect(165 + wagonOffset, 120, 20, 20, 20, 20);

    }

    private void drawTrain(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(30, 80, 80, 40);
        gc.fillRect(80, 60, 30, 30);
        gc.setStroke(Color.BLACK);
        gc.fillRoundRect(35, 120, 20, 20, 20, 20);
        gc.fillRoundRect(80, 120, 20, 20, 20, 20);
    }

    private ArrayList<String> getTrainNames() {
        ArrayList<String> trainNameList = new ArrayList<String>();
        for (Train train : trainList) {
            trainNameList.add(train.getName());
        }
        return trainNameList;
    }
    public void addSelectedWagon(ActionEvent event){
        System.out.println("addSelectedWagon");
    }
    //public void dropDownWagon(ActionEvent event){System.out.println("dropDownWagon");}
    //public void dropDownTrain(ActionEvent event){System.out.println("dropDownTrain");}
    @FXML
    void deleteTrain(ActionEvent event) {
        deleteTrain();
        updateTrainList();
        updateGUI();
    }

    private void deleteTrain() {
        trainList.remove(selectedTrain);
        selectedTrain = null;
        updateGUI();
    }*/




}
