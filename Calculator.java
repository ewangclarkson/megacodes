/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;

/**
 *
 * @author EWANG CLARKSON
 */
//the lines of codes below imports classes and its methods from the java API
import javax.swing.JFrame;
import java.awt.Color;
import cm.ubeau.clarks.MainCalculatorFrame;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.Icon;

public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static JFrame app;
    
    public static void main(String[] args)
    {
      app = new JFrame();
      MainCalculatorFrame.mainInterface();
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      app.setResizable(false);
      app.setBackground(Color.LIGHT_GRAY);
      app.setVisible(true);
    }
    
}
