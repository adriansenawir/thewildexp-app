package sebersih.model;

public abstract class DateAbs {
    private String tanggal;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public DateAbs(String tanggal) {
        this.tanggal = tanggal;
    }

    public abstract String getTanggalSekarang();
}
