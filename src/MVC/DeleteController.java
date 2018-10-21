package MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.PasswordField;

import javax.swing.*;


public class DeleteController extends Controller {
    private Model model = new Model();
    private String password;

    @FXML
    private void deleteForever(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Confirmation");
        dialog.setHeaderText("Enter password to confirm:");
        dialog.setContentText("Password:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(pass -> {
            this.password = pass;
        });
        if (password != null && model.isMember(Main.signedUserName, password)) {
            model.deleteUser(Main.signedUserName, password);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete User");
            alert.setHeaderText(null);
            alert.setContentText("User Deleted Successfully");
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
            alert.setContentText("User Deleted Canceled");
            alert.showAndWait();
            try {
                super.showMainMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
