/*
====================================================
TUGAS OOP PLAYLIST MUSIK
Nama Kelompok :
1. Arti Suryaning Tyas - 2902724341
2. Alviyan Syafriansyah Matondang - 2902730565
3. Hilman Permana - 2902727532
4. Andika Indra Kirana - 2602204405

Program : Sistem Manajemen Playlist Musik
====================================================
*/

// Class Lagu untuk merepresentasikan setiap lagu dalam playlist

import java.util.Scanner;

// Class Lagu
class Lagu {

    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }

    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
        System.out.println("--------------------------");
    }
}


// Class User
class User {

    private String nama;
    private String email;
    private String password;
    private String akses;

    public User(String nama, String email, String password, String akses) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.akses = akses;
    }

    public void tampilkanAkses(){
        System.out.println("Nama User : " + nama);
        System.out.println("Akses User : " + akses);
        System.out.println("--------------------------");
    }
}


// Class Admin
class Admin extends User {

    public Admin(String nama, String email, String password) {
        super(nama, email, password, "Admin");
    }

    @Override
    public void tampilkanAkses(){
    }

    public void tambahLagu(Lagu[] playlist, Lagu laguBaru, int index) {

        if (index < playlist.length && playlist[index] == null) {
            playlist[index] = laguBaru;
            System.out.println("Lagu berhasil ditambahkan: " + laguBaru.getJudul());
        } else {
            System.out.println("Slot playlist sudah terisi atau index tidak valid.");
        }
    }
}


// Class Member
class Member extends User {

    public Member(String nama, String email, String password) {
        super(nama, email, password, "Member");
    }

    @Override
    public void tampilkanAkses(){
        System.out.println("Member hanya dapat melihat playlist.");
    }

    public void lihatPlaylist(Lagu[] playlist) {

        System.out.println("=== PLAYLIST UNTUK MEMBER ===");

        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                playlist[i].tampilkanInfo();
            }
        }
    }
}


// Class Main
public class PlaylistOOP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Lagu[] playlist = new Lagu[7];

        playlist[0] = new Lagu("Hati-Hati di Jalan", "Tulus", 4.2);
        playlist[1] = new Lagu("Sial", "Mahalini", 4.0);
        playlist[2] = new Lagu("Komang", "Raim Laode", 3.9);
        playlist[3] = new Lagu("Tak Segampang Itu", "Anggi Marito", 4.1);
        playlist[4] = new Lagu("Melukis Senja", "Budi Doremi", 4.3);

        boolean jalan = true;

        while (jalan) {

            System.out.println("\n===== LOGIN SISTEM PLAYLIST =====");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Keluar");
            System.out.print("Pilih login: ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {

                Admin admin = new Admin("Admin", "admin@gmail.com", "123");
                admin.tampilkanAkses();

                boolean menuAdmin = true;

                while (menuAdmin) {

                    System.out.println("\n===== MENU ADMIN =====");
                    System.out.println("1. Tambah Lagu");
                    System.out.println("2. Lihat Playlist");
                    System.out.println("3. Back");
                    System.out.print("Pilih menu: ");
                    int menu = input.nextInt();
                    input.nextLine();

                    if (menu == 1) {

                        System.out.print("Masukkan Judul Lagu: ");
                        String judul = input.nextLine();

                        System.out.print("Masukkan Artis: ");
                        String artis = input.nextLine();

                        System.out.print("Masukkan Durasi (menit): ");
                        double durasi = input.nextDouble();

                        System.out.print("Masukkan index playlist (0-6): ");
                        int index = input.nextInt();
                        input.nextLine();

                        Lagu laguBaru = new Lagu(judul, artis, durasi);
                        admin.tambahLagu(playlist, laguBaru, index);
                    }

                    else if (menu == 2) {

                        System.out.println("\n=== PLAYLIST ===");

                        for (Lagu lagu : playlist) {
                            if (lagu != null) {
                                lagu.tampilkanInfo();
                            }
                        }
                    }

                    else if (menu == 3) {
                        menuAdmin = false;
                    }

                    else {
                        System.out.println("Menu tidak tersedia.");
                    }

                }

            }

            else if (pilihan == 2) {

                Member member = new Member("User", "user@gmail.com", "123");

                member.tampilkanAkses();
                member.lihatPlaylist(playlist);

                System.out.println("Tekan enter untuk kembali...");
                input.nextLine();
            }

            else if (pilihan == 3) {

                jalan = false;
                System.out.println("Program selesai.");

            }

            else {
                System.out.println("Pilihan tidak tersedia.");
            }

        }

    }
}
