package app.lan_files_exchanger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Screen;
import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private static final int defaultFontSize=13;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        stage.setTitle("LAN Files Exchanger");

        Screen primaryScreen = Screen.getPrimary();
        int initWidth = (int)(960/primaryScreen.getOutputScaleX());
        int initHeight = (int)(540/primaryScreen.getOutputScaleY());

        //Set default windows size depending on the scale of display
        initRootLayout(initWidth,initHeight);

        showLANFilesExchanger();

        try {
            primaryStage.getScene().getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("stylesheet/default.css")).toExternalForm());
        }
        catch (NullPointerException e){
            System.out.println("Default CSS stylesheet not found");
        }

        //Resize the font size in function of the screen display scale
        primaryStage.getScene().getRoot().setStyle("-fx-font-size: "+ defaultFontSize/primaryScreen.getOutputScaleX()+"pt");

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout(int width,int height){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout,width,height);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the interface of the LAN Files Exchanger inside the root layout
     */
    public void showLANFilesExchanger(){
        try {
            //Load LAN Files Exchanger view from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LANFilesExchanger.fxml"));
            AnchorPane LANFilesExchanger = (AnchorPane) loader.load();

            //Set the LAN Files Exchanger into the center of root layout
            this.rootLayout.setCenter(LANFilesExchanger);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the main stage
     * @return primaryStage
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
            launch(args);
    }
}