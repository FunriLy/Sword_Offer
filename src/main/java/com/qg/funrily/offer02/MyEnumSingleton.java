package com.qg.funrily.offer02;

/**
 * 实现接口的形式 来实现 枚举类单例模式
 * @author FunriLy
 * Created by FunriLy on 2017/11/21.
 * From small beginnings comes great things.
 */
public enum  MyEnumSingleton implements MySingleton {
    INSTANCE {
        @Override
        public void doSomething() {
            System.out.println("complete singleton");
        }
    };

    public static MySingleton getInstance() {
        return MyEnumSingleton.INSTANCE;
    }
}
