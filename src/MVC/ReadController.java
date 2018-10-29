package MVC;

import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ReadController extends Controller {
    private Model model = new Model();
    @FXML
    private TextField user_name;
    @FXML
    private Text username_read;
    @FXML
    private Text first_name_read;
    @FXML
    private Text last_name_read;
    @FXML
    private Text bDate_read;
    @FXML
    private Text city_read;

    @FXML
    /* function receives username and displays his details if found */
    public void readUserData(ActionEvent event) {
        String user = user_name.getText();
        String[] res = model.readUser(user);

        if(res != null) {
            username_read.setText(res[0]);
            first_name_read.setText(res[1]);
            last_name_read.setText(res[2]);
            bDate_read.setText(res[3]);
            city_read.setText(res[4]);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("user not found");
            alert.setHeaderText(null);
            alert.setContentText("there is no user called " + user);
            alert.showAndWait();
        }
    }
}
