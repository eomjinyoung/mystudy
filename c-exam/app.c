#include <stdio.h>
#include "calc.h"


int main() {
    int r = plus(100, 200);
    r = minus(r, 17);
    r = multiply(r, 3);
    r = divide(r, 2);

    printf("result = %d\n", r);
}