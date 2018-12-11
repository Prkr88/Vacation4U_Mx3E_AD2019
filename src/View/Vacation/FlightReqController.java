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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightReqController extends Controller implements Initializable{

    public static Controller myController;
    private Model model = new Model();

    @FXML private TableView<Request> requestTable;

    @FXML private TableColumn<Request,CheckBox> tb_choose;
    @FXML private TableColumn<Request,Integer> tb_id;
    @FXML private TableColumn<Request,String> tb_buyer;
    @FXML
    public Button aprove;
    @FXML
    public Button cancel;

    private static ObservableList<Request> rList = FXCollections.observableArrayList();
    public  Stage stage = new Stage();


    public void setRequestList(ArrayList<ArrayList<String>> requestList) {
        rList.clear();
        for (int i=0; i<requestList.size();i++){
            int iVacID = Integer.parseInt((requestList.get(i)).get(0));
            Request r = new Request(iVacID, (requestList.get(i)).get(1));
            rList.add(r);
        }

    }

    @Override
    public void initialize(URL url , ResourceBundle rs){
        //setFlightList();
        this.requestTable.setItems(rList);
        tb_choose.setCellValueFactory(new PropertyValueFactory<Request,CheckBox>("RDATA_check"));
        tb_id.setCellValueFactory(new PropertyValueFactory<Request,Integer>("RDATA_id"));
        tb_buyer.setCellValueFactory(new PropertyValueFactory<Request,String>("RDATA_buyer_Request"));

    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


    public void showTable() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/FlightRequests.fxml"));
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
        for (int i = 0; i <rList.size() && vId == -1 ; i++) {
            if(rList.get(i).isChecked()){
                vId = rList.get(i).getRDATA_id();
                Main.toAprove = rList.get(i);
            }
        }
        if(vId==-1){
            System.out.println("flight not selected");
        }
        else{
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Request Aproved");
            alert.setHeaderText(null);
            alert.setContentText("Request Aproved Successfuly!");
            alert.showAndWait();
            //Main.staticController.setScreen(Main.screenMainMenuID);
        }
    }

    @FXML
    private void closeTable(ActionEvent event){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();

    }


}
