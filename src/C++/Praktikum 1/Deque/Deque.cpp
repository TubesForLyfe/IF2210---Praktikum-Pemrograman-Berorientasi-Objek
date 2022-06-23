#include "Deque.hpp"
#include <iostream>
using namespace std;

Deque::Deque() : neff(0), maxel(10), first(0), last(0) {
  this->queue = new int[this->maxel + 1];
}

Deque::Deque(int maxel) : neff(0), maxel(maxel), first(0), last(0) {
  this->queue = new int[this->maxel + 1];
}

Deque::Deque(const Deque& other) : neff(other.neff), maxel(other.maxel), first(other.first), last(other.last) {
  this->queue = new int[other.maxel + 1];
  for (int i = 0; i < other.maxel; i++) {
    this->queue[i] = other.queue[i];
  }
}

Deque::~Deque() {
  delete[] this->queue;
}

bool Deque::isFull() const {
  return this->neff == this->maxel;
}

bool Deque::isEmpty() const {
  return this->neff == 0;
}

void operator>(int e, Deque& q) {
  // menambahkan e di depan deque jika q.isFull() == false
  // F.S. neff bertambah 1, first bergeser ke kiri (sirkuler), last tetap
  if (!q.isFull()) {
      q.neff += 1;
      q.first -= 1;
      q.queue[q.first] = e;
  }
}

void operator<(Deque& q, int e) {
  // menambahkan e di belakang deque jika q.isFull() == false
  // F.S. neff bertambah 1, last bergeser ke kanan (sirkuler), first tetap
  if (!q.isFull()) {
      q.neff += 1;
      q.last += 1;
      q.queue[q.last] = e;
  }
}

void operator>(Deque& q, int* e) {
  // mengambil elemen paling belakang deque dan mengassign ke e, jika q.isEmpty() == false
  // mengassign e dengan 0 jika q.isEmpty() == true
  // F.S. neff berkurang 1, last bergeser ke kiri (sirkuler), first tetap
  if (q.isEmpty()) {
      *e = 0;
  } else {
      *e = q.queue[q.last];
      q.last -= 1;
  }
}

void operator<(int* e, Deque& q) {
  // mengambil elemen paling depan deque dan mengassign ke e, jika q.isEmpty() == false
  // mengassign e dengan 0 jika q.isEmpty() == true
  // F.S. neff berkurang 1, first bergeser ke kanan (sirkuler), last tetap
  if (q.isEmpty()) {
      *e = 0;
  } else {
      *e = q.queue[q.first];
      q.first += 1;
  }
}