/*
====================================================
TUGAS OOP PLAYLIST MUSIK
Nama Kelompok :
1. Arti Suryaning Tyas - (NIM)
2. Alviyan Syafriansyah Matondang - (NIM)
3. Hilman Permana - 2902727532
4. Andika Indra Kirana - 2602204405

Program : Sistem Manajemen Playlist Musik
====================================================
*/

// Class Lagu untuk merepresentasikan setiap lagu dalam playlist
class Lagu {

    // Atribut lagu (enkapsulasi → private)
    private String judul;
    private String artis;
    private double durasi;

    // Constructor untuk menginisialisasi objek Lagu
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter untuk mengambil judul lagu
    public String getJudul() {
        return judul;
    }

    // Setter untuk mengubah judul lagu
    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter untuk mengambil nama artis
    public String getArtis() {
        return artis;
    }

    // Setter untuk mengubah nama artis
    public void setArtis(String artis) {
        this.artis = artis;
    }

    // Getter untuk mengambil durasi lagu
    public double getDurasi() {
        return durasi;
    }

    // Setter untuk mengubah durasi lagu
    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    // Method untuk menampilkan informasi lengkap lagu
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
        System.out.println("--------------------------");
    }
}


class User {
    private String nama;
    private String email;
    private String password;
    private String akses; // Akses pengguna (misalnya: "admin", "user")

    public User(String nama, String email, String password, String akses) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.akses = akses;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    // Method untu(k menampilkan informasi akses pengguna
    public void tampilkanAkses(){
        System.out.println("Nama User : " + nama);
        System.out.println("Akses User : " + akses);
        System.out.println("--------------------------");
    }
}
// Class Admin sebagai turunan dari User
class Admin extends User {

    public Admin(String nama, String email, String password) {
        super(nama, email, password, "Admin");
    }
    // Override method dari class User
    @Override
    public void tampilkanAkses(){
        System.out.println("Admin memiliki akses untuk menambahkan lagu.");
    }

    // Method menambahkan lagu
    public void tambahLagu(Lagu[] playlist, Lagu laguBaru, int index) {

        if (index < playlist.length) {
            playlist[index] = laguBaru;
            System.out.println("Admin menambahkan lagu: " + laguBaru.getJudul());
        } else {
            System.out.println("Playlist sudah penuh.");
        }
    }
}

// Class utama untuk menjalankan program
public class PlaylistOOP {

    public static void main(String[] args) {

        // Array untuk menyimpan kumpulan lagu (playlist)
        Lagu[] playlist = new Lagu[7];

        // Menambahkan lagu ke dalam playlist
        playlist[0] = new Lagu("Hati-Hati di Jalan", "Tulus", 4.2);
        playlist[1] = new Lagu("Sial", "Mahalini", 4.0);
        playlist[2] = new Lagu("Komang", "Raim Laode", 3.9);
        playlist[3] = new Lagu("Tak Segampang Itu", "Anggi Marito", 4.1);
        playlist[4] = new Lagu("Melukis Senja", "Budi Doremi", 4.3);

        // Admin menambahkan lagu
        Admin admin = new Admin("Admin", "Admin@gmail.com", "123");
        
        admin.tampilkanAkses();
        
        admin.tambahLagu(playlist, new Lagu("Evaluasi", "Hindia", 4.5),5);
        admin.tambahLagu(playlist, new Lagu("Blue", "Yung kai", 3.8),6);
        System.out.println();

        // Menampilkan semua lagu dalam playlist
        System.out.println("=== PLAYLIST LAGU ===");

        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                playlist[i].tampilkanInfo();
            }
        }
    }
}
