public class Kendaraan {

    private String nomorPlat;
    private String jenisKendaraan;
    private String pemilik;

    // Constructor
    public Kendaraan(String nomorPlat, String jenisKendaraan, String pemilik) {
        this.nomorPlat = nomorPlat;
        this.jenisKendaraan = jenisKendaraan;
        this.pemilik = pemilik;
    }

    // Getter
    public String getNomorPlat() {
        return nomorPlat;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public String getPemilik() {
        return pemilik;
    }

    // Menampilkan data kendaraan
    @Override
    public String toString() {
        return "Plat: " + nomorPlat +
               ", Jenis: " + jenisKendaraan +
               ", Pemilik: " + pemilik;
    }
}