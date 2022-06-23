#include "WarungSaltedEgg.hpp"
#include <iostream>
using namespace std;

WarungSaltedEgg::WarungSaltedEgg(int uang, int nasi, int telur, int telurAsin, int ayam) : WarungNasi(uang, nasi, telur) {
    this->telurAsin = telurAsin;
    this->ayam = ayam;
}

bool WarungSaltedEgg::masak(int pesanan) {
    if (getNasi() < pesanan && getTelur() < pesanan && this->telurAsin < 3*pesanan && this->ayam < pesanan) {
        return false;
    } else {
        int pendapatan = pesanan * 30000;
        setUang(getUang() + pendapatan);
        return true;
    }
}