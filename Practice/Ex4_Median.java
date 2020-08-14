import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex4_Median {
    public static void main(String[] args) {
        int[] nums1 = { 2 };
        int[] nums2 = {};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = nums1.length;
        while (length > 0) {
            arrayList.add(nums1[length - 1]);
            length--;
        }
        length = nums2.length;
        while (length > 0) {
            arrayList.add(nums2[length - 1]);
            length--;
        }
        Collections.sort(arrayList);
        if (arrayList.size() % 2 == 0) {
            result = (double) ((arrayList.get(arrayList.size() / 2 - 1)) + (arrayList.get(arrayList.size() / 2))) / 2;
        } else {
            result = (double) (arrayList.get((arrayList.size() + 1) / 2 - 1));
        }
        return result;
    }
}