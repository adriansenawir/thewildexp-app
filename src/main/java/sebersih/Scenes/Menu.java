package sebersih.Scenes;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
import sebersih.Datasources.BarangDataSource;
import sebersih.model.Barang;

public class Menu {
    private int totalHarga = 0;
    private Label totalLabel;
    private Stage primaryStage;
    public String userName;
    List<String> selectItem = new ArrayList<>();

    final List<Barang> listBarang;

    public Menu(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.listBarang = BarangDataSource.getListBarang();
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

          //vbox
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #CACDCB;");
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll( palingatas,gridpaneatas);

        

        // selectItem.clear();
        // List 1
        for (int i=0;i<listBarang.size();i++) {
            final int index = i;
            GridPane daftar = new GridPane();
            daftar.setAlignment(Pos.TOP_LEFT);
            daftar.setHgap(150);
            daftar.setVgap(15);
            daftar.setPadding(new Insets(15, 20, 15, 39));

            Label namaDaftar1 = new Label(listBarang.get(i).getNama() + "\nRp. " + listBarang.get(i).getHarga());
            namaDaftar1.setFont(new Font("ROCKWELL", 15));
            namaDaftar1.setStyle("-fx-font-weight: bold;");
            // namaDaftar1.setAlignment(Pos.TOP_LEFT);
            daftar.add(namaDaftar1, 0, 0);
            GridPane.setHalignment(namaDaftar1, HPos.LEFT);

            Button hargaButton1 = createHargaButton(listBarang.get(i).getHarga(), namaDaftar1, index);
            // hargaButton1.setAlignment(Pos.TOP_RIGHT);
            hargaButton1.setStyle("-fx-background-color: #FFFFFF;");
            hargaButton1.setOnMouseEntered(e ->{
                hargaButton1.setStyle("-fx-background-color: #A1ABB6;-fx-cursor: hand;");
            });
            hargaButton1.setOnMouseExited(e -> {
                hargaButton1.setStyle("-fx-background-color: #FFFFFF;");
            });
            daftar.add(hargaButton1, 1, 0);
            GridPane.setHalignment(hargaButton1, HPos.RIGHT);
            layout.getChildren().add(daftar);
        }

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
            TamStruk tamStruk = new TamStruk(primaryStage, totalHarga, selectItem);
            tamStruk.show(userName);
            // selectItem.clear();
        });
        buttoncetak.setOnMouseEntered(e ->{
            buttoncetak.setStyle("-fx-background-color: #A1ABB6; -fx-cursor: hand;");
        });
        buttoncetak.setOnMouseExited(e -> {
            buttoncetak.setStyle("-fx-background-color: #394867; -fx-cursor: hand;");
        });

        // layout.setPadding(new Insets(2));
        layout.getChildren().addAll(total,buttoncetak);
        // layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 600);

        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        private Button createHargaButton(int harga, Label label, int index) {
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
                selectItem.add(listBarang.get(index).getNama());
            });
            return hargaButton;
        }
}
