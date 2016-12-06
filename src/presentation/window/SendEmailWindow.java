package presentation.window;

import business.Email.EmailSenderService;
import business.utilities.DefaultValues;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import presentation.utilities.StringValuesMessage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by raoman on 05/12/2016.
 */
public class SendEmailWindow implements Initializable {
    private static final String MSG_FAIL = "mensaje no enviado";
    @FXML protected Button sendButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField addresseeField;
    @FXML protected TextField subjectField;
    @FXML protected TextArea msgTextArea;


    @Override
    public void initialize( URL location, ResourceBundle resources ) {
        sendButton.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                sendEmail();
            }
        } ) );
        cancelButton.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                //cerrar esta ventana es la de Reportes

            }
        } ) );

    }

    private void sendEmail( ) {
        String addressee=addresseeField.getText();
        String subject=subjectField.getText();
        String msg= msgTextArea.getText();
        if(!(addressee.isEmpty()||subject.isEmpty()||msg.isEmpty())){
            try {
                EmailSenderService sender=new EmailSenderService();
                sender.sendEmail( addressee,subject,msg );
                showNotification( StringValuesMessage.MSG_SENDED );
                prepareForNexEmail();
            }
            catch( Exception e ){
                showNotification( StringValuesMessage.MSG_NO_SENDED );
            }

        }
        else{
            JOptionPane.showMessageDialog(null, StringValuesMessage.MSG_INCOMPLETE,
                    StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void prepareForNexEmail(){
        cleanField();
    }
    private void cleanField(){
        addresseeField.setText( DefaultValues.STRING);
        subjectField.setText( DefaultValues.STRING);
        msgTextArea.setText( DefaultValues.STRING);
    }
    private void showNotification(String msgNotification){
        JOptionPane.showMessageDialog(null,msgNotification,
                StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
    }
}
