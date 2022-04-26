package com.me.dvdPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PanelUpdater extends JPanel {
    boolean topLeft=true,topRight=false,bottomLeft=false,bottomRight=false;
    public Image Resize(BufferedImage img, int width, int height, double resizeAm) {
        Image Img = img.getScaledInstance(width,height, Image.SCALE_AREA_AVERAGING);
        return Img;
    }
    Random rand = new Random();
    int CharacterX= rand.nextInt(200)+400;
    int CharacterY=rand.nextInt(200)+200;
    //int CharacterX= 750;
   //int CharacterY=400;
    public getInfo info;
    public PanelUpdater getPanel() {
        return this;
    }
    public void init(double Speed, getInfo info) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getInfo info = new getInfo();
                while (true) {
                    getPanel().repaint();
                    synchronized(Thread.currentThread())
                    {
                        try {
                            Thread.currentThread().sleep((long) (info.getSpeed()*16));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.start();
    }
    public PanelUpdater(getInfo info) {
        this.init(info.getSpeed(), info);
        this.info=info;
    }
    @Override
    public void paintComponent(Graphics g) {
        try {
            g.setColor(Color.white);
            g.fillRect(0,0,1920,1080);
            BufferedImage img = ImageIO.read(new File("src/com/me/dvdPlayer/Window.png"));
            if (topLeft) {
                CharacterX++;
                CharacterY++;
            }
            if (topRight) {
                CharacterX++;
                CharacterY--;
            }
            if (bottomLeft) {
                CharacterX--;
                CharacterY++;
            }
            if (bottomRight) {
                CharacterX--;
                CharacterY--;
            }
            if (this.getHeight()-CharacterY-info.getRescaleSizeHeight()==0 && this.getWidth()-CharacterX-info.getRescaleSizeWidth()==0) {
                System.out.println("hit bottom right!");
            }
            if (this.getWidth()-CharacterX-info.getRescaleSizeWidth()==0) {
                System.out.println(topLeft);
                System.out.println(topRight);
                System.out.println(bottomLeft);
                System.out.println(bottomRight);
                if (topRight) {
                    bottomRight=true;
                    topRight=false;
                }
                if (topLeft) {
                    bottomLeft=true;
                    topLeft=false;
                }
            }
            if (this.getHeight()-CharacterY-info.getRescaleSizeHeight()==0) {
                if (topLeft) {
                    topRight=true;
                    topLeft=false;
                }
                if (bottomLeft) {
                    bottomRight=true;
                    bottomLeft=false;
                }
            }
            if (CharacterY==0) {
                if (bottomRight) {
                    bottomLeft=true;
                    bottomRight=false;
                }
                if (topRight) {
                    topLeft=true;
                    topRight=false;
                }

            }
            if (CharacterX==0) {
                if (bottomLeft) {
                    topLeft=true;
                    bottomLeft=false;
                }
                if (bottomRight) {
                    topRight=true;
                    bottomRight=false;
                }
            }
            g.drawImage(Resize(img, info.getRescaleSizeHeight(),info.getRescaleSizeWidth(),info.speed),CharacterX,CharacterY,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
