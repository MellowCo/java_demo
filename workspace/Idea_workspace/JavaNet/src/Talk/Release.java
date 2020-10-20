package Talk;

import java.io.Closeable;
import java.io.IOException;

//关闭流
public class Release {
    static void close(Closeable... targets){

        //遍历关闭流
        for (Closeable target : targets) {
            if(target!=null){
                try {
                    target.close();
                } catch (IOException e) {
                    System.out.println("Release异常");
                }
            }
        }

    }

}
