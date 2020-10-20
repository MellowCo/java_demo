package IO_Uilts;

import java.io.InputStream;
import java.io.OutputStream;

public interface IO_UiltsInterface {
    void copy(InputStream i, OutputStream o);
    void close(InputStream i,OutputStream o);
}
