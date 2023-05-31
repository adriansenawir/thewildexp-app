package sebersih;

import java.io.InputStream;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private int totalHarga = 0;
    private Label totalLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Sebersih");

        menuUtama();
        primaryStage.show();
    }

    private void menuUtama() {
        // label kasir
        Label labelkasir = new Label("KASIR");
        labelkasir.setFont(new Font("ROCKWELL", 50));
        labelkasir.setStyle("-fx-font-weight: bold; ");
        labelkasir.setAlignment(Pos.TOP_CENTER);

        // logo
        InputStream inputstream = getClass().getResourceAsStream("/image/logo.png");
        Image url = new Image(inputstream);
        ImageView logo = new ImageView(url);
        
        // logo.setImage(url);
        logo.setFitHeight(90);
        logo.setFitWidth(220);

        // label sebersih
        Label labelsebersih = new Label("SEBERSIH SHOES & CARE");
        labelsebersih.setFont(new Font(18));
        labelsebersih.setStyle("-fx-font-weight: bold; ");
        labelsebersih.setAlignment(Pos.TOP_CENTER);

        // image & button keranjang
        InputStream inputlogo = getClass().getResourceAsStream("/image/keranjang.png");
        Image url1 = new Image(inputlogo);
        ImageView logo1 = new ImageView(url1);
        logo1.setFitHeight(100);
        logo1.setFitWidth(100);

        Button keranjang = new Button("MASUK", logo1);
        keranjang.setFont(new Font("Forte", 15));
        keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 480; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        keranjang.setAlignment(Pos.CENTER);
        keranjang.setOnMouseEntered(e -> {
            keranjang.setStyle("-fx-background-color: #000000;-fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        });
        keranjang.setOnMouseExited(e -> {
            keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        });
        keranjang.setOnAction(e -> {
            sceneMenu();
        });

        // membuat ketentuan tampilan
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #5F9EA0; ");
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(20);
        layout.getChildren().addAll(labelkasir, logo, keranjang, labelsebersih);

        Scene scene = new Scene(layout, 400, 660);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sceneMenu() {
        // bentuk yang bersampingan
        GridPane gridpaneatas = new GridPane();
        gridpaneatas.setAlignment(Pos.TOP_CENTER);
        gridpaneatas.setHgap(130); // mengatur jarak dari sel horizontal (BACK & CLEAR)
        gridpaneatas.setVgap(15); // mengatur jarak dari sel vertikal
        gridpaneatas.setPadding(new Insets(20, 20, 5, 20)); // mengatur jarak dari scene

        // Button back & gambarnya
        InputStream inputLogoBack = getClass().getResourceAsStream("/image/back.png");
        Image url1 = new Image(inputLogoBack);
        ImageView logokembali = new ImageView(url1);
        logokembali.setImage(url1);
        logokembali.setFitHeight(35);
        logokembali.setFitWidth(35);

        Button back = new Button("Back", logokembali);
        back.setFont(new Font("Forte", 20));
        // back.setMaxHeight(15);
        // back.setMaxWidth(15);
        back.setStyle("-fx-background-radius: 20; -fx-cursor: hand;");
        back.setOnAction(e -> {
            menuUtama();
        });
        gridpaneatas.add(back, 0, 0);
        GridPane.setHalignment(back, HPos.CENTER);

        InputStream inputLogoClear = getClass().getResourceAsStream("/image/clear.png");
        Image url2 = new Image(inputLogoClear);
        ImageView logoclear = new ImageView(url2);
        logoclear.setImage(url2);
        logoclear.setFitHeight(35);
        logoclear.setFitWidth(35);

        Button clear = new Button("Clear", logoclear);
        clear.setFont(new Font("Forte", 20));
        clear.setStyle("-fx-background-radius: 20; -fx-cursor: hand;");
        clear.setOnAction(e -> {
            totalHarga = 0;
            sceneMenu();
        });
        gridpaneatas.add(clear, 1, 0);
        GridPane.setValignment(clear, VPos.CENTER);

        // List 1
        GridPane daftar1 = new GridPane();
        daftar1.setAlignment(Pos.TOP_LEFT);
        daftar1.setHgap(130);
        daftar1.setVgap(15);
        daftar1.setPadding(new Insets(20, 20, 20, 20));

        Label namaDaftar1 = new Label("Clean Wash Easy \n Rp. 30.000");
        namaDaftar1.setFont(new Font("ROCKWELL", 15));
        namaDaftar1.setStyle("-fx-font-weight: bold; ");
        namaDaftar1.setAlignment(Pos.TOP_LEFT);
        daftar1.add(namaDaftar1, 0, 0);
        GridPane.setHalignment(namaDaftar1, HPos.CENTER);

        Button hargaButton1 = createHargaButton(30000);
        hargaButton1.setAlignment(Pos.TOP_RIGHT);
        daftar1.add(hargaButton1, 1, 0);
        GridPane.setValignment(hargaButton1, VPos.CENTER);

        //list 2
        GridPane daftar2 = new GridPane();
        daftar2.setAlignment(Pos.TOP_LEFT);
        daftar2.setHgap(130);
        daftar2.setVgap(15);
        daftar2.setPadding(new Insets(20, 20, 20, 20));

        Label namaDaftar2 = new Label("Clean Wash Hard \n Rp. 35.000");
        namaDaftar2.setFont(new Font("ROCKWELL", 15));
        namaDaftar2.setStyle("-fx-font-weight: bold; ");
        namaDaftar2.setAlignment(Pos.TOP_LEFT);
        daftar2.add(namaDaftar2, 0, 0);
        GridPane.setHalignment(namaDaftar2, HPos.CENTER);

        Button hargaButton2 = createHargaButton(35000);
        hargaButton2.setAlignment(Pos.TOP_RIGHT);
        daftar2.add(hargaButton2, 1, 0);
        GridPane.setValignment(hargaButton2, VPos.CENTER);

        //list 3
        GridPane daftar3 = new GridPane();
        daftar3.setAlignment(Pos.TOP_LEFT);
        daftar3.setHgap(173);
        daftar3.setVgap(15);
        daftar3.setPadding(new Insets(20, 20, 20, 20));

        Label namaDaftar3 = new Label("Flash Wash \n Rp. 25.000");
        namaDaftar3.setFont(new Font("ROCKWELL", 15));
        namaDaftar3.setStyle("-fx-font-weight: bold; ");
        namaDaftar3.setAlignment(Pos.TOP_LEFT);
        daftar3.add(namaDaftar3, 0, 0);
        GridPane.setHalignment(namaDaftar3, HPos.CENTER);

        Button hargaButton3 = createHargaButton(25000);
        hargaButton3.setAlignment(Pos.TOP_RIGHT);
        daftar3.add(hargaButton3, 1, 0);
        GridPane.setValignment(hargaButton3, VPos.CENTER);

        //list 4
        GridPane daftar4 = new GridPane();
        daftar4.setAlignment(Pos.TOP_LEFT);
        daftar4.setHgap(178);
        daftar4.setVgap(15);
        daftar4.setPadding(new Insets(20, 20, 20, 20));

        Label namaDaftar4 = new Label("Kids Shoes \n Rp. 20.000");
        namaDaftar4.setFont(new Font("ROCKWELL", 15));
        namaDaftar4.setStyle("-fx-font-weight: bold; ");
        namaDaftar4.setAlignment(Pos.TOP_LEFT);
        daftar4.add(namaDaftar4, 0, 0);
        GridPane.setHalignment(namaDaftar4, HPos.CENTER);

        Button hargaButton4 = createHargaButton(20000);
        hargaButton4.setAlignment(Pos.TOP_RIGHT);
        daftar4.add(hargaButton4, 1, 0);
        GridPane.setValignment(hargaButton4, VPos.CENTER);

        //info harga button
        totalLabel = new Label("Total: Rp." + totalHarga);
        totalLabel.setFont(new Font("ARIAL", 20));
        totalLabel.setAlignment(Pos.BOTTOM_CENTER);

        //button scene ke menu berikutnya
        InputStream inputlogosave = getClass().getResourceAsStream("/image/save.png");
        Image urlsave = new Image(inputlogosave);
        ImageView logo2 = new ImageView(urlsave);
        logo2.setFitHeight(50);
        logo2.setFitWidth(50);

        Button buttoncetak = new Button("Cetak");
        buttoncetak.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setValignment(buttoncetak, VPos.BOTTOM);


        //vbox
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #5F9EA0;");
        // layout.setAlignment(Pos.TOP_CENTER);
        // layout.setPadding(new Insets(2));
        layout.getChildren().addAll(gridpaneatas,daftar1,daftar2,daftar3,daftar4, totalLabel,buttoncetak);

        Scene scene = new Scene(layout, 400, 600);

        primaryStage.setTitle("Button Harga");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        private Button createHargaButton(int harga) {
            Button hargaButton = new Button("tambah");

            hargaButton.setOnAction(e -> {
                totalHarga += harga;
                DecimalFormat decimalFormat = new DecimalFormat("#.##0");
                String formattedTotalHarga = decimalFormat.format(totalHarga);
                totalLabel.setText("Total: Rp." + formattedTotalHarga);
            });
            return hargaButton;
        }

    private void struk(){

    }
}