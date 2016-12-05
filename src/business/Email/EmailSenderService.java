package business.Email;

/**
 * Created by raoman on 04/12/2016.
 */

import javax.mail.*;
import javax.mail.internet.*;

import static business.Email.EmailDefaultValues.*;

    public class EmailSenderService {

        private final String MSG_ERROR="Mensaje no enviado";
        private final EmailConnector connector;

        public EmailSenderService( ) {
            connector=new EmailConnector();
        }

        public void sendEmail(String addressee,String subject,String message){
             try{
               Message msgCreated=createMessage( addressee,subject,message );
               Transport.send( msgCreated );
;
            }catch (Exception me){
                new Exception( MSG_ERROR);
            }

        }
        private Message createMessage(String addressee,String subject,String message) throws Exception {
            Session accountEmailSession=connector.getConnection();
            InternetAddress adressee= new InternetAddress(addressee);
            InternetAddress sender=new InternetAddress(accountEmailSession.getProperty( SENDER_IDENTIFIER ));
            Message msgCreated = new MimeMessage(accountEmailSession);

            msgCreated.setFrom(sender);
            msgCreated.setRecipient(Message.RecipientType.TO,adressee );
            msgCreated.setSubject(subject);
            msgCreated.setText(message);

            return msgCreated;
        }
    }
