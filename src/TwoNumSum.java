import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangxinhua
 * @date 2020/3/2
 */
public class TwoNumSum {
  /**
   *
   *给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
   * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
   *
   * 示例:给定 nums = [2, 7, 11, 15], target = 9
   * 因为 nums[0] + nums[1] = 2 + 7 = 9
   * 所以返回 [0, 1]
   *
   */

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15,3,6};
    int target = 9;

    twoSumOptionOne(nums,target);
    twoSumOptionTwo(nums,target);
    twoSumOptionThree(nums,target);

  }


  public static int[] twoSumOptionOne(int[] nums, int targer){
    System.out.println("option one ------------------------------!");
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
       if( nums[j]==targer-nums[i]){
         System.out.println(nums[i]+"+"+nums[j]+"="+targer);
        }
      }
    }
    return null;
  }

  public static int[] twoSumOptionTwo(int[] nums, int targer){
    System.out.println("option two ------------------------------!");
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = targer - nums[i];
      //map.get(complement)!=i 排除自身和重复
      if (map.containsKey(complement) && map.get(complement)>i) {
        System.out.println(nums[i]+"+"+nums[map.get(complement)]+"="+targer);
      }
    }
    return null;
  }


  public static int[] twoSumOptionThree(int[] nums, int targer){
    System.out.println("option three ------------------------------!");
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = targer - nums[i];
      if (map.containsKey(complement)) {
        System.out.println(nums[i]+"+"+nums[map.get(complement)]+"="+targer);
      }
      map.put(nums[i], i);
    }
    return null;
  }

}
