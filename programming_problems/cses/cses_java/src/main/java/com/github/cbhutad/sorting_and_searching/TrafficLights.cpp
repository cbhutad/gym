#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int x, n;
    cin >> x >> n;

    set<int> pos;
    multiset<int> lengths;

    pos.insert(0);
    pos.insert(x);
    lengths.insert(x);

    for (int i = 0; i < n; i++) {
        int p;
        cin >> p;

        pos.insert(p);
        auto it = pos.find(p);

        int right = *next(it);
        int left = *prev(it);

        lengths.erase(lengths.find(right - left));
        lengths.insert(p - left);
        lengths.insert(right - p);

        cout << *lengths.rbegin() << " ";
    }
}