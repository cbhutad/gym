class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int currentval = nums[0];
        int total_count = 1, count = 1;

        for (int i = 1;i < nums.size();i++) {
            if (nums[i] == currentval) {
                if (count < 2) {
                    total_count++;
                } else {
                    nums[i] = 10001;
                }
                count++;
            } else {
                if (count > 2) {
                    nums[i - 1] = 10001;
                }
                currentval = nums[i];
                total_count++;
                count = 1;
            }
            //cout << currentval << " " << total_count << " " << count << endl;
        }
        // for (int i = 0;i < nums.size();i++) {
        //     cout << nums[i] << " ";
        // }
        // cout << endl;
        sort(nums.begin(), nums.end());
        return total_count;
    }
};