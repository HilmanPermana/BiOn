/*
Anggota Kelompok

1. Andika Indra Kirana (2602204405)
2. Alviyan Syafriansyah Matondang (2902730565)
3. Arti Suryaning Tyas (2902724341)
4. Hilman Permana (2902727532)

 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        LinkedList listMhs = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n=== MENU ===");
            System.out.println("1. Menambah data mahasiswa");
            System.out.println("2. Menampilkan data mahasiswa");
            System.out.println("3. Menghapus data mahasiswa");
            System.out.println("4. Memperbarui nilai mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch(pilihan){
                case 1:
                    System.out.println("1. Menambah data mahasiswa");
                    System.out.println("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.println("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.println("Masukkan Nilai: ");
                    int nilai = scanner.nextInt();
                    scanner.nextLine();
                    listMhs.tambahMhs(nim, nama, nilai);
                    break;
                case 2:
                    System.out.println("2. Menampilkan data mahasiswa");
                    listMhs.tampilMhs();
                    break;
                case 3:
                    System.out.println("3. Menghapus data mahasiswa");
                    System.out.println("Masukkan NIM mahasiswa yang ingi dihapus: ");
                    String nimHapus = scanner.nextLine();
                    listMhs.hapusMhs(nimHapus);
                    break;
                case 4:
                    System.out.println("4. Memperbarui nilai mahasiswa");
                    System.out.println("Masukkan NIM mahasiswa yang ingin diperbarui: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.println("Masukkan nilai baru: ");
                    int nilaiBaru = scanner.nextInt();
                    scanner.nextLine();
                    listMhs.updateNilaiMhs(nimUpdate, null, nilaiBaru);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");}
        }
    }
}