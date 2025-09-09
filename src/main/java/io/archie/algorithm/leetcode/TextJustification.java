package io.archie.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

class TextJustification {


    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {

        public List<String> fullJustify(String[] words, int maxWidth) {
            // This is an
            // example of text
            // justification.

            // 1. 按行分配字符串
            // 2. 统计每行最大 max length
            // 3. 3个及以上平均分配
            List<String> ans = new ArrayList<>();
            int n = words.length;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; ) {
                list.clear();
                list.add(words[i]);
                int cur = words[i++].length();
                while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                    cur += 1 + words[i].length();
                    list.add(words[i++]);
                }
                // 当前为最后一行，为左对齐
                if (i == n) {
                    StringBuilder sb = new StringBuilder(list.get(0));
                    for (int k = 1; k < list.size(); k++) {
                        sb.append(" ").append(list.get(k));
                    }
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                    break;
                }

                // 如果当前行只有一个word，处理为左对齐
                int count = list.size();
                if (count == 1) {
                    StringBuilder str = new StringBuilder(list.get(0));
                    while (str.length() != maxWidth) {
                        str.append(" ");
                    }
                    ans.add(str.toString());
                    continue;
                }

                // 其他情况，应该均分空格
                int wordWidth = cur - (count - 1);
                int spaceWidth = maxWidth - wordWidth;
                int spaceItemWidth = spaceWidth / (count - 1);
                StringBuilder spaceItem = new StringBuilder();
                for (int k = 0; k < spaceItemWidth; k++) {
                    spaceItem.append(" ");
                }
                StringBuilder sb = new StringBuilder();
                for (int k = 0, sum = 0; k < count; k++) {
                    String item = list.get(k);
                    sb.append(item);
                    if (k == count - 1) {
                        break;
                    }
                    sb.append(spaceItem);
                    sum += spaceItemWidth;
                    // 计算剩余间隙
                    int remain = count - k - 1 - 1;
                    // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙中多补充一个空格
                    if(remain * spaceItemWidth + sum < spaceWidth){
                        sb.append(" ");
                        sum++;
                    }
                }
                ans.add(sb.toString());
            }
            return ans;
        }
    }
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        new TextJustification().new Solution().fullJustify(words, maxWidth).forEach(System.out::println);
    }
}