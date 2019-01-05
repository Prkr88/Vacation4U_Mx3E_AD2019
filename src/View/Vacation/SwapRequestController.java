package View.Vacation;

import Controller.Controller;
import Model.Model;
import Model.*;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;

public class SwapRequestController extends Controller {

    private Model model = new Model();


    @FXML
    private void viewAction(ActionEvent event) throws IOException {
        SelectApp sa = new SelectApp();
        String[] res = sa.selectSwapRequestVacation();
        if (res[0] != null && res[1] != null) {
            String otherUserVac = res[0];
            String otherUserID = res[1];
            SelectApp selectApp = new SelectApp();
            ArrayList<ArrayList<String>> resultSetList = selectApp.selectSwapRequests();
            FlightDetController fdc = new FlightDetController();
            fdc.setFlightList(resultSetList, ViewMode.specific, otherUserVac);
            fdc.showTable();
        }
    }


    @FXML
    private void confirmAction(ActionEvent event) {
        model.swapRequestUpdate();
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}