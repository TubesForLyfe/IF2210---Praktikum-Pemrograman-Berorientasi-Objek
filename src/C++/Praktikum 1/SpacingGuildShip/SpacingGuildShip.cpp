#include "SpacingGuildShip.hpp"
#include <iostream>
using namespace std;

int SpacingGuildShip::producedShips = 0;
float SpacingGuildShip::totalGuildTravel = 0;

SpacingGuildShip::SpacingGuildShip() : maxPassengerCap(50) ,guildNavigatorCount(3), serialNum(++this->producedShips){
    this->passengerCount = 0;
    this->operatingGuildNavigator = 3;
    this->spiceStock = 50;
}

SpacingGuildShip::SpacingGuildShip(int maxPassengerCap, int guildNavigatorCount, int spiceStock) : maxPassengerCap(maxPassengerCap), guildNavigatorCount(guildNavigatorCount), serialNum(++this->producedShips){
    this->passengerCount = 0;
    this->operatingGuildNavigator = guildNavigatorCount;
    this->spiceStock = spiceStock;
}

SpacingGuildShip::SpacingGuildShip(const SpacingGuildShip& Ship) : maxPassengerCap(Ship.maxPassengerCap) ,guildNavigatorCount(Ship.guildNavigatorCount), serialNum(++this->producedShips) {
    this->passengerCount = Ship.passengerCount;
    this->operatingGuildNavigator = Ship.operatingGuildNavigator;
    this->spiceStock = Ship.spiceStock;
}

SpacingGuildShip::~SpacingGuildShip(){
}

int SpacingGuildShip::getShipSerialNum() const{
    return this->serialNum;
}

int SpacingGuildShip::getPassengerCount() const{
    return this->passengerCount;
}

void SpacingGuildShip::travel(float distance) {
    if (this->operatingGuildNavigator > 0) {
        totalGuildTravel +=  distance / ((E * E) * this->operatingGuildNavigator);
        this->operatingGuildNavigator -= 1;
    }
}

void SpacingGuildShip::boarding(int addedPassengers){
    if (addedPassengers + this->passengerCount > this->maxPassengerCap) {
        this->passengerCount = this->maxPassengerCap;
    } else {
        this->passengerCount += addedPassengers;
    }
}

void SpacingGuildShip::dropOff(int droppedPassengers) {
    if ( this->passengerCount - droppedPassengers < 0) {
        this->passengerCount = 0;
    } else {
        this->passengerCount -= droppedPassengers;
    }
}

void SpacingGuildShip::refreshNavigator(int n) {
    int minStock = n * GUILD_NAVIGATOR_SPICE_DOSE;
    while (this->spiceStock > minStock && this-> operatingGuildNavigator < this->guildNavigatorCount) {
        this->operatingGuildNavigator += 1;
        this->spiceStock -= minStock;
    }
}

void SpacingGuildShip::transitToArrakis(int addedSpice) {
    this->spiceStock += addedSpice;
}