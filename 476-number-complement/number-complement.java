public class Solution {
    public int findComplement(int num) {
        int numBits;
        int bitmask;
         numBits = Integer.toBinaryString(num).length();
        
        
         bitmask = (1 << numBits) - 1;
        
        
        return num ^ bitmask;
    }
}
