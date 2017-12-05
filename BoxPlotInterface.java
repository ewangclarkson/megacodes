/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;

import cm.ubeau.clarks.Calculator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.Box;
/**
 *
 * @author EWANG CLARKSON
 */
public class BoxPlotInterface 
{
    private static Box hbox;
    private static JTextArea outputMatrix;
    private static PrintStream stream;
    private static FileInputStream file;
    private static JTextArea inputMatrix;
    private static JButton button,button1;
    final static int MAX_LEN=10000000;
    protected static int strlen=0;
    protected static int boxElement[] = new int[MAX_LEN];
    
   
    public static void getInputInterface()
    {
      button = new JButton("ok");
      button.setForeground(Color.GRAY);
      button.setBackground(Color.WHITE);
      button.setBorderPainted(false);
      hbox = Box.createHorizontalBox();
      hbox.add(button);
       MainCalculatorFrame.vbox.removeAll();
       inputMatrix = new JTextArea();
       inputMatrix.setBackground(Color.WHITE);
       MainCalculatorFrame.vbox.add(inputMatrix);
       MainCalculatorFrame.vbox.add(hbox);
       Calculator.app.getContentPane().setBackground(Color.WHITE);
       Calculator.app.setSize(700,300);
       Calculator.app.setTitle("ENTER THE ELEMENTS FOR BOXPLOT");
       button.addActionListener(
                new ActionListener()
                {
                   
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                       openFile();
                       System.out.printf("%s",inputMatrix.getText());
                       closeFile();
                      MainBoxPlotOperation();
                    }
                     public void openFile()
                     {
                      try{
                          stream = new  PrintStream("BoxPlotInput");
                          System.setOut(stream);
                         }
                        catch(IOException ioexception)
                         {
                           System.err.println(ioexception);
                           System.exit(1);
                         }
                     }
                  public void  closeFile()
                    {
                    stream.close();
                    }
                });
    }
      public static void openFileInput() throws FileNotFoundException
                     {
                         file = new  FileInputStream("BoxPlotInput");
                     }
    public static void MainBoxPlotOperation()
    {
     try{
       openFileInput();
       Scanner input = new Scanner(file);
   
       button1 = new JButton("return");
       button1.setForeground(Color.GRAY);
       button1.setBackground(Color.WHITE);
       button1.setBorderPainted(false);
       while(input.hasNext())
          boxElement[strlen++]=input.nextInt();
 
       MainCalculatorFrame.vbox.removeAll();
       MainCalculatorFrame.vbox.add(new JScrollPane(new InvertedBoxPlot()));
       MainCalculatorFrame.vbox.add(button1);
       button1.setBorderPainted(false);
       button1.addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent event)
                        {
                            MainCalculatorFrame.vbox.removeAll();
                             MainCalculatorFrame.mainInterface();
                        }
                    }
         );
         Calculator.app.setSize(700,700);
         Calculator.app.setTitle("INVERTED BOXPLOT");
         Calculator.app.getContentPane().setBackground(Color.WHITE);
       }
       catch(FileNotFoundException exception)
       {
           System.out.println(exception);
           System.exit(1);
       }
       finally{
           closeFileInput();
          
       }
    }
     public static void  closeFileInput()
                    {
                    stream.close();
                    }
}


/**
 * 
 * @author EWANG CLARKSON
 */
class InvertedBoxPlot extends JPanel
{
    
    @Override
    public  void paintComponent(Graphics graph)
      {
        super.paintComponent(graph);
         
         Random rand = new Random();
                    
          final int TEN=10;
          int red,blue,green,i,number;
        
           int height=getHeight();
           int width=getWidth();
                
             setBackground(Color.WHITE);
           for(i=0;i<BoxPlotInterface.strlen;i++)
            {
              number=BoxPlotInterface.boxElement[i];
              green=rand.nextInt(255);
              red=rand.nextInt(255);
              blue=rand.nextInt(255);
              Color color = new Color(red,blue,green);
              graph.setColor(color);
              graph.fillRect((number*2)+100,5,number*2,number*5);
              graph.drawString(String.format("%d",number),number*2,(number*5) + 10);
           
           }
           graph.setColor(Color.BLUE);
           graph.drawLine(3,5,width-5,5);
           graph.drawLine(width-5,5,width-5,height-3);
           graph.drawLine(3,5,10,0);
           graph.drawLine(3,5,10,10);
           graph.drawLine(width-5,height-3,width,height-8);
           graph.drawLine(width-5,height-3,width-10,height-8);
            

         graph.drawString(String.format("scale : x5"),0,height/2);

     } 
}