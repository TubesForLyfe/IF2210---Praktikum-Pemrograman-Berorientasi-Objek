import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

// ANDA TIDAK BOLEH MENAMBAH, MENGURANGI, ATAU MENGUBAH NAMA ATRIBUT KELAS
class NummerReageerbuisje {
  private Stack<Integer> contents;      // Isi dari NummerReageerbuisje
  private int capacity;                 // Kapasitas maksimal dari NummerReageerbuisje
  private int filledCap;                // Berapa banyak angka yang telah mengisi NummerReageerbuisje
  
  public NummerReageerbuisje() {
    // Default konstruktor dengan capacity = 3
    contents = new Stack<Integer>();
    filledCap = 0;
    capacity = 3;
  } 

  public NummerReageerbuisje(int cap) {
    // Modified konstruktor dengan capacity = cap
    contents = new Stack<Integer>();
    filledCap = 0;
    capacity = cap;
  }

  public int getCapacity() {
    // getter atribut capacity
    return capacity;
  }

  public int getFilledCap() {
    // getter atribut filledCap
    return filledCap;
  }

  public void receiveOneSubstance(int substance) {
    // NummerReageerbuisje menerima satu "substance" yaitu angka yang masuk
    if (filledCap < capacity) {
        contents.push(substance);
        filledCap++;
    }
  } 

  public void pour(NummerReageerbuisje other) {
    // NummerReageerbuisje menuangkan isi dari contents ke NummerReageerbuisje other hingga other penuh
    // Note: Angka yang dituangkan terlebih dahulu adalah angka yang paling atas posisinya
    while (filledCap > 0 && other.getFilledCap() < other.getCapacity()) {
        other.receiveOneSubstance(contents.pop());
        filledCap--;
    }
  }

  public void pourAllContents() {
    // NummerReageerbuisje ditumpahkan sepenuhnya, sehigga contents kosong
    // Melakukan println untuk setiap elemen yang tumpah berurut dari yang paling awal tumpah
    while (filledCap > 0) {
        System.out.println(contents.pop());
        filledCap--;
    }
  }

  public void stirSwirl() {
    // contents dari NummerReageerbuisje menjadi terbalik urutannya
    List<Integer> temp = new ArrayList<Integer>();
    while (filledCap > 0) {
        temp.add(contents.pop());
        filledCap--;
    }
    for (int i = 0; i < temp.size(); i++) {
        contents.push(temp.get(i));
        filledCap++;
    }
  }

  public void centrifuge() {
    // contents dari NummerReageerbuisje diurutkan berdasarkan nilai angkanya, 
    // dengan yang terbesar di paling bawah dan yang terkecil di paling atas
    List<Integer> temp = new ArrayList<Integer>();
    while (filledCap > 0) {
        temp.add(contents.pop());
        filledCap--;
    }
    Collections.sort(temp, Collections.reverseOrder());
    for (int i = 0; i < temp.size(); i++) {
        contents.push(temp.get(i));
        filledCap++;
    }
  }
}