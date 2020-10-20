package Stream;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {
        Buffered b = new Buffered();
        long t1 = System.currentTimeMillis();

        b.copy();
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}

class Buffered {

    public void copy() {

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new BufferedInputStream(new FileInputStream("plane.png"));
            os = new BufferedOutputStream(new FileOutputStream("plane-copy.png"));
            int len = -1;
            byte a[] = new byte[1024];

            while ((len = is.read(a)) != -1) {
                os.write(a, 0, len);
                os.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (os != null) {
                    os.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}