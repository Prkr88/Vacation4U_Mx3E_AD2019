package View.Vacation;

import Controller.Controller;
import Model.DeleteApp;
import Model.InsertApp;
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
import Controller.ControlledScreen;
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
import java.util.Date;
import java.text.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDetController extends Controller implements Initializable{

    public static Controller myController;
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
    @FXML
    public Button buynow;
    @FXML
    public Button cancel;

    private static ObservableList<Flight> fList = FXCollections.observableArrayList();
    public  Stage stage = new Stage();

    public void setFlightList(ArrayList<ArrayList<String>> flightsList) {
        fList.clear();
        for (int i=0; i<flightsList.size();i++){
            int iVacID = Integer.parseInt((flightsList.get(i)).get(0));
            String sellerId = (flightsList.get(i)).get(1);
            if (!sellerId.equals(Main.signedUserName)) {
                Flight f = new Flight(iVacID, (flightsList.get(i)).get(2), (flightsList.get(i)).get(3),
                        (flightsList.get(i)).get(10), Integer.parseInt((flightsList.get(i)).get(12)), (flightsList.get(i)).get(11), (flightsList.get(i)).get(7), (flightsList.get(i)).get(8), Integer.parseInt((flightsList.get(i)).get(4)), Integer.parseInt((flightsList.get(i)).get(5)), Integer.parseInt((flightsList.get(i)).get(6)), (flightsList.get(i)).get(1));
                fList.add(f);
            }
        }

        /*
        Flight f1 = new Flight(1, "03-01",
                "06-01","AZA",
                100,"yes","AIR_Z",
                "pleasure",1,0,0,"Greg");

        this.fList.add(f1);
        */
        //this.fList.add(f2);
    }

    @Override
    public void initialize(URL url , ResourceBundle rs){
        //setFlightList();
        this.flightTable.setItems(fList);
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
        if(Main.signedUserName == null){
            buynow.setDisable(true);
        }

    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


    public void showTable() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/FlightDetails.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(fileInputStream);
        Scene scene = new Scene(root, 800, 450);
        this.stage.setTitle("New Window");
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    private void checkOut(ActionEvent event){
        int vId = -1;
        InsertApp insertApp = new InsertApp();
        DeleteApp deleteApp = new DeleteApp();
        String sellrID = "";
        String buyerID = Main.signedUserName;
        int price = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String date_s = dateFormat.format(date);
        for (int i = 0; i <fList.size() && vId == -1 ; i++) {
            if(fList.get(i).isChecked()){
                vId = fList.get(i).getFDATA_id();
                Main.toBuy = fList.get(i);
                sellrID = fList.get(i).getFDATA_seller();
                price = fList.get(i).getFDATA_cost();
                insertApp.insertVacationRequest(vId,buyerID,sellrID);
                //deleteApp.deleteOfferedVacations(vId);
            }
        }
        if(vId==-1){
            System.out.println("flight not selected");
        }
        else{
            Stage stage = (Stage) buynow.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Request Sent");
            alert.setHeaderText(null);
            alert.setContentText("Order Request Sent Successfuly!");
            alert.showAndWait();
            Main.staticController.setScreen(Main.screenMainMenuID);
        }
    }

    @FXML
    private void closeTable(ActionEvent event){
        Stage stage = (Stage) buynow.getScene().getWindow();
        stage.close();
    }

}
