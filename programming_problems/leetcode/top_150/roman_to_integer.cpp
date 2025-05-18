class Solution {
public:
    int romanToInt(string s) {
        int index = 0, value = 0;
        while (index < s.size()) {

            if (s[index] == 'I') {
                if (index + 1 < s.size() && s[index + 1] == 'V') {
                    index += 2;
                    value += 4;
                } else if (index + 1 < s.size() && s[index + 1] == 'X') {
                    index += 2;
                    value += 9;
                } else {
                    index += 1;
                    value += 1;
                } 
            } else if (s[index] == 'V') {
                index += 1;
                value += 5;
            } else if (s[index] == 'X') {
                if (index + 1 < s.size() && s[index + 1] == 'L') {
                    index += 2;
                    value += 40;
                } else if (index + 1 < s.size() && s[index + 1] == 'C') {
                    index += 2;
                    value += 90;
                } else {
                    index += 1;
                    value += 10;
                } 
            } else if (s[index] == 'L') {
                index += 1;
                value += 50;
            } else if (s[index] == 'C') {
                if (index + 1 < s.size() && s[index + 1] == 'D') {
                    index += 2;
                    value += 400;
                } else if (index + 1 < s.size() && s[index + 1] == 'M') {
                    index += 2;
                    value += 900;
                } else {
                    index += 1;
                    value += 100;
                } 
            } else if (s[index] == 'D') {
                index += 1;
                value += 500;
            } else if (s[index] == 'M') {
                index += 1;
                value += 1000;
            }
        }
        return value;
    }
};