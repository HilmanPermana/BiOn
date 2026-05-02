/**
 * TUGAS KELOMPOK 3 - ARRAYS REKURSIF
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

import java.util.Scanner;

public class PlaylistRekursif {
    private Lagu[] playlist;
    private static final int MAX_CAPACITY = 10;
    private static int jumlahLagu;

    public PlaylistRekursif() {
        playlist = new Lagu[MAX_CAPACITY];
        jumlahLagu = 0;
    }

    public Lagu[] getListLagu() {
        return playlist;
    }

    // =============================================
    // OPERASI DASAR
    // =============================================

    public void tampilkanSemuaLagu() {
        System.out.println("\n========================================");
        System.out.println("        DAFTAR LAGU DALAM PLAYLIST        ");
        System.out.println("========================================");
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
            return;
        }
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("\n--- Lagu #" + (i + 1) + " ---");
            playlist[i].tampilkanInfo();
        }
    }

    public void tambahLagu(Scanner scanner) {
        if (jumlahLagu >= MAX_CAPACITY) {
            System.out.println("ERROR: Playlist penuh!");
            return;
        }
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan nama artis: ");
        String artis = scanner.nextLine();
        System.out.print("Masukkan durasi (detik): ");
        try {
            int durasi = Integer.parseInt(scanner.nextLine());
            playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
            jumlahLagu++;
            System.out.println("✓ Berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("ERROR: Input tidak valid.");
        }
    }

    public void hapusLagu(Scanner scanner) {
        if (jumlahLagu == 0) return;
        System.out.print("Masukkan judul yang ingin dihapus: ");
        String judulCari = scanner.nextLine();
        int indexHapus = -1;
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulCari)) {
                indexHapus = i;
                break;
            }
        }
        if (indexHapus != -1) {
            for (int i = indexHapus; i < jumlahLagu - 1; i++) {
                playlist[i] = playlist[i + 1];
            }
            playlist[jumlahLagu - 1] = null;
            jumlahLagu--;
            System.out.println("✓ Berhasil dihapus.");
        } else {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    public void cariLagu(Scanner scanner) {
        System.out.print("Masukkan kata kunci judul: ");
        String cari = scanner.nextLine();
        boolean ditemukan = false;
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().toLowerCase().contains(cari.toLowerCase())) {
                playlist[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Lagu tidak ditemukan.");
    }

    public void urutkanLaguBerdasarkanDurasi() {
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }
        System.out.println("✓ Playlist berhasil diurutkan berdasarkan durasi.");
    }

    // =============================================
    // OPERASI REKURSIF
    // =============================================

    static double totalDurasi(Lagu[] list, int n) {
        if (list == null || n <= 0) return 0;
        return list[n - 1].getDurasi() + totalDurasi(list, n - 1);
    }

    static void tampilkanMundur(Lagu[] list, int index) {
        if (list == null || index <= 0) return;
        System.out.println(index + ". " + list[index - 1].getJudul());
        tampilkanMundur(list, index - 1);
    }

    static Lagu cariDurasiTerpanjang(Lagu[] list, int index) {
        if (list == null || index <= 0) return null;
        if (index == 1) return list[0];
        Lagu juara = cariDurasiTerpanjang(list, index - 1);
        return (list[index - 1].getDurasi() > juara.getDurasi()) ? list[index - 1] : juara;
    }

    static String formatDurasiTotal(double totalDetik) {
        int menit = (int) totalDetik / 60;
        int detik = (int) totalDetik % 60;
        return String.format("%d.%02d", menit, detik);
    }

    // =============================================
    // MAIN METHOD
    // =============================================

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistRekursif manager = new PlaylistRekursif();
        manager.tambahLaguSample();

        int pilihan;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║     === MENU PLAYLIST MUSIK ===      ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Tampilkan semua lagu             ║");
            System.out.println("║  2. Tambah lagu baru                 ║");
            System.out.println("║  3. Hapus lagu berdasarkan judul     ║");
            System.out.println("║  4. Cari lagu berdasarkan judul      ║");
            System.out.println("║  5. Urutkan lagu berdasarkan durasi  ║");
            System.out.println("║  6. Hitung total durasi              ║");
            System.out.println("║  7. Reverse tampilan lagu            ║");
            System.out.println("║  8. Cari durasi terpanjang           ║");
            System.out.println("║  9. Analisis Rekursif                ║");
            System.out.println("║  10. Keluar                          ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Pilih menu (1-10): ");
            
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) { pilihan = 0; }

            switch (pilihan) {
                case 1: manager.tampilkanSemuaLagu(); break;
                case 2: manager.tambahLagu(scanner); break;
                case 3: manager.hapusLagu(scanner); break;
                case 4: manager.cariLagu(scanner); break;
                case 5: manager.urutkanLaguBerdasarkanDurasi(); break;
                case 6:
                    System.out.println("Total durasi: " + formatDurasiTotal(totalDurasi(manager.playlist, jumlahLagu)) + " menit");
                    break;
                case 7:
                    System.out.println("\nDaftar lagu (Terbalik):");
                    tampilkanMundur(manager.playlist, jumlahLagu);
                    break;
                case 8:
                    Lagu lp = cariDurasiTerpanjang(manager.playlist, jumlahLagu);
                    if (lp != null) System.out.println("Lagu terpanjang: " + lp.getJudul() + " (" + lp.getDurasiFormatted() + ")");
                    break;
                case 9:
                    // ========================================================
                    // MENU ANALISIS REKURSIF (GABUNGAN)
                    // ========================================================
                    if (jumlahLagu == 0) {
                        System.out.println("\nPlaylist masih kosong.");
                        break;
                    }
                    System.out.println("\n=== ANALISIS REKURSIF PLAYLIST ===");
                    System.out.println("Jumlah lagu : " + jumlahLagu);

                    // 1. Durasi
                    long s1 = System.nanoTime();
                    double totalD = totalDurasi(manager.playlist, jumlahLagu);
                    long e1 = System.nanoTime();
                    System.out.println("Total durasi : " + formatDurasiTotal(totalD) + " menit");

                    // 2. Terpanjang
                    long s2 = System.nanoTime();
                    Lagu ter = cariDurasiTerpanjang(manager.playlist, jumlahLagu);
                    long e2 = System.nanoTime();
                    if (ter != null) {
                        System.out.println("Lagu terpanjang : \"" + ter.getJudul() + "\" - " + ter.getArtis() + " (" + ter.getDurasiFormatted() + ")");
                    }

                    // 3. Reverse
                    System.out.println("\nDaftar lagu (ditampilkan terbalik):");
                    long s3 = System.nanoTime();
                    tampilkanMundur(manager.playlist, jumlahLagu);
                    long e3 = System.nanoTime();

                    // Execution Times (Formatting agar tidak muncul 0 ms)
                    System.out.println("\n----------------------------------------");
                    System.out.format("Execution Time (totalDurasi): %.5f ms\n", (e1 - s1) / 1_000_000.0);
                    System.out.format("Execution Time (tampilkanMundur): %.5f ms\n", (e3 - s3) / 1_000_000.0);
                    System.out.format("Execution Time (cariDurasiTerpanjang): %.5f ms\n", (e2 - s2) / 1_000_000.0);
                    break;
                case 10:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 10);
        scanner.close();
    }

    private void tambahLaguSample() {
        playlist[0] = new Lagu("Perfect", "Ed Sheeran", 263);
        playlist[1] = new Lagu("Shivers", "Ed Sheeran", 207);
        playlist[2] = new Lagu("Fix You", "Coldplay", 295);
        playlist[3] = new Lagu("Yellow", "Coldplay", 269);
        playlist[4] = new Lagu("Viva La Vida", "Coldplay", 242);
        jumlahLagu = 5;
    }
}
