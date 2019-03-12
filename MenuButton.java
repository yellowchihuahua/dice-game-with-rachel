import java.awt.*;

public class MenuButton {
    public MenuButton(int x, int y, int buttonWidth, int buttonHeight, String buttonText, Graphics g){
        g.setColor(Color.white);
        g.fillRoundRect(x,y,buttonWidth,buttonHeight, 20,20);

        Font buttonfont = new Font("Calibri",1,buttonHeight-20);

        g.setFont(buttonfont);
        g.setColor(Color.red);
        g.drawString(buttonText,(x + buttonWidth)/2,y + 57);

    }

}
