package Web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class WebDown extends Thread{
    private String url;
    private String name;
    public WebDown(String url, String name) {
        super();
        this.url = url;
        this.name = name;
    }
    
    @Override
    public void run() {
        WebDownClass wds = new WebDownClass();
        wds.down(url, name);
    }
    
    public static void main(String[] args) {
        WebDown wd = new WebDown(  "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549256469&di=bd1540e74cf58a644101e427572ae925&imgtype=jpg&er=1&src=http%3A%2F%2Fstatic.open-open.com%2Flib%2FuploadImg%2F20150829%2F20150829171421_548.jpg","1.jpg" );
        WebDown wd2 = new WebDown("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2709495586,1126321144&fm=26&gp=0.jpg","2.jpg");
        WebDown wd3 = new WebDown("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3073503467,2696779211&fm=15&gp=0.jpg","3.jpg");
        
        wd.start();
        wd2.start();
        wd3.start();        
    }
}

class WebDownClass{
    void down(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}