package IO_Uilts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitMerge {
    public static void main(String[] args) throws IOException {
        File file = new File("li.text");
       // File endFile = new File("I:\\Java\\Idea_workspace\\IO_Test\\copy");
        String endPath = "I:\\Java\\Idea_workspace\\IO_Test\\copy";
        encapsulation en = new encapsulation(file, 1024, endPath);
        en.jisuan();
    }

}


class encapsulation {
    private File file;
    private int size;
    private String endPath;
    private File endFile;
    private List<String> pathList =new ArrayList<>();

    public encapsulation(File file, int size, String endPath) {
        this.file = file;
        this.size = size;
        this.endPath = endPath;
    }

    void jisuan() throws IOException {
        long fileSize = file.length();
        System.out.println(fileSize);
        int block = (int) Math.ceil(fileSize * 1.0 / size);
        int actualSize = (int) (fileSize > size ? size : fileSize);


        for (int i = 0; i < block; i++) {
            int beginPos = size * i;
            int endPos;
            System.out.println(i+"->"+actualSize);
            if (i == block - 1) {
                endPos = actualSize;
            } else {
                endPos = size;
            }
            endFile = new File(endPath,"copy-"+i+"-"+file.getName());
            pathList.add(endFile.getAbsolutePath());
            split(beginPos, endPos);
        }
            merge();

    }


    void split(int beginPos, int endPos) throws IOException {
        RandomAccessFile ras = new RandomAccessFile(file, "r");
        RandomAccessFile destRas = new RandomAccessFile(endFile, "rw");
        int len = -1;
        byte a[] = new byte[1024];
        ras.seek(beginPos);

        while ((len = ras.read(a)) != -1) {
            if (len > endPos) {
                destRas.write(a, 0, len);
                endPos -= len;
            } else {
                destRas.write(a, 0, len);
                break;
            }
        }
    }

    void merge() throws IOException {
        BufferedOutputStream fis = new BufferedOutputStream(new FileOutputStream(new File(endPath,"vector.text")));
        Vector<InputStream> is = new Vector<>();
        for (int i=0;i<pathList.size();i++){
            is.add(new BufferedInputStream(new FileInputStream(pathList.get(i))));
        }

        SequenceInputStream sis = new SequenceInputStream(is.elements());
        int len = -1;
        byte a[] = new byte[1024];

        while ((len=sis.read(a))!=-1){
            fis.write(a,0,len);
        }
        fis.flush();
        sis.close();
        fis.close();
    }
}

