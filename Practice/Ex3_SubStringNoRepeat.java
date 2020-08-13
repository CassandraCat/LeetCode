import java.util.ArrayList;

public class Ex3_SubStringNoRepeat {
    public static void main(String[] args) {
        String s = "ohomm";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        Character[] character = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int result = 0;
        for (int i = 0; i < character.length; i++) {
            if (!arrayList.contains(character[i])) {
                arrayList.add(character[i]);
            } else {
                result = Math.max(result, arrayList.size());
                int index = i - 1;
                while (index >= 0) {
                    if (character[index] != character[i]) {
                        index--;
                    } else {
                        break;
                    }
                }
                arrayList.clear();
                arrayList.add(character[index + 1]);
                i = index + 1;
            }
            result = Math.max(result, arrayList.size());
        }
        return result;
    }
}