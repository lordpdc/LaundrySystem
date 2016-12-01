package presentation.gui.tabs;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by cesar on 01/12/16.
 */
public class View {
    Tab tab;

    public View() {
        try {
            URL getingsmh = getClass().getResource("tabs/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tab getTab(){
        return tab;
    }

    public void setTab(Tab tab){
        this.tab = tab;
    }

}
