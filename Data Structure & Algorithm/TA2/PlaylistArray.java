/**
 * ================================================
 * TUGAS KELOMPOK 2 - ARRAYS AND ITS OPERATIONS
 * ================================================
 * Nama Kelompok:
 * 1. [Nama Anggota 1] - [NIM 1]
 * 2. [Nama Anggota 2] - [NIM 2]
 * 3. [Nama Anggota 3] - [NIM 3]
 * 
 * Kelas: [Kode Kelas]
 * Mata Kuliah: Data Structures
 * ================================================
 */

import java.util.Scanner;

public class PlaylistArray {
    // =============================================
    // ATRIBUT CLASS
    // =============================================
    
    // Array statis untuk menyimpan objek Lagu dengan kapasitas maksimum 10
    private Lagu[] playlist;
    
    // Konstanta untuk kapasitas maksimum playlist
    private static final int MAX_CAPACITY = 10;
    
    // Variabel untuk melacak jumlah lagu saat ini dalam playlist
    private int jumlahLagu;

    // =============================================
    // CONSTRUCTOR
    // =============================================
    
    /**
     * Constructor untuk inisialisasi playlist
     * Membuat array kosong dengan kapasitas maksimum 10
     */
    public PlaylistArray() {
        playlist = new Lagu[MAX_CAPACITY];
        jumlahLagu = 0;
    }

    // =============================================
    // OPERASI TRAVERSAL
    // Time Complexity: O(n) - Linear
    // Space Complexity: O(1) - Constant
    // =============================================
    
    /**
     * Method untuk menampilkan semua lagu dalam playlist (TRAVERSAL)
     * 
     * ANALISIS KOMPLEKSITAS:
     * - Time Complexity: O(n) dimana n adalah jumlah lagu dalam playlist
     *   Karena kita harus mengunjungi setiap elemen satu per satu
     * - Space Complexity: O(1) karena tidak memerlukan ruang tambahan
     *   yang bergantung pada ukuran input
     */
    public void tampilkanSemuaLagu() {
        System.out.println("\n========================================");
        System.out.println("        DAFTAR LAGU DALAM PLAYLIST       ");
        System.out.println("========================================");
        
        // Cek apakah playlist kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Silakan tambahkan lagu.");
            return;
        }
        
        // Traversal: mengunjungi setiap elemen array dari index 0 sampai jumlahLagu-1
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("\n--- Lagu #" + (i + 1) + " ---");
            playlist[i].tampilkanInfo();
        }
        
        System.out.println("\n========================================");
        System.out.println("Total lagu dalam playlist: " + jumlahLagu + "/" + MAX_CAPACITY);
        System.out.println("========================================");
    }

    // =============================================
    // OPERASI INSERTION
    // Time Complexity: O(1) - Constant
    // Space Complexity: O(1) - Constant
    // =============================================
    
    /**
     * Method untuk menambahkan lagu baru ke dalam playlist (INSERTION)
     * 
     * ANALISIS KOMPLEKSITAS:
     * - Time Complexity: O(1) - Constant
     *   Karena penambahan dilakukan di akhir array (append)
     *   dan tidak perlu menggeser elemen lain
     * - Space Complexity: O(1) - Constant
     *   Karena hanya menambahkan satu elemen baru
     */
    public void tambahLagu(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("          TAMBAH LAGU BARU              ");
        System.out.println("========================================");
        
        // Cek apakah playlist sudah penuh
        if (jumlahLagu >= MAX_CAPACITY) {
            System.out.println("ERROR: Playlist sudah penuh! Maksimum " + MAX_CAPACITY + " lagu.");
            System.out.println("Silakan hapus lagu terlebih dahulu untuk menambah lagu baru.");
            return;
        }
        
        // Input data lagu dari user
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();
        
        System.out.print("Masukkan nama artis: ");
        String artis = scanner.nextLine();
        
        System.out.print("Masukkan durasi (dalam detik): ");
        int durasi;
        
        // Validasi input durasi
        try {
            durasi = Integer.parseInt(scanner.nextLine());
            if (durasi <= 0) {
                System.out.println("ERROR: Durasi harus lebih dari 0 detik!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Input durasi tidak valid!");
            return;
        }
        
        // Insertion: menambahkan lagu baru di posisi akhir array
        // Index untuk lagu baru adalah jumlahLagu (karena index dimulai dari 0)
        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++; // Increment counter
        
        System.out.println("\n✓ Lagu berhasil ditambahkan ke playlist!");
        System.out.println("Jumlah lagu saat ini: " + jumlahLagu + "/" + MAX_CAPACITY);
    }

    // =============================================
    // OPERASI DELETION
    // Time Complexity: O(n) - Linear
    // Space Complexity: O(1) - Constant
    // =============================================
    
    /**
     * Method untuk menghapus lagu dari playlist berdasarkan judul (DELETION)
     * 
     * ANALISIS KOMPLEKSITAS:
     * - Time Complexity: O(n) - Linear
     *   Karena dalam kasus terburuk (worst case):
     *   1. Pencarian membutuhkan O(n) untuk menemukan lagu
     *   2. Penghapusan membutuhkan O(n) untuk menggeser elemen
     *   Total: O(n) + O(n) = O(2n) = O(n)
     * - Space Complexity: O(1) - Constant
     *   Karena hanya menggunakan variabel temporary untuk shifting
     */
    public void hapusLagu(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("           HAPUS LAGU                   ");
        System.out.println("========================================");
        
        // Cek apakah playlist kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada lagu untuk dihapus.");
            return;
        }
        
        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judulCari = scanner.nextLine();
        
        // Step 1: Cari index lagu yang akan dihapus (Linear Search)
        int indexHapus = -1;
        for (int i = 0; i < jumlahLagu; i++) {
            // Pencarian case-insensitive menggunakan equalsIgnoreCase
            if (playlist[i].getJudul().equalsIgnoreCase(judulCari)) {
                indexHapus = i;
                break; // Lagu ditemukan, keluar dari loop
            }
        }
        
        // Cek apakah lagu ditemukan
        if (indexHapus == -1) {
            System.out.println("Lagu dengan judul \"" + judulCari + "\" tidak ditemukan dalam playlist.");
            return;
        }
        
        // Simpan info lagu yang akan dihapus untuk konfirmasi
        String judulDihapus = playlist[indexHapus].getJudul();
        String artisDihapus = playlist[indexHapus].getArtis();
        
        // Step 2: Geser semua elemen setelah index yang dihapus ke kiri
        // Ini diperlukan agar array tetap rapat (tidak ada gap/lubang)
        for (int i = indexHapus; i < jumlahLagu - 1; i++) {
            playlist[i] = playlist[i + 1]; // Geser elemen ke kiri
        }
        
        // Step 3: Set elemen terakhir menjadi null dan kurangi counter
        playlist[jumlahLagu - 1] = null;
        jumlahLagu--;
        
        System.out.println("\n✓ Lagu \"" + judulDihapus + "\" oleh " + artisDihapus + " berhasil dihapus!");
        System.out.println("Jumlah lagu saat ini: " + jumlahLagu + "/" + MAX_CAPACITY);
    }

    // =============================================
    // OPERASI SEARCHING (Linear Search)
    // Time Complexity: O(n) - Linear
    // Space Complexity: O(1) - Constant
    // =============================================
    
    /**
     * Method untuk mencari lagu berdasarkan judul (SEARCHING - Linear Search)
     * 
     * ANALISIS KOMPLEKSITAS:
     * - Time Complexity: O(n) - Linear
     *   Best Case: O(1) - Lagu ditemukan di index pertama
     *   Average Case: O(n/2) = O(n) - Lagu ditemukan di tengah
     *   Worst Case: O(n) - Lagu ditemukan di index terakhir atau tidak ada
     * - Space Complexity: O(1) - Constant
     *   Karena hanya menggunakan variabel sederhana untuk iterasi
     */
    public void cariLagu(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("           CARI LAGU                    ");
        System.out.println("========================================");
        
        // Cek apakah playlist kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada lagu untuk dicari.");
            return;
        }
        
        System.out.print("Masukkan judul lagu yang dicari: ");
        String judulCari = scanner.nextLine();
        
        // Linear Search: mencari elemen secara berurutan dari awal hingga akhir
        boolean ditemukan = false;
        int indexDitemukan = -1;
        
        for (int i = 0; i < jumlahLagu; i++) {
            // Pencarian menggunakan contains untuk partial match (case-insensitive)
            if (playlist[i].getJudul().toLowerCase().contains(judulCari.toLowerCase())) {
                ditemukan = true;
                indexDitemukan = i;
                
                System.out.println("\n✓ Lagu ditemukan pada posisi #" + (i + 1));
                System.out.println("----------------------------------------");
                playlist[i].tampilkanInfo();
                System.out.println("----------------------------------------");
            }
        }
        
        if (!ditemukan) {
            System.out.println("\n✗ Lagu dengan kata kunci \"" + judulCari + "\" tidak ditemukan dalam playlist.");
        }
    }

    // =============================================
    // BONUS: OPERASI SORTING (Bubble Sort by Duration)
    // Time Complexity: O(n²) - Quadratic
    // Space Complexity: O(1) - Constant
    // =============================================
    
    /**
     * Method untuk mengurutkan lagu berdasarkan durasi (SORTING)
     * Menggunakan algoritma Bubble Sort
     * 
     * ANALISIS KOMPLEKSITAS:
     * - Time Complexity: O(n²) - Quadratic
     *   Karena menggunakan nested loop
     * - Space Complexity: O(1) - Constant
     *   Karena sorting dilakukan in-place
     */
    public void urutkanLaguBerdasarkanDurasi() {
        System.out.println("\n========================================");
        System.out.println("    URUTKAN LAGU BERDASARKAN DURASI     ");
        System.out.println("========================================");
        
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada lagu untuk diurutkan.");
            return;
        }
        
        if (jumlahLagu == 1) {
            System.out.println("Hanya ada 1 lagu dalam playlist. Tidak perlu diurutkan.");
            return;
        }
        
        // Bubble Sort: membandingkan dan menukar elemen yang berdekatan
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {
                // Bandingkan durasi lagu yang berdekatan
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Swap: tukar posisi jika durasi lebih besar
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }
        
        System.out.println("✓ Playlist berhasil diurutkan berdasarkan durasi (terpendek ke terpanjang)!");
        tampilkanSemuaLagu();
    }

    // =============================================
    // MAIN METHOD - Menu Interaktif
    // =============================================
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistArray playlistManager = new PlaylistArray();
        
        // Tambahkan beberapa lagu sample untuk testing
        playlistManager.tambahLaguSample();
        
        int pilihan;
        
        // Loop menu utama
        do {
            // Tampilkan menu
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║     === MENU PLAYLIST MUSIK ===      ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Tampilkan semua lagu             ║");
            System.out.println("║  2. Tambah lagu baru                 ║");
            System.out.println("║  3. Hapus lagu berdasarkan judul     ║");
            System.out.println("║  4. Cari lagu berdasarkan judul      ║");
            System.out.println("║  5. Urutkan lagu berdasarkan durasi  ║");
            System.out.println("║  6. Keluar                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Pilih menu (1-6): ");
            
            // Validasi input menu
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                pilihan = 0; // Invalid input
            }
            
            // Proses pilihan menu
            switch (pilihan) {
                case 1:
                    // TRAVERSAL - O(n)
                    playlistManager.tampilkanSemuaLagu();
                    break;
                    
                case 2:
                    // INSERTION - O(1)
                    playlistManager.tambahLagu(scanner);
                    break;
                    
                case 3:
                    // DELETION - O(n)
                    playlistManager.hapusLagu(scanner);
                    break;
                    
                case 4:
                    // SEARCHING - O(n)
                    playlistManager.cariLagu(scanner);
                    break;
                    
                case 5:
                    // SORTING - O(n²)
                    playlistManager.urutkanLaguBerdasarkanDurasi();
                    break;
                    
                case 6:
                    System.out.println("\n========================================");
                    System.out.println("  Terima kasih telah menggunakan");
                    System.out.println("      Playlist Music Manager!");
                    System.out.println("========================================");
                    break;
                    
                default:
                    System.out.println("\n✗ Pilihan tidak valid! Silakan masukkan angka 1-6.");
            }
            
        } while (pilihan != 6);
        
        scanner.close();
    }
    
    /**
     * Method helper untuk menambahkan lagu sample (untuk testing)
     */
    private void tambahLaguSample() {
        playlist[0] = new Lagu("Raim Laode", "Iqra", 354);
        playlist[1] = new Lagu("Feast", "Nina", 391);
        playlist[2] = new Lagu("Float", "Sementara", 290);
        playlist[3] = new Lagu("Raim Laode", "Komang", 320);
        playlist[4] = new Lagu("Hindia", "Cincin", 310);
        playlist[5] = new Lagu("Budi Doremi", "Doremi", 330);
        playlist[6] = new Lagu("Wali", "Nenekku Pahlawanku", 295);
        jumlahLagu = 7;
    }
}
