class ArrayOperations {
    // Proses menampilkan semua elemen dalam array
    public void traversal(String[] arr) {

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Proses mencari elemen dalam array menggunakan metode linear search
    public String linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return "Ditemukan di indeks " + i;
            }
        }
        return "Element " + target + " tidak ditemukan.";
    }

    // Proses mencari elemen dalam array menggunakan metode binary search
    public String binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].equals(target)) {
                return "Ditemukan di indeks " + mid;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Element " + target + " tidak ditemukan.";
    }

    // Proses menyisipkan elemen ke dalam array menggunakan System.arraycopy
    public void insertionWithArrayCopy(String[] arr, String element, int index){
        if(index < arr.length){
            System.arraycopy(arr, index, arr, index + 1, arr.length - index - 1);
            arr[index] = element;
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Proses menyisipkan elemen ke dalam array pada posisi tertentu
    public void insertion(String[] arr, String element, int index) {
        if (index < arr.length) {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Proses menghapus elemen dari array pada posisi tertentu
    public void deletion(String[] arr, int index) {
        if (index < arr.length) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        } else {
            System.out.println("Index tidak valid.");
        }
    }

}