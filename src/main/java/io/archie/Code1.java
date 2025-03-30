package io.archie;

/**
 * 单例模式 <br>
 *
 * @Author: MrArchie
 * @Date: 2024/12/19 13:31
 */
public class Code1 {
    // 静态常量
    public static final Code1 INSTANCE_1 = new Code1();

    private Code1() {}

    private static volatile Code1 code1;

    // DCL 模式
    public static Code1 getInstance() {
        if(code1 == null) {
            synchronized (Code1.class) {
                if(code1 == null) {
                    code1 = new Code1();
                }
            }
        }
        return code1;
    }

    // 静态内部类模式
    // 优势：不调用不加载
    public static class Code1Builder {
        public static final Code1 INSTANCE = new Code1();
    }

    // 枚举模式
    public enum Code1Enum {
        INSTANCE;

        // do something
        public void doSomething() {
            System.out.println("doSomething");
        }
    }
}