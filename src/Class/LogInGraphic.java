/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.JFrame;

/**
 *
 * @author yunus
 */
public class LogInGraphic extends JFrame {

    public LogInGraphic(){
        super("Entry");

        // Set default close operation for JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set JFrame size
        setSize(400, 400);

        // Make JFrame visible
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        // draw the face
        g.setColor(Color.YELLOW);
        g.fillOval(100, 30, 200, 200);

        // draw the eyes
        g.setColor(Color.BLACK);
        g.fillOval(145, 85, 30, 30);
        g.fillOval(215, 85, 30, 30);

        // draw the mouth
        g.fillOval(140, 110, 120, 60);

        // "touch up" the mouth into a smile
        g.setColor(Color.YELLOW);
        g.fillRect(140, 110, 120, 30);
        g.fillOval(140, 120, 120, 40);

        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke1 = new BasicStroke(6f);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(stroke1);
        g2d.setFont(new Font("Algerian", Font.PLAIN, 30));
        g2d.drawString("SUCCESFULLY LOG IN", 55, 300);
        g2d.drawRect(10, 240, 370, 120);
    }

    public static void main(String[] args) {
        LogInGraphic panel = new LogInGraphic();

    }
}
