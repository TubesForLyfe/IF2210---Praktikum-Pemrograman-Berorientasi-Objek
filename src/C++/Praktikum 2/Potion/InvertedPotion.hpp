// InvertedPotion.hpp

#ifndef _INVERTED_POTION_HPP_
#define _INVERTED_POTION_HPP_

#include "Potion.hpp"

class InvertedPotion : public MonoEffectPotion {
public:
    InvertedPotion(Potion *A1);
    int cast();
};

#endif