package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ImageFrame frame = new ImageFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Image image = new Image();
        add(image);
    }
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}
class Image extends JComponent
{
    public Image()
    {
        try
        {
            image = ImageIO.read(new File("src/1.jpg"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g)
    {
        if(image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, null);

//        for(int i = 0; i * imageWidth <= getWidth(); i++)
//            for(int j = 0; j * imageHeight <= getHeight(); j++)
//                if(i + j > 0)
//                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }
    private java.awt.Image image;
}
