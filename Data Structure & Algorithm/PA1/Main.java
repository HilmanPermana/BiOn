import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private Double ipk;

    /* Constructor 1 */
    public Mahasiswa(String nama, String nim, String jurusan, Double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    /* Method 1: Menampilkan informasi mahasiswa */
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk + '\n');
    }

    /* Getter IPK */
    public Double getIpk() {
        return ipk;
    }

    /* Setter IPK */
    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    /* Getter NIM */
    public String getNim() {
        return nim;
    }

    /* Method 2.1 : Cek Kelususan */
    public String cekKelulusan() {
        if (ipk >= 3.0) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }

    /* Method 2.2 : Update IPK */
    public void updateIpk(Double ipkBaru) {
        this.ipk = ipkBaru;
    }

    /* Method 2.3 : Menampilkan Info Kelulusan */
    public void tampilkanInfoKelulusan() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
        System.out.println("Status: " + cekKelulusan() + '\n');
    }

    /*Method 3.1 : Menentukan Predikat Akademik*/
    public String predikatAkademik() {
        if (ipk >= 3.75) {
            return "Dengan Pujian";
        } else if (ipk >= 3.50 && ipk < 3.75) {
            return "Sangat Memuaskan";
        } else if (ipk >= 3.00 && ipk < 3.50) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }

    /* Method 3.2 : Menampilkan Info Predikat Akademik */
    public void tampilkanInfoPredikat() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
        System.out.println("Status: " + cekKelulusan());
        System.out.println("Predikat: " + predikatAkademik() + '\n');
    }

}

public class Main {
    public static void main(String[] args) {
        /* Soal 1 : Pembuatan Class dan Object */
        Mahasiswa[] daftar = new Mahasiswa[5];
        daftar[0] = new Mahasiswa("Gulam Ahmad", "123456789", "Teknik Informatika", 3.75);
        daftar[1] = new Mahasiswa("Ukar Smith", "987654321", "Sistem Informasi", 3.85);
        daftar[2] = new Mahasiswa("Jacob Franklin", "456789123", "Teknik Komputer", 3.90);
        daftar[3] = new Mahasiswa("Emily Gorbert", "321654987", "Teknik Elektro", 3.80);
        daftar[4] = new Mahasiswa("Sophia Lee", "654321987", "Teknik Mesin", 3.70);

        System.out.println("=== Data Mahasiswa ===");
        for (Mahasiswa mhs : daftar) {
            mhs.tampilkanInfo();
        }

        /* Soal 2 : Menerapkan Enkapsulasi dan Method */
        System.out.println("=== Update IPK Mahasiswa ===" + '\n');
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine();

        // Validasi NIM
        if (nimInput.equals(daftar[0].getNim()) || nimInput.equals(daftar[1].getNim())
                || nimInput.equals(daftar[2].getNim()) || nimInput.equals(daftar[3].getNim())
                || nimInput.equals(daftar[4].getNim())) {
            System.out.print("Masukkan IPK baru: ");
            Double ipkBaru = scanner.nextDouble();

            // Update IPK
            for (Mahasiswa mhs : daftar) {
                if (mhs.getNim().equals(nimInput)) {
                    mhs.updateIpk(ipkBaru);
                    System.out.println("Data berhasil diperbarui!" + '\n');
                    System.out.println("=== Data Mahasiswa ===" + '\n');
                    mhs.tampilkanInfoKelulusan();
                    break;
                }
            }
        } else {
            System.out.println("NIM tidak ditemukan.");
        }

        scanner.close();

        /* Soal 3 : Menentukan Predikat Akademik*/
        System.out.println("Menentukan Predikat Akademik");
        System.out.println("=== Data Mahasiswa ===" + '\n');
        daftar[0].tampilkanInfoPredikat();

    }
}