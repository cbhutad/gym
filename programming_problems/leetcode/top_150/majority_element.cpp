class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int maxcount = 1;
        int maxvalue = nums[0];
        int count = 1;
        for (int i = 1; i < nums.size();i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                if (count > maxcount) {
                    maxcount = count;
                    maxvalue = nums[i - 1];
                    count = 1;
                    if (maxcount > (nums.size() / 2))
                        break;
                }
            }
        }
        // if the last element is the majority elmeent case
        if (count > (nums.size() / 2)) {
            maxvalue = nums[nums.size() - 1];
        }
        return maxvalue;
    }
};
