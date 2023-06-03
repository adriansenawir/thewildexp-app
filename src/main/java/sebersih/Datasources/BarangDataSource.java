package sebersih.Datasources;

import java.util.ArrayList;
import java.util.List;

import sebersih.model.Barang;

public class BarangDataSource {
    private static String[] nama = {"Clean Wash Easy", "Clean Wash Hard", "Flash Wash Care ", "Kids Shoes Wash "};

    private static int[] harga = {30000, 35000, 25000,20000};


    public static List<Barang> getListBarang(){
        List<Barang> listBarang = new ArrayList<>();
        for (int i=0;i<nama.length;i++) {
            // String namaBarang = nama[i].replace("\\n", "\n");
            listBarang.add(new Barang(nama[i], harga[i]));
        }
        return listBarang;
    }
}
