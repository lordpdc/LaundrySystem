package presentation.gui.Tabs;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by raoman on 12/11/2016.
 */
public abstract class TabAdministrator {

    @FXML private Tab genericTab;
    @FXML private Button createButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Button searchButton;
    @FXML private TextField searchField;
    @FXML private TableView dataTable;



    public void TabAdministrator(){
        setTextComponents();

    }

    abstract void setTextComponents();




}
