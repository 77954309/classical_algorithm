package com.algorithm.structure.hash.leetcode;

import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.*;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/1/20 21:07
 * @Created by limeng
 */
public class Solution {
    @Test
    public void init(){
       // isAnagram("cd","ab");
      //  groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

      //  twoSum2(new int[]{3,2,3},6);

      //  threeSum(new int[]{-2,0,1,1,2});

       // HashMap<String,String> map1 = new HashMap<>();
       // threeSum2(new int[]{3,0,-2,-1,1,2});

        fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }


    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }

        int n = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int firstTarget = target;
            firstTarget -= nums[first];
            for (int second = first+1; second < n; second++) {

                if(second >(first+1) && nums[second] == nums[second-1]){
                    continue;
                }
                int secondTarget = firstTarget;
                secondTarget -= nums[second];
                int fourth = n-1;
                for (int third = second+1; third < n; third++) {
                    if(third > second+1 && nums[third] == nums[third-1]){
                        continue;
                    }

                    while (third < fourth && nums[fourth] + nums[third] > secondTarget){
                        --fourth;
                    }

                    if(third == fourth){
                        break;
                    }

                    if(secondTarget == nums[fourth] + nums[third]){
                        List<Integer> childs = new ArrayList<>();
                        childs.add(nums[first]);
                        childs.add(nums[second]);
                        childs.add(nums[third]);
                        childs.add(nums[fourth]);
                        list.add(childs);
                    }

                }

            }
        }
        return list;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            int target = 0;
            target -= nums[first];
            int third = n - 1;
            for (int second = first+1; second < n; second++) {

                if(second > (first+1) && nums[second] == nums[second -1]){
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }

                if(second == third){
                    break;
                }

                if(target == nums[second] + nums[third]){
                    List<Integer> childs = new ArrayList<>();
                    childs.add(nums[first]);
                    childs.add(nums[second]);
                    childs.add(nums[third]);
                    list.add(childs);
                }

            }
        }

        return list;
    }
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *  
     * 提示：
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map2 = new HashMap<>();

        HashMap<String, List<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if(map2.containsKey(0-(nums[i]+nums[j]))){
                    int k = map2.get(0-(nums[i]+nums[j]));
                    if(k == i || k == j){
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    String key = list.toString();
                    if(!map1.containsKey(key)){
                        map1.put(key,list);
                    }

                }
                if(!map2.containsKey(nums[j])){
                    map2.put(nums[j],j);
                }
            }

        }
        System.out.println(map1);
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *  
     * 提示：
     *
     *  2 <= nums.length <= 103
     *  -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     *出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        int res = 0;
        int[] ress = new int[2];
        for (int i = 0; i < l; i++) {
            res = nums[i];
            for (int j = i+1; j < l; j++) {
                res += nums[j];
                if(res == target){
                    ress[0] = i;
                    ress[1] = j;
                    break;
                }
                res -= nums[j];
            }
        }

        return null;
    }
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 说明：
     *
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * @param strs
     */
    public void groupAnagrams(String[] strs){

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s:strs){
            int l = s.length();
            int[] counts = new int[26];
            for (int i = 0; i < l; i++) {
                counts[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(counts[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }

        //new ArrayList<>(map.values());
        System.out.println(map.values());


    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 等价：两个字符串排序后相等
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     */
    public void isAnagram(String s, String t){
        int sl = s.length();
        int tl = t.length();
        if(sl != tl){
            return;
        }

        java.util.Map<Character,Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char tmp;
        boolean res = true;
        for (int i = 0; i < sl ; i++) {
            tmp = ss[i];
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
        }

        char[] tt = t.toCharArray();
        for (int i = 0; i < tl; i++) {
            tmp = tt[i];
            map.put(tmp,map.getOrDefault(tmp,0) -1);
            if(map.get(tmp) < 0){
                res = false;
                break;
            }
        }

        System.out.println(res);

    }


    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
