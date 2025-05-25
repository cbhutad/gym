class Solution {
public:
    bool isSubsequence(string s, string t) {
        int sindex = 0, tindex = 0;
        if (s.size() == 0)
            return true;
        if (t.size() == 0 && s.size() != 0)
            return false;
        while (sindex < s.size() && tindex < t.size()) {
            if (s[sindex] == t[tindex]) {
                sindex++;
            }
            tindex++;
        }
        if (sindex == s.size())
            return true;
        return false;
    }
};