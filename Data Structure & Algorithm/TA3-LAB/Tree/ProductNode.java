public class ProductNode {

    int id;
    String nama;
    int harga;

    ProductNode left, right;

    public ProductNode(
        int id,
        String nama,
        int harga
    ) {

        this.id = id;
        this.nama = nama;
        this.harga = harga;

        left = right = null;
    }
}