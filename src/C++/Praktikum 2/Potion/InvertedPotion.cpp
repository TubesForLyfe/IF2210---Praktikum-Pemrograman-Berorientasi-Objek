// InvertedPotion.cpp

#include "InvertedPotion.hpp"
#include <iostream>

using namespace std;

InvertedPotion::InvertedPotion(Potion *A1) : MonoEffectPotion(A1) {
    //
}

int InvertedPotion::cast() {
    return ((-1) * x->cast());
}