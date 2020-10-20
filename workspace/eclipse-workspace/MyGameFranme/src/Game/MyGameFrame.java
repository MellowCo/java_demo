package Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


public class MyGameFrame extends Frame{
        
    private Image offScreenImage = null;
    
        public void update(Graphics g) {
            if(offScreenImage == null)
                offScreenImage = this.createImage(500,500);//这是游戏窗口的宽度和高度
         
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    } 
    
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeImg,250,250);
	Shell shells[]=new Shell[Constant.GAME_SHELLS];
	Explode explode;
	
	Date startTime=new Date();
	Date endTime;
	int time;
	
	public void paint(Graphics g) {
	    Color c=g.getColor();
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);

		//画出50个炮弹
		for(int i=0;i<shells.length;i++) {
		    shells[i].draw(g);
		    
		    //碰撞检测
	    boolean peng=shells[i].getRect().intersects(plane.getRect());
	    if(peng) {
	        plane.live=false;
	        if(explode==null) { 
	             explode=new Explode(plane.x,plane.y);
	             endTime=new Date();
	             time=(int)((-startTime.getTime()+endTime.getTime())/1000);
	        }
	        explode.drawExplode(g);
	    }
	    
	     if(!plane.live) {
	         g.setColor(Color.WHITE); 
	         Font f=new Font("宋体",1 , 20);
	         g.setFont(f);
	         g.drawString("游戏时间："+time+"秒", (int)plane.x, (int)plane.y);
	     }
		}
		g.setColor(c);
	}
	
//窗口初始化	
public void launchFrame() {
	setTitle("li");
	setSize(Constant.GAME_WIDTH,Constant.GAME_HIGH);
	setLocation(300, 300);
	setVisible(true);
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
	});	
	new PaintThread().start();
	addKeyListener(new KeyMonitor());
	
	//初始化炮弹个数
	for(int i=0;i<shells.length;i++) {
	    shells[i]=new Shell();
	}
	
}

//多线程
class PaintThread extends Thread{
	@Override
	public void run() {
			while(true) {
					repaint();
					try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
			}
	}
}

//键盘监听
class KeyMonitor extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        plane.addDirection(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.misDirection(e);
    }
    
}

		
public static void main(String[] args) {
        MyGameFrame game=new MyGameFrame();
		game.launchFrame();
	} 
}
