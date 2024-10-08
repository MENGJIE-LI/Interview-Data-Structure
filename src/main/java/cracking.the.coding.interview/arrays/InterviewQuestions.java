package cracking.the.coding.interview.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewQuestions {

    public static void main(String[] args) {
//        int[] myNums = {-1,0,1,2,-1,-4};
//        threeSum(myNums);
//        lengthOfLongestSubstringTwoDistinct("ccaabbb");
        nextClosestTime2("19:34");
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        String subResult = "";
        int max = 0;
        int curr = 0;

        while(left < s.length() && right < s.length()){
            String sub = s.substring(left, right);
            if(!sub.contains(s.substring(right, right + 1))){
                right ++;
                curr ++;
                if(curr > max){
                    max = curr;
                    subResult = s.substring(left, right);
                }
            }else{
                while(s.charAt(left) != s.charAt(right) && left < right){
                    left ++;
                    curr --;
                }
                left++;
                curr--;
            }
        }
        return max;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int sum2 = nums[l] + nums[r];
            for(int i = l; i < r - 1 ; i++){
                if(i > 0 && nums[i]==nums[i-1])
                    continue;
                if(nums[i] == 0 - sum2){
                    result.add(new ArrayList(Arrays.asList(nums[l], nums[i], nums[r])));
                    l++;
                    r--;
                }
            }
            if(sum2 < 0){
                while(l < r && nums[l+1]==nums[l]){
                    l++;
                }
            }
            else{
                while(l < r && nums[r-1]==nums[r]){
                    r--;
                }
            }
            l++;
            r--;
        }
        return result;
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int left = 0;
        int right = 0;
        Set<Character> mySet = new HashSet<>();
        int max = 0;

        while(right < s.length()){
            if(!mySet.contains(s.charAt(right)) && mySet.size() == 2){
                mySet.remove(s.charAt(left));
                mySet.add(s.charAt(right));
                for(left = right; left >= 0 && mySet.contains(s.charAt(left)); left--) {}
                max = Math.max(max, right - left);
            }
            mySet.add(s.charAt(right));
            right ++;

        }
        return Math.max(max, right - left - 1);
    }


    public static String nextClosestTime(String time) {

        int[] digits = new int[4];

        digits[0] = Character.getNumericValue(time.charAt(0));
        digits[1] = Character.getNumericValue(time.charAt(1));
        digits[2] = Character.getNumericValue(time.charAt(3));
        digits[3] = Character.getNumericValue(time.charAt(4));


        List<Integer> myList = Arrays.stream(digits)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(myList);
        int change = 0;

        HashMap<Integer, Integer> digitRule = new HashMap<>();
        digitRule.put(0,2);
        digitRule.put(1,3);
        digitRule.put(2,5);
        digitRule.put(3,9);

        outerLoop:
        for(int i = 3; i > 0; i--){
            int no = myList.indexOf(digits[i]);
            if(no < 3){
                for(int j = 3; j > no; j --){
                    if(myList.get(j) <= digitRule.get(i)){
                        digits[i] = myList.get(j);
                        change = i + 1;
                        break outerLoop;
                    }
                }
            }
        }
        for(int i = change; i < 4; i++){
            digits[i] = myList.get(0);
        }
        return "" + digits[0] + digits[1] + ":" + digits[2] + digits[3];
    }

    public static String nextClosestTime2(String time) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(time.charAt(0)- '0');
        set.add(time.charAt(1)- '0');
        set.add(time.charAt(3)- '0');
        set.add(time.charAt(4)- '0');

        int hours = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(3));

        while(true) {
            mins++;
            hours = (hours + mins/60) % 24;
            mins = mins % 60;
            if(set.contains(hours/10) &&
                    set.contains(hours%10) &&
                    set.contains(mins/10) &&
                    set.contains(mins%10)) break;
        }
        return String.format("%02d", hours) + ":" + String.format("%02d", mins);
    }

}
