package WebDown;

import java.io.IOException;

public class StartWebDown extends Thread {
    private String url;
    private String name;

    public StartWebDown(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void run() {
        WebDowner wd = new WebDowner();
        try {
            wd.down(url,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        StartWebDown s = new StartWebDown("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549256469&di=bd1540e74cf58a644101e427572ae925&imgtype=jpg&er=1&src=http%3A%2F%2Fstatic.open-open.com%2Flib%2FuploadImg%2F20150829%2F20150829171421_548.jpg","1.jpg");
        StartWebDown s2 = new StartWebDown("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2709495586,1126321144&fm=26&gp=0.jpg","2.jpg");
        StartWebDown s3 = new StartWebDown("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3073503467,2696779211&fm=15&gp=0.jpg","3.jpg");

        s.start();
        s2.start();
        s3.start();

    }
}
