public class BinarySearchTree {

    ProductNode root;

    // INSERT
    public ProductNode insert(
        ProductNode root,
        int id,
        String nama,
        int harga
    ) {

        if (root == null) {

            return new ProductNode(
                id,
                nama,
                harga
            );
        }

        if (id < root.id) {

            root.left =
                insert(
                    root.left,
                    id,
                    nama,
                    harga
                );

        } else if (id > root.id) {

            root.right =
                insert(
                    root.right,
                    id,
                    nama,
                    harga
                );
        }

        return root;
    }

    // SEARCH
    public ProductNode search(
        ProductNode root,
        int id
    ) {

        if (
            root == null ||
            root.id == id
        ) {

            return root;
        }

        if (id < root.id) {

            return search(
                root.left,
                id
            );
        }

        return search(
            root.right,
            id
        );
    }

    // DELETE
    public ProductNode delete(
        ProductNode root,
        int id
    ) {

        if (root == null) {
            return root;
        }

        if (id < root.id) {

            root.left =
                delete(
                    root.left,
                    id
                );

        } else if (id > root.id) {

            root.right =
                delete(
                    root.right,
                    id
                );

        } else {

            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            ProductNode temp =
                minValue(root.right);

            root.id = temp.id;
            root.nama = temp.nama;
            root.harga = temp.harga;

            root.right =
                delete(
                    root.right,
                    temp.id
                );
        }

        return root;
    }

    // MIN VALUE
    public ProductNode minValue(
        ProductNode root
    ) {

        ProductNode current = root;

        while (
            current.left != null
        ) {

            current = current.left;
        }

        return current;
    }

    // TRAVERSAL
    public void inorderTraversal(
        ProductNode root
    ) {

        if (root != null) {

            inorderTraversal(root.left);

            System.out.println(
                "ID : " + root.id +
                " | Nama : " + root.nama +
                " | Harga : " +
                root.harga
            );

            inorderTraversal(root.right);
        }
    }
}