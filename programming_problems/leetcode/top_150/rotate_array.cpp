class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        int first = 0;
        int last = nums.size() - 1;
        // reverse the array
        reverse(nums, first,last);
        // reverse the first k elements
        first = 0;
        last = k - 1;
        reverse(nums, first, last);
        // reverse last k elements
        first = k;
        last = nums.size() - 1;
        reverse(nums, first, last);
    }

    void reverse(vector<int>& nums, int first, int last) {
        int temp = -1;
        while (first <= last) {
            temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
};