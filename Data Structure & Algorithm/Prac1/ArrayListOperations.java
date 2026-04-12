import java.util.ArrayList;

public class ArrayListOperations {
    private ArrayList<String> list;

    public void traversal(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Konstruktor untuk inisialisasi ArrayList
    public ArrayListOperations(String arr[]) {
        list = new ArrayList<>();
        for (String element : arr) {
            list.add(element);
        }
    }

    // Proses menyisipkan elemen ke dalam ArrayList
    public void insertion(String element) {
        list.add(element);
    }

    // Proses menghapus elemen dari ArrayList pada posisi tertentu
    public void deletion(int index) {
        if (index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Proses mencari elemen dalam ArrayList
    public String search(String target) {
        if (list.contains(target)) {
            return "Ditemukan di indeks " + list.indexOf(target);
        }
        return "Element " + target + " tidak ditemukan.";
    }

    // Proses mengurutkan elemen dalam ArrayList
    public void sort() {
        list.sort((a, b) -> b.compareTo(a));
    }

    public ArrayList<String> getList() {
        return list;
    }
}