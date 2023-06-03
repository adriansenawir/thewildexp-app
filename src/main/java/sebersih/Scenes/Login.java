package sebersih.Scenes;

import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
    private Stage primaryStage;
    public String userName;

    public Login(Stage primaryStage){
        this.primaryStage=primaryStage;
    }

    public void show(){
        // label kasir
        Label labelkasir = new Label("KASIR");
        labelkasir.setFont(new Font("ROCKWELL", 50));
        labelkasir.setStyle("-fx-font-weight: bold; ");
        labelkasir.setAlignment(Pos.TOP_CENTER);

        // logo
        InputStream inputstream = getClass().getResourceAsStream("/image/logosebersih.png");
        Image url = new Image(inputstream);
        ImageView logo = new ImageView(url);
        
        // logo.setImage(url);
        logo.setFitHeight(200);
        logo.setFitWidth(200);

        // label sebersih
        Label labelsebersih = new Label("''Berusahalah untuk tidak menjadi sukses\ntapi berusahalah untuk menjadi bernilai''");
        labelsebersih.setFont(new Font(14));
        labelsebersih.setStyle("-fx-font-weight: bold; ");
        labelsebersih.setAlignment(Pos.TOP_CENTER);

        // TextFields for username and password
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setPrefWidth(150);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefWidth(150);
        
        HBox usernameLayout = new HBox();
        usernameLayout.getChildren().addAll(usernameLabel,usernameField);
        usernameLayout.setSpacing(10);
        usernameLayout.setAlignment(Pos.CENTER);

        HBox passwordLayout = new HBox();
        passwordLayout.getChildren().addAll(passwordLabel, passwordField);
        passwordLayout.setSpacing(10);
        passwordLayout.setAlignment(Pos.CENTER);

        Button login = new Button("LOGIN");
        login.setFont(new Font("Retro Warmth", 15));
        login.setStyle("-fx-background-color: #105A86;-fx-text-fill:white; -fx-background-radius: 50; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-width: 1px;");
        login.setAlignment(Pos.CENTER);
        login.setOnMouseEntered(e -> {
            login.setStyle("-fx-background-color: #FFFFF;-fx-background-radius: 50; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-width: 1px;");
        });
        login.setOnMouseExited(e -> {
            login.setStyle("-fx-background-color: #105A86;-fx-text-fill:white; -fx-background-radius: 50; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-width: 1px;");
        });

        login.setOnAction(e -> { String usernameInput = usernameField.getText() ; String passwordInput = passwordField.getText();
            try {
                int passwordInt = Integer.parseInt(passwordInput);
                if (usernameInput.matches("[a-zA-Z]+") && passwordInt >= 0) {
                    Menu menu = new Menu(primaryStage);
                    menu.userName = usernameField.getText();
                    menu.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid username or password. Please try again.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException ex) {
                // If the password is not an integer, show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Password must be an Integer. Please try again.");
                alert.showAndWait();
            }
        });

    // membuat ketentuan tampilan
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #CACDCB; ");
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(20);
        layout.getChildren().addAll(labelkasir, logo, labelsebersih, usernameLayout, passwordLayout, login);
        
        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

