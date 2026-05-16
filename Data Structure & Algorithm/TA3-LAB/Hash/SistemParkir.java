import java.util.HashMap;
import java.util.Map;

public class SistemParkir {

    // Hash Table
    private HashMap<String, Kendaraan> dataParkir;

    // Constructor
    public SistemParkir() {
        dataParkir = new HashMap<>();
    }

    // Kendaraan masuk
    public void kendaraanMasuk(Kendaraan kendaraan) {

        if (dataParkir.containsKey(kendaraan.getNomorPlat())) {
            System.out.println("Kendaraan sudah berada di area parkir.");
        } else {
            dataParkir.put(kendaraan.getNomorPlat(), kendaraan);
            System.out.println("Kendaraan berhasil masuk.");
        }
    }

    // Kendaraan keluar
    public void kendaraanKeluar(String nomorPlat) {

        if (dataParkir.containsKey(nomorPlat)) {
            dataParkir.remove(nomorPlat);
            System.out.println("Kendaraan berhasil keluar.");
        } else {
            System.out.println("Kendaraan tidak ditemukan.");
        }
    }

    // Cari kendaraan
    public void cariKendaraan(String nomorPlat) {

        Kendaraan kendaraan = dataParkir.get(nomorPlat);

        if (kendaraan != null) {
            System.out.println("Data kendaraan ditemukan:");
            System.out.println(kendaraan);
        } else {
            System.out.println("Kendaraan tidak ditemukan.");
        }
    }

    // Tampilkan semua kendaraan
    public void tampilkanSemuaKendaraan() {

        if (dataParkir.isEmpty()) {
            System.out.println("Area parkir kosong.");
            return;
        }

        System.out.println("\n=== DATA KENDARAAN PARKIR ===");

        for (Map.Entry<String, Kendaraan> entry : dataParkir.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Hitung total kendaraan
    public void totalKendaraan() {
        System.out.println("Total kendaraan parkir: " + dataParkir.size());
    }
}