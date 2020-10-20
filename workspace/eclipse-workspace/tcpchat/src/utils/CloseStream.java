package utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseStream {
    public static void closeAll(Closeable... closeables){
        for (Closeable closeable : closeables) {
            if(closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
