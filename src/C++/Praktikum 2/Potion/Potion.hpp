#ifndef _POTION_HPP_
#define _POTION_HPP_

class Potion {
public:
  Potion() {
  }
  virtual int cast() = 0;
};

class BasePotion : public Potion {
protected:
  int hp;

public:
  BasePotion(int hp);
  int cast();
};

class MonoEffectPotion : public Potion {
protected:
  Potion* x;

public:
  MonoEffectPotion(Potion* x);
  virtual int cast() = 0;
};

class MixPotion : public Potion {
protected:
  Potion* x;
  Potion* y;

public:
  MixPotion(Potion* x, Potion* y);
  virtual int cast() = 0;
};

#endif