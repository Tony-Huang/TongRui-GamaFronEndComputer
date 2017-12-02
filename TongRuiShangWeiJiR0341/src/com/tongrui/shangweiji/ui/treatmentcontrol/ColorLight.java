package com.tongrui.shangweiji.ui.treatmentcontrol;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ColorLight extends JPanel implements ActionListener, Observer {
    protected GeneralPath secondHand = new GeneralPath();
    protected Ellipse2D face;
    private Color clockColor;
    private boolean hasArrow;
    private int radius;
    private int size;
    private double arrowDirection = 0;
    private boolean arrowCycling = false;

    public double getArrowDirection() {
        return arrowDirection;
    }

    public void setArrowDirection(double arrowDirection) {
        if (hasArrow){
            this.arrowDirection = arrowDirection;
            secondTransform.setToRotation((arrowDirection * Math.PI / 6.0), radius, radius); //Half cycle is six hours
            repaint();
        }
    }
    

    public boolean isArrowCycling() {
        return arrowCycling;
    }
    protected static Color secondColor = Color.black;

    public ColorLight(Color color, boolean hasArrow, int radius) {
        this.clockColor = color;
        this.hasArrow = hasArrow;
        this.radius = radius;
        this.size = 2*radius + 2; //Width and Hight
        setArrow(hasArrow);

        face = new Ellipse2D.Float(0, 0, 2 * radius, 2 * radius);
    }

     public ColorLight() {
         this(Color.gray, true, 20);
     }
     
    protected AffineTransform secondTransform = AffineTransform.getRotateInstance(0, radius, radius);

    public void setArrow(boolean hasArrow_) {
        this.hasArrow = hasArrow_;
        if (hasArrow_) {
            secondHand.moveTo(radius - 1, 12);
            secondHand.lineTo(radius + 1, 12);
            secondHand.lineTo(radius + 1, radius);
            secondHand.lineTo(radius - 1, radius);
            secondHand.lineTo(radius - 1, 12);

            secondHand.moveTo(radius - 3, 12);
            secondHand.lineTo(radius + 3, 12);
            secondHand.lineTo(radius, 1);
            secondHand.lineTo(radius - 3, 12);
        } else {
            secondHand.reset();
        }
        repaint();
    }

    public boolean isHasArrow() {
        return hasArrow;
    }
    
    protected Timer timer = new Timer(200, this);

    public void setArrowCycle(boolean toCycle) {
        if (toCycle) {
            arrowCycling = true;
            timer.start();
        } else {
            timer.stop();
            arrowCycling = false;
        }
    }

    // 当这个时钟面板从一个容器中删除
    public void removeNotify() {
        timer.stop();
        super.removeNotify();
    }

    // 计时器动作事件
    public void actionPerformed(ActionEvent event) {
        arrowDirection += 0.5;
        
//        //Example of moving the watch
//        if(arrowDirection > 500) arrowDirection = 10;
//        this.setBounds((int)arrowDirection, (int)arrowDirection, size, size);
        
        if (hasArrow){
            secondTransform.setToRotation((arrowDirection*Math.PI / 6.0), radius, radius); //Half cycle is six hours
            repaint();
        }
    }
    
    public void paint(Graphics g) {
        // Call the superclass first to paint the border (if one is assigned)
        super.paint(g);
        // Get the graphics context and turn on anti-aliasing
        Graphics2D g2 = (Graphics2D) g;
        // 开启反锯齿
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        // Set the paint for the clock face and fill it in
        // 时钟表面颜色设置和填充
        g2.setPaint(clockColor);
        g2.fill(face);
        // Set the paint to black and draw the clock's outline
        // 黑色绘画时钟轮廓
        g2.setPaint(Color.black);
        g2.draw(face);

        // 绘画秒针
        if (hasArrow) {
            g2.setPaint(secondColor);
            g2.fill(secondHand.createTransformedShape(secondTransform));
        }
    }

    public void setClockColor(Color col){
        this.clockColor = col;
        repaint();
    }

    public Color getClockColor() {
        return clockColor;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
