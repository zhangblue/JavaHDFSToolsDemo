package cn.com.zhangdi.utils.service;

import cn.com.zhangdi.utils.MatchingMode;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by zhangdi on 2017/06/21.
 */
public interface HDFSUtilsInterface {
    FileStatus[] getFileStatusListWith(Path srcPath, String startKey, MatchingMode matchingMode, String strEndKey, FileSystem fileSystem) throws IOException;

    FileStatus[] getFileStatus(Path strPath,FileSystem fileSystem) throws IOException;


}
