package cn.com.zhangdi.utils.service.impl;

import cn.com.zhangdi.utils.MatchingMode;
import cn.com.zhangdi.utils.MyPathFilter;
import cn.com.zhangdi.utils.service.HDFSUtilsInterface;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by zhangdi on 2017/06/21.
 */
public class HDFSUtils extends HDFSUtilsBean {

    /**
     * 获取固定格式开头文件
     *
     * @param strPath
     * @param strKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListStartWith(String strPath, String strKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(new Path(strPath), strKey, MatchingMode.STARTWITH, null, fileSystem);
    }

    /**
     * 获取固定格式开头文件
     *
     * @param path
     * @param strKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListStartWith(Path path, String strKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(path, strKey, MatchingMode.STARTWITH, null, fileSystem);
    }

    /**
     * 获取包含某字符串文件列表
     *
     * @param strPath
     * @param strBeginKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListContainsWith(String strPath, String strBeginKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(new Path(strPath), strBeginKey, MatchingMode.CONTAINS, null, fileSystem);
    }

    /**
     * 获取包含某字符串文件列表
     *
     * @param path
     * @param strBeginKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListContainsWith(Path path, String strBeginKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(path, strBeginKey, MatchingMode.CONTAINS, null, fileSystem);
    }

    /**
     * 获取固定内容结尾文件列表
     *
     * @param strPath
     * @param strEndKey
     * @param fileSystem
     * @return
     */
    public FileStatus[] getFileStatusListEndWith(String strPath, String strEndKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(new Path(strPath), null, MatchingMode.ENDWITH, strEndKey, fileSystem);
    }

    /**
     * 获取固定内容结尾文件列表
     *
     * @param path
     * @param strEndKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListEndWith(Path path, String strEndKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(path, null, MatchingMode.ENDWITH, strEndKey, fileSystem);
    }

    /**
     * 获取以固定开头和固定结尾的文件列表
     *
     * @param strPath     扫描目录
     * @param strBeginKey 固定开头
     * @param fileSystem  hdfs文件系统
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListStartAndEndWith(Path strPath, String strBeginKey, String strEndKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(strPath, strBeginKey, MatchingMode.STARTWITH, strEndKey, fileSystem);
    }

    /**
     * 获取以固定开头和固定结尾的文件列表
     *
     * @param strPath
     * @param strBeginKey
     * @param strEndKey
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatusListStartAndEndWith(String strPath, String strBeginKey, String strEndKey, FileSystem fileSystem) throws IOException {
        return super.getFileStatusListWith(new Path(strPath), strBeginKey, MatchingMode.STARTWITH, strEndKey, fileSystem);
    }


    /**
     * 获取所有文件
     *
     * @param path
     * @param fileSystem
     * @return
     * @throws IOException
     */
    public FileStatus[] getFileStatus(Path path, FileSystem fileSystem) throws IOException {
        return super.getFileStatus(path, fileSystem);
    }

}

class HDFSUtilsBean implements HDFSUtilsInterface {

    public FileStatus[] getFileStatusListWith(Path srcPath, String startKey, MatchingMode matchingMode, String strEndKey, FileSystem fileSystem) throws IOException {
        return fileSystem.listStatus(srcPath, new MyPathFilter(startKey, matchingMode, strEndKey));
    }

    public FileStatus[] getFileStatus(Path strPath, FileSystem fileSystem) throws IOException {
        return fileSystem.listStatus(strPath);
    }
}
