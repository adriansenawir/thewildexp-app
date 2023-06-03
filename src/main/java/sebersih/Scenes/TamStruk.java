package sebersih.Scenes;

import java.time.LocalDate;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sebersih.model.DateExt;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TamStruk {
    private int totalHarga;
    private Stage primaryStage;
    private String userName;

    public TamStruk(Stage primaryStage, int totalHarga){
        this.primaryStage = primaryStage;
        this.totalHarga = totalHarga;
    }

    public void show(String userName){
        this.userName = userName;
        // Membuat tampilan struk seperti kertas
        StackPane stackPane = new StackPane();
        GridPane strukPane = new GridPane();

        Image bgImage = new Image("/image/logosebersihB&W.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setFitWidth(100);
        bgImageView.setFitHeight(100);
        bgImageView.setPreserveRatio(true);

        stackPane.getChildren().add(bgImageView);
        StackPane.setAlignment(bgImageView, Pos.CENTER);

        strukPane.add(stackPane, 0, 0);
        GridPane.setMargin(stackPane, new Insets(0, 0, 20, 0));

        strukPane.setAlignment(Pos.TOP_CENTER);
        strukPane.setHgap(10);
        strukPane.setVgap(10);
        strukPane.setPadding(new Insets(20));

        // Judul struk
        Label judulLabel = new Label("SEBERSIH SHOES & CARE");
        judulLabel.setFont(new Font("Arial", 15));
        judulLabel.setStyle("-fx-font-weight: bold; ");
        strukPane.add(judulLabel, 0, 1, 2, 1);

        // Alamat
        Label alamatLabel = new Label("BTP BLOK AB. 90\nMakassar\n0896 0212 8837");
        alamatLabel.setFont(new Font("Arial", 15));
        strukPane.add(alamatLabel, 0, 2, 2, 1);

        // Tanggal
        DateExt dateExt = new DateExt(null);
        Label tanggalLabel = new Label("Tanggal: " + dateExt.getTanggalSekarang());
        tanggalLabel.setFont(new Font("Arial", 15));
        strukPane.add(tanggalLabel, 0, 3, 2, 1);

        //nama kasir
        Label namaKasir = new Label("Kasir : "+userName);
        namaKasir.setFont(new Font("Arial", 15));
        namaKasir.setStyle("-fx-font-weight: bold; ");
        strukPane.add(namaKasir, 0, 4, 2, 1);

        // Daftar pembelian
        Label daftarLabel = new Label("Daftar Pembelian:");
        daftarLabel.setFont(new Font("Arial", 15));
        daftarLabel.setStyle("-fx-font-weight: bold; ");
        strukPane.add(daftarLabel, 0, 5, 2, 1);

        // List pembelian

        // Total pembelian
        Label totalLabel = new Label("Total: Rp." + totalHarga);
        totalLabel.setFont(new Font("Arial", 15));
        totalLabel.setStyle("-fx-font-weight: bold; ");
        strukPane.add(totalLabel, 0, 6, 2, 1);

        // Button OK
        Button okButton = new Button("OK CETAK");
        okButton.setStyle("-fx-cursor: hand;-fx-background-color: #105A86;-fx-text-fill: white;");
        okButton.setOnAction(e -> {
            pdfkan();
        });
        strukPane.add(okButton, 0, 7, 2, 1);
        GridPane.setHalignment(okButton, HPos.CENTER);

        // Membuat tampilan struk sebagai scene baru
        Scene strukScene = new Scene(strukPane, 300, 450);
        Stage strukStage = new Stage();
        strukStage.initModality(Modality.APPLICATION_MODAL); 
        strukStage.setTitle("Struk Pembelian");
        strukStage.setScene(strukScene);
        strukStage.show();
    }

    
    public void pdfkan() {
        // Membuat struk dengan PDF
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("SEBERSIH SHOES & CARE");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 15);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 670);
            contentStream.showText("BTP BLOK AB. 90");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 15);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 650);
            contentStream.showText("MAKASSAR");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 15);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 630);
            contentStream.showText("0896 0212 8837");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 600);
            contentStream.showText("Tanggal: " + LocalDate.now().toString());
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 570);
            contentStream.showText("Kasir: " + userName);
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 540);
            contentStream.showText("Daftar Pembelian:");
            contentStream.endText();

            // Menambahkan daftar pembelian dan total ke PDF

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 510);
            contentStream.showText("Total: Rp." + totalHarga);
            contentStream.endText();

            contentStream.close();

            // Menyimpan file PDF
            document.save("struk.pdf");
            document.close();
            System.out.println("Kamu berhasil mencetaknya");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
