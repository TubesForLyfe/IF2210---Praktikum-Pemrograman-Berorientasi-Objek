// HealingPotion.cpp

#include "HealingPotion.hpp"
#include <iostream>

using namespace std;

HealingPotion::HealingPotion(Potion *A1, Potion *A2) : MixPotion(A1, A2) {
    //
}

int HealingPotion::cast() {
    return (abs(x->cast() + y->cast()));
}