#### 简介
模块化hds的操作函数

#### [HDFS工具类][1]介绍
* 获取指定HDFS目录下以固定开头的文件列表：
```
FileStatus[] getFileStatusListStartWith(String strPath, String strKey, FileSystem fileSystem)

FileStatus[] getFileStatusListStartWith(Path path, String strKey, FileSystem fileSystem)
```

* 获取指定HDFS目录下以固定结尾的文件列表
```
FileStatus[] getFileStatusListEndWith(String strPath, String strEndKey, FileSystem fileSystem)

FileStatus[] getFileStatusListEndWith(Path path, String strEndKey, FileSystem fileSystem)
```

* 获取指定HDFS目录下文件名包含指定内容的文件列表
```
FileStatus[] getFileStatusListContainsWith(String strPath, String strBeginKey, FileSystem fileSystem)

FileStatus[] getFileStatusListContainsWith(Path path, String strBeginKey, FileSystem fileSystem)

```

[1]:./src/main/java/cn/com/zhangdi/utils/service/impl/HDFSUtils.java