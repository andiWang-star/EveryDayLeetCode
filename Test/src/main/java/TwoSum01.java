import java.util.HashMap;
import java.util.Map;

public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        //1.暴力破解法
       /*
       int []index = new int[2];
       for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==target-nums[j])
                {
                    index[0]=i;
                    index[1]=j;
                }
            }
        }
        //throw new IllegalArgumentException("No two sum solution");
        */
        //2.2遍hash法
       /* Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int key = target-nums[i];
            if(map.containsKey(key) && map.get(key)!=i)
            {
                index[0]=i;
                index[1]=map.get(key);
            }
        }*/
        //一遍hash
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //遍历map
        for (int i=0;i<nums.length;i++)
        {
            // 查看是否存在值key在map中，且不为nums[i]
            int key=target-nums[i];
            if(map.containsKey(key) && map.get(key)!=i)
            {
                return new int[]{i,map.get(key)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
