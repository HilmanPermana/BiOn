import java.util.Arrays;

class Main {
    public static void main(String[] args){
        // Sampel 100 Elemen Data String
        String[] dataMentah = {
            "Able", "Active", "Adept", "Agile", "Apt", "Ardent", "Astute", "Awesome", "Bold", "Brave",
            "Bright", "Brisk", "Calm", "Capable", "Caring", "Cheerful", "Choice", "Clean", "Clear", "Clever",
            "Crisp", "Desirous", "Devoted", "Eager", "Earnest", "Expert", "Faithful", "Fast", "Fierce", "Fine",
            "Firm", "Fit", "Fleet", "Fond", "Frank", "Fresh", "Gentle", "Glad", "Grand", "Great",
            "Happy", "Honest", "Hopeful", "Joyful", "Keen", "Kind", "Lively", "Loving", "Loyal", "Masterful",
            "Merry", "Mighty", "Mild", "New", "Nimble", "Novel", "Open", "Passionate", "Peaceful", "Placid",
            "Potent", "Prime", "Proud", "Pure", "Quick", "Radiant", "Rapid", "Rare", "Ready", "Robust",
            "Safe", "Secure", "Select", "Serene", "Sharp", "Shrewd", "Sincere", "Skilled", "Smart", "Soft",
            "Solid", "Sound", "Stable", "Steady", "Strong", "Sturdy", "Superb", "Sweet", "Swift", "Tender",
            "Tranquil", "True", "Trusting", "Unique", "Vibrant", "Warm", "Wise", "Zealous", "Zestful", 
            "Zippy", "Zany", "Zesty", "Zingy", "Zippy", "Zappy", "Zazzy", "Zesty", "Zany", "Zealous", "Zippy"
        };

        // Membuat variabel sampel data sesuai permintaan (mengambil potongan dari dataMentah)
        String[] arr10 = Arrays.copyOfRange(dataMentah, 0, 10);
        String[] arr30 = Arrays.copyOfRange(dataMentah, 0, 30);
        String[] arr50 = Arrays.copyOfRange(dataMentah, 0, 50);
        String[] arr70 = Arrays.copyOfRange(dataMentah, 0, 70);
        String[] arr100 = Arrays.copyOfRange(dataMentah, 0, 100);

        ArrayOperations arrOps = new ArrayOperations();
        ArrayListOperations arrListOps = new ArrayListOperations(arr10);
        // Proses Operasi Traversal
        System.out.print("Array Traversal : ");
        arrOps.traversal(arr10);
        System.out.print("ArrayList Traversal : ");
        arrListOps.traversal(arr10);
        System.out.println();

        // Proses Pencarian Elemen
        System.out.print("Pencarian kata 'Agile' dalam Array :  ");
        System.out.println(arrOps.linearSearch(arr10, "Agile"));
        System.out.print("Pencarian kata 'Brave' dalam ArrayList :  ");
        System.out.println(arrListOps.search("Brave"));
        System.out.println();

        // Proses Penyisipan Elemen
        System.out.print("Array setelah penyisipan elemen 'Happiness' : ");
        arrOps.insertionWithArrayCopy(arr10, "Happiness", 5);
        arrOps.traversal(arr10);
        System.out.println();

        System.out.print("ArrayList setelah penyisipan elemen 'Godness' : ");
        arrListOps.insertion("Godness");
        arrListOps.traversal(arrListOps.getList().toArray(new String[0]));
        System.out.println();

        
        System.out.println("=== HASIL PERBANDINGAN WAKTU EKSEKUSI (Berdasarkan Ukuran Data) ===");
        
        // Menjalankan method pengujian untuk masing-masing ukuran data
        Comparison.ujiKecepatan(arr10, "arr10");
        Comparison.ujiKecepatan(arr30, "arr30");
        Comparison.ujiKecepatan(arr50, "arr50");
        Comparison.ujiKecepatan(arr70, "arr70");
        Comparison.ujiKecepatan(arr100, "arr100");
        System.out.println();

        // Proses Pengurutan Elemen
        System.out.print("ArrayList sebelum diurutkan : ");
        arrListOps.traversal(arrListOps.getList().toArray(new String[0]));
        arrListOps.sort();
        System.out.print("ArrayList setelah diurutkan Secara Descending : ");
        arrListOps.traversal(arrListOps.getList().toArray(new String[0]));
        System.out.println();
    }
}