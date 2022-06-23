import java.lang.Comparable;

class Mahasiswa implements Comparable<Mahasiswa> {
    private int kodeJurusan;
    private int angkatan;
    private float ipk;

    public Mahasiswa(int kodeJurusan, int angkatan, float ipk) {
        this.kodeJurusan = kodeJurusan;
        this.angkatan = angkatan;
        this.ipk = ipk;
    }

    public int getKodeJurusan() {
        return this.kodeJurusan;
    }

    public int getAngkatan() {
        return this.angkatan;
    }

    public float getIpk() {
        return this.ipk;
    }

    public int compareTo(Mahasiswa m) {
        // compareTo mengembalikan:
        // 0 bila this sama dengan m
        // 1 bila this lebih dari m
        // -1 bila this kurang dari m
        if (this.getKodeJurusan() < m.getKodeJurusan()) {
            return -1;
        } else if (this.getKodeJurusan() == m.getKodeJurusan()) {
            if (this.getAngkatan() > m.getAngkatan()) {
                return -1;
            } else if (this.getAngkatan() == m.getAngkatan()) {
                if (this.getIpk() > m.getIpk()) {
                    return -1;
                } else if (this.getIpk() == m.getIpk()) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}