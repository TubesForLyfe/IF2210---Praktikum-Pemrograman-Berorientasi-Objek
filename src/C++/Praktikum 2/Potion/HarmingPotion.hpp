// HarmingPotion.hpp

#ifndef _HARMING_POTION_HPP_
#define _HARMING_POTION_HPP_

#include "Potion.hpp"

class HarmingPotion : public MixPotion {
public:
    HarmingPotion(Potion *A1, Potion *A2);
    int cast();
};

#endif