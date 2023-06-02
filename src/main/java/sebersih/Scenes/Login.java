package sebersih.Scenes;

import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
    private Stage primaryStage;

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

        // // image & button keranjang
        // InputStream inputlogo = getClass().getResourceAsStream("/image/keranjang.png");
        // Image url1 = new Image(inputlogo);
        // ImageView logo1 = new ImageView(url1);

        // logo1.setFitHeight(100);
        // logo1.setFitWidth(100);

        // Button keranjang = new Button("MASUK", logo1);
        // keranjang.setFont(new Font("Forte", 15));
        // keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 480; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        // keranjang.setAlignment(Pos.CENTER);
        // keranjang.setOnMouseEntered(e -> {
        //     keranjang.setStyle("-fx-background-color: #000000;-fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        // });
        // keranjang.setOnMouseExited(e -> {
        //     keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        // });
        // keranjang.setOnAction(e -> {
        //     sceneMenu();
        // });

        
        // Button keranjang = new Button();
        // // keranjang.setFont(new Font("Forte", 15));
        // keranjang.setGraphic(logo1);
        // keranjang.setStyle("-fx-background-color: #105A86; -fx-background-radius: 480; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
        // keranjang.setAlignment(Pos.CENTER);
        // keranjang.setOnMouseEntered(e -> {
        //     keranjang.setStyle("-fx-background-color: #000000;-fx-background-radius: 180; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
        // });
        // keranjang.setOnMouseExited(e -> {
        //     keranjang.setStyle("-fx-background-color: #105A86; -fx-background-radius: 180; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
        // });
        // login.setOnAction(e -> {
        //     sceneMenu();
        // });

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
        login.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
        login.setAlignment(Pos.CENTER);
        login.setOnMouseEntered(e -> {
            login.setStyle("-fx-background-color: #1E90FF;-fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
        });
        login.setOnMouseExited(e -> {
            login.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
        });

        // logo1.setFitHeight(50);
        // logo1.setFitWidth(50);
        login.setOnAction(e -> { String usernameInput = usernameField.getText() ; String passwordInput = passwordField.getText();
            try {
                int passwordInt = Integer.parseInt(passwordInput);
                if (usernameInput.matches("[a-zA-Z]+") && passwordInt >= 0) {
                    Menu menu = new Menu(primaryStage, passwordInt);
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

        // Tombol daftar
        Button daftar = new Button("DAFTAR");
        daftar.setFont(new Font("Retro Warmth", 15));
        daftar.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand;  -fx-border-color: #000000;");
        daftar.setAlignment(Pos.CENTER);
        daftar.setOnMouseEntered(e -> {
            daftar.setStyle("-fx-background-color: #1E90FF;-fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand;  -fx-border-color: #000000;");
        });
        daftar.setOnMouseExited(e -> {
            daftar.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000;");
        });
        
        // VBox daftarLayout = new VBox();
        
            daftar.setOnAction(e -> {
            VBox daftarLayout = new VBox(); // create a new layout container

            Label label = new Label("Silakan isi formulir pendaftaran");
            label.setFont(new Font("Retro Warmth", 20));
            label.setAlignment(Pos.CENTER);
            daftarLayout.getChildren().add(label);

            TextField namaField = new TextField();
            namaField.setPromptText("Nama Lengkap");
            daftarLayout.getChildren().add(namaField);

            TextField emailField = new TextField();
            emailField.setPromptText("Email");
            daftarLayout.getChildren().add(emailField);

            Button submitButton = new Button("Submit");
            submitButton.setOnAction(event -> {
                String nama = namaField.getText();
                String email = emailField.getText();

                if (!nama.isEmpty() && !email.isEmpty()) {
                    // proses input dan submit data ke server

                    // kembali ke halaman sebelumnya setelah sukses submit
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                } else {
                    // handle error when fields are empty
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Mohon lengkapi semua kolom");

                    alert.showAndWait();
                }
            });
            daftarLayout.getChildren().add(submitButton);

            // Scene newScene = new Scene(daftarLayout, 400, 600); // use the layout container as the scene root
        });

        // // Menambahkan tombol daftar
        
        // daftarLayout.getChildren().addAll(daftar);
        // daftarLayout.setAlignment(Pos.CENTER);

        // // Membuat halaman daftar
        // VBox daftarLayout = new VBox();
        // daftarLayout.setSpacing(10);


        // registrationScene.setRoot(daftarLayout)= new Scene(daftarLayout);
        // Stage stage = (Stage) daftar.getScene().getWindow();
        // stage.setScene(registrationScene);


    // membuat ketentuan tampilan
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #CACDCB; ");
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(20);
        layout.getChildren().addAll(labelkasir, logo, labelsebersih, usernameLayout, passwordLayout, login, daftar);
        
        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

