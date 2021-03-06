package View.Vacation;

import Controller.Controller;
import View.Main;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import View.User.PasswordInputDialog;


public class DeleteController extends Controller {
    private Model model = new Model();

    @FXML
    TextField vacID;

    @FXML
    private void deleteAction(ActionEvent event) {
        String sVacID = vacID.getText();
        int iVacID = Integer.parseInt(sVacID);
        if (sVacID!=null) {
        model.deleteOfferedVacations(iVacID);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Vacation");
        alert.setHeaderText(null);
        alert.setContentText("Vacation Deleted Successfully");
        alert.showAndWait();
        super.myController.setScreen(Main.screenMainMenuID);
    } else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText(null);
        alert.setContentText("Vacation Deleted Canceled");
        alert.showAndWait();
        try {
            super.showMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

    @FXML
    public void displayVacations(ActionEvent event) throws IOException {
        ArrayList<ArrayList<String>> result = model.displayVacation();
        FlightDetController fdc = new FlightDetController();
        fdc.setFlightList(result, ViewMode.mine, "");
        fdc.showTable(false);
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}
