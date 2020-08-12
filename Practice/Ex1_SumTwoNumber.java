import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Ex1_SumTwoNumber{
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers,9)));
        System.out.println(Arrays.toString(twoSum2(numbers, 9)));
    }

    public static int[] twoSum(int[] numbers, int target){
        int[] index = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target){
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    public static int[] twoSum2(int [] numbers, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int values = target - numbers[i];
            if(map.containsKey(values)){
                return new int[] {map.get(values),i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}