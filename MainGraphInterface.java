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
/*
 *the following calls includes classes and their main methods from the java API
 */
import cm.ubeau.clarks.Calculator;
import cm.ubeau.clarks.MainCalculatorFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Box;
import static java.lang.Math.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//start of the main class
public class MainGraphInterface
{
   private static final int maximumButSize=12;
   private static final int maximumBoxSize=5;
   private static Font font;
   private static JButton returnButton;
   private static JButton buttons[] = new JButton[maximumButSize];
   private static Box hbox[] = new Box[maximumBoxSize];
   
   private static String display[] = { "linear        ","Quadratic  ","Degree3  ",
                                       "Degree4   ","Degree5     ","Degree6 ",
                                       "Degree7   ","Degree8     ","Degree9 ",
                                       "Degree10 ","DrawShape","Drawing  "
                                     };
   
   public static void graphInterface()
   {
      int loop=0;
      //the line of code below calls the inner  class EventHandler when a button is pressed
       EventHandler handler = new EventHandler();
       /*
        *creats font object to change the default font and creats a
        *button to enable the user to return to the main calculator Interface
        */
       font = new Font("serif",Font.BOLD,20);
       returnButton = new JButton("          LOAD THE MAIN WINDOW       ");
       returnButton.setBackground(Color.WHITE);
       returnButton.setForeground(Color.GRAY);
       returnButton.setFont(font);
       //CALLS the class MainCalculatorFrame to load the main window
       returnButton.addActionListener(
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
      //the next lines of codes creats the new buttons
       for(int i=0;i<maximumButSize;i++)
       {
           buttons[i] = new JButton(display[i]);
           buttons[i].setFont(font);
           buttons[i].addActionListener(handler);
       }
       //packs the buttons in a horizontal boxes
       for(int k=0;k<4;k++)
        {
          hbox[k] = Box.createHorizontalBox();
           for(int j=0;j<3;j++){
               hbox[k].add(buttons[loop]);
               loop++;
            }
        }
       hbox[maximumBoxSize-1] = Box.createHorizontalBox();
       hbox[maximumBoxSize-1].add(returnButton);
        
       MainCalculatorFrame.vbox.removeAll();
       for(int k=0;k<maximumBoxSize;k++)
           MainCalculatorFrame.vbox.add(hbox[k]);
       
       Calculator.app.setSize(370,210);
       Calculator.app.setTitle("PLOTTING POLYNOMIAL GRAPHS");
       
   }
   /*
    * the next method plots the graph of a linear equation
   */
    private static void plotLinearGraph()
    {
       JButton button;
       JLabel label1,label2;
       Box hbox[]= new Box[3];
       final JTextField textfield1,textfield2;
        //creats two textfields to enter the gradient and the intercept
        textfield1 = new JTextField(10);
        textfield1.setForeground(Color.GRAY);
        textfield2 = new JTextField(10);
        textfield2.setForeground(Color.GRAY);
        //labels to prompt the user to enter the gradient and the intercept
         label1 = new JLabel("ENTER THE GRADIENT");
         label1.setForeground(Color.GRAY);
         label1.setFont(new Font("serif",Font.BOLD,15));
         label2 = new JLabel("ENTER THE INTERCEPT");
         label2.setForeground(Color.GRAY);
         label2.setFont(new Font("serif",Font.BOLD,15));
         
         button =new JButton("ok");
         button.setBackground(Color.WHITE);
         button.setForeground(Color.GRAY);
         button.setFont(new Font("serif",Font.BOLD,15));
       
         //packing horizontal boxes
         hbox[0] = Box.createHorizontalBox();
         hbox[0].add(label1);
         hbox[0].add(textfield1);
         hbox[1] = Box.createHorizontalBox();
         hbox[1].add(label2);
         hbox[1].add(textfield2);
         hbox[2] = Box.createHorizontalBox();
         hbox[2].add(button);
         button.setBorderPainted(false);
          //when pressed emits an event that calls an ananymous inner class to perform required operations
         button.addActionListener(
                                   new ActionListener()
                                   {
                                      @Override
                                      public void actionPerformed(ActionEvent event)
                                      {
                                          MainCalculatorFrame.vbox.removeAll();
                                          MainCalculatorFrame.vbox.add(new DisplayLinearInterface(Integer.parseInt(textfield1.getText()),Integer.parseInt(textfield2.getText())));  
                                          JButton button1 = new JButton ("PRESS TO LOAD MAIN WINDOW");
                                          button1.setBackground(Color.WHITE);
                                          button1.setForeground(Color.GRAY);
                                          button1.setBorderPainted(false);
                                          MainCalculatorFrame.vbox.add(button1);
                                          Calculator.app.setTitle(String.format("Linear graphs y = %dx + %d",Integer.parseInt(textfield1.getText()),Integer.parseInt(textfield2.getText())));
                                          Calculator.app.setSize(900,700);
                                          Calculator.app.setResizable(true);
                                          button1.addActionListener( new ActionListener()
                                                                      {
                                                                        public void actionPerformed(ActionEvent event)
                                                                        {
                                                                            MainGraphInterface.graphInterface();
                                                                            Calculator.app.setResizable(false);
                                                                        }
                                                                       }
                                          ); 
                                      }
                                   }
         );
         MainCalculatorFrame.vbox.removeAll();
         for(int i=0;i<3;i++)
            MainCalculatorFrame.vbox.add(hbox[i]);
         
         Calculator.app.setTitle("GRADIENT AND Y INTERCEPT");
         Calculator.app.setSize(400,120);
        
    }
   /*
    *the inner class below is called when a buttom is pressed to plot the graph of the 
    *corresponding instructions on the button in question
    */
   private static class EventHandler implements ActionListener
           {
               @Override
               public void actionPerformed(ActionEvent event)
               {
                  Object buttonComparism;
                         buttonComparism = event.getSource();
                         
                         if(buttonComparism == buttons[0])
                         {
                             plotLinearGraph();
                         }
               }
           }
   
}

//plot the graph of a linear equation
 class DisplayLinearInterface extends JPanel
 {
    private int gradient;
    private int intercept;
    private JButton button;
     
    public DisplayLinearInterface(int gradient,int intercept)
    {
        this.gradient = gradient;
        this.intercept = intercept;
    }
     
    @Override
    public void paintComponent(Graphics graph)
    {
        super.paintComponent(graph);
        
        int y=0,y1,x=0,x1,point1,point2;
        int  height=getHeight();
        int width=getWidth();

            setBackground(Color.WHITE);
            graph.setColor(Color.GRAY);
 
               point1=width/2;
               point2=height/2;

              graph.drawLine(width/2,0,width/2,height);
              graph.drawLine(0,height/2,width,height/2); 

           y1 =(gradient*x)+ intercept;
           x1 = (-intercept/gradient);
            
          if(y1<0&&x1<0)
              graph.drawLine(width/2,(point2 + (abs(y1))),(point1 - (abs(x1))),height/2);
           else  if(y1>0&&x1<0)
              graph.drawLine(width/2,(point2 - (abs(y1))),(point1 - (abs(x1))),height/2);
           else  if(y1>0&&x1>0)
              graph.drawLine(width/2,(point2 - (abs(y1))),(point1 + (abs(x1))),height/2);
           else
              graph.drawLine(width/2,(point2 + (abs(y1))),(point1 + (abs(x1))),height/2);
                
    }
 }
