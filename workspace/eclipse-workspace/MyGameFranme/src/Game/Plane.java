package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
    boolean up,down,left,right;
    boolean live=true;
    public void drawSelf(Graphics g) {
        if(live) {
            
            super.drawSelf(g);
            
            if(up) {
                y-=speed;
            }
            
            if(down) {
                y+=speed;
            }
            
            if(left) {
                x-=speed;
            }
            
            if(right) {
                x+=speed;
            }
        }
        
    
    }
    
    public Plane(Image img, double x, double y) {
        this.img=img;
        this.x=x;
        this.y=y;
        this.width=img.getWidth(null);
        this.height=img.getHeight(null);
    }
    
    public void addDirection(KeyEvent e) {
        switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
            up=true;
            break;
            
        case KeyEvent.VK_DOWN:
            down=true;
            break;
            
        case KeyEvent.VK_LEFT:
            left=true;
            break;
            
        case KeyEvent.VK_RIGHT:
            right=true;
            break;
        }  
    }
    
    public void misDirection(KeyEvent e) {
        switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
            up=false;
            break;
            
        case KeyEvent.VK_DOWN:
            down=false;
            break;
            
        case KeyEvent.VK_LEFT:
            left=false;
            break;
            
        case KeyEvent.VK_RIGHT:
            right=false;
            break;
        }  
    }
    
    
    
}
