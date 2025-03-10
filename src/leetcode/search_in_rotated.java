package leetcode;

public class search_in_rotated {

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = 0;
        while(l < r) {
            int mid = (l + r)/2;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l ++;
                r --;
            }

            else if(nums[l] <= nums[mid]) {
                if(target >= nums[l] && target > nums[mid]) {
                   r = mid - 1;
                } else {
                    l = mid  + 1;
                }
            } else {
                if(target <= nums[r] && target > nums[mid]) {
                    r = mid = 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
