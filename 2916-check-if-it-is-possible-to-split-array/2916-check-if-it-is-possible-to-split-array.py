from typing import List

class Solution:
    def canSplitArray(self, nums: List[int], m: int) -> bool:
        n = len(nums)
        if n <= 1:
            return True
        
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]
        
        dp = [[False] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        
        for l in range(2, n + 1):
            for i in range(n - l + 1):
                j = i + l - 1
                for k in range(i, j):
                    left_good = (k - i + 1 == 1) or (prefix[k + 1] - prefix[i] >= m)
                    right_good = (j - k == 1) or (prefix[j + 1] - prefix[k + 1] >= m)
                    
                    if left_good and right_good and dp[i][k] and dp[k+1][j]:
                        dp[i][j] = True
                        break
        
        return dp[0][n-1]
 