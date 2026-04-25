package Perpustakaan;
public class LinkedList {
    Buku head;

    public LinkedList(){
        this.head = null;
    }

    public boolean kodeValid(String kode){
        if(kode.length() <= 5){
            return true;
        } else {
            return false;
        }
    }

    public boolean minLimaBuku(){
        int count = 0;
        Buku current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count >= 5;
    }

    public void tambah(String kode, String judul, String penulis){
        Buku newBuku = new Buku(kode, judul, penulis);
        if(head == null){
            head = newBuku;
            System.out.println("Buku dengan Judul " + head.judul + " Berhasil Ditambahkan");
            System.out.println();
        } else {
            Buku current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newBuku;
            System.out.println("Buku dengan Judul " + newBuku.judul + " Berhasil Ditambahkan");
            System.out.println();
        }
    }

    public void tampil(){
        System.out.println("Daftar Buku:" );
        Buku current = head;
        while(current != null){
            System.out.println("Kode: " + current.kode + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
            current = current.next;
        }
    }

    public void hapus(String kode){
        if(head == null){
            System.out.println("Daftar buku kosong.");
            return;
        }

        if(head.kode.equals(kode)){
            head = head.next;
            System.out.println("Buku dengan judul " + head.judul + " telah dihapus.");
            return;
        }

        Buku current = head;
        if(current.kode.equals(kode)){
            System.out.println("Buku dengan judul " + current.judul + " telah dihapus.");
            return;
        }
        while(current.next != null){
            if(current.next.kode.equals(kode)){
                System.out.println("Buku dengan judul " + current.next.judul + " telah dihapus.");
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Buku dengan kode " + kode + " tidak ditemukan.");
    }

    public void cari(String kode){
        Buku current = head;
        while(current != null){
            if(current.kode.equals(kode)){
                System.out.println("Buku ditemukan: Kode: " + current.kode + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku dengan kode " + kode + " tidak ditemukan.");
    }
}
