#include "Box.hpp"
#include <iostream>
using namespace std;

int main() {
    Box *b2 = new Box(2);
    Box *b0 = new Box();
    Box *b1 = new Box(1);
    *b0 = *b2;
    Box *b11 = new Box(*b1);
    b0->peek();
    b11->peek();

    delete b0;
    delete b1;
    delete b11;
    delete b2;
}