import java.awt.*;

//need to change void to float
//change class Object to abstract
// change getscreen to use enum SCREEN
public abstract class Object {
    protected float x,y;
    protected ID id;
    protected float velX, velY;

    public Object(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public float getX(){return x; }
    public float getY(){return y; }
    public void setId(ID id){this.id = id;}
    public ID getId(SCREEN screen){return id;}
    public void setVelX(int velX){ this.velX = velX;}
    public void setVelY(int velY){this.velY = velY;}
    public float getVelX(){return velX;}
    public float getVelY(){return velY;}
}
