package cc.fyp.leetcode.permutaionCombination;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Leetcode的一道题 串联所有单词的子串
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * 思路：
 * 遍历数组的每一个单词。
 * 从第一个单词开始从，字符串中匹配，如果匹配到了，从当前位置截取到数组字符串长度总和的匹配串
 * 从匹配串中再遍历查询是否能匹配的所有的数组字符。
 * 时间复杂度高，过不了
 * @author von
 * @description:
 * @date 2021/4/20 15:28
 */
public class PermutationCombinationLeetCode1 {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> reData = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
        }

        //匹配串长度
        Integer wordLength = sb.length();
        Integer sLength = s.length();

        for (int i = 0; i < words.length; i++) {
            System.out.println("正在匹配第" + i +"个，共有" +wordLength.toString()+ "个");

            String word = words[i];
            int x = 0;
            while (x >= 0){
                x = s.indexOf(word,x);
                if (x == -1){
                    break;
                }

                if (sLength - x < wordLength){
                    break;
                }

                String substring = s.substring(x + word.length(), x+ wordLength);
                String[] newString = removeChoose(words, i);
                boolean allContent = isAllContent(substring, newString);
                if (allContent){
                    if (!reData.contains(x)){
                        reData.add(x);
                    }
                }
                x++;
            }
        }

        return reData;
    }

    /**
     * 截取后的字符串和剩余的单词数组匹配
     * @param subString
     * @param words
     * @return
     */
    public static boolean isAllContent(String subString,String [] words){

        for (int i = 0; i < words.length; i++) {
            String indexWords = words[i];
            Integer mutl = indexWords.length();
            int flag = subString.indexOf(indexWords);

            while (flag%mutl != 0 && flag!=-1){
                flag++;
                flag = subString.indexOf(indexWords, flag);
            }


            if (flag == -1){
                return false;
            }

            String a = subString.substring(0, flag);
            String b = subString.substring(flag + words[i].length());

            subString = a + b;
        }
        return true;
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

//        String x =  "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String[] y = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String x =  "aaa";
        String[] y = {"a"};
        List<Integer> substring = findSubstring(x, y);
        System.out.println(substring);

        //isAllContent(x,y);

    }
}
