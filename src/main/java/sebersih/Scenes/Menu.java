package sebersih.Scenes;

import java.io.InputStream;
import java.text.DecimalFormat;

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

public class Menu {
    private int totalHarga = 0;
    private Label totalLabel;
    private Stage primaryStage;
    public String userName;

    public Menu(Stage primaryStage){
        this.primaryStage = primaryStage;
        // this.totalHarga = totalHarga;
    }

    public void show(){
        // transaksi top
        GridPane palingatas = new GridPane();
        palingatas.setAlignment(Pos.TOP_LEFT);
        palingatas.setPadding(new Insets(10));
        palingatas.setStyle("-fx-background-color: #A1ABB6");
        palingatas.setPrefWidth(400);
        palingatas.setHgap(10);
        
        Label labeltransaksi = new Label("TRANSAKSI BARU");
        labeltransaksi.setFont(new Font(15));
        labeltransaksi.setStyle("-fx-font-family: Fire wall; -fx-font-weight: bold; ");
        palingatas.add(labeltransaksi, 2,2);

        InputStream inputlogouser = getClass().getResourceAsStream("/image/user.png");
        Image urluser = new Image(inputlogouser);
        ImageView logouser = new ImageView(urluser);
        logouser.setFitHeight(20);
        logouser.setFitWidth(20);
        palingatas.add(logouser, 20,2);

        // bentuk yang bersampingan
        GridPane gridpaneatas = new GridPane();
        gridpaneatas.setAlignment(Pos.TOP_CENTER);
        gridpaneatas.setHgap(160); // mengatur jarak dari sel horizontal (BACK & CLEAR)
        gridpaneatas.setVgap(15); // mengatur jarak dari sel vertikal
        gridpaneatas.setPadding(new Insets(20, 20, 5, 20)); // mengatur jarak dari scene

        // Button back & gambarnya
        InputStream inputLogoBack = getClass().getResourceAsStream("/image/back.png");
        Image url1 = new Image(inputLogoBack);
        ImageView logokembali = new ImageView(url1);
        logokembali.setImage(url1);
        logokembali.setFitHeight(25);
        logokembali.setFitWidth(25);

        Button back = new Button("Back", logokembali);
        back.setFont(new Font("Forte", 15));
        back.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86; ");
        back.setOnAction(e -> {
            Login login = new Login(primaryStage);
            login.show();
        });
        back.setOnMouseEntered(e ->{
            back.setStyle("-fx-background-radius: 15; -fx-background-color: #A1ABB6; -fx-cursor: hand;");
        });
        back.setOnMouseExited(e -> {
            back.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86;");
        });
        gridpaneatas.add(back, 0, 0);
        GridPane.setHalignment(back, HPos.CENTER);

        InputStream inputLogoClear = getClass().getResourceAsStream("/image/clear.png");
        Image url2 = new Image(inputLogoClear);
        ImageView logoclear = new ImageView(url2);
        logoclear.setImage(url2);
        logoclear.setFitHeight(25);
        logoclear.setFitWidth(25);

        Button clear = new Button("Clear", logoclear);
        clear.setFont(new Font("Forte", 15));
        clear.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86; ");
        clear.setOnAction(e -> {
            totalHarga = 0;
            Menu menu =new Menu(primaryStage);
            menu.show();
        });
        clear.setOnMouseEntered(e ->{
            clear.setStyle("-fx-background-radius: 15; -fx-background-color: #A1ABB6; -fx-cursor: hand;");
        });
        clear.setOnMouseExited(e -> {
            clear.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86;");
        });
        gridpaneatas.add(clear, 1, 0);
        GridPane.setValignment(clear, VPos.CENTER);

        // List 1
        GridPane daftar1 = new GridPane();
        daftar1.setAlignment(Pos.TOP_LEFT);
        daftar1.setHgap(150);
        daftar1.setVgap(15);
        daftar1.setPadding(new Insets(30, 20, 20, 39));

        Label namaDaftar1 = new Label("Clean Wash Easy \n Rp. 30.000");
        namaDaftar1.setFont(new Font("ROCKWELL", 15));
        namaDaftar1.setStyle("-fx-font-weight: bold;");
        namaDaftar1.setAlignment(Pos.TOP_LEFT);
        daftar1.add(namaDaftar1, 0, 0);
        GridPane.setHalignment(namaDaftar1, HPos.CENTER);

        Button hargaButton1 = createHargaButton(30000, namaDaftar1);
        hargaButton1.setAlignment(Pos.TOP_RIGHT);
        hargaButton1.setStyle("-fx-background-color: #FFFFFF;");
        hargaButton1.setOnMouseEntered(e ->{
            hargaButton1.setStyle("-fx-background-color: #A1ABB6;-fx-cursor: hand;");
        });
        hargaButton1.setOnMouseExited(e -> {
            hargaButton1.setStyle("-fx-background-color: #FFFFFF;");
        });
        daftar1.add(hargaButton1, 1, 0);
        GridPane.setValignment(hargaButton1, VPos.CENTER);

        //list 2
        GridPane daftar2 = new GridPane();
        daftar2.setAlignment(Pos.TOP_LEFT);
        daftar2.setHgap(150);
        daftar2.setVgap(15);
        daftar2.setPadding(new Insets(20, 20, 20, 39));

        Label namaDaftar2 = new Label("Clean Wash Hard \n Rp. 35.000");
        namaDaftar2.setFont(new Font("ROCKWELL", 15));
        namaDaftar2.setStyle("-fx-font-weight: bold;");
        namaDaftar2.setAlignment(Pos.TOP_LEFT);
        daftar2.add(namaDaftar2, 0, 0);
        GridPane.setHalignment(namaDaftar2, HPos.CENTER);

        Button hargaButton2 = createHargaButton(35000, namaDaftar2);
        hargaButton2.setAlignment(Pos.TOP_RIGHT);
        hargaButton2.setStyle("-fx-background-color: #FFFFFF;");
        hargaButton2.setOnMouseEntered(e ->{
            hargaButton2.setStyle("-fx-background-color: #A1ABB6; -fx-cursor: hand;");
        });
        hargaButton2.setOnMouseExited(e -> {
            hargaButton2.setStyle("-fx-background-color: #FFFFFF;");
        });
        daftar2.add(hargaButton2, 1, 0);
        GridPane.setValignment(hargaButton2, VPos.CENTER);

        //list 3
        GridPane daftar3 = new GridPane();
        daftar3.setAlignment(Pos.TOP_LEFT);
        daftar3.setHgap(193);
        daftar3.setVgap(15);
        daftar3.setPadding(new Insets(20, 20, 20, 39));

        Label namaDaftar3 = new Label("Flash Wash \n Rp. 25.000");
        namaDaftar3.setFont(new Font("ROCKWELL", 15));
        namaDaftar3.setStyle("-fx-font-weight: bold;");
        namaDaftar3.setAlignment(Pos.TOP_LEFT);
        daftar3.add(namaDaftar3, 0, 0);
        GridPane.setHalignment(namaDaftar3, HPos.CENTER);

        Button hargaButton3 = createHargaButton(25000, namaDaftar3);
        hargaButton3.setAlignment(Pos.TOP_RIGHT);
        hargaButton3.setStyle("-fx-background-color: #FFFFFF;");
        hargaButton3.setOnMouseEntered(e->{
            hargaButton3.setStyle("-fx-background-color: #A1ABB6; -fx-cursor: hand; ");
        });
        hargaButton3.setOnMouseExited(e -> {
            hargaButton3.setStyle("-fx-background-color: #FFFFFF;");
        });
        daftar3.add(hargaButton3, 1, 0);
        GridPane.setValignment(hargaButton3, VPos.CENTER);

        //list 4
        GridPane daftar4 = new GridPane();
        daftar4.setAlignment(Pos.TOP_LEFT);
        daftar4.setHgap(198);
        daftar4.setVgap(15);
        daftar4.setPadding(new Insets(20, 20, 20, 39));

        Label namaDaftar4 = new Label("Kids Shoes \n Rp. 20.000");
        namaDaftar4.setFont(new Font("ROCKWELL", 15));
        namaDaftar4.setStyle("-fx-font-weight: bold;");
        namaDaftar4.setAlignment(Pos.TOP_LEFT);
        daftar4.add(namaDaftar4, 0, 0);
        GridPane.setHalignment(namaDaftar4, HPos.CENTER);

        Button hargaButton4 = createHargaButton(20000, namaDaftar4);
        hargaButton4.setAlignment(Pos.TOP_RIGHT);
        hargaButton4.setStyle("-fx-background-color: #FFFFFF;");
        hargaButton4.setOnMouseEntered(e ->{
            hargaButton4.setStyle("-fx-background-color: #A1ABB6;-fx-cursor: hand;");
        });
        hargaButton4.setOnMouseExited(e -> {
            hargaButton4.setStyle("-fx-background-color: #FFFFFF;");
        });
        daftar4.add(hargaButton4, 1, 0);
        GridPane.setValignment(hargaButton4, VPos.CENTER);

        //info harga button
        GridPane total = new GridPane();
        total.setAlignment(Pos.BOTTOM_CENTER);
        total.getHgap();
        total.getVgap();
        total.setPadding(new Insets(18, 0, 20, 0));
        // total.setStyle("-fx-background-color: #A1ABB6");
        

        totalLabel = new Label("Total: Rp." + totalHarga);
        totalLabel.setFont(new Font("ARIAL", 20));
        totalLabel.setAlignment(Pos.BOTTOM_CENTER);
        total.add(totalLabel, 0, 0);
        totalLabel.setStyle("-fx-background-color: #A1ABB6; -fx-padding: 10px; -fx-background-radius: 10;");

        // Label to display on the receipt
        Label strukLabel = new Label();
        strukLabel.setFont(new Font("Arial", 15));
        strukLabel.setStyle("-fx-font-weight: bold; ");

        //button scene ke menu berikutnya
        InputStream inputlogosave = getClass().getResourceAsStream("/image/save.png");
        Image urlsave = new Image(inputlogosave);
        ImageView logo2 = new ImageView(urlsave);
        logo2.setFitHeight(50);
        logo2.setFitWidth(50);

        Button buttoncetak = new Button();
        buttoncetak.setStyle("-fx-background-color: #394867; -fx-cursor: hand; ");
        buttoncetak.setAlignment(Pos.BOTTOM_CENTER);
        buttoncetak.setGraphic(logo2);
        buttoncetak.setOnAction(e -> {
            TamStruk tamStruk = new TamStruk(primaryStage, totalHarga);
            tamStruk.show(userName);
        });
        buttoncetak.setOnMouseEntered(e ->{
            buttoncetak.setStyle("-fx-background-color: #A1ABB6; -fx-cursor: hand;");
        });
        buttoncetak.setOnMouseExited(e -> {
            buttoncetak.setStyle("-fx-background-color: #394867; -fx-cursor: hand;");
        });

        //vbox
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #CACDCB;");
        layout.setAlignment(Pos.TOP_CENTER);
        // layout.setPadding(new Insets(2));
        layout.getChildren().addAll(palingatas,gridpaneatas,daftar1,daftar2,daftar3,daftar4, total,buttoncetak);
        // layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 600);

        primaryStage.setTitle("Button Harga");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        private Button createHargaButton(int harga, Label label) {
            InputStream inputlogotambah = getClass().getResourceAsStream("/image/tambah.png");
            Image urltambah = new Image(inputlogotambah);
            ImageView logotambah = new ImageView(urltambah);
            logotambah.setFitHeight(25);
            logotambah.setFitWidth(25);

            Button hargaButton = new Button();
            hargaButton.setGraphic(logotambah);

            hargaButton.setOnAction(e -> {
                totalHarga += harga;
                DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                String formattedTotalHarga = decimalFormat.format(totalHarga);
                totalLabel.setText("Total: Rp." + formattedTotalHarga);

            });
            return hargaButton;
        }
}
