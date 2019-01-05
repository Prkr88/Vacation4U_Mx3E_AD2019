package View.Vacation;

import Controller.Controller;
import Model.Model;
import Model.UpdateApp;
import Model.DeleteApp;
import Model.SelectApp;
import Model.InsertApp;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import java.util.List;

public class FlightReqController extends Controller implements Initializable{

    public Controller loginController = Main.loginController;
    private Model model = new Model();

    @FXML private TableView<Request> requestTable;

    @FXML private TableColumn<Request,CheckBox> tb_choose;
    @FXML private TableColumn<Request,Integer> tb_id;
    @FXML private TableColumn<Request,String> tb_buyer;
    @FXML public Button approve ;
    @FXML public Button cancel ;

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

    @FXML
    public void showTable() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/FlightRequests.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(fileInputStream);
        Scene scene = new Scene(root, 800, 450);
        this.approve = (Button)fxmlLoader.getNamespace().get("approve");
        if(Main.approveMode == 0){
            this.stage.setTitle("Select Vacation to Approve");
            this.approve.setText("Approve Selected");
        }
        else{
            this.stage.setTitle("Approve Payment");
            this.approve.setText("Approve Payment");
        }
        this.stage.setScene(scene);
        this.stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                try {
                    stage.close();
                    loginController.checkVactionsUpdate();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    int vId = -1;

    DeleteApp deleteApp = new DeleteApp();


    @FXML
    private void checkOut(ActionEvent event){
        UpdateApp updateApp = new UpdateApp();
        DeleteApp deleteApp = new DeleteApp();
        SelectApp selectApp = new SelectApp();
        InsertApp insertApp = new InsertApp();
        int vId = -1;
        String buyerID = "";
        String sellerID = "";
        String flightDetails[];
        ArrayList<ArrayList<String>> flightData = new ArrayList<ArrayList<String>>();
        int price = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String date_s = dateFormat.format(date);
        for (int i = 0; i <rList.size() && vId == -1 ; i++) {
            if(rList.get(i).isChecked()){
                vId = rList.get(i).getRDATA_id();
                Main.toAprove = rList.get(i);
                buyerID = rList.get(i).getRDATA_buyer_Request();
                if(Main.approveMode == 0) {
                    updateApp.updateAproved(vId,buyerID);
                }
                else{
                    sellerID = Main.signedUserName;
                    flightData = selectApp.selectOfferedVacationById(vId);
                    price = Integer.parseInt(flightData.get(0).get(12));
                    insertApp.insertToSold(vId,buyerID,sellerID,date_s,price);
                    deleteApp.deleteVacationRequest(vId,buyerID);
                    updateApp.updateDeclinedRequest(vId);
                    deleteApp.deleteOfferedVacations(vId);
                }
            }
        }
        if(vId==-1){
            System.out.println("flight not selected");
        }
        else{
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            if(Main.approveMode == 0) {
                alert.setTitle("Request Aproved");
                alert.setContentText("Request Aproved Successfully!");
            }
            else{
                alert.setTitle("Congratulations!");
                alert.setContentText("Vacation Handling Complete!\n Thank you for Using EveryVacation(Tm)");
            }
            alert.showAndWait();
            //Main.staticController.setScreen(Main.screenMainMenuID);
        }
    }

    @FXML
    private void closeTable(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancel.getScene().getWindow();
        loginController.checkVactionsUpdate();
        stage.close();

    }


}
