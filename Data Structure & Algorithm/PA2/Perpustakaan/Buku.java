package Perpustakaan;
public class Buku {
    String kode;
    String judul;
    String penulis;
    Buku next;

    public Buku(String kode, String judul, String penulis){
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
