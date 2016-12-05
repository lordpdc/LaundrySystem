package business.Email;

/**
 * Created by raoman on 04/12/2016.
 */

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static business.Email.EmailDefaultValues.*;

    public class EmailSenderService {
        private final String MSG_ERROR="Mensaje no enviado";
        private final EmailConnector connector;

        public EmailSenderService( ) {
            connector=new EmailConnector();
        }


        public void sendEmail(String addressee,String subject,String message){


             try{
                Message mimeMessage = new MimeMessage(connector.getSession());
                mimeMessage.setFrom(new InternetAddress(SENDER_VALUE));
                mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressee));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(message);

                Transport.send( mimeMessage );
;
            }catch (MessagingException me){
                 me.printStackTrace();
                new Exception( MSG_ERROR+me.toString());
            }

        }
    }
