import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter {

    //initialize
    private Main main;
    private Handler handler;
    Random r = new Random();

    //thingies
    public static int buttonWidth = 500;
    public static int buttonHeight = 80;
    private int buttonPadding = 100;
    private int arc = 20;
    private int bounceVel = 20;
    public int buttonXstart = (Main.WIDTH - buttonWidth) / 2;



    public Menu(Main main, Handler handler){
        //initialize
        this.main = main;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        System.out.println("mouse pressed");


        //if statements for gamestate
        if(MouseOver(mx,my,(Main.WIDTH-buttonWidth)/2, 255, buttonWidth, buttonHeight)){
            //main.gameScreen = SCREEN.HighLow;
            System.out.println("highlow");
        }
        else if(MouseOver(mx,my,(Main.WIDTH-buttonWidth)/2, 255+buttonPadding, buttonWidth, buttonHeight)){
          //  main.gameScreen = SCREEN.Craps;
            System.out.println("craps");
        }
        else if(MouseOver(mx,my,(Main.WIDTH-buttonWidth)/2, 255+buttonPadding*2,buttonWidth,buttonHeight)){
            System.exit(1);
        }
    }

    public void MouseReleased(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(MouseOver(mx,my,300,300,buttonHeight,buttonHeight)){
            main.gameScreen = SCREEN.Menu;
        }


    }

    private boolean MouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }


    public void render(Graphics g){

 /*       if(main.gameScreen == SCREEN.Menu) {
            new MenuButton(buttonXstart, 225, buttonWidth, buttonHeight, "", g);
        }
        else if(main.gameScreen == SCREEN.HighLow) {
            handler.addObject(new MenuParticle((r.nextInt((buttonXstart + buttonWidth-30) - (buttonXstart+30)) + (buttonXstart+30)), (r.nextInt(buttonYend - (225+15))+ (225+15)),ID.MenuParticle, handler));
            System.out.println("particle");
            new MenuButton(buttonXstart, 227, buttonWidth, buttonHeight, "", g);
        }
*/
        Font ourfont= new Font("Calibri", 1, 100);
        //titles
        g.setColor(Color.white);
        g.setFont(ourfont);
        g.drawString("Dice Game", 255   , 150);

        //buttons
        new MenuButton((Main.WIDTH-buttonWidth)/2,225,buttonWidth,buttonHeight,"HighLow",g);
        new MenuButton((Main.WIDTH-buttonWidth)/2,225+buttonPadding,buttonWidth,buttonHeight,"Craps",g);
        new MenuButton((Main.WIDTH-buttonWidth)/2,225+buttonPadding*2,buttonWidth,buttonHeight,"Quit",g);

       // System.out.println("rendering");

    }

    public void tick(){

    }

}
