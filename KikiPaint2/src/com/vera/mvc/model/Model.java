/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;


public class Model extends Observable {

    MyShape currentShape;
    MyShape sampleShape;
    ArrayList<MyShape> list;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public Model() {
        list = new ArrayList<>();
    }

    public Model(MyShape sampleShape) {
        this.sampleShape = sampleShape;
        list = new ArrayList<>();
    }

    public void inintCurrentShape() {
        currentShape = sampleShape.clone();
        list.add(currentShape);
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        if (list != null) {
            for (MyShape s : list) {
                s.draw(g);
            }
        }
    }

}
