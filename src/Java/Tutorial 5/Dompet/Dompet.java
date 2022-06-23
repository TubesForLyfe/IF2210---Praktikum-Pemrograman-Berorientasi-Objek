import java.util.*;

public class Dompet<T extends Number> {
    private ArrayList<Transaction> transactions;


     public Dompet() {
        // Constructor tanpa parameter, transactions diinisialisasi dengan array list baru
        this.transactions = new ArrayList<>();
    }


    public Dompet(T initialBalance) {
        // Constructor dengan parameter T initialBalance, inisialisasi transactions dengan array list baru dan tambahkan transaksi tambah dengan value initial balance
        /* contoh transaksi tambah: new Transaction<T>('+', initialBalance) */
        this.transactions = new ArrayList<>();
        this.addMoney(initialBalance);
    }

    public void addMoney(T money) {
        // Buat prosedur addMoney dengan parameter T money, tambahkan transaksi tambah dengan senilai money
        this.transactions.add(new Transaction<T>('+', money));
    }

    public boolean takeMoney(T money) {
        // Tambahkan transaksi kurang sebesar money (perlu ada pengecekan apakah balance cukup atau tidak)
        // false bila transaksi gagal, true bila berhasil
        if (this.getBalance() < money.doubleValue()) {
            return false;
        } else {
            this.transactions.add(new Transaction<T>('-', money));
            return true;
        }
    }

    public void setBalance(T balance) {
        // Mengganti transaksi agar bernilai sama dengan balance
        // Tips: inisialisasi ulang transactions, lalu tambahkan transaksi tambah sebanyak balance
        this.transactions = new ArrayList<>();
        this.addMoney(balance);
    }

    // Akses nilai Double dilakukan dengan .doubleValue()
    // Contoh: amount.doubleValue()

    public Double getBalance(){
        // Mencari balance dompet dari transaksi dengan cara menghitung total transaksi
        Double amount = 0.00;
        for(Transaction<T> tr : this.transactions){
            if(tr.getType() == '+'){
                amount += tr.getAmount().doubleValue();
            } else {
                amount -= tr.getAmount().doubleValue();
            }
        }
        return amount;
    }

    public void printTransactions() {
        // Print seluruh transaksi yang ada pada array
        // Format: Transactions [indeks + 1]: [tipe transaksi] [amount]
        // Contoh: Transactions 3: + 500
        int i = 0;
        for(Transaction<T> tr : this.transactions){
            System.out.println("Transactions " + (i+1) + ": " + tr.getType() + " " + tr.getAmount());
            i++;
        }
    }

    public Double getAverageTransaction() {
        // Mencari rata-rata transaksi (jika tidak ada transaksi, berikan hasil null)
        if(this.transactions.size() == 0){
            return null;
        } else {
            Double jumlah = this.getBalance();
            int count = this.transactions.size();
            return jumlah/count;
        }
    }

    public Double getMinimumTransaction() {
        // Mencari nilai minimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if(this.transactions.size() == 0){
            return null;
        } else {
            Double min = (double) this.transactions.get(0).getAmount().doubleValue();
            for(Transaction<T> tr : this.transactions){
                if (min > tr.getAmount().doubleValue()){
                    min = tr.getAmount().doubleValue();
                }
            }
            return min;
        }
    }

    public Double getMaximumTransaction() {
        // Mencari nilai maksimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if(this.transactions.size() == 0){
            return null;
        }else{
            Double max = this.transactions.get(0).getAmount().doubleValue();
            for(Transaction<T> tr : this.transactions){
                if (max < tr.getAmount().doubleValue()){
                    max = tr.getAmount().doubleValue();
                }
            }
            return max;
        }
    }
}