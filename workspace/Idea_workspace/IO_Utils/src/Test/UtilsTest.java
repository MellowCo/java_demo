package Test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UtilsTest {
    public static void main(String[] args) throws IOException {
        File file = new File("li.text");

        //文件大小
        long len = FileUtils.sizeOf(new File("li.text"));
        System.out.println(len);

        //文件夹大小
        len = FileUtils.sizeOfDirectory(new File("I:\\Java\\Idea_workspace"));
        System.out.println(len);

        /**
         * 输出文件路径下的文件，没有文件不输出
         *
         *  DirectoryFileFilter.INSTANCE 子孙级，为空，操作当前路径
         *  EmptyFileFilter.NOT_EMPTY 文件不为空
         */
//        Collection<File> c = FileUtils.listFiles(new File("I:\\Java\\eclipse"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
//        for(File f:c){
//            System.out.println(f.getAbsolutePath());
//        }

        //文件到String
        String msg=FileUtils.readFileToString(file,"utf8");
        System.out.println(msg);

        //文件到byte[]
        byte a[] = FileUtils.readFileToByteArray(file);
        System.out.println(a.length);

        //逐行读取
        List<String> l = FileUtils.readLines(file, "utf8");
        for (String s: l ) {
            System.out.println(s);
        }

        //拷贝文件
        FileUtils.copyFile(file,new File("li-copy.text"));

        //拷贝文件到目录
        FileUtils.copyFileToDirectory(file,new File("lib"));

        //拷贝url内容
        String url = "http://www.baidu.com";
        FileUtils.copyURLToFile(new URL(url),file);
    }

}
