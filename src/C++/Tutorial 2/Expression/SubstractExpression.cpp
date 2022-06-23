// SubstractExpression.cpp

#include "SubstractExpression.hpp"
#include <iostream>

using namespace std;

SubstractExpression::SubstractExpression(Expression *A1, Expression *A2) : BinaryExpression(A1, A2) {
    //
}

int SubstractExpression::solve() {
    return (x->solve() - y->solve());
}