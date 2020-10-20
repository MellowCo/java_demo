package IO_Uilts;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO_Uilts implements IO_UiltsInterface {

    @Override
    public void copy(InputStream i, OutputStream o) {
            int len = -1;
            byte a[] = new byte[1024];

        try {
            while((len=i.read(a))!=-1){
                o.write(a,0,len);
                o.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(i,o);
        }
    }

    @Override
    public void close(InputStream i, OutputStream o) {
        try {
            if(i!=null){
                i.close();
            }
            if(o!=null){
                o.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
