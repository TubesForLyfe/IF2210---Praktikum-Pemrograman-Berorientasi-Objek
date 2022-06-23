#include "BurnableBarrel.hpp"
#include <iostream>
using namespace std;

BurnableBarrel::BurnableBarrel() : Damageable(), Burnable() {
    //
}

BurnableBarrel::BurnableBarrel(int health) : Damageable(health), Burnable() {
    //
}

void BurnableBarrel::takeDamage(int damage, string element) {
    if (Damageable::isDestroyed()) {
        //
    } else {
        if (element == "fire") {
            Burnable::burn();
        } else if (element == "water") {
            Burnable::watered();
        }

        if (Burnable::isBurned()) {
            Damageable::takeDamage(damage * this->multiplier);
        }
    }
}