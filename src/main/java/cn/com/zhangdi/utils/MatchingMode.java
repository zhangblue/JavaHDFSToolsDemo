package cn.com.zhangdi.utils;

/**
 * Created by zhangdi on 2017/06/20.
 */
public enum MatchingMode {
    STARTWITH(1), // 开头匹配
    ENDWITH(2), // 结尾匹配
    CONTAINS(3);// 内容匹配

    private final int value;

    MatchingMode(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
