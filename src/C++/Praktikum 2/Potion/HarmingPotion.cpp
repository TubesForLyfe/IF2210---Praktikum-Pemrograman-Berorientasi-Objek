// HarmingPotion.cpp

#include "HarmingPotion.hpp"
#include <iostream>

using namespace std;

HarmingPotion::HarmingPotion(Potion *A1, Potion *A2) : MixPotion(A1, A2) {
    //
}

int HarmingPotion::cast() {
    return ((-1) * abs(x->cast() + y->cast()));
}