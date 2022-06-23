// SubstractExpression.hpp

#ifndef _SUBSTRACT_EXPRESSION_HPP_
#define _SUBSTRACT_EXPRESSION_HPP_

#include "Expression.hpp"

class SubstractExpression : public BinaryExpression {
public:
    SubstractExpression(Expression *A1, Expression *A2);
    int solve();
};

#endif