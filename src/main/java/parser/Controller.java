package parser;

import domain.Component;
import domain.Train;
import domain.TrainGroep;
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
import java.lang.reflect.Array;
import java.util.*;

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
    private TextField idWagon;
    @FXML
    private TextField typo;
    @FXML
    private ListView console;
    @FXML
    private ListView output;
    private ObservableList<String> logs = FXCollections.observableArrayList();
    private ObservableList<String> outputlogs = FXCollections.observableArrayList();
    private List<Train> trainArrayList =  TrainGroep.getInstance().getTrainList();
    private LogTrainService logTrainService = LogTrainService.getInstance();
    private List<String> outlog = new ArrayList<>();
    private List<String> log  = LogTrainService.Logger;



    public GraphicsContext gc = createTrainConfig();
    ObservableList<String> trainNames1 = FXCollections.observableArrayList(getTrainNames());
    private ArrayList<Train> listOfExistingTrains = new ArrayList<Train>();
    private String selectedTrain;
    private String selectedType;
    private ArrayList<String> trainList = new ArrayList<String>();
    HashMap<String, String> componentType = new HashMap<String, String>();
    ObservableList<String> trainNames2 = FXCollections.observableArrayList(getTrainNames());
    private char components;


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

    private void drawTrain(GraphicsContext gc, String name) {
        gc.clearRect(0, 0, 900, 600);
        gc.setFill(Color.GREEN);
        gc.fillRect(30, 80, 80, 40);
        gc.fillRect(80, 60, 30, 30);
        gc.setStroke(Color.GREEN);
        gc.fillRoundRect(35, 120, 20, 20, 20, 20);
        gc.fillRoundRect(80, 120, 20, 20, 20, 20);
        gc.setFill(Color.WHITE);
        gc.fillText(name, 70, 100);
    }

    public boolean setText(String str) throws IOException{
        String name = newTrainName.getText();

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
            trainList.add(name);
            drawTrain(gc, name);
            updateTrainList();

            return true;

        }catch (Exception e){
            return false;

        }

    }

    private void updateTrainList() {
        trainNames1 = FXCollections.observableArrayList(trainList);
        dropDownTrain.setItems(trainNames1);
    }

    public void Save(ActionEvent event){
        try {
            logTrainService.WriteJson();
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
        String selectedTrainName = dropDownTrain.getValue();

        ArrayList<String> cake = new ArrayList<String>();
        cake.add("Locomotive");
        cake.add("GoodsWagon");
        cake.add("PersonsWagon");
        trainNames2 = FXCollections.observableArrayList(cake);
        dropDownWagon.setItems(trainNames2);

        for (String train : trainList){
            if (train.equals(selectedTrainName)) {
                selectedTrain = train;
                GUI(selectedTrain);
            }
        }
    }

    private void drawWagon(GraphicsContext gc, String componentsk, int iteratorNumber) {
        int wagonOffset = iteratorNumber * 100;
        this.components = componentsk.charAt(0);
        if (components == 'L'){
            gc.setFill(Color.GREEN);
        } else if (components == 'G'){
            gc.setFill(Color.RED);
        } else if (components == 'P'){
            gc.setFill(Color.BLUE);

        }
        gc.fillRect(120 + wagonOffset, 80, 80, 40);
        gc.fillRoundRect(125 + wagonOffset, 120, 20, 20, 20, 20);
        gc.fillRoundRect(165 + wagonOffset, 120, 20, 20, 20, 20);

    }



    @FXML
    void createBtn(ActionEvent event) {
        System.out.println("create btn");
    }

    public void deleteSelectedTrain(ActionEvent event){
        deleteTrain();
        updateTrainList();
        System.out.println("deleteSelectedTrain");
    }

    private void deleteTrain() {
        trainList.remove(selectedTrain);
        selectedTrain = null;
        GUI(null);
    }

    public void deleteSelectedWagon(ActionEvent event){
        System.out.println("deleteSelectedWagon");
    }
    public void addSelectedWagon(ActionEvent event){
        if(selectedTrain != null) {
            selectedType = dropDownWagon.getValue();
            String shortSelectedType = "";
            if (selectedType == "Locomotive") {
                shortSelectedType = "L";
            } else if (selectedType == "GoodsWagon") {
                shortSelectedType = "G";
            } else {
                shortSelectedType = "P";
            }
            String id = idWagon.getText();
            String type = typo.getText();
            componentType.put(shortSelectedType + "" + id, type);
            System.out.println(componentType);
            GUI(selectedTrain);
        } else{
            System.out.println("Geen trein geselecteerd.");
        }
    }

    private ArrayList<String> getTrainNames() {
        ArrayList<String> trainName = new ArrayList<>();
        trainName.add(String.valueOf(trainList));
        //json read.
        return trainName;
    }

    private void GUI(String name){
        gc.clearRect(0,0,900,600);
        if (selectedTrain != null) {
            drawTrain(gc, name);
            int iteratorNumber = 0;
            for (Map.Entry me : componentType.entrySet()) {
                String compie = (String) me.getKey();
                System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
                iteratorNumber++;
                drawWagon(gc, compie, iteratorNumber);
            }



            //ArrayList<Component> componentTypes = selectedTrain.getComponentType();
                /*int componentIterator = 0;
                for (Map.Entry me : componentType.entrySet()){
                    drawWagon(gc, componentType, componentIterator);
                    componentIterator++;
                }*/
            }
        }
    }

/*

    names = FXCollections.observableArrayList(getTrainNames());
        dropDownTrain.setItems((ObservableList<String>) trainNames);
*/


