package View.Vacation;

import Controller.Controller;
import View.Main;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Optional;
import View.User.PasswordInputDialog;


public class DeleteController extends Controller {
    private Model model = new Model();

    @FXML
    TextField vacID;

    private void deleteForever(ActionEvent event) {
        String sVacID = vacID.getText();
        int iVacID = Integer.parseInt(sVacID);
        if (sVacID!=null) {
        model.deleteVacation(sVacID);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Vacation");
        alert.setHeaderText(null);
        alert.setContentText("Vacation Deleted Successfully");
        alert.showAndWait();
        try {
            super.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}
