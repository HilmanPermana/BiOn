public class Stack {
    private Node top;

    // Method Push : Menambahkan riwayat transaksi baru ke tumpukkan paling atas
    public void push(String noAntrian, String namaPelanggan, int totBelanja){
        Node newNode = new Node(noAntrian, namaPelanggan, totBelanja);

        if(top == null){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }


    // Method untuk menampilkan Riwayat Transaksi
    public void tampilkanRiwayat(){
        System.out.println("\n=== Riwayat Transaksi (Terbaru - Terlama) ===");
        if(top == null){
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        Node curr = top;
        int urutan = 1;
        while (curr != null){
            System.out.println(urutan + ". Pelanggan: " + curr.namaPelanggan + " (No: " + curr.noAntrian + ")" + " Tota Belanja : " + curr.totalBelanja);
            curr = curr.next; //Turun ke riwayat yang lebih lama
            urutan++;
        }
        System.out.println("=============================================");
    }
}
