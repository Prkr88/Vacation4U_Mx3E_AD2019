package View.Vacation;

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

public class CreateController extends Controller {

    public ScreensController myController;
    private Model model = new Model();

    @FXML
    private TextField TXTBX_adult_amount;
    @FXML
    private TextField TXTBX_child_amount;
    @FXML
    private TextField TXTBX_baby_amount;
    @FXML
    private TextField TXTBX_price;
    @FXML
    private TextField TXTBX_destination;
    @FXML
    private TextField TXTBX_airline_company;
    @FXML
    private TextField TXTBX_arrival_DD;
    @FXML
    private TextField TXTBX_arrival_MM;
    @FXML
    private TextField TXTBX_arrival_YYYY;
    @FXML
    private TextField TXTBX_departure_DD;
    @FXML
    private TextField TXTBX_departure_MM;
    @FXML
    private TextField TXTBX_departure_YYYY;
    @FXML
    private TextField TXTBX_luggage_details;
    @FXML
    private CheckBox CHKBX_lodging_included;
    @FXML
    private CheckBox CHKBX_return_flight_included;
    @FXML
    private ImageView beachImage;
    @FXML
    private ImageView hikingImage;
    @FXML
    private ImageView urbanImage;
    @FXML
    private Label selectedType;
    @FXML
    private ComboBox<String> comboType;


    @FXML
    private void createAction(ActionEvent event) {
        String strAdultAmount = TXTBX_adult_amount.getText();
        String strChildAmount = TXTBX_child_amount.getText();
        String strBabyAmount = TXTBX_baby_amount.getText();
        String strTotalPrice = TXTBX_price.getText();
        int iAdultAmount = Integer.parseInt(strAdultAmount);
        int iChildAmount = Integer.parseInt(strChildAmount);
        int iBabyAmount = Integer.parseInt(strBabyAmount);
        int iTotalPrice = Integer.parseInt(strTotalPrice);
        String strDepDD = TXTBX_departure_DD.getText();
        String strDepMM = TXTBX_departure_MM.getText();
        String strDepYYYY = TXTBX_departure_YYYY.getText();
        String strDepDate = strDepYYYY + "-" + strDepMM  + "-" + strDepDD;
        String strArriveDD = TXTBX_arrival_DD.getText();
        String strArriveMM = TXTBX_arrival_MM.getText();
        String strArriveYYYY = TXTBX_arrival_YYYY.getText();
        String strArrivalDate = strArriveYYYY + "-" + strArriveMM  + "-" + strArriveDD;
        String strDestination = TXTBX_destination.getText();
        String strAirline = TXTBX_airline_company.getText();
        Boolean boolLodge = CHKBX_lodging_included.isSelected();
        Boolean boolReturnFlight = CHKBX_return_flight_included.isSelected();
        String sLodge;
        String sReturn;
        if (boolLodge)
            sLodge = "yes";
        else
            sLodge = "no";
        if (boolReturnFlight)
            sReturn = "yes";
        else
            sReturn = "no";
        String strLuggageDetails = TXTBX_luggage_details.getText();
        comboType = new ComboBox<>();
        comboType.getItems().setAll("beach", "hiking", "urban");
        selectedType.textProperty().bind(comboType.getSelectionModel().selectedItemProperty());
        comboType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldType, String newType) {
                if (oldType != null) {
                    switch(oldType) {
                        case "beach": beachImage.setVisible(false); break;
                        case "hiking": hikingImage.setVisible(false); break;
                        case "urban": urbanImage.setVisible(false); break;
                    }
                }
                if (newType != null) {
                    switch(newType) {
                        case "beach": beachImage.setVisible(true); break;
                        case "hiking": hikingImage.setVisible(true); break;
                        case "urban": urbanImage.setVisible(true); break;
                    }
                }
            }
        });
        String strVacType = comboType.getValue();
        model.addVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, strVacType, sLodge, sReturn, strLuggageDetails);
        try {
            super.showMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}
