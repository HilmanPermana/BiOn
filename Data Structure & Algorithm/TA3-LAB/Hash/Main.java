import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SistemParkir parkir = new SistemParkir();

        int pilihan;

        do {

            System.out.println("\n===== SISTEM DATA PARKIR =====");
            System.out.println("1. Kendaraan Masuk");
            System.out.println("2. Kendaraan Keluar");
            System.out.println("3. Cari Kendaraan");
            System.out.println("4. Tampilkan Semua Kendaraan");
            System.out.println("5. Hitung Total Kendaraan");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.print("Masukkan Nomor Plat: ");
                    String plat = input.nextLine();

                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String jenis = input.nextLine();

                    System.out.print("Masukkan Nama Pemilik: ");
                    String pemilik = input.nextLine();

                    Kendaraan kendaraan = new Kendaraan(plat, jenis, pemilik);

                    parkir.kendaraanMasuk(kendaraan);

                    break;

                case 2:

                    System.out.print("Masukkan Nomor Plat: ");
                    plat = input.nextLine();

                    parkir.kendaraanKeluar(plat);

                    break;

                case 3:

                    System.out.print("Masukkan Nomor Plat: ");
                    plat = input.nextLine();

                    parkir.cariKendaraan(plat);

                    break;

                case 4:

                    parkir.tampilkanSemuaKendaraan();

                    break;

                case 5:

                    parkir.totalKendaraan();

                    break;

                case 0:

                    System.out.println("Program selesai.");
                    break;

                default:

                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}