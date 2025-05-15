class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int idx1 = m - 1, idx2 = n - 1, index = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] >= nums2[idx2]) {
                nums1[index] = nums1[idx1];
                idx1--;
            } else {
                nums1[index] = nums2[idx2];
                idx2--;
            }
            index--;
        }
        while (idx1 >= 0) {
            nums1[index] = nums1[idx1];
            idx1--;
            index--;
        }
        while (idx2 >= 0) {
            nums1[index] = nums2[idx2];
            idx2--;
            index--;
        }
    }
};