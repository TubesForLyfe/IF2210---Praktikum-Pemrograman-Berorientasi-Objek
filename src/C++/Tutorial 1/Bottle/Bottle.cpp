#include "Bottle.hpp"

int Bottle::numOfBottle = 0;

Bottle::Bottle() : id(numOfBottle+1) {
    this->height = 10.00;
    this->radius = 10.00;
    this->waterHeight = 0;
    numOfBottle += 1;
}

Bottle::Bottle(float height, float radius) : id(numOfBottle+1) {
    this->height = height;
    this->radius = radius;
    this-> waterHeight = 0;
    numOfBottle += 1;
}

Bottle::Bottle(const Bottle& bottle) : id(bottle.id) {
    this->height = bottle.height;
    this->radius = bottle.radius;
    this->waterHeight = bottle.waterHeight;
}

Bottle::~Bottle() {

}

int Bottle::getId() const {
    return this->id;
}

float Bottle::getWaterVolume() const {
    return (PI*this->radius*this->radius*this->waterHeight);
}

float Bottle::getBottleVolume() const {
    return (PI*this->radius*this->radius*this->height);
}

void Bottle::setHeight(float height) {
    this->height = height;
    if (this->height < this->waterHeight) {
        this->waterHeight = this->height;
    }
}

void Bottle::addWater(float waterVolume) {
    waterVolume = this->getWaterHeightIfVolume(waterVolume);
    this->waterHeight += waterVolume;
    if (this->waterHeight > this->height) {
        this->waterHeight = this->height;
    }
}

void Bottle::substractWater(float waterVolume) {
    waterVolume = this->getWaterHeightIfVolume(waterVolume);
    this->waterHeight -= waterVolume;
    if (this->waterHeight < 0) {
        this->waterHeight = 0;
    }
}

float Bottle::getWaterHeightIfVolume(float waterVolume) const {
    return (waterVolume/(PI*this->radius*this->radius));
}

void Bottle::pourWaterTo(Bottle& other) {
    float thisWaterVolume = this->getWaterVolume();
    float otherWaterVolume = other.getWaterVolume();
    float otherBottleVolume = other.getBottleVolume();

    if (thisWaterVolume + otherWaterVolume > otherBottleVolume) {
        other.addWater(thisWaterVolume);
        this->substractWater(otherBottleVolume-otherWaterVolume);
    } else {
        this->waterHeight = 0.00;
        other.addWater(thisWaterVolume);
    }
}