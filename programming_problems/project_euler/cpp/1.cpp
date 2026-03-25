#include <iostream>

using namespace std;

int main() {
    int total_sum = 0;

    for (int number = 1; number < 1000; number++) {
        if (number % 3 == 0 || number % 5 == 0) {
            total_sum += number;
        }
    }

    cout << total_sum << endl;

    return 0;
}