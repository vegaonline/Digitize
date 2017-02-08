/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitizervega;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author vega
 */
public class DigitizerVega extends Application {

    private Stage primStage;
    private BorderPane mainLayout;
    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primStage = primaryStage;
        primStage.setTitle("DigitizerVega: A Digitizer tool by Dr. Abhijit Bhattacharyya");
        FXMLLoader loader = new FXMLLoader(DigitizerVega.class.getResource("mainScreen.fxml"));
        mainLayout = (BorderPane) loader.load();
        mainScene = new Scene(mainLayout);
        primStage.setScene(mainScene);
        primStage.setMinHeight(600);
        primStage.setMinWidth(1200);
        MainScreenController controller = loader.getController();
        primStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
