package io.archie.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HuaweiTest3 {
//    public static void main(String[] args) {
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            // 注意 hasNext 和 hasNextLine 的区别
//            List<String> inputs = new ArrayList<>();
//            while (in.hasNextLine()) { // 注意 while 处理多个 case
//                String line = in.nextLine();
//                if (" ".equals(line) || line.isEmpty()) {
//                    break;
//                }
//                inputs.add(line);
//            }
//            System.out.println(count(inputs));
//        }
//    }

    public static void main(String[] args) {
        String s = "COMMAND TABLE IF EXISTS \"UNITED STATE\";\n"
            + "COMMAND A GREAT (\n"
            + "    ID ADSAB,\n"
            + "    download_length INTE-GER,  -- test;\n"
            + "    file_name TEXT,\n"
            + "    guid TEXT,\n"
            + "    mime_type TEXT,\n"
            + "    notifica-tionid INTEGER,\n"
            + "    original_file_name TEXT,\n"
            + "    pause_reason_type INTEGER,\n"
            + "    resumable_flag INTEGER,\n"
            + "    start_time INTEGER,\n"
            + "    state INTEGER,\n"
            + "    folder TEXT,\n"
            + "    path TEXT,\n"
            + "    total_length INTE-GER,\n"
            + "    url TEXT\n"
            + ");";
        List<String> ls = new ArrayList<>(Arrays.asList(s.split("\n")));
        System.out.println(count(ls));
    }

    public static int count(List<String> inputs) {
        long res = 0;
        int i = 0;
        for (String input : inputs) {
            if (input.contains("--")) {
                input = input.substring(0, input.indexOf("--"));
            }
            if (input.contains(";")) {
                String[] split = input.split(";");
                long count = Arrays.stream(split).filter(s -> !s.trim().isEmpty()).count();
                res += count;
            } else if (i == inputs.size() - 1) {
                res++;
            }
            i++;
        }
        return (int) res;
    }

    // 统计有效的文本数量
    private static int countValidTexts(String content) {
        // 移除注释
        content = removeComments(content);

        // 按分号分割
        String[] parts = content.split(";");
        int count = 0;

        for (String part : parts) {
            // 修剪多余的空白字符
            String trimmedPart = part.trim();

            // 忽略空文本
            if (!trimmedPart.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    // 去除注释，保留字符串中的 "--"
    private static String removeComments(String content) {
        StringBuilder result = new StringBuilder();
        boolean inSingleQuote = false;
        boolean inDoubleQuote = false;

        int length = content.length();
        for (int i = 0; i < length; i++) {
            char currentChar = content.charAt(i);

            // 检查是否进入字符串
            if (currentChar == '\'' && !inDoubleQuote) {
                inSingleQuote = !inSingleQuote;
            } else if (currentChar == '\"' && !inSingleQuote) {
                inDoubleQuote = !inDoubleQuote;
            }

            // 如果遇到 "--" 并且不在字符串内，跳过注释
            if (i < length - 1 && content.charAt(i) == '-' && content.charAt(i + 1) == '-'
                && !inSingleQuote && !inDoubleQuote) {
                // 跳到行尾
                while (i < length && content.charAt(i) != '\n') {
                    i++;
                }
                continue;
            }

            // 将字符添加到结果中
            result.append(currentChar);
        }

        return result.toString();
    }
}