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
    @FXML private TableColumn<Flight,Integer> tb_id;
    @FXML private TableColumn<Flight,String> tb_f_departure;
    @FXML private TableColumn<Flight,String> tb_f_return;
    @FXML private TableColumn<Flight,String> tb_destination;
    @FXML private TableColumn<Flight,Integer> tb_cost;

    private ObservableList<Flight> fList = FXCollections.observableArrayList();

    private void getFlightList() {

        Flight f1 = new Flight(1, "03-01", "06-01","AZA", "100");
        Flight f2 = new Flight(2, "03-01", "06-01","Lebanon", "100");
        this.fList.add(f1);
        this.fList.add(f2);
    }

    @Override
    public void initialize(URL url , ResourceBundle rs){
        getFlightList();
        this.flightTable.setItems(this.fList);
        tb_choose.setCellValueFactory(new PropertyValueFactory<Flight,CheckBox>("FDATA_check"));
        tb_id.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_id"));
        tb_f_departure.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_f_departure"));
        tb_f_return.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_f_return"));
        tb_destination.setCellValueFactory(new PropertyValueFactory<Flight,String>("FDATA_destination"));
        tb_cost.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("FDATA_cost"));
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


    public void showTable(Stage secondaryStage) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/FlightDetails.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(fileInputStream);
        Scene scene = new Scene(root, 800, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();

    }


}
