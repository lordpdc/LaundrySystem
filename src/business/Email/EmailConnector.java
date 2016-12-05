package business.Email;

import javax.mail.*;

import java.util.Properties;

import static business.Email.EmailDefaultValues.*;

/**
 * Created by raoman on 05/12/2016.
 */
public class EmailConnector {
    private Properties serverEmailPropiertes;
    private Session session;

    public EmailConnector(  ) {
        serverEmailPropiertes=new Properties(  );
        setDefaultServerProperties();
        addPropiertesSession();
    }

    public  Session getSession( ) {
        return session;
    }
    public Object getProperties(String nameProperties){
        return serverEmailPropiertes.get( nameProperties );
    }

    private void setDefaultServerProperties() {
        serverEmailPropiertes.put( HOST_IDENTIFIER,HOST_VALUE );
        serverEmailPropiertes.put( TLS_IDENTIFIER,TLS_VALUE );
        serverEmailPropiertes.put( PORT_IDENTIFIER, PORT_VALUE );
        serverEmailPropiertes.put( SENDER_IDENTIFIER,SENDER_VALUE);
        serverEmailPropiertes.put( USER_IDENTIFIER, USER_VALUE);
        serverEmailPropiertes.put( PASSWORD_REQUIRED_IDENTIFIER, PASSWORD_REQUIRED_VALUE);
    }
    private void addPropiertesSession(){
         session = Session.getInstance(serverEmailPropiertes,login());

    }
    private Authenticator login(){
        return new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication( ) {
                return new PasswordAuthentication( SENDER_VALUE, PASSWORD );
            }
        };
    }
}
