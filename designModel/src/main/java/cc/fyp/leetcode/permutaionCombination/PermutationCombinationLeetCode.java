package cc.fyp.leetcode.permutaionCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Leetcode的一道题 串联所有单词的子串
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * 思路：
 * 数组内的单词，进行排列组合运算，生成需要匹配的字符串
 * 然后通过indexOf方法进行一个个的匹配查看位置，返回结果。
 * 排列组合使用递归方式完成
 * 这个算法能实现功能，但是过不了单元测试，因为时间复杂度过高。
 *
 * @author von
 * @description:
 * @date 2021/4/20 15:28
 */
public class PermutationCombinationLeetCode {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> recode = new ArrayList();
        List<String> pc = new ArrayList();

        permCombin("",words,pc);

        for(int i = 0; i<pc.size();i++){
            int x = s.indexOf(pc.get(i));
            if( x != -1){
                while (x >= 0){
                    if (!recode.contains(x)){
                        recode.add(x);
                    }
                    x = s.indexOf(pc.get(i),x+1);
                }
            }
        }
        return recode;

    }

    public static void permCombin(String code, String [] others, List<String> result){
        if (others.length == 1){
            result.add(code + others[0]);
            return;
        }
        for (int i = 0; i < others.length; i++) {
            String head =code+others[i];
            String[] detail = removeChoose(others,i);
            permCombin(head,detail,result);
        }
    }

    public static String[] removeChoose(String[] nums,int flag){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (flag == i){
                continue;
            }else {
                result.add(nums[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {

        String x = "foobarfoobar";
        String[] y = {"foo","bar"};
        List<Integer> substring = findSubstring(x, y);
        System.out.println(substring);

    }
}
