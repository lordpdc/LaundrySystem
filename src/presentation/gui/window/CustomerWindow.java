package presentation.gui.window;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class CustomerWindow implements Initializable {

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextField telephoneField;
    @FXML protected TextField emailField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
