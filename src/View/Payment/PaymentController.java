package View.Payment;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentController extends Controller {

    public ScreensController myController;
    private Model model = new Model();

    @FXML
    private Button logInPayPal;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField nameOnCard;
    @FXML
    private TextField cardNum;
    @FXML
    private TextField expireDate;
    @FXML
    private TextField cvc;
    @FXML
    private Button payVisa;


    public int payPal(ActionEvent event) {
        if(email.getText().equals("") || password.getText().equals(""))
            return 0;
        commitPayment();
        return 1;
    }

    public int visa(ActionEvent event) {
        if(nameOnCard.getText().equals("") || cardNum.getText().equals("") ||
                expireDate.getText().equals("") || cvc.getText().equals("")) {
            return 0;
        }
        commitPayment();
        return 1;
    }

    private void commitPayment() {
        DeleteApp deleteApp = new DeleteApp();
        deleteApp.deleteOfferedVacations(Main.toBuy.getFDATA_id());
        deleteApp.deleteVacationRequest(Main.toBuy.getFDATA_id(), Main.signedUserName);
        InsertApp insertApp = new InsertApp();
        insertApp.addSoldVacation(Main.toBuy.getFDATA_id(),Main.signedUserName, Main.toBuy.getFDATA_seller(),
                Main.toBuy.getFDATA_cost());
    }
    @FXML
    private void payWithPayPal(ActionEvent event) {
        super.myController.setScreen(Main.screenPaypalID);
    }

    @FXML
    private void payWithVisa(ActionEvent event) {
        super.myController.setScreen(Main.screenVisaID);
    }


}
