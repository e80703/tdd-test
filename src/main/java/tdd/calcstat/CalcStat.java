package tdd.calcstat;

public class CalcStat {

  public int getMin(int[] nums) {
    int min = setOriginalNum(nums);
    for (int next : nums) {
      min = compareMin(min, next);
    }
    return min;
  }

  public int getMax(int[] nums) {
    int max = setOriginalNum(nums);
    for (int next : nums) {
      max = compareMax(max, next);
    }
    return max;
  }

  public int getAverage(int[] nums) {
    int sum = getSum(nums);
    int average = sum / getSize(nums);
    return average;
  }

  public int getSize(int[] nums) {
    return nums.length;
  }

  public int compareMin(int previous, int next) {
    return next < previous ? next : previous;
  }

  public int compareMax(int previous, int next) {
    return next > previous ? next : previous;
  }

  public int setOriginalNum(int[] nums) {
    return nums[0];
  }

  public int getSum(int[] nums) {
    int sum = 0;
    for (int i = 0; i < getSize(nums); i++) {
      sum += nums[i];
    }
    return sum;
  }

}
