package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - gp.tileSize / 2;
        screenY = gp.screenHeight/2 - gp.tileSize / 2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = 25 * gp.tileSize;
        worldY = 25 * gp.tileSize;
        speed = 10;
        direction = "down";
    }

    public void getPlayerImage(){

        try {

//            up0 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_up_0.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_up_2.png"));
            up1w = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_up_1_Wait.png"));

//            down0 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_down_0.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_down_2.png"));
            down1w = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_down_1_Wait.png"));

            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_left_2.png"));
            left1w = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_left_1_Wait.png"));

            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_right_2.png"));
            right1w = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Player/motor/player_right_1_Wait.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){
                direction = "down";
            }
            else if(keyH.leftPressed == true){
                direction = "left";
            }
            else if(keyH.rightPressed == true){
                direction = "right";
            }
//            else if(keyH.upPressed == true && keyH.leftPressed == true){
//                direction = "upLeft";
//            }
//            else if(keyH.upPressed == true && keyH.rightPressed == true){
//                direction = "upRight";
//            }
//            else if(keyH.downPressed == true && keyH.leftPressed == true){
//                direction = "downLeft";
//            }
//            else if(keyH.downPressed == true && keyH.rightPressed == true){
//                direction = "downRight";
//            }

            spriteCounter++;
            if(spriteCounter > 1){
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                else if (spriteNum == 0){
                    spriteNum = 2;
                }
                spriteCounter = 0;
            }
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.chekTile(this);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false){
//                switch (direction){
//                    case "up": worldY -= speed; break;
//                    case "down": worldY += speed; break;
//                    case "left": worldX -= speed; break;
//                    case "right": worldX += speed; break;
//                }
                if(direction == "up"){
                    worldY -= speed;
                }
                else if(direction == "down"){
                    worldY += speed;
                }
                else if(direction == "left"){
                    worldX -= speed;
                }
                else if(direction == "right"){
                    worldX += speed;
                }
//                else if(direction == "upLeft"){
//                    worldY -= speed;
//                    worldX -= speed;
//                }
//                else if(direction == "upRight"){
//                    worldY -= speed;
//                    worldX += speed;
//                }
//                else if(direction == "downLeft"){
//                    worldY += speed;
//                    worldX -= speed;
//                }
//                else if(direction == "downRight"){
//                    worldY += speed;
//                    worldX += speed;
//                }
            }
        }
        else if(direction == "up"){
            spriteNum = 0;
        }
        else if(direction == "down"){
            spriteNum = 0;
        }
        else if(direction == "left"){
            spriteNum = 0;
        }
        else if(direction == "right"){
            spriteNum = 0;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.ORANGE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 0){
                    image = up1w;
                }
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 0){
                    image = down1w;
                }
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 0){
                    image = left1w;
                }
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 0){
                    image = right1w;
                }
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,  null);
    }
}
