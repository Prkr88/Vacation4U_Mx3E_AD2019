package View.Vacation;

import Controller.Controller;
import Model.*;
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
import java.io.FileNotFoundException;
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

public class SwapVacationsController extends Controller implements Initializable{

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
    private TextField vac_id;
    @FXML
    public Button cancel;
    @FXML
    public Button swap_mine;

    private static ObservableList<Flight> fList = FXCollections.observableArrayList();
    public Stage stage = new Stage();
    //private ObservableList<Flight> fList = FXCollections.observableArrayList();

    public SwapVacationsController() {
        //SelectApp selectApp = new SelectApp();
        //ArrayList<ArrayList<String>> resultSetList = selectApp.selectSwapVacation();
        //FlightDetController fdc = new FlightDetController();
        //fdc.setFlightList(resultSetList);
        //fdc.showTable();
        //setFlightList(resultSetList);
        //showTable();
    }


    public void setFlightList(ArrayList<ArrayList<String>> flightsList) {
        this.fList.clear();
        for (int i=0; i<flightsList.size();i++) {
            int iVacID = Integer.parseInt((flightsList.get(i)).get(0));
            String swapperId = (flightsList.get(i).get(1));
            if (!swapperId.equals(Main.signedUserName)) {
                Flight f = new Flight(iVacID, (flightsList.get(i)).get(2), (flightsList.get(i)).get(3),
                        (flightsList.get(i)).get(10), Integer.parseInt((flightsList.get(i)).get(12)), (flightsList.get(i)).get(11), (flightsList.get(i)).get(7), (flightsList.get(i)).get(8), Integer.parseInt((flightsList.get(i)).get(4)), Integer.parseInt((flightsList.get(i)).get(5)), Integer.parseInt((flightsList.get(i)).get(6)), (flightsList.get(i)).get(1));
                this.fList.add(f);
            }
        }
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

        //if(Main.signedUserName == null) swap_mine.setDisable(true);

    }

    public void initSwapScreen() throws IOException {
        SelectApp selectApp = new SelectApp();
        ArrayList<ArrayList<String>> resultSetList = selectApp.selectSwapVacation();
        //FlightDetController fdc = new FlightDetController();
        //fdc.setFlightList(resultSetList);
        //fdc.showTable();
        setFlightList(resultSetList);
        //showTable();
    }

    public void showTable() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/View/Vacation/SwapVacationXML.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(fileInputStream);
        Scene scene = new Scene(root, 800, 450);
        this.stage.setTitle("New Window");
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    private void requestSwap(ActionEvent event){
        int iVacID_A = -1;
        String sUser_A = "";
        String sUser_B = Main.signedUserName;
        int iVacID_B = -1;
        try {
            String sVacID_B = vac_id.getText();
            iVacID_B = Integer.parseInt(sVacID_B);
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vacation ID Alert");
            alert.setHeaderText(null);
            alert.setContentText("Your Vacation ID is missing.");
            alert.showAndWait();
        }
        for (int i = 0; i <fList.size() && iVacID_A == -1 ; i++) {
            if(fList.get(i).isChecked()){
                iVacID_A = fList.get(i).getFDATA_id();
                sUser_A = fList.get(i).getFDATA_seller();
            }
        }
        if(iVacID_A==-1){
            System.out.println("flight not selected");
        }
        else{
            try {
                model.swapInsertRequest(iVacID_A, sUser_A, iVacID_B, sUser_B);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Swapping request was sent successfully!");
                alert.showAndWait();
                Stage stage = (Stage) swap_mine.getScene().getWindow();
                stage.close();
                super.myController.setScreen(Main.screenMainMenuID);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void displayVacations(ActionEvent event) throws IOException {
        ArrayList<ArrayList<String>> result = model.displayVacation();
        FlightDetController fdc = new FlightDetController();
        fdc.setFlightList(result, ViewMode.mine, "");
        fdc.showTable();
    }

    @FXML
    public void addMine(ActionEvent event) throws IOException {
        try {
            String sVacID = vac_id.getText();
            int iVacID = Integer.parseInt(sVacID);
            model.swapInsertVacation(iVacID);
            try {
                super.showMainMenu();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vacation ID Alert");
            alert.setHeaderText(null);
            alert.setContentText("Your Vacation ID is missing.");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }

    @FXML
    private void closeTable(ActionEvent event){
        Stage stage = (Stage) swap_mine.getScene().getWindow();
        stage.close();
    }

}
