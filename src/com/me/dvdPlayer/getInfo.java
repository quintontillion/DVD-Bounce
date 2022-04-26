package com.me.dvdPlayer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class getInfo {

    public int getRescaleSizeWidth() {
        return rescaleSizeWidth;
    }

    public void setRescaleSizeWidth(int rescaleSizeWidth) {
        this.rescaleSizeWidth = rescaleSizeWidth;
    }

    public int getRescaleSizeHeight() {
        return rescaleSizeHeight;
    }

    public void setRescaleSizeHeight(int rescaleSizeHeight) {
        this.rescaleSizeHeight = rescaleSizeHeight;
    }

    int rescaleSizeWidth=0;
    int rescaleSizeHeight=0;
    int x=0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    int possibleamounts=12;
    int y=0;
    int threads=0;
    double speed=0;

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }

    boolean RGB=false;

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }
    int windowWidth=0;

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public boolean isUndecorated() {
        return Undecorated;
    }

    public void setUndecorated(boolean undecorated) {
        Undecorated = undecorated;
    }

    boolean Undecorated=false;
    int windowHeight=0;
    boolean fullscreen=false;
    public getInfo() {
        System.out.println("e");
        BufferedReader lines = null;
        try {
            lines = new BufferedReader(new FileReader("src/com/me/dvdPlayer/Info.json"));
            String temp="";
            String total="";
            int lineAm=0;
            StringBuilder builder = new StringBuilder();
            System.out.println("e");
            while ((temp = lines.readLine()) != null) {
                builder.append(temp);
                builder.append(System.getProperty("line.seperator"));
                total+=temp;
            }
            for (int i=0;i<possibleamounts;i++) {
                JSONObject obj = new JSONObject(total);
                JSONArray arr = obj.names();
                Object obj1 = obj.get(arr.get(i).toString());
                System.out.println(obj1.getClass());
                if (obj1 instanceof Integer) {
                    System.out.println(arr.get(i)+" "+obj1);

                    if (arr.get(i).equals("rescaleSizeWidth")) {
                        this.setRescaleSizeWidth((Integer) obj1);
                    }

                    if (arr.get(i).equals("rescaleSizeHeight")) {
                        this.setRescaleSizeHeight((Integer) obj1);
                    }

                    if (arr.get(i).equals("x")) {
                        this.setX((Integer) obj1);
                    }

                    if (arr.get(i).equals("y")) {
                        this.setY((Integer) obj1);
                    }

                    if (arr.get(i).equals("threads")) {
                        this.setThreads((Integer) obj1);
                    }

                    if (arr.get(i).equals("windowWidth")) {
                        this.setWindowWidth((Integer) obj1);
                    }

                    if (arr.get(i).equals("windowHeight")) {
                        this.setWindowHeight((Integer) obj1);
                    }
                }
                if (obj1 instanceof BigDecimal) {
                    System.out.println(arr.get(i)+" "+obj1);
                    if (arr.get(i).equals("speed")) {
                        this.setSpeed( ((BigDecimal) obj1).doubleValue());
                    }
                }

                if (obj1 instanceof Boolean) {
                    System.out.println(arr.get(i)+" "+obj1);
                    if (arr.get(i).equals("fullscreen")) {
                        this.setFullscreen((boolean) obj1);
                    }

                    if (arr.get(i).equals("Undecorated")) {
                        this.setUndecorated((boolean) obj1);
                    }

                    if (arr.get(i).equals("RGB")) {
                        this.setRGB((boolean) obj1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}