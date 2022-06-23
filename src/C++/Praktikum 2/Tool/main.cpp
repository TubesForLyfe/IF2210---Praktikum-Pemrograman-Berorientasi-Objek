#include "Pickaxe.hpp"
#include "ReinforcedAxe.hpp"
#include <iostream>

using namespace std;

int main() {
    Pickaxe *p1 = new Pickaxe();
    p1->use();
    p1->enchant();
    Pickaxe *p2 = new Pickaxe(*p1);
    p1 = new Pickaxe();
    *p1 = *p2;
    ReinforcedAxe *r1 = new ReinforcedAxe();
    r1->use();
    ReinforcedAxe *r2 = new ReinforcedAxe(*r1);
    r1->enchant();
    ReinforcedAxe *r3 = new ReinforcedAxe(*r2 + *r1);
    r3->repair();
    delete r1;
    delete r2;
    delete r3;
    delete p1;
    delete p2;
}