package sebersih.model;

import java.time.LocalDate;

public class DateExt extends DateAbs{

    public DateExt(String tanggal) {
        super(tanggal);
    }

    @Override
    public String getTanggalSekarang() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    
}
