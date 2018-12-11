package View;

import Controller.Controller;
import Model.SelectApp;
import View.Main;
import View.Vacation.FlightDetController;
import View.Vacation.FlightReqController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuController extends Controller {

    @FXML
    /* function listens for opening the Search Form */
    private void readUserData(ActionEvent event){
        super.myController.setScreen(View.Main.screenReadDataID);
    }

    @FXML
    /* function listens for opening the Update Form */
    private void updateUserData(ActionEvent event){
        super.myController.setScreen(Main.screenUpdateDataID);
    }

    @FXML
    /* function listens for opening the Deletion Form */
    private void deleteUser(ActionEvent event){
        super.myController.setScreen(Main.screenDeleteUserID);
    }

    @FXML
    private void createVacation(ActionEvent event){
        super.myController.setScreen(Main.screenCreateVacationID);
    }

    @FXML
    private void readVacation(ActionEvent event){
        super.myController.setScreen(Main.screenReadVacationID);
    }

    @FXML
    private void updateVacation(ActionEvent event){
        super.myController.setScreen(Main.screenUpdateVacationID);
    }

    @FXML
    private void deleteVacation(ActionEvent event){
        super.myController.setScreen(Main.screenDeleteVacationID);
    }

    @FXML
    private void logOut(ActionEvent event){
        super.myController.setScreen(Main.screenLoginID);
    }

    @FXML
    private void pay(ActionEvent event){
        super.myController.setScreen(Main.screenPaymentMethodID);
    }

    @FXML
    private void SearchVacation (ActionEvent event) {super.myController.setScreen(Main.screenFindVacationID);}

    @FXML
    public void getRequests(ActionEvent event) throws IOException {
        ArrayList<ArrayList<String>> resultSetList = null;
        SelectApp selectApp = new SelectApp();
        resultSetList = selectApp.selectVacationRequest(Main.signedUserName);
        FlightReqController fdc = new FlightReqController();
        fdc.setRequestList(resultSetList);
        fdc.showTable();
    }
}
