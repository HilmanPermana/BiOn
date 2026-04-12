import java.util.ArrayList;
import java.util.Arrays;

public class Comparison {
    // Method untuk menguji Array vs ArrayList
    public static void ujiKecepatan(String[] arr, String namaVar) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        
        // Mengambil elemen terakhir sebagai target agar pencarian list bekerja maksimal (skenario terburuk)
        String target = arr[arr.length - 1]; 

        System.out.println("\n--- Ukuran Data: " + arr.length + " Elemen (" + namaVar + ") | Target: '" + target + "' ---");

        // 1. Pengukuran pada Array (Menggunakan Binary Search bawaan)
        long startTimeArr = System.nanoTime();
        Arrays.binarySearch(arr, target); 
        long endTimeArr = System.nanoTime();
        long durationArr = endTimeArr - startTimeArr;
        System.out.printf("Waktu eksekusi Array (Binary Search) : %.6f ms\n", (durationArr / 1000000.0));

        // 2. Pengukuran pada ArrayList (Menggunakan Linear Search / contains bawaan)
        long startTimeList = System.nanoTime();
        list.contains(target); 
        long endTimeList = System.nanoTime();
        long durationList = endTimeList - startTimeList;
        System.out.printf("Waktu eksekusi ArrayList (Linear)    : %.6f ms\n", (durationList / 1000000.0));
    }
}