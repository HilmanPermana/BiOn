import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Queue antrian = new Queue();
        Stack riwayatTrx = new Stack();
        try (Scanner input = new Scanner(System.in)) {
            int pilih;
            
            do{
                System.out.println("\n=== SISTEM KASIR TOKO ===");
                System.out.println("1. Tambah Antrian");
                System.out.println("2. Layani Pelanggan");
                System.out.println("3. Tampilkan Antrian");
                System.out.println("4. Lihat Riwayat Transaksi");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                pilih = input.nextInt();
                input.nextLine(); //Membersihkan Buffer

                switch(pilih){
                    case 1:
                        System.out.println("Minimal 5 pelanggan berada dalam antrian.");
                        while(!antrian.minLima()){
                            System.out.print("Masukkan Nomor Antrian: ");
                            String noAntri = input.nextLine();
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String nama = input.nextLine();
                            System.out.print("Masukkan Total Belanja: ");
                            int totBelanja = input.nextInt();
                            input.nextLine();
                            antrian.enqueue(noAntri, nama, totBelanja);
                        }
                        System.out.print("Masukkan Nomor Antrian: ");
                        String noAntri = input.nextLine();
                        System.out.print("Masukkan Nama Pelanggan: ");
                        String nama = input.nextLine();
                        System.out.print("Masukkan Total Belanja");
                        int totBelanja = input.nextInt();
                        input.nextLine();
                        antrian.enqueue(noAntri, nama, totBelanja);
                        break;
                    case 2:
                        antrian.dequeue(riwayatTrx);
                        break;
                    case 3:
                        antrian.display();
                        break;
                    case 4:
                        riwayatTrx.tampilkanRiwayat();
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");

                }
            }while(true);
        }
    }
};