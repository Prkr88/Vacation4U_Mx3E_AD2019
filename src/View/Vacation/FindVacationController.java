package View.Vacation;

import Controller.Controller;
import Model.SelectApp;
import View.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindVacationController extends Controller {
    private static ListView<String> listView;

    public ListView<String> getListView() {
        return listView;
    }

    @FXML
    private TextField day1;
    @FXML
    private TextField month1;
    @FXML
    private TextField year1;
    @FXML
    private TextField day2;
    @FXML
    private TextField month2;
    @FXML
    private TextField year2;
    @FXML
    private TextField maxPrice;
    @FXML
    private TextField destination;
    @FXML
    private Button search;

    @FXML
    public void find(ActionEvent event) throws IOException {
        String d1 = day1.getText();
        String m1 = month1.getText();
        String y1 = year1.getText();
        String d2 = day2.getText();
        String m2 = month2.getText();
        String y2 = year2.getText();
        ArrayList<ArrayList<String>> resultSetList = null;

        if (!d1.equals("") || !d2.equals("") || !m1.equals("") || !m2.equals("") || !y1.equals("") || !y2.equals("")) {
            if(d1.equals("") || d2.equals("") || m1.equals("") || m2.equals("") || y1.equals("") || y2.equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Worning!");
                alert.setContentText("Invalid date");
                alert.show();
                return;
            }
        }

        String date1 = d1 + "-" + m1 + "-" + y1;
        String date2 = d2 + "-" + m2 + "-" + y2;
        String price = maxPrice.getText();
        String dest = destination.getText();
        SelectApp selectApp = new SelectApp();
        resultSetList = selectApp.selectOfferedVacation(date1, date2, price, dest);
        FlightDetController fdc = new FlightDetController();
        fdc.setFlightList(resultSetList);
        fdc.showTable();
//        ObservableList<String> vacations = FXCollections.observableArrayList();
//        listView = new ListView<>();
//        listView.setPrefSize(700, 700);
//        listView.setEditable(true);
//        try {
//            int i = 0;
//            for (i = 0;i<resultSetList.size();i++) {
//                String res = "departure: " + resultSetList.get(i).get(2) +
//                        " return: " + resultSetList.get(i).get(3) +
//                        " destination: " + resultSetList.get(i).get(4) +
//                        " cost: " + resultSetList.get(i).get(5) +
//                        " flight back included: " + resultSetList.get(i).get(6) +
//                        " flight company: " + resultSetList.get(i).get(7) +
//                        " type: " + resultSetList.get(i).get(8) +
//                        " adult tickets: " + resultSetList.get(i).get(9) +
//                        " kid tickets: " + resultSetList.get(i).get(10) +
//                        " baby tickets: " + resultSetList.get(i).get(11) +
//                        " seller ID: " + resultSetList.get(i).get(1);
//                vacations.add(res);
//            }
//            listView.setItems(vacations);
//            listView.setCellFactory(ComboBoxListCell.forListView(vacations));
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("FindVacation.fmxl"));
//            Stage stage = new Stage();
//            stage.setTitle("Vacations");
//            StackPane root = new StackPane();
//            root.getChildren().add(listView);
//            stage.setScene(new Scene(root, 800, 800));
//            stage.show();

//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }



    private void cancelAction(ActionEvent event) {
        super.myController.setScreen(Main.screenFindVacationID);
    }
}
