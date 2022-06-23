#include "Potion.hpp"

BasePotion::BasePotion(int hp) {
  this->hp = hp;
}

int BasePotion::cast() {
  return this->hp;
}

MonoEffectPotion::MonoEffectPotion(Potion* x) {
  this->x = x;
}

MixPotion::MixPotion(Potion* x, Potion* y) {
  this->x = x;
  this->y = y;
}