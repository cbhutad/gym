class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int count = 1, previndex = 0, newindex = 1, n = nums.size();
        while (newindex < n) {
            if (nums[newindex] != nums[newindex - 1]) {
                count++;
                if (newindex - 1 != previndex) {
                    nums[previndex + 1] = nums[newindex];
                }
                previndex++;
            }
            newindex++;
        }
        return count;
    }
};