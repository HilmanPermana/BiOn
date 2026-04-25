package Perpustakaan;
/*
    Program Pengelolaan Daftar Buku Perpustakaan
    Hilman Permana - 2902727532
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        LinkedList daftarBuku = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("====== SISTEM DATA BUKU ======");
            System.out.println("Menu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch(pilih){
                case 1:
                    while(!daftarBuku.minLimaBuku()){
                        System.out.println("Minimal 5 Buku harus ditambahkan");
                        System.out.print("Masukkan Kode Buku: ");
                        String kode = scanner.nextLine();
                        daftarBuku.kodeValid(kode);
                        if(!daftarBuku.kodeValid(kode)){
                            System.out.println("Kode Buku Maksimal 5 Karakter. Silahkan input ulang.");
                            break;
                        }
                        System.out.print("Masukkan Judul : ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan Penulis: ");
                        String penulis = scanner.nextLine();
                        daftarBuku.tambah(kode, judul, penulis);
                    }
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    daftarBuku.kodeValid(kode);
                    if(!daftarBuku.kodeValid(kode)){
                        System.out.println("Kode Buku Maksimal 5 Karakter. Silahkan input ulang.");
                        break;
                    }
                    System.out.print("Masukkan Judul : ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    daftarBuku.tambah(kode, judul, penulis);
                    break;
                case 2:
                    if(!daftarBuku.minLimaBuku()){
                        System.out.println("Minimal 5 Buku harus ditambahkan sebelum dapat menghapus buku.");
                        break;
                    }else {
                        System.out.print("Masukkan kode buku yang ingin dihapus: ");
                        String kodeHapus = scanner.nextLine();
                        daftarBuku.hapus(kodeHapus);
                        break;
                    }
                case 3:
                    if(!daftarBuku.minLimaBuku()){
                        System.out.println("Minimal 5 Buku harus ditambahkan sebelum dapat menampilkan buku.");
                        break;
                    } else {
                        System.out.print("Masukkan kode buku yang ingin dicari: ");
                        String kodeCari = scanner.nextLine();
                        daftarBuku.cari(kodeCari);
                        break;
                    }
                case 4:
                    if(!daftarBuku.minLimaBuku()){
                        System.out.println("Minimal 5 Buku harus ditambahkan sebelum dapat menghapus buku.");
                        break;
                    } else {
                        daftarBuku.tampil();
                        break;
                    }
                case 5:
                    System.out.println("Terima Kasih Telah Menggunakan Sistem Data Buku Perpustakaan");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silahkan pilih menu yang tersedia.");
            }
        } while(true);
    }
}
