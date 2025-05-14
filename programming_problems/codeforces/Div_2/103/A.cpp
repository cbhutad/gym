#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0;i < n;i++) {
        cin >> nums[i];
    }

    int maxIndex = -1, minIndex = -1, maxValue = 0, minValue = 100;

    for (int i = 0;i < n;i++) {
        if (nums[i] > maxValue) {
            maxValue = nums[i];
            maxIndex = i;
        }
        if (nums[i] <= minValue) {
            minValue = nums[i];
            minIndex = i;
        }
    }

    int minSeconds = maxIndex + (n - 1 - minIndex);

    if (minIndex < maxIndex) {
        minSeconds -= 1;
    }

    cout << minSeconds << endl;

    return 0;
}