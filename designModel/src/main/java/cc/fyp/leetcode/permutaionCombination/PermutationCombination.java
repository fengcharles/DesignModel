package cc.fyp.leetcode.permutaionCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 数组内的字符串进行排列组合。
 * 1、如果字符串不重复，可以有 N！个排列组合
 * @author von
 * @description:
 * @date 2021/4/20 15:28
 */
public class PermutationCombination {


    public static void permCombin(String code, String [] others, List<String> result){
        if (others.length == 1){
            result.add(code + others[0]);
            return;
        }
        for (int i = 0; i < others.length; i++) {
            String head =code + others[i];
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

        List<String> lists = new ArrayList<>();
        String[] y = {"a","b","c","a"};
        permCombin("",y,lists);

        System.out.println(lists);

    }
}
