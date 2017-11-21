package com.qg.funrily.offer02;


import javafx.stage.StageStyle;

/**
 * 面试题2：实现Singleton模式 —— 7种
 * @author FunriLy
 * Created by FunriLy on 2017/11/21.
 * From small beginnings comes great things.
 */
public class Test02 {

    /**
     * 饿汉式单例模式，线程安全
     * 该方法在类加载就实例化
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();
        /**
         * 私有化对象
         */
        private Singleton(){}
        public static Singleton getInstance () {
            return INSTANCE;
        }
    }

    /**
     * 懒汉式单例模式，线程不安全
     */
    public static class Singleton2{
        private static Singleton2 INSTANCE = null;
        private Singleton2(){}
        public static Singleton2 getInstance () {
            if (INSTANCE == null) {
                INSTANCE = new Singleton2();
            }
            return INSTANCE;
        }
    }

    /**
     * 懒汉式单例模式，线程安全，但多线程下效率不高
     * 使用关键字 synchronized 修饰
     */
    public static class Singleton3 {
        private static Singleton3 INSTANCE = null;
        private Singleton3() {}
        public static synchronized Singleton3 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton3();
            }
            return INSTANCE;
        }
    }

    /**
     * 懒汉式当例模式(变种)，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 INSTANCE = null;
        static {
            INSTANCE = new Singleton4();
        }
        private Singleton4() {}
        public static Singleton4 getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 使用静态内部类单例模式，线程安全
     * 利用了classloder的机制来保证初始化instance时只有一个线程
     * 其优点：只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5() {}
        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 枚举类单例模式，《Effective Java》中推荐的
     */
    public enum Singleton6 {
        /**
         * 枚举类实现其实省略了private类型的构造函数
         * private Singleton6() {}
         */
        INSTANCE;
        public void whateverMethod() {
        }
    }

    /**
     * 使用双重校验锁单例模式，线程安全
     */
    public static class Singleton7 {
        private volatile static Singleton7 INSTANCE = null;
        private Singleton7() {}
        public static Singleton7 getInstance() {
            if (INSTANCE == null) {
                synchronized (Singleton7.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton7();
                    }
                }
            }
            return INSTANCE;
        }
    }
}
