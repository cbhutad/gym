class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int size = nums.size();
        int count = 0, i = 0, j= size - 1;
        bool flag = false;
        while (i <= j ) {
            flag = false;
            if (nums[i] == val) {
                while (j > i) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        flag = true;
                        j--;
                        break;
                    } else {
                        j--;
                    }
                }
                // This for adding check if the element to be removed is the last element or all the elements are val.
                // flag is added to check if array length is 2 units.
                if (i == j && !flag) {
                    count--;
                }
            } 
            count++;
            i++;
        }


        return count;
    }
};