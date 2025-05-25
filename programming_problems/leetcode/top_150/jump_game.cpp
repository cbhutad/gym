class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 1) {
            return true;
        }
        int lastidx = nums.size() - 1;
        int currentidx = lastidx - 1;

        while (currentidx >= 0) {
            if (nums[currentidx] + currentidx >= lastidx) {
                lastidx = currentidx;
            }
            currentidx--;
        }

        if (lastidx == 0) {
            return true;
        }

        return false;
    }
};