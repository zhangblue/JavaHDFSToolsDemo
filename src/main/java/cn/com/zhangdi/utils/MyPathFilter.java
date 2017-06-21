package cn.com.zhangdi.utils;

import com.google.common.base.Strings;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

/***
 * 获取HDFS目录目录名中存在strType的文件
 *
 * @author zhangdi
 *
 */
public class MyPathFilter implements PathFilter {

    private String strBeginKey = "";
    private MatchingMode matchingModeBegin;
    private String strEndKey = "";

    public MyPathFilter(String strBeginKey, MatchingMode matchingModeBegin, String strEndKey) {
        super();
        this.strBeginKey = strBeginKey;
        this.matchingModeBegin = matchingModeBegin;
        this.strEndKey = strEndKey;
    }

    public boolean accept(Path arg0) {
        boolean bReturn = false;
        switch (matchingModeBegin.getValue()) {
            case 1:
                if (Strings.isNullOrEmpty(strEndKey)) {
                    bReturn = arg0.getName().startsWith(strBeginKey);
                } else {
                    bReturn = arg0.getName().startsWith(strBeginKey) && arg0.getName().endsWith(strEndKey);
                }
                break;
            case 2:
                bReturn = arg0.getName().endsWith(strEndKey);
                break;
            case 3:
                if (Strings.isNullOrEmpty(strEndKey)) {
                    bReturn = arg0.getName().contains(strBeginKey);
                } else {
                    bReturn = arg0.getName().contains(strBeginKey) && arg0.getName().endsWith(strEndKey);
                }
                break;
            default:
                break;
        }
        return bReturn;
    }
}
