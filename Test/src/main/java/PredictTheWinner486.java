public class PredictTheWinner486 {
    //中等难度
    //使用的是动态规划，但是我不会，好难（预测赢家）
    // 解析：i,j分别指向当前数组的最左端和最右端，最开始i,j从两个相邻的开始，然后j向后移动，扩大选择范围，更新差值
    public boolean PredictTheWinner(int[] nums) {
        int length=nums.length;
        int [][]dp=new int[length][length];
        for(int i=0;i<length;i++)
        {
            dp[i][i]=nums[i];
        }
        for(int i=length-2;i>=0;i--)
        {
            for(int j=i+1;j<length;j++)
            {
                int left = nums[i]-dp[i+1][j]; //选择左端后，与往后选择的差值
                int right= nums[j]-dp[i][j-1]; //选择右端后，与往后选择的差值
                dp[i][j]=Math.max(left,right);
            }
        }
        return dp[0][length-1]>=0;
    }
}
