/**
 * TUGAS KELOMPOK 2 - ARRAYS AND ITS OPERATIONS
 * Nama Kelompok:
 * 1. [Alviyan Syafriansah Matondang] - [2902730565]
 * 2. [Andika Indra Kirana] - [2602204405]
 * 3. [Arti Suryaning Tyas] - [2902724341]
 * 4. [Hilman Permana] – [2902727532]
 * 
 * Kelas: LUCA - LEC  
 * Mata Kuliah: Data Structures
 * ================================================
 */

public class Lagu {
    // Atribut dari class Lagu
    private String judul;
    private String artis;
    private int durasi; // dalam detik

    // Constructor untuk inisialisasi objek Lagu
    public Lagu(String judul, String artis, int durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Getter untuk artis
    public String getArtis() {
        return artis;
    }

    // Getter untuk durasi
    public int getDurasi() {
        return durasi;
    }

    // Method untuk mengkonversi durasi dari detik ke format mm:ss
    public String getDurasiFormatted() {
        int menit = durasi / 60;
        int detik = durasi % 60;
        return String.format("%d:%02d", menit, detik);
    }

    // Method untuk menampilkan informasi lagu
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + getDurasiFormatted());
    }
}
