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
    private TextField TXTBX_adult_price;
    @FXML
    private TextField TXTBX_child_price;
    @FXML
    private TextField TXTBX_baby_price;
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
        String strAdultPrice = TXTBX_adult_price.getText();
        String strChildPrice = TXTBX_child_price.getText();
        String strBabyPrice = TXTBX_baby_price.getText();
        int intAdultAmount = Integer.parseInt(strAdultAmount);
        int intChildAmount = Integer.parseInt(strChildAmount);
        int intBabyAmount = Integer.parseInt(strBabyAmount);
        int intAdultPrice = Integer.parseInt(strAdultPrice);
        int intChildPrice = Integer.parseInt(strChildPrice);
        int intBabyPrice = Integer.parseInt(strBabyPrice);
        int intTotalAmount = intAdultAmount+intChildAmount+intBabyAmount;
        int intTotalPrice = intAdultPrice+intChildPrice+intBabyPrice;
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
        String strLuggageDetails = TXTBX_luggage_details.getText();
        //List<String> newItems = new ArrayList<>();
        //newItems.add("beach");
        //newItems.add("hiking");
        //newItems.add("urban");
        //comboType.setItems(newItems);
        //comboType.getItems().setAll(newItems);
        //comboType.getItems().addAll("beach", "hiking", "urban");
        //comboType.setItems("Beach", "Hiking", "Urban");
        //comboType.getItems().setAll("beach", "hiking", "urban");
        comboType.getItems().addAll("beach", "hiking", "urban");
        selectedType.textProperty().bind(comboType.getSelectionModel().selectedItemProperty());
        comboType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldType, String newType) {
                if (oldType != null) {
                    switch(oldType) {
                        case "beach": beachImage.setVisible(true); break;
                        case "hiking": hikingImage.setVisible(true); break;
                        case "urban": urbanImage.setVisible(true); break;
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
        //model.registerVacationToDB(intTotalAmount, intTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, boolLodge, boolReturnFlight, strLuggageDetails);
        try {
            super.showMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(View.Main.screenLoginID);
    }


}