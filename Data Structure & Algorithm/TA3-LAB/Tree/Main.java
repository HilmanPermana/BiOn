import java.util.Scanner;

public class Main {

    public static void main(
        String[] args
    ) {

        Scanner input =
            new Scanner(System.in);

        BinarySearchTree bst =
            new BinarySearchTree();

        int pilihan;

        do {

            System.out.println(
                "\n===== MENU ====="
            );

            System.out.println(
                "1. Tambah Produk"
            );

            System.out.println(
                "2. Cari Produk"
            );

            System.out.println(
                "3. Hapus Produk"
            );

            System.out.println(
                "4. Tampilkan Produk"
            );

            System.out.println(
                "5. Hitung Total Belanja"
            );

            System.out.println(
                "0. Keluar"
            );

            System.out.print(
                "Pilih menu: "
            );

            pilihan =
                input.nextInt();

            switch (pilihan) {

                // = INSERT =
                case 1:

                    System.out.print(
                        "Masukkan ID Produk: "
                    );

                    int id =
                        input.nextInt();

                    input.nextLine();

                    System.out.print(
                        "Masukkan Nama Produk: "
                    );

                    String nama =
                        input.nextLine();

                    System.out.print(
                        "Masukkan Harga: "
                    );

                    int harga =
                        input.nextInt();

                    bst.root =
                        bst.insert(
                            bst.root,
                            id,
                            nama,
                            harga
                        );

                    System.out.println(
                        "Produk berhasil ditambahkan!"
                    );

                    break;

                // = SEARCH =
                case 2:

                    System.out.print(
                        "Cari ID Produk: "
                    );

                    int cari =
                        input.nextInt();

                    ProductNode hasil =
                        bst.search(
                            bst.root,
                            cari
                        );

                    if (hasil != null) {

                        System.out.println(
                            "Produk ditemukan"
                        );

                        System.out.println(
                            "Nama : " +
                            hasil.nama
                        );

                        System.out.println(
                            "Harga : " +
                            hasil.harga
                        );

                    } else {

                        System.out.println(
                            "Produk tidak ditemukan"
                        );
                    }

                    break;

                // = DELETE =
                case 3:

                    System.out.print(
                        "Hapus ID Produk: "
                    );

                    int hapus =
                        input.nextInt();

                    bst.root =
                        bst.delete(
                            bst.root,
                            hapus
                        );

                    System.out.println(
                        "Produk berhasil dihapus!"
                    );

                    break;

                // = TRAVERSAL =
                case 4:

                    System.out.println(
                        "\n=== DATA PRODUK ==="
                    );

                    bst.inorderTraversal(
                        bst.root
                    );

                    break;

                // = HITUNG TOTAL =
                case 5:

                    System.out.print(
                        "Berapa produk yang dibeli: "
                    );

                    int banyak =
                        input.nextInt();

                    int subtotal = 0;

                    for (
                        int i = 1;
                        i <= banyak;
                        i++
                    ) {

                        System.out.println(
                            "\nProduk ke-" + i
                        );

                        System.out.print(
                            "Masukkan ID Produk: "
                        );

                        int idProduk =
                            input.nextInt();

                        ProductNode produk =
                            bst.search(
                                bst.root,
                                idProduk
                            );

                        if (produk != null) {

                            System.out.println(
                                "Nama Produk : " +
                                produk.nama
                            );

                            System.out.println(
                                "Harga : " +
                                produk.harga
                            );

                            System.out.print(
                                "Jumlah beli: "
                            );

                            int jumlah =
                                input.nextInt();

                            // Expression Tree
                            // harga * jumlah

                            String postfix1[] = {
                                String.valueOf(
                                    produk.harga
                                ),
                                String.valueOf(
                                    jumlah
                                ),
                                "*"
                            };

                            ExpressionTree exp =
                                new ExpressionTree();

                            ExpNode root1 =
                                exp.buildTree(
                                    postfix1
                                );

                            int hasilBelanja =
                                exp.evaluate(
                                    root1
                                );

                            subtotal +=
                                hasilBelanja;

                        } else {

                            System.out.println(
                                "Produk tidak ditemukan!"
                            );
                        }
                    }

                    System.out.print(
                        "\nMasukkan diskon: "
                    );

                    int diskon =
                        input.nextInt();

                    // subtotal - diskon

                    String postfix2[] = {
                        String.valueOf(
                            subtotal
                        ),
                        String.valueOf(
                            diskon
                        ),
                        "-"
                    };

                    ExpressionTree exp2 =
                        new ExpressionTree();

                    ExpNode root2 =
                        exp2.buildTree(
                            postfix2
                        );

                    int total =
                        exp2.evaluate(
                            root2
                        );

                    System.out.println(
                        "\nSubtotal : " +
                        subtotal
                    );

                    System.out.println(
                        "Total Belanja : " +
                        total
                    );

                    break;

                // = EXIT =
                case 0:

                    System.out.println(
                        "Program selesai."
                    );

                    break;

                default:

                    System.out.println(
                        "Menu tidak tersedia!"
                    );
            }

        } while (pilihan != 0);

        input.close();
    }
}