package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public BufferedImage  up0, up1, up2, up1w, up2w, down0, down1, down2, down1w, down2w, left1, left2, left1w, left2w, right1, right2, right1w, right2w;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
