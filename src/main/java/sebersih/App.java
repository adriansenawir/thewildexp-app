package sebersih;

import java.util.HashMap;
import java.util.Map;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private Map<String, Double> hargaPencucian;

    private Label totalHargaLabel;
    private double totalHarga;
    private Map<String, Integer> jumlahKlik;

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
        Image url = new Image("https://document-export.canva.com/btPKA/DAFTbzbtPKA/15/thumbnail/0001.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAQYCGKMUHWDTJW6UD%2F20230524%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230524T115206Z&X-Amz-Expires=33420&X-Amz-Signature=862dd3d9c07498ba3f3b22e7e904ff89f09eb69a724f945c95c0225bb18c9123&X-Amz-SignedHeaders=host&response-expires=Wed%2C%2024%20May%202023%2021%3A09%3A06%20GMT");
        ImageView logo = new ImageView(url);
        logo.setImage(url);
        logo.setFitHeight(90);
        logo.setFitWidth(220);

        // label sebersih
        Label labelsebersih = new Label("SEBERSIH SHOES & CARE");
        labelsebersih.setFont(new Font(18));
        labelsebersih.setStyle("-fx-font-weight: bold; ");
        labelsebersih.setAlignment(Pos.TOP_CENTER);

        // image & button keranjang
        Image url1 = new Image("https://cdn.icon-icons.com/icons2/2644/PNG/512/cart_plus_fill_icon_159642.png");
        ImageView logo1 = new ImageView(url1);
        logo1.setImage(url1);
        logo1.setFitHeight(50);
        logo1.setFitWidth(50);

        Button keranjang = new Button("MASUK", logo1);
        keranjang.setFont(new Font("Forte", 15));
        keranjang.setStyle("-fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
        keranjang.setAlignment(Pos.CENTER);
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
        gridpaneatas.setPadding(new Insets(20, 20, 20, 20)); // mengatur jarak dari scene

        // Button back & gambarnya
        Image url1 = new Image("https://cdn.pixabay.com/photo/2013/03/29/13/39/arrow-97608_640.png");
        ImageView logokembali = new ImageView(url1);
        logokembali.setImage(url1);
        logokembali.setFitHeight(35);
        logokembali.setFitWidth(35);

        Button back = new Button("Back", logokembali);
        back.setFont(new Font("Forte", 20));
        back.setStyle("-fx-background-radius: 20; -fx-cursor: hand;");
        back.setOnAction(e -> {
            menuUtama();
        });
        gridpaneatas.add(back, 0, 0);
        GridPane.setHalignment(back, HPos.CENTER);

        Image url2 = new Image("https://cdn.pixabay.com/photo/2015/08/27/10/14/symbol-909831_640.png");
        ImageView logoclear = new ImageView(url2);
        logoclear.setImage(url2);
        logoclear.setFitHeight(35);
        logoclear.setFitWidth(35);

        Button clear = new Button("Clear", logoclear);
        clear.setFont(new Font("Forte", 20));
        clear.setStyle("-fx-background-radius: 20; -fx-cursor: hand;");
        clear.setOnAction(e -> {
            sceneMenu();
        });
        gridpaneatas.add(clear, 1, 0);
        GridPane.setValignment(clear, VPos.CENTER);

        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #5F9EA0;");
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(gridpaneatas);

        hargaPencucian = new HashMap<>();
        hargaPencucian.put("Normal Wash\nRp", 10.0);
        hargaPencucian.put("Deep Clean", 15.0);
        hargaPencucian.put("Dry Clean", 20.0);
        hargaPencucian.put("Suede Cleaning", 25.0);

        jumlahKlik = new HashMap<>();
        jumlahKlik.put("Normal Wash\nRp", 0);
        jumlahKlik.put("Deep Clean", 0);
        jumlahKlik.put("Dry Clean", 0);
        jumlahKlik.put("Suede Cleaning", 0);

        // Membuat layout utama
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        // Menambahkan judul
        Label titleLabel = new Label("Jenis Pencucian");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        root.getChildren().add(titleLabel);

        // Menambahkan grid pane untuk menu pencucian
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);

        // Menambahkan menu-menu pencucian
        int rowIndex = 0;
        int columnIndex = 0;

        for (String jenisPencucian : hargaPencucian.keySet()) {
            // Membuat ikon gambar untuk setiap jenis pencucian
            Image url1Image = new Image("https://cdn.pixabay.com/photo/2013/03/29/13/39/arrow-97608_640.png");
            ImageView imageView = new ImageView(url1Image);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);

            // Membuat button untuk setiap jenis pencucian
            Button button = new Button(jenisPencucian, imageView);
            Label jumlahKlikLabel = new Label("0");
            HBox buttonBox = new HBox(5);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.getChildren().addAll(button, jumlahKlikLabel);
            button.setOnAction(event -> {
                int jumlahKlik = jumlahKlik.get(jenisPencucian);
    jumlahKlik++;
    jumlahKlikLabel.setText(String.valueOf(jumlahKlik));
    jumlahKlik.put(jenisPencucian, jumlahKlik);

    // Perbarui tampilan button
    button.setStyle("-fx-background-color: #00A9A6" + "; -fx-background-radius: 10;");
    tambahHarga(hargaPencucian.get(jenisPencucian));
});

            // Menambahkan button ke dalam grid pane
            gridPane.add(buttonBox, columnIndex, rowIndex);

            // Mengatur indeks baris dan kolom
            columnIndex++;
            if (columnIndex == 3) {
                columnIndex = 0;
                rowIndex++;
            }
        }

        // Menambahkan grid pane ke dalam layout utama
        root.getChildren().add(gridPane);

        // Menambahkan label total harga
        Label totalLabel = new Label("Total Harga:");
        totalHargaLabel = new Label("0.0");
        totalHargaLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox totalHargaBox = new HBox(10);
        totalHargaBox.getChildren().addAll(totalLabel, totalHargaLabel);
        totalHargaBox.setAlignment(Pos.CENTER);

        root.getChildren().add(totalHargaBox);

        layout.getChildren().add(root);

        Scene scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void tambahHarga(String jenisPencucian) {
        double harga = hargaPencucian.get(jenisPencucian);
        int klik = jumlahKlik.get(jenisPencucian);
        klik++;
        jumlahKlik.put(jenisPencucian, klik);
        totalHarga += harga;
        totalHargaLabel.setText(String.format("%.2f", totalHarga));
        System.out.println("Jenis Pencucian: " + jenisPencucian);

    }

   
}
