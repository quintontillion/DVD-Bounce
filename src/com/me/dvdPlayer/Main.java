package com.me.dvdPlayer;

import javax.swing.*;

public class Main {
    JFrame frame;
    getInfo Info;
    public Main(){
        Info = new getInfo();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,Info.getWindowWidth(),Info.getWindowHeight());
        frame.setUndecorated(Info.isUndecorated());
        if (Info.isFullscreen()){
            frame.setBounds(0,0,1920,1080);
        }
        JPanel updater = new PanelUpdater(Info);
        frame.add(updater);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        new Main();
    }
}