import java.awt.*;
import java.util.Random;

public class MenuParticle extends Object{

    private Handler handler;
    Random r = new Random();

    private Color color;
    private int randomColor;

    public MenuParticle(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;


        if(this.y > (y+Menu.buttonHeight)/2){
            velY = r.nextInt((5)+1)-5;
        }
        if(this.y <= (y+Menu.buttonHeight)/2){
            velY = r.nextInt((5)+1);
        }
        velX = 0;
    //    if(this.x > (x+Menu.buttonWidth)/2){
    //        velX = r.nextInt((5)+1)-5;
    //    }
    //    if(this.y <= (y+Menu.buttonWidth)/2){
    //        velX = r.nextInt((5)+1);
    //    }
        int randomColor = r.nextInt(3);

        if(randomColor == 0) {
            color = new Color(255, 195, 43);
        }
        else if(randomColor == 1){
            color = new Color(255,27,15);
        }
        else if(randomColor == 2){
            color = new Color(255,144,0);
        }

    }

    public Rectangle getBounds(){return new Rectangle((int)x,(int)y,3,3);}

    public void tick(){
        x+=velX;
        y+=velY;

        if(y <= 0 || y >= Main.HEIGHT){
            handler.removeObject(this);
        }
        if(x <= 0 || x >= Main.WIDTH){
            handler.removeObject(this);
        }


    }

    public void render(Graphics g){
        g.setColor(color);
        g.fillRoundRect((int)x,(int)y,4,4,2,2);
    }
}
