#include "Bike.h"
#include "Car.h"
#include <iostream>

using namespace std;

int main() {
    Car *c4 = new Car(4);
    Vehicle *c10 = new Car(10);
    Bike *b = new Bike();
    Vehicle *v = new Vehicle(*b);
    delete b;
    c10->drive();
    v->clean();
    c4->drive();
    v->park();
    delete c10;
    delete v;
    delete c4;
}