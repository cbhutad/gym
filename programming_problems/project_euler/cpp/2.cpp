#include <iostream>

long long fibonacciSumEven(long long limit) {
    long long fib1 = 1;
    long long fib2 = 2;
    long long sum_even = 0;

    while (fib1 < limit) {
        if (fib1 % 2 == 0) {
            sum_even += fib1;
        }
        
        long long next_fib = fib1 + fib2;
        fib1 = fib2;
        fib2 = next_fib;
    }

    return sum_even;
}

int main() {
    std::cout << "The sum of even-valued terms in the Fibonacci sequence up to 4 million is: "
              << fibonacciSumEven(4000000) << '\n';

    return 0;
}