class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int i = 0, j;
        bool flag = false;
        for (i = 0; i < strs[0].size();i++) {
            for (j = 1; j < strs.size(); j++) {
                if ((strs[j].size() < (i + 1)) || (strs[0][i] != strs[j][i])) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            } 
        }
        string result = "";
        j = 0;
        for (; j < i;j++) {
            result += strs[0][j];
        }
        return result;
    }
};