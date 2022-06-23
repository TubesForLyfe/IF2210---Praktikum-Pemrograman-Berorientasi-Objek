#include "ExplodableBarrel.hpp"
#include <iostream>
using namespace std;

ExplodableBarrel::ExplodableBarrel() : Damageable(1), Explodable() {
    this->radius = 5;
}

ExplodableBarrel::ExplodableBarrel(int radius, int baseDamage) : Damageable(1), Explodable(baseDamage) {
    this->radius = radius;
}

void ExplodableBarrel::takeDamage(int damage, string element) {
    if (Damageable::isDestroyed()) {
        //
    } else {
        Damageable::takeDamage(damage);
        if (Damageable::isDestroyed()) {
            Explodable::explode(this->radius);
        }
    }
}