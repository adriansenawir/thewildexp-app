package sebersih;

import javafx.application.Application;
import javafx.stage.Stage;
import sebersih.Scenes.Login;



public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // this.primaryStage = primaryStage;
        primaryStage.setTitle("Sebersih");

        Login login = new Login(primaryStage);
        login.show();
        primaryStage.show();
    }
}