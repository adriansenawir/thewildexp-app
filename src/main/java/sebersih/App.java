package sebersih;

import javafx.application.Application;
import javafx.stage.Stage;
import sebersih.Scenes.Login;



public class App extends Application {
    // private Stage primaryStage;
    // private int totalHarga = 0;
    // private Label totalLabel;
    // private String namaDaftar11;
    // String namaDaftar11;

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

    // private void menuUtama() {
    //     // label kasir
    //     Label labelkasir = new Label("KASIR");
    //     labelkasir.setFont(new Font("ROCKWELL", 50));
    //     labelkasir.setStyle("-fx-font-weight: bold; ");
    //     labelkasir.setAlignment(Pos.TOP_CENTER);

    //     // logo
    //     InputStream inputstream = getClass().getResourceAsStream("/image/logosebersih.png");
    //     Image url = new Image(inputstream);
    //     ImageView logo = new ImageView(url);
        
    //     // logo.setImage(url);
    //     logo.setFitHeight(200);
    //     logo.setFitWidth(200);

    //     // label sebersih
    //     Label labelsebersih = new Label("''Berusahalah untuk tidak menjadi sukses\ntapi berusahalah untuk menjadi bernilai''");
    //     labelsebersih.setFont(new Font(14));
    //     labelsebersih.setStyle("-fx-font-weight: bold; ");
    //     labelsebersih.setAlignment(Pos.TOP_CENTER);

    //     // // image & button keranjang
    //     // InputStream inputlogo = getClass().getResourceAsStream("/image/keranjang.png");
    //     // Image url1 = new Image(inputlogo);
    //     // ImageView logo1 = new ImageView(url1);

    //     // logo1.setFitHeight(100);
    //     // logo1.setFitWidth(100);

    //     // Button keranjang = new Button("MASUK", logo1);
    //     // keranjang.setFont(new Font("Forte", 15));
    //     // keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 480; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
    //     // keranjang.setAlignment(Pos.CENTER);
    //     // keranjang.setOnMouseEntered(e -> {
    //     //     keranjang.setStyle("-fx-background-color: #000000;-fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
    //     // });
    //     // keranjang.setOnMouseExited(e -> {
    //     //     keranjang.setStyle("-fx-background-color: #BB9F31; -fx-background-radius: 180; -fx-pref-width: 180px; -fx-pref-height: 180px; -fx-cursor: hand;");
    //     // });
    //     // keranjang.setOnAction(e -> {
    //     //     sceneMenu();
    //     // });

        
    //     // Button keranjang = new Button();
    //     // // keranjang.setFont(new Font("Forte", 15));
    //     // keranjang.setGraphic(logo1);
    //     // keranjang.setStyle("-fx-background-color: #105A86; -fx-background-radius: 480; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
    //     // keranjang.setAlignment(Pos.CENTER);
    //     // keranjang.setOnMouseEntered(e -> {
    //     //     keranjang.setStyle("-fx-background-color: #000000;-fx-background-radius: 180; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
    //     // });
    //     // keranjang.setOnMouseExited(e -> {
    //     //     keranjang.setStyle("-fx-background-color: #105A86; -fx-background-radius: 180; -fx-pref-width: 50px; -fx-pref-height: 50px; -fx-cursor: hand;");
    //     // });
    //     // login.setOnAction(e -> {
    //     //     sceneMenu();
    //     // });

    //     // TextFields for username and password
    //     Label usernameLabel = new Label("Username:");
    //     TextField usernameField = new TextField();
    //     usernameField.setPromptText("Username");
    //     usernameField.setPrefWidth(150);

    //     Label passwordLabel = new Label("Password:");
    //     PasswordField passwordField = new PasswordField();
    //     passwordField.setPromptText("Password");
    //     passwordField.setPrefWidth(150);
        
    //     HBox usernameLayout = new HBox();
    //     usernameLayout.getChildren().addAll(usernameLabel,usernameField);
    //     usernameLayout.setSpacing(10);
    //     usernameLayout.setAlignment(Pos.CENTER);

    //     HBox passwordLayout = new HBox();
    //     passwordLayout.getChildren().addAll(passwordLabel, passwordField);
    //     passwordLayout.setSpacing(10);
    //     passwordLayout.setAlignment(Pos.CENTER);

    //     Button login = new Button("LOGIN");
    //     login.setFont(new Font("Retro Warmth", 15));
    //     login.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
    //     login.setAlignment(Pos.CENTER);
    //     login.setOnMouseEntered(e -> {
    //         login.setStyle("-fx-background-color: #1E90FF;-fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
    //     });
    //     login.setOnMouseExited(e -> {
    //         login.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000; -fx-border-width: 1px;");
    //     });

    //     // logo1.setFitHeight(50);
    //     // logo1.setFitWidth(50);
    //     login.setOnAction(e -> { String usernameInput = usernameField.getText() ; String passwordInput = passwordField.getText();
    //         try {
    //             int passwordInt = Integer.parseInt(passwordInput);
    //             if (usernameInput.matches("[a-zA-Z]+") && passwordInt >= 0) {
    //                 sceneMenu();
    //             } else {
    //                 Alert alert = new Alert(Alert.AlertType.ERROR);
    //                 alert.setTitle("Login Failed");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("Invalid username or password. Please try again.");
    //                 alert.showAndWait();
    //             }
    //         } catch (NumberFormatException ex) {
    //             // If the password is not an integer, show an error message
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("Login Failed");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Password must be an Integer. Please try again.");
    //             alert.showAndWait();
    //         }
    //     });

    //     // Tombol daftar
    //     Button daftar = new Button("DAFTAR");
    //     daftar.setFont(new Font("Retro Warmth", 15));
    //     daftar.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand;  -fx-border-color: #000000;");
    //     daftar.setAlignment(Pos.CENTER);
    //     daftar.setOnMouseEntered(e -> {
    //         daftar.setStyle("-fx-background-color: #1E90FF;-fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand;  -fx-border-color: #000000;");
    //     });
    //     daftar.setOnMouseExited(e -> {
    //         daftar.setStyle("-fx-background-color: #1E90FF; -fx-background-radius: 0; -fx-pref-width: 120px; -fx-pref-height: 30px; -fx-cursor: hand; -fx-border-color: #000000;");
    //     });
        
    //     // VBox daftarLayout = new VBox();
        
    //         daftar.setOnAction(e -> {
    //         VBox daftarLayout = new VBox(); // create a new layout container

    //         Label label = new Label("Silakan isi formulir pendaftaran");
    //         label.setFont(new Font("Retro Warmth", 20));
    //         label.setAlignment(Pos.CENTER);
    //         daftarLayout.getChildren().add(label);

    //         TextField namaField = new TextField();
    //         namaField.setPromptText("Nama Lengkap");
    //         daftarLayout.getChildren().add(namaField);

    //         TextField emailField = new TextField();
    //         emailField.setPromptText("Email");
    //         daftarLayout.getChildren().add(emailField);

    //         Button submitButton = new Button("Submit");
    //         submitButton.setOnAction(event -> {
    //             String nama = namaField.getText();
    //             String email = emailField.getText();

    //             if (!nama.isEmpty() && !email.isEmpty()) {
    //                 // proses input dan submit data ke server

    //                 // kembali ke halaman sebelumnya setelah sukses submit
    //                 Stage stage = (Stage) submitButton.getScene().getWindow();
    //                 stage.close();
    //             } else {
    //                 // handle error when fields are empty
    //                 Alert alert = new Alert(AlertType.ERROR);
    //                 alert.setTitle("Error");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("Mohon lengkapi semua kolom");

    //                 alert.showAndWait();
    //             }
    //         });
    //         daftarLayout.getChildren().add(submitButton);

    //         Scene newScene = new Scene(daftarLayout, 400, 600); // use the layout container as the scene root
    //     });

    //     // // Menambahkan tombol daftar
        
    //     // daftarLayout.getChildren().addAll(daftar);
    //     // daftarLayout.setAlignment(Pos.CENTER);

    //     // // Membuat halaman daftar
    //     // VBox daftarLayout = new VBox();
    //     // daftarLayout.setSpacing(10);


    //     // registrationScene.setRoot(daftarLayout)= new Scene(daftarLayout);
    //     // Stage stage = (Stage) daftar.getScene().getWindow();
    //     // stage.setScene(registrationScene);


    // // membuat ketentuan tampilan
    //     VBox layout = new VBox();
    //     layout.setStyle("-fx-background-color: #CACDCB; ");
    //     layout.setAlignment(Pos.TOP_CENTER);
    //     layout.setSpacing(20);
    //     layout.getChildren().addAll(labelkasir, logo, labelsebersih, usernameLayout, passwordLayout, login, daftar);
    //     Scene scene = new Scene(layout, 400, 600);
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }
    
    // public void sceneMenu() {
    //     // transaksi top
    //     GridPane palingatas = new GridPane();
    //     palingatas.setAlignment(Pos.TOP_LEFT);
    //     palingatas.setPadding(new Insets(10));
    //     palingatas.setStyle("-fx-background-color: #A1ABB6");
    //     palingatas.setPrefWidth(400);
    //     palingatas.setHgap(10);
        
    //     Label labeltransaksi = new Label("TRANSAKSI BARU");
    //     labeltransaksi.setFont(new Font(15));
    //     labeltransaksi.setStyle("-fx-font-family: Fire wall; -fx-font-weight: bold; ");
    //     palingatas.add(labeltransaksi, 2,2);

    //     InputStream inputlogouser = getClass().getResourceAsStream("/image/user.png");
    //     Image urluser = new Image(inputlogouser);
    //     ImageView logouser = new ImageView(urluser);
    //     logouser.setFitHeight(20);
    //     logouser.setFitWidth(20);
    //     palingatas.add(logouser, 20,2);

    //     // bentuk yang bersampingan
    //     GridPane gridpaneatas = new GridPane();
    //     gridpaneatas.setAlignment(Pos.TOP_CENTER);
    //     gridpaneatas.setHgap(160); // mengatur jarak dari sel horizontal (BACK & CLEAR)
    //     gridpaneatas.setVgap(15); // mengatur jarak dari sel vertikal
    //     gridpaneatas.setPadding(new Insets(20, 20, 5, 20)); // mengatur jarak dari scene

    //     // Button back & gambarnya
    //     InputStream inputLogoBack = getClass().getResourceAsStream("/image/back.png");
    //     Image url1 = new Image(inputLogoBack);
    //     ImageView logokembali = new ImageView(url1);
    //     logokembali.setImage(url1);
    //     logokembali.setFitHeight(25);
    //     logokembali.setFitWidth(25);

    //     Button back = new Button("Back", logokembali);
    //     back.setFont(new Font("Forte", 15));
    //     back.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86; ");
    //     back.setOnAction(e -> {
    //         menuUtama();
    //     });
    //     gridpaneatas.add(back, 0, 0);
    //     GridPane.setHalignment(back, HPos.CENTER);

    //     InputStream inputLogoClear = getClass().getResourceAsStream("/image/clear.png");
    //     Image url2 = new Image(inputLogoClear);
    //     ImageView logoclear = new ImageView(url2);
    //     logoclear.setImage(url2);
    //     logoclear.setFitHeight(25);
    //     logoclear.setFitWidth(25);

    //     Button clear = new Button("Clear", logoclear);
    //     clear.setFont(new Font("Forte", 15));
    //     clear.setStyle("-fx-background-radius: 15; -fx-text-fill: white; -fx-cursor: hand; -fx-background-color: #105A86; ");
    //     clear.setOnAction(e -> {
    //         totalHarga = 0;
    //         sceneMenu();
    //     });
    //     gridpaneatas.add(clear, 1, 0);
    //     GridPane.setValignment(clear, VPos.CENTER);

    //     // List 1
    //     GridPane daftar1 = new GridPane();
    //     daftar1.setAlignment(Pos.TOP_LEFT);
    //     daftar1.setHgap(150);
    //     daftar1.setVgap(15);
    //     daftar1.setPadding(new Insets(30, 20, 20, 39));

    //     Label namaDaftar1 = new Label("Clean Wash Easy \n Rp. 30.000");
    //     namaDaftar1.setFont(new Font("ROCKWELL", 15));
    //     namaDaftar1.setStyle("-fx-font-weight: bold; -fx-cursor: hand;");
    //     namaDaftar1.setAlignment(Pos.TOP_LEFT);
    //     daftar1.add(namaDaftar1, 0, 0);
    //     GridPane.setHalignment(namaDaftar1, HPos.CENTER);

    //     //

    //     Button hargaButton1 = createHargaButton(30000, namaDaftar1);
    //     hargaButton1.setAlignment(Pos.TOP_RIGHT);
    //     daftar1.add(hargaButton1, 1, 0);
    //     GridPane.setValignment(hargaButton1, VPos.CENTER);

    //     //list 2
    //     GridPane daftar2 = new GridPane();
    //     daftar2.setAlignment(Pos.TOP_LEFT);
    //     daftar2.setHgap(150);
    //     daftar2.setVgap(15);
    //     daftar2.setPadding(new Insets(20, 20, 20, 39));

    //     Label namaDaftar2 = new Label("Clean Wash Hard \n Rp. 35.000");
    //     namaDaftar2.setFont(new Font("ROCKWELL", 15));
    //     namaDaftar2.setStyle("-fx-font-weight: bold; -fx-cursor: hand; ");
    //     namaDaftar2.setAlignment(Pos.TOP_LEFT);
    //     daftar2.add(namaDaftar2, 0, 0);
    //     GridPane.setHalignment(namaDaftar2, HPos.CENTER);

    //     Button hargaButton2 = createHargaButton(35000, namaDaftar2);
    //     hargaButton2.setAlignment(Pos.TOP_RIGHT);
    //     daftar2.add(hargaButton2, 1, 0);
    //     GridPane.setValignment(hargaButton2, VPos.CENTER);

    //     //list 3
    //     GridPane daftar3 = new GridPane();
    //     daftar3.setAlignment(Pos.TOP_LEFT);
    //     daftar3.setHgap(193);
    //     daftar3.setVgap(15);
    //     daftar3.setPadding(new Insets(20, 20, 20, 39));

    //     Label namaDaftar3 = new Label("Flash Wash \n Rp. 25.000");
    //     namaDaftar3.setFont(new Font("ROCKWELL", 15));
    //     namaDaftar3.setStyle("-fx-font-weight: bold; -fx-cursor: hand;");
    //     namaDaftar3.setAlignment(Pos.TOP_LEFT);
    //     daftar3.add(namaDaftar3, 0, 0);
    //     GridPane.setHalignment(namaDaftar3, HPos.CENTER);

    //     Button hargaButton3 = createHargaButton(25000, namaDaftar3);
    //     hargaButton3.setAlignment(Pos.TOP_RIGHT);
    //     daftar3.add(hargaButton3, 1, 0);
    //     GridPane.setValignment(hargaButton3, VPos.CENTER);

    //     //list 4
    //     GridPane daftar4 = new GridPane();
    //     daftar4.setAlignment(Pos.TOP_LEFT);
    //     daftar4.setHgap(198);
    //     daftar4.setVgap(15);
    //     daftar4.setPadding(new Insets(20, 20, 20, 39));

    //     Label namaDaftar4 = new Label("Kids Shoes \n Rp. 20.000");
    //     namaDaftar4.setFont(new Font("ROCKWELL", 15));
    //     namaDaftar4.setStyle("-fx-font-weight: bold; -fx-cursor: hand;");
    //     namaDaftar4.setAlignment(Pos.TOP_LEFT);
    //     daftar4.add(namaDaftar4, 0, 0);
    //     GridPane.setHalignment(namaDaftar4, HPos.CENTER);

    //     Button hargaButton4 = createHargaButton(20000, namaDaftar4);
    //     hargaButton4.setAlignment(Pos.TOP_RIGHT);
    //     daftar4.add(hargaButton4, 1, 0);
    //     GridPane.setValignment(hargaButton4, VPos.CENTER);

    //     //info harga button
    //     GridPane total = new GridPane();
    //     total.setAlignment(Pos.BOTTOM_CENTER);
    //     total.getHgap();
    //     total.getVgap();
    //     total.setPadding(new Insets(18, 0, 20, 0));
    //     // total.setStyle("-fx-background-color: #A1ABB6");
        

    //     totalLabel = new Label("Total: Rp." + totalHarga);
    //     totalLabel.setFont(new Font("ARIAL", 20));
    //     totalLabel.setAlignment(Pos.BOTTOM_CENTER);
    //     total.add(totalLabel, 0, 0);
    //     totalLabel.setStyle("-fx-background-color: #A1ABB6; -fx-padding: 10px; -fx-background-radius: 10;");

    //     // Label to display on the receipt
    //     Label strukLabel = new Label();
    //     strukLabel.setFont(new Font("Arial", 15));
    //     strukLabel.setStyle("-fx-font-weight: bold; ");

    //     //button scene ke menu berikutnya
    //     InputStream inputlogosave = getClass().getResourceAsStream("/image/save.png");
    //     Image urlsave = new Image(inputlogosave);
    //     ImageView logo2 = new ImageView(urlsave);
    //     logo2.setFitHeight(50);
    //     logo2.setFitWidth(50);

    //     Button buttoncetak = new Button();
    //     buttoncetak.setStyle("-fx-background-color: #394867; -fx-cursor: hand; ");
    //     buttoncetak.setAlignment(Pos.BOTTOM_CENTER);
    //     buttoncetak.setGraphic(logo2);
    //     buttoncetak.setOnAction(e -> {
    //         struk();
    //     });

    //     //vbox
    //     VBox layout = new VBox();
    //     layout.setStyle("-fx-background-color: #CACDCB;");
    //     layout.setAlignment(Pos.TOP_CENTER);
    //     // layout.setPadding(new Insets(2));
    //     layout.getChildren().addAll(palingatas,gridpaneatas,daftar1,daftar2,daftar3,daftar4, total,buttoncetak);
    //     // layout.setAlignment(Pos.CENTER);

    //     Scene scene = new Scene(layout, 400, 600);

    //     primaryStage.setTitle("Button Harga");
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }

    //     private Button createHargaButton(int harga, Label label) {
    //         InputStream inputlogotambah = getClass().getResourceAsStream("/image/tambah.png");
    //         Image urltambah = new Image(inputlogotambah);
    //         ImageView logotambah = new ImageView(urltambah);
    //         logotambah.setFitHeight(25);
    //         logotambah.setFitWidth(25);

    //         Button hargaButton = new Button();
    //         hargaButton.setGraphic(logotambah);

    //         hargaButton.setOnAction(e -> {
    //             totalHarga += harga;
    //             DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    //             String formattedTotalHarga = decimalFormat.format(totalHarga);
    //             totalLabel.setText("Total: Rp." + formattedTotalHarga);

    //         });
    //         return hargaButton;
    //     }

    // private void struk(){
    //     // Membuat tampilan struk seperti kertas
    //     StackPane stackPane = new StackPane();
    //     GridPane strukPane = new GridPane();

    //     Image bgImage = new Image("/image/logosebersihB&W.png");
    //     ImageView bgImageView = new ImageView(bgImage);
    //     bgImageView.setFitWidth(100);
    //     bgImageView.setFitHeight(100);
    //     bgImageView.setPreserveRatio(true);

    //     stackPane.getChildren().add(bgImageView);
    //     StackPane.setAlignment(bgImageView, Pos.CENTER);

    //     strukPane.add(stackPane, 0, 0);
    //     GridPane.setMargin(stackPane, new Insets(0, 0, 20, 0));

    //     strukPane.setAlignment(Pos.TOP_CENTER);
    //     strukPane.setHgap(10);
    //     strukPane.setVgap(10);
    //     strukPane.setPadding(new Insets(20));

    //     // Judul struk
    //     Label judulLabel = new Label("SEBERSIH SHOES & CARE");
    //     judulLabel.setFont(new Font("Arial", 15));
    //     judulLabel.setStyle("-fx-font-weight: bold; ");
    //     strukPane.add(judulLabel, 0, 1, 2, 1);

    //     // Alamat
    //     Label alamatLabel = new Label("BTP BLOK AB. 90\nMakassar\n0896 0212 8837");
    //     alamatLabel.setFont(new Font("Arial", 15));
    //     strukPane.add(alamatLabel, 0, 2, 2, 1);

    //     // Tanggal
    //     Label tanggalLabel = new Label("Tanggal: " + LocalDate.now().toString());
    //     tanggalLabel.setFont(new Font("Arial", 15));
    //     strukPane.add(tanggalLabel, 0, 3, 2, 1);

    //     // Daftar pembelian
    //     Label daftarLabel = new Label("Daftar Pembelian:");
    //     daftarLabel.setFont(new Font("Arial", 15));
    //     daftarLabel.setStyle("-fx-font-weight: bold; ");
    //     strukPane.add(daftarLabel, 0, 4, 2, 1);

    //     // List pembelian

    //     // Total pembelian
    //     Label totalLabel = new Label("Total: Rp." + totalHarga);
    //     totalLabel.setFont(new Font("Arial", 15));
    //     totalLabel.setStyle("-fx-font-weight: bold; ");
    //     strukPane.add(totalLabel, 0, 5, 2, 1);

    //     // Button OK
    //     Button okButton = new Button("OK CETAK");
    //     okButton.setStyle("-fx-cursor: hand;");
    //     okButton.setOnAction(e -> {
    //         saveStrukToPDF();
    //         menuUtama();
    //         // openPDF();
    //     });
    //     strukPane.add(okButton, 0, 6, 2, 1);
    //     GridPane.setHalignment(okButton, HPos.CENTER);

    //     // Membuat tampilan struk sebagai scene baru
    //     Scene strukScene = new Scene(strukPane, 300, 400);
    //     Stage strukStage = new Stage();
    //     strukStage.setTitle("Struk Pembelian");
    //     strukStage.setScene(strukScene);
    //     strukStage.show();
    // }

//     private void saveStrukToPDF() {
//         // Membuat struk dengan PDF
//         PDDocument document = new PDDocument();
//         PDPage page = new PDPage();
//         document.addPage(page);

//         try {
//             PDPageContentStream contentStream = new PDPageContentStream(document, page);
//             contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 700);
//             contentStream.showText("SEBERSIH SHOES & CARE");
//             contentStream.endText();

//             contentStream.setFont(PDType1Font.HELVETICA, 15);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 670);
//             contentStream.showText("BTP BLOK AB. 90");
//             contentStream.endText();

//             contentStream.setFont(PDType1Font.HELVETICA, 15);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 640);
//             contentStream.showText("MAKASSAR");
//             contentStream.endText();

//             contentStream.setFont(PDType1Font.HELVETICA, 15);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 620);
//             contentStream.showText("0896 0212 8837");
//             contentStream.endText();

//             contentStream.setFont(PDType1Font.HELVETICA, 12);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 600);
//             contentStream.showText("Tanggal: " + LocalDate.now().toString());
//             contentStream.endText();

//             contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 570);
//             contentStream.showText("Daftar Pembelian:");
//             contentStream.endText();

//             // Menambahkan daftar pembelian dan total ke PDF

//             contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
//             contentStream.beginText();
//             contentStream.newLineAtOffset(50, 540);
//             contentStream.showText("Total: Rp." + totalHarga);
//             contentStream.endText();

//             contentStream.close();

//             // Menyimpan file PDF
//             document.save("struk.pdf");
//             document.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

// }