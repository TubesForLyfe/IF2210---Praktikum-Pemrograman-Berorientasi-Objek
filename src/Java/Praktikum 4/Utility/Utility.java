import java.util.*;

public class Utility {
    /*
     * swap()
     * Menukar 2 elemen pada sebuah array
     * Parameter: array generik, index i, dan index j
     * Jika indeks diluar array, maka array tidak berubah
     */
    public static <T> void swap(T[] arr, int i, int j) {
        // Pemeriksaan letak indeks
        if (arr.length > i && 0 <= i && arr.length > j && 0 <= j) {
            // Pertukaran
            T temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static <T> Object[] repeat(T[] arr, int N) {
        ArrayList<T> list = new ArrayList<T>();
        int i;
        int j;
        
        for (i = 0; i < N; i++) {
            for (j = 0; j < arr.length; j++) {
                list.add(arr[j]);
            }
        }

        return list.toArray();
    }

    /*
     * join()
     * Menggabungkan seluruh elemen pada array menjadi sebuah string dengan delimeter ","
     */
    public static <T> String join(T[] arr) {
        String joined = new String();
        int i;

        if (arr.length != 0) {
            joined += arr[0];
            for (i = 1; i < arr.length; i++) {
                joined += ",";
                joined += arr[i];
            }
        }
        return joined;
    }

    /*
     * sum() 
     * Menghasilkan jumlah dari seluruh elemen array dengan tipe double
     * Parameter: array generik
     */
    public static <T extends Number> Double sum(T[] arr) {
        int i;
        Double sum = 0.0;
        for (i = 0; i < arr.length; i++) {
            sum += arr[i].doubleValue();
        }
        return sum;
    }
}