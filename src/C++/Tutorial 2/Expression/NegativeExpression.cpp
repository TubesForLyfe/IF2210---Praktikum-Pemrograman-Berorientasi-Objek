// NegativeExpression.cpp

#include "NegativeExpression.hpp"
#include <iostream>

using namespace std;

NegativeExpression::NegativeExpression(Expression *A1) : UnaryExpression(A1) {
    //
}

int NegativeExpression::solve() {
    return ((-1) * x->solve());
}