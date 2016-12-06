package presentation.window;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import presentation.utilities.StringValuesMessage;
import presentation.utilities.StringValuesWindow;

import javax.swing.*;

/**
 * Created by Luis on 05/12/2016.
 */
public abstract class window implements Initializable{
    protected boolean isUpdate = false;

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;


    public void setText(){
        cancelButton.setText(StringValuesWindow.cancelButton);
        createButton.setText(StringValuesWindow.createButton);
    }

    public abstract void setWindowtoUpdate(int id);

    protected void setIsUpdate(boolean isUpdate){
        this.isUpdate = isUpdate;
    }

    protected abstract boolean isFieldEmty();
    protected abstract void cleanWindow();

    protected void FieldEmptyMessage(){
        JOptionPane.showMessageDialog(null, StringValuesMessage.missingFieldMessage,
                StringValuesMessage.warningTitle,JOptionPane.WARNING_MESSAGE);
    }
}
