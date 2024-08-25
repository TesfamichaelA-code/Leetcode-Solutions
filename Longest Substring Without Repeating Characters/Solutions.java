import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
