/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitizervega;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author vega
 */
public class MainScreenController implements Initializable {

    JFileChooser fileChooser = new JFileChooser();
    private File fileRead;
    private File fileWrite;
    private File recordsDir;

    @FXML
    private MenuItem OpenDoc;
    @FXML
    private MenuItem QuitIt;
    @FXML
    private MenuItem Digitize;
    @FXML
    private MenuItem ClearData;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane rightPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void doOpenDoc(ActionEvent event) {
    }

    @FXML
    private void goQuit(ActionEvent event) {
        System.gc();
        System.exit(0);
    }

    @FXML
    private void doDigitize(ActionEvent event) {
    }

    @FXML
    private void doClearData(ActionEvent event) {
    }

}
