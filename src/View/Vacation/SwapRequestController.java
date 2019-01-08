package View.Vacation;

import Controller.Controller;
import Model.Model;
import Model.*;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SwapRequestController extends Controller {

    private Model model = new Model();

    @FXML
    private TextField choose_id;

    @FXML
    private void viewAction(ActionEvent event) throws IOException {
        SelectApp sa = new SelectApp();
        String[] res = sa.selectSwapRequestVacation();
        if (res != null) {
            String otherUserVac = res[2];
            SelectApp selectApp = new SelectApp();
            ArrayList<ArrayList<String>> resultSetList = selectApp.selectSwapRequests();
            FlightDetController fdc = new FlightDetController();
            fdc.setFlightList(resultSetList, ViewMode.specific, otherUserVac);
            fdc.showTable(false);
        }
    }


    @FXML
    private void confirmAction(ActionEvent event) {
        String strChosenID = choose_id.getText();
        if (strChosenID.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vacation ID Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please choose a vacation ID to swap with.");
            alert.showAndWait();
        }
        else {
            model.swapRequestUpdate();
            try {
                SelectApp sa = new SelectApp();
                String[] res = sa.selectSwapRequestVacation();
                String user_A = res[0];
                String vacID_A = res[1];
                String vacID_B = res[2];
                String user_B = res[3];
                int iVacID_A = Integer.parseInt(vacID_A);
                int iVacID_B = Integer.parseInt(vacID_B);
                model.deleteOfferedVacations(iVacID_A);
                model.deleteOfferedVacations(iVacID_B);
                DeleteApp da = new DeleteApp();
                da.deleteAfterSwap(iVacID_A, iVacID_B);
            } catch (Exception e) {
                int i;
            }
            super.myController.setScreen(Main.screenMainMenuID);
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}