// AddExpression.cpp

#include "AddExpression.hpp"
#include <iostream>

using namespace std;

AddExpression::AddExpression(Expression *A1, Expression *A2) : BinaryExpression(A1, A2) {
    //
}

int AddExpression::solve() {
    return (x->solve() + y->solve());
}