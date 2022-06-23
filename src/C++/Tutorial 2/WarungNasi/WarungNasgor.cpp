#include "WarungNasgor.hpp"
#include <iostream>
using namespace std;

WarungNasgor::WarungNasgor(int uang, int nasi, int telur, int kecap) : WarungNasi(uang, telur, nasi) {
    this->kecap = kecap;
}

bool WarungNasgor::masak(int pesanan) {
    if (getNasi() < pesanan && getTelur() < pesanan && this->kecap < pesanan) {
        return false;
    } else {
        int pendapatan = pesanan * 15000;
        setUang(getUang() + pendapatan);
        return true;
    }
}