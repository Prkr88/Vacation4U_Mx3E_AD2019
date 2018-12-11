package View.Vacation;

import Controller.Controller;
import Model.Model;
import View.Main;
import View.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.scene.control.CheckBox;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDetController extends Controller implements Initializable{

    public ScreensController myController;
    private Model model = new Model();

    @FXML private TableView<Flight> flightTable;

    @FXML private TableColumn<Flight,CheckBox> tb_choose;
    //@FXML private TableColumn<Flight,Integer> tb_id;
    @FXML private TableColumn<Flight,String> tb_f_departure;
    @FXML private TableColumn<Flight,String> tb_f_return;
    @FXML private TableColumn<Flight,String> tb_destination;
    @FXML private TableColumn<Flight,Integer> tb_cost;
    @FXML private TableColumn<Flight,Integer> tb_A;
    @FXML private TableColumn<Flight,Integer> tb_K;
    @FXML private TableColumn<Flight,Integer> tb_B;
    @FXML private TableColumn<Flight,String> tb_back;
    @FXML private TableColumn<Flight,String> tb_type;
    @FXML private TableColumn<Flight,String> tb_f_company;
    @FXML private TableColumn<Flight,String> tb_seller;

    private ObservableList<Flight> fList = FXCollections.observableArrayList();

    private void setFlightList(ArrayList<ArrayList<String>> flightsList) {

        Flight f1 = new Flight(1, "03-01",
                "06-01","AZA",
                100,"yes","AIR_Z",
                "pleasure",1,0,0,"Greg");

        this.fList.add(f1);
        //this.fList.add(f2);
    }

    @Override
    public void initialize(URL url , ResourceBundle rs){
        //setFlightList();
        this.flightTable.setItems(this.fList);
        tb_choose.setCellValueFactory(new PropertyValueFactory<Flight,CheckBox>("FDATA_check"));
        //tb_id.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_id"));
        tb_f_departure.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_f_departure"));
        tb_f_return.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_f_return"));
        tb_destination.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_destination"));
        tb_cost.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_cost"));
        tb_A.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_A"));
        tb_K.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_K"));
        tb_B.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_B"));
        tb_back.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_back"));
        tb_type.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_vacType"));
        tb_f_company.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_company"));
        tb_seller.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_seller"));

    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


    public void showTable(Stage secondaryStage) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/FlightDetails_1.1.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(fileInputStream);
        Scene scene = new Scene(root, 800, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();

    }


}
