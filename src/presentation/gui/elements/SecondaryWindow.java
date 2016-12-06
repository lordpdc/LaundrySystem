package presentation.gui.elements;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javax.swing.*;

/**
 * Created by cesar on 05/12/16.
 */
public class SecondaryWindow<T> {
    protected JFrame frame;
    protected T primaryView;


    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    public void setPrimaryView(T primaryView){
        this.primaryView = primaryView;
    }

    protected EventHandler<KeyEvent> numericValidation(final Integer maxLengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= maxLengh) {
                    e.consume();
                }
                if(e.getCharacter().matches("[0-9.]")){
                    if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                        e.consume();
                    }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                        e.consume();
                    }
                }else{
                    e.consume();
                }
            }
        };
    }
}
