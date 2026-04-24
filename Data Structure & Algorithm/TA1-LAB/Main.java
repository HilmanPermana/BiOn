// Anggota Kelompok

// 1. Andika Indra Kirana (2602204405)
// 2. Alviyan Syafriansyah Matondang (2902730565)
// 3. Arti Suryaning Tyas (2902724341)
// 4. Hilman Permana (2902727532)


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue antrean = new Queue(); // Membuat objek Queue
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTREAN CUSTOMER SERVICE ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input.nextLine();
                    antrean.enqueue(nama);
                    break;

                case 2:
                    antrean.dequeue();
                    break;

                case 3:
                    antrean.display();
                    break;

                case 4:
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 4);

        // Tutup Scanner (menghindari resource leak)
        input.close();
    }
}
