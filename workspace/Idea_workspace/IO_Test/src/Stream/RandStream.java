package Stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandStream {
    public static void main(String[] args) throws IOException {
        test1 ts = new test1();
        //ts.t1();
        File file = new File("li.text");
        ts.feng(file, 1024);
    }

}


class test1 {

    void t1(int beginPos, int endPos) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("li.text"), "r");
        raf.seek(beginPos);
        int len = -1;
        byte a[] = new byte[1024];

        while ((len = raf.read(a)) != -1) {
            if (endPos > len) {

                String s = new String(a, 0, len);
//                System.out.println(s);
                endPos -= len;

            } else {
                String s = new String(a, 0, len);
//                System.out.println(s);
                break;
            }

        }
    }


    void feng(File file, int fengSize) throws IOException {
        long size = file.length();
        int shu = (int) (Math.ceil(size * 1.0 / fengSize));
        System.out.println(size);


        for (int i = 0; i < shu; i++) {
            int actualSize = (int) (size > fengSize ? fengSize : size);
            System.out.println(actualSize+"-->"+size);
            int beginPos = fengSize * i;
            int endPos;

            if (actualSize != fengSize) {
                endPos = actualSize;
            } else {
                endPos = fengSize;
            }
            size -= endPos;
            System.out.println(i + "----" + beginPos + "---" + endPos);
            t1(beginPos, endPos);
        }


    }


}