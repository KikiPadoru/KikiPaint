/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.view;

import com.vera.mvc.Controller.State;
import com.vera.mvc.model.MyShape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MyFrame extends JFrame {

    MyPanel panel;
    State state;
    Toolkit toolkit= Toolkit.getDefaultToolkit();
    Dimension dimension= toolkit.getScreenSize();

    public MyFrame(State state) {
        this.state = state;
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        JMenu file = new JMenu("Файл");
        JMenu menu=new JMenu("Заливка");;
        JMenu color = new JMenu("Цвет");
        JMenu jColor = new JMenu("Свой цвет");
        JMenu figures = new JMenu("Фигура");
        JMenuItem colorChooser = new JMenuItem("OK");
        menu.setBackground(Color.GRAY);
        menu.setOpaque(true);
        jColor.setOpaque(true);
        color.setOpaque(true);
        bar.add(file);
        bar.add(menu);
        bar.add(color);
        bar.add(jColor);
        bar.add(figures);
        JMenuItem jMenuItem;
        jMenuItem = new JMenuItem("Fill");
        JMenuItem jMenuItem1;
        jMenuItem1 = new JMenuItem("NoFill");
        menu.add(jMenuItem);
        menu.add(jMenuItem1);
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.FILL);
            }
        });
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.NO_FILL);
            }
        });
        //////////////////////////////////////
        JMenuItem Yellow=new JMenuItem("");
        Yellow.setBackground(Color.YELLOW);
        Yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.YELLOW);
                color.setBackground(Color.YELLOW);
                jColor.setBackground(Color.YELLOW);
            }
        });
        JMenuItem Red = new JMenuItem("");
        Red.setBackground(Color.RED);
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.RED);
                color.setBackground(Color.RED);
                jColor.setBackground(Color.RED);
            }
        });
        JMenuItem Green = new JMenuItem("");
        Green.setBackground(Color.GREEN);
        Green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.GREEN);
                color.setBackground(Color.GREEN);
                jColor.setBackground(Color.GREEN);
            }
        });
        JMenuItem Blue = new JMenuItem("");
        Blue.setBackground(Color.BLUE);
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.BLUE);
                color.setBackground(Color.BLUE);
                jColor.setBackground(Color.BLUE);
            }
        });
        JMenuItem Black = new JMenuItem("");
        Black.setBackground(Color.BLACK);
        Black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.BLACK);
                color.setBackground(Color.BLACK);
                jColor.setBackground(Color.BLACK);
            }
        });
        JMenuItem Magenta = new JMenuItem("");
        Magenta.setBackground(Color.MAGENTA);
        Magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.MAGENTA);
                color.setBackground(Color.MAGENTA);
                jColor.setBackground(Color.MAGENTA);
            }
        });
        JMenuItem White = new JMenuItem("");
        White.setBackground(Color.WHITE);
        White.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.WHITE);
                color.setBackground(Color.WHITE);
                jColor.setBackground(Color.WHITE);
            }
        });
        color.add(White);
        color.add(Black);
        color.add(Yellow);
        color.add(Red);
        color.add(Green);
        color.add(Blue);
        color.add(Magenta);

        JMenuItem Rectangle = new JMenuItem("Квад");
        Rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setRectangularShape(new Rectangle2D.Double());
            }
        });
        JMenuItem Ellipse = new JMenuItem("Круг");
        Ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setRectangularShape(new Ellipse2D.Double());
            }
        });

        figures.add(Rectangle);
        figures.add(Ellipse);
        ///////////////////////////////////////////////
        JColorChooser jColorChooser = new JColorChooser();
        jColor.add(jColorChooser);
        jColor.add(colorChooser);
        colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color a = jColorChooser.getColor();
                state.setColor(a);
                color.setBackground(a);
                jColor.setBackground(a);
            }
        });
        /////////////////////////////////////////////////////////////////
        JMenuItem save =new JMenuItem("Сохранить");
        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savefile();
            }
        });
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(dimension.width/2-500,dimension.height/2-300,1000, 600);
        setTitle("KikiPaint");
        setVisible(true);
    }
    public void savefile()
    {
        BufferedImage image2 = new BufferedImage(panel.getWidth(), panel.getHeight(),     BufferedImage.TYPE_INT_RGB);
        JFileChooser jFile = new JFileChooser();
        jFile.showSaveDialog(null);
        Path pth = jFile.getSelectedFile().toPath();
        JOptionPane.showMessageDialog(null, pth.toString());
        Graphics2D graphics2D = image2.createGraphics();
        panel.paint(graphics2D);
        graphics2D.dispose();
        try {
            ImageIO.write(image2, "jpeg", new File(pth.toString()+".jpeg"));
        } catch (IOException ox) {
            // TODO: handle exception
            ox.printStackTrace();

        }
    }
    public void setPanel(MyPanel panel) {
        panel.setBackground(Color.WHITE);
        this.panel = panel;
        add(panel);
    }
}
