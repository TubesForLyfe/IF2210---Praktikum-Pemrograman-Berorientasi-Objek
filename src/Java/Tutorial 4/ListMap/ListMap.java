class ListMap implements Map {
    private ListMapEntry first;

    /**
     * Menambahkan (key, value) ke dalam map
     * Melakukan overwrite jika sudah terdapat elemen dengan key yang sama.
     */
    public void set(String key, String value) {
        ListMapEntry p = this.first;
        ListMapEntry q = null;
        while (p != null && !p.getKey().equals(key)) {
            q = p;
            p = p.getNext();
        }
        if (p == null) {
            p = new ListMapEntry(key, value);
            if (this.first == null) {
                this.first = p;
            } else {
                q.setNext(p);
            }
        } else {
            p.setValue(value);
        }
    }

    /**
     * Mengembalikan value yang tersimpan untuk key tertentu pada map
     * Mengembalikan NULL apabila map tidak mengandung key masukan.
     */
    public String get(String key) {
        ListMapEntry p = this.first;
        while (p != null && !p.getKey().equals(key)) {
            p = p.getNext();
        }
        if (p == null) {
            return "NULL";
        } else {
            return p.getValue();
        }
    }

    /**
     * Menghitung jumlah elemen yang ada pada map
     */
    public int size() {
        ListMapEntry p = this.first;
        int count = 0;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    } 
}