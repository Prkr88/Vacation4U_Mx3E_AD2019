package View.Payment;

import Controller.Controller;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private void payWithPayPal(ActionEvent event) {
        super.myController.setScreen(Main.screenPaypalID);
    }

    @FXML
    private void payWithVisa(ActionEvent event) {
        super.myController.setScreen(Main.screenVisaID);
    }


}
