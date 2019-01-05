package View.Vacation;

import Controller.Controller;
import Model.Model;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import Controller.Controller;
import View.Main;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Optional;
import View.User.PasswordInputDialog;
import java.io.IOException;

public class SwapRequestController extends Controller {

    private Model model = new Model();


    @FXML
    private void confirmAction(ActionEvent event) {
        model.swapRequestUpdate();
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}