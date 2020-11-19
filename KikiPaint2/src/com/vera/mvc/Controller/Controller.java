/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import com.vera.mvc.model.Model;
import com.vera.mvc.model.MyShape;
import com.vera.mvc.view.MyFrame;
import com.vera.mvc.view.MyPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author Wera
 */
public class Controller {
    Model model;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pd;
    State state;
    MyShape shape;
    public Controller() {
        model = new Model();
        state = new State(model);
        state.setShape(new MyShape(new Rectangle2D.Double()));
        state.setColor(Color.yellow);
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame(state);
        frame.setPanel(panel);
        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pd[0] = p;
        model.inintCurrentShape();
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        model.changeShape(pd);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

}
