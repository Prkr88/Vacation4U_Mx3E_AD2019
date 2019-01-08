package View.Vacation;

import Controller.Controller;
import Model.Model;
import View.Main;
import View.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CreateController extends Controller implements Initializable {

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
    private ComboBox<String> comboType = new ComboBox<>();

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert beachImage != null : "fx:id=\"beachImage\" was not injected: check your FXML file";
        assert comboType != null : "fx:id=\"comboType\" was not injected: check your FXML file";
        assert hikingImage != null : "fx:id=\"hikingImage\" was not injected: check your FXML file";
        assert urbanImage != null : "fx:id=\"urbanImage\" was not injected: check your FXML file";
        assert selectedType != null : "fx:id=\"selectedType\" was not injected: check your FXML file";
        comboType.getItems().setAll("other","beach", "hiking", "urban");
        selectedType.textProperty().bind(comboType.getSelectionModel().selectedItemProperty());
        comboType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldType, String newType) {
                if (oldType != null) {
                    switch (oldType) {
                        case "beach":
                            beachImage.setVisible(false);
                            break;
                        case "hiking":
                            hikingImage.setVisible(false);
                            break;
                        case "urban":
                            urbanImage.setVisible(false);
                            break;
                    }
                }
                if (newType != null) {
                    switch (newType) {
                        case "beach":
                            beachImage.setVisible(true);
                            break;
                        case "hiking":
                            hikingImage.setVisible(true);
                            break;
                        case "urban":
                            urbanImage.setVisible(true);
                            break;
                    }
                }
            }
        });
    }

    @FXML
    private void createAction(ActionEvent event) {
        try {
            String strAdultAmount = TXTBX_adult_amount.getText();
            String strChildAmount = TXTBX_child_amount.getText();
            String strBabyAmount = TXTBX_baby_amount.getText();
            String strTotalPrice = TXTBX_price.getText();
            int iAdultAmount = 0, iChildAmount = 0, iBabyAmount = 0, iTotalPrice = 0;
            try {
                iAdultAmount = Integer.parseInt(strAdultAmount);
            } catch (Exception e) {
                iAdultAmount = 0;
            }
            try {
                iChildAmount = Integer.parseInt(strChildAmount);
            } catch (Exception e) {
                iChildAmount = 0;
            }
            try {
                iBabyAmount = Integer.parseInt(strBabyAmount);
            } catch (Exception e) {
                iBabyAmount = 0;
            }
            try {
                iTotalPrice = Integer.parseInt(strTotalPrice);
            } catch (Exception e) {
                iTotalPrice = 0;
            }
            String strDepDD = TXTBX_departure_DD.getText();
            String strDepMM = TXTBX_departure_MM.getText();
            String strDepYYYY = TXTBX_departure_YYYY.getText();
            String strDepDate = strDepYYYY + "-" + strDepMM + "-" + strDepDD;
            String strArriveDD = TXTBX_arrival_DD.getText();
            String strArriveMM = TXTBX_arrival_MM.getText();
            String strArriveYYYY = TXTBX_arrival_YYYY.getText();
            String strArrivalDate = strArriveYYYY + "-" + strArriveMM + "-" + strArriveDD;
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
            String strVacType = "";
            try { strVacType = comboType.getValue(); } catch (Exception e) { strVacType = "other"; }
            if (strVacType == null)
                 strVacType = "other";
            if (strVacType.equals(""))
                strVacType = "other";
            String strLuggageDetails = TXTBX_luggage_details.getText();
            if ((iAdultAmount == 0 && iChildAmount == 0 && iBabyAmount == 0) || iTotalPrice == 0 || strDepDD.equals("") || strDepMM.equals("") || strDepYYYY.equals("")
                    || strArriveDD.equals("") || strArriveMM.equals("") || strArriveYYYY.equals("") || strAirline.equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill obligated fields marked red.");
                alert.showAndWait();
            } else {
                int opp = 0;
                opp = model.addVacation(iAdultAmount, iChildAmount, iBabyAmount, iTotalPrice, strDestination, strAirline, strDepDate, strArrivalDate, strVacType, sLodge, sReturn, strLuggageDetails);
                try {
                    this.TXTBX_adult_amount.clear();
                    this.TXTBX_child_amount.clear();
                    this.TXTBX_baby_amount.clear();
                    this.TXTBX_price.clear();
                    this.TXTBX_destination.clear();
                    this.TXTBX_airline_company.clear();
                    this.TXTBX_arrival_DD.clear();
                    this.TXTBX_arrival_MM.clear();
                    this.TXTBX_arrival_YYYY.clear();
                    this.TXTBX_departure_DD.clear();
                    this.TXTBX_departure_MM.clear();
                    this.TXTBX_departure_YYYY.clear();
                    this.TXTBX_luggage_details.clear();
                    this.CHKBX_lodging_included.setSelected(false);
                    this.CHKBX_return_flight_included.setSelected(false);
                    this.beachImage.setVisible(false);
                    this.hikingImage.setVisible(false);
                    this.urbanImage.setVisible(false);
                    this.selectedType.setVisible(false);
                    this.comboType.setPromptText("-choose-");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Your vacation has been successfully posted.");
                    alert.showAndWait();
                    super.showMainMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill obligated fields marked red.\n\n(or unlock db if in debug mode)");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenMainMenuID);
    }


}
/*
    @Override
    public void initialize(URL Location, ResourceBundle resources) {
        comboType.setItems(FXCollections.observableArrayList("beach", "hiking", "urban"));
    }
*/


