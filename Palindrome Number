class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0) {
            return false;
        }
        
        
        if (x == 0) {
            return true;
        }
        
        
        int original = x;
        long reversedNum = 0;
        
        while (x > 0) {
            int digit = x % 10;
            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }
        
       
        return original == reversedNum;
    }
}
