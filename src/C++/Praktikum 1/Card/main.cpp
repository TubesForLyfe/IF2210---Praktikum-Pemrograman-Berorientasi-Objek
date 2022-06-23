#include "Card.hpp"
#include <iostream>
using namespace std;

int main() {
    Card *c1 = new Card(1);
    Card *c0 = new Card();
    Card *c2 = new Card(2);
    *c0 = *c1;
    c1->gesek();
    Card *c22 = new Card(*c2);
    c2->gesek();

    delete c1;
    delete c2;
    delete c22;
    delete c0;
}