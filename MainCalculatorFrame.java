/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;

/**
 *
 * @author EWANG CLARKSON
 */
//includes information from the java API

 import cm.ubeau.clarks.Calculator;
 import cm.ubeau.clarks.ChooseMatrixMethodsInterface;
 import javax.swing.JButton;
 import java.awt.Font;
 import java.awt.Color;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import java.awt.BorderLayout;
 import javax.swing.Box;
 import static java.lang.Math.*;
import javax.swing.JTextArea;
//declares the main class
public class MainCalculatorFrame 
{
  private static final int SEVEN=7,EIGHT=8;
  private static Font font;
  private static JTextArea textfield;
  private static final Box hbox[] = new Box[EIGHT];
  public static Box vbox;
  private static final  JButton buttons[][] = new JButton[EIGHT][SEVEN];
  private static final String funct[][]={{"Cos   ","Sin    ","  tan  ","Log"," Ln ","   gpa  ","Binary  "},
      {"Cos'1","Sin'1 ","tan'1 ","exp","fact!","Matrix","BoxPlot"},
      {"Cosh ","Sinh  ","tanh  ","nCr","nPr ","Graphs","SQuare  "},
      {"Cosh'1","Sinh'1","tanh'1","clear","Cube","Sqrt","Cbrt    "},
      {"Polynomial  ","10^x","   1    ","    2    ","    3  ","  (    ","  )     "},
      {"Complex     ","   Ac ","    4   " ,"    5    ","    6  ","   +  "," -  "},
      {"       x^y       "," 1/x  ","   7    " ,"    8    ","    9  ","    x "," /  "},
      {"   PI     ","   0    ","   +/-   "," =",".","sumersion","fabinocci"}
  };  
  private static final String tooltip[][] ={{"Cosine ","Sine","tangent","Logarithm","Natural logaritm","stdents GPA","Binary"},
          {"Cosine inverse","Sine inverse","inverse of tangent","exponent","factorial","Matrix","BoxPlot"},
          {"Cosh","Sinh","tanh","combinations","permutations","ploting graphs","SQuare of numbers"},
          { "inverse of Cosh","inverse of sinh","inverse of tanh","clear textfield","Cube a number","SQRT","CBRT"},
          {"Polynomial calculations","10^y","1","2","3","(",")"},
          {"complex number perations","reset","4","5","6","+","-","%"},
          {"squaring any number","reciprocal","7","8","9","x","/"},
          {"Mathematical PI 22/7","0","+/-","=",".","arithmetic and geometric","fabinocci of a number"}
          };
   public static void mainInterface()
   {
       int i,j;
       /*
       *this creates a text entry and buttons and adds them to the JFrame
       */
       
        textfield = new JTextArea(10,30);
        font = new Font("sans",Font.PLAIN,50);
        textfield.setFont(font);
        textfield.setAutoscrolls(true);
        textfield.setSelectedTextColor(Color.BLUE);
        textfield.setBackground(Color.WHITE);
        textfield.setForeground(Color.GRAY);
        Calculator.app.setLayout(new BorderLayout());
        
         vbox =  Box.createVerticalBox();
         vbox.add(textfield);
          EventHandler handler = new EventHandler();
          
          for(int k=0;k<EIGHT;k++)
              hbox[k] = Box.createHorizontalBox();
          
          for(i=0;i<EIGHT;i++)
          {
              for(j=0;j<SEVEN;j++)
              {
                  buttons[i][j] = new JButton(funct[i][j]);
                  buttons[i][j].setToolTipText(tooltip[i][j]);
                  buttons[i][j].setFont(new Font("serif",Font.BOLD,15));
                  buttons[i][j].addActionListener((ActionListener) handler);
                  hbox[i].add(buttons[i][j]);
              }
              vbox.add(hbox[i]);
          }
          Calculator.app.getContentPane().setBackground(Color.WHITE);
          Calculator.app.add(vbox);
          Calculator.app.setTitle("CALCULATOR");
          Calculator.app.setSize(560,340);
       
   }
   /*
    *the following calculates the factorial of a number
   */

    /**
     *
     * @param n
     * @return
     */
    
    public  static long factorial(long n)
             {
                long number ;
                 number = n;
                 if( number == 0 )
                     return 1;
                 else if( number == 1 )
                     return 1;
                 return (number * (factorial(number-1)));
             }
    //the lines of codes  below handles the event emitted by the JButtons
   public static class EventHandler implements ActionListener
           {
            
      /**
       *
       * @param event
       */
      @Override
             public void actionPerformed(ActionEvent event)
             {
                String text;
                long number=0;
                if(event.getSource()==buttons[0][0])
                {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",cos(Double.parseDouble(text))));
                         
                 }
                if(event.getSource()==buttons[0][1])
                 {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%f",sin(Float.parseFloat(text))));
                         
                 }
                 if(event.getSource()==buttons[0][2])
                  {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",tan(Double.parseDouble(text))));
                   }
                 if(event.getSource()==buttons[0][3])
                   {
                    text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",log10(Double.parseDouble(text))));
                   }
                 if(event.getSource()==buttons[0][4])
                  {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",log(Double.parseDouble(text))));
                  }
                if(event.getSource()==buttons[0][5])
                 {
                      MainGPAInterface.gpaGUI();   
                 }
                if(event.getSource()==buttons[0][6])
                 {
                     BinaryInterface.mainBinaryInterface();
                 }
                if(event.getSource()==buttons[1][0])
                {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",acos(Float.parseFloat(text))));
                         
                 }
                if(event.getSource()==buttons[1][1])
                 {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",asin(Double.parseDouble(text))));
                         
                 }
                 if(event.getSource()==buttons[1][2])
                  {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",atan(Double.parseDouble(text))));
                   }
                 if(event.getSource()==buttons[1][3])
                   {
                    text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",exp(Double.parseDouble(text))));
                   }
                 else if(event.getSource()==buttons[1][4])
                  {
                   String string;
                   long value;
                    string = textfield.getText();
                      value = factorial(Long.parseLong(string));   
                      textfield.setText(String.format("%d",value));
                  }
                if(event.getSource()==buttons[1][5])
                 {
                    ChooseMatrixMethodsInterface.listInterface();    
                 }
                if(event.getSource()==buttons[1][6])
                 {
                     BoxPlotInterface.getInputInterface();
                 }
               
                if(event.getSource()==buttons[2][0])
                {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",cosh(Float.parseFloat(text))));
                         
                 }
                if(event.getSource()==buttons[2][1])
                 {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",sinh(Double.parseDouble(text))));
                         
                 }
                 if(event.getSource()==buttons[2][2])
                  {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",tanh(Double.parseDouble(text))));
                   }
                 if(event.getSource()==buttons[2][3])
                   {
                    text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",log10(Double.parseDouble(text))));
                   }
                 else if(event.getSource()==buttons[2][4])
                  {
                   String string;
                   long value;
                    string = textfield.getText();
                      value = factorial(Long.parseLong(string));   
                      textfield.setText(String.format("%d",value));
                  }
                if(event.getSource()==buttons[2][5])
                 {
                    MainGraphInterface.graphInterface();    
                 }
                if(event.getSource()==buttons[2][6])
                 {
                   String string;
                    double value;
                    string = textfield.getText();
                     value = Double.parseDouble(string);  
                      textfield.setText(String.format("%g",value*value)); 
                 }
                
               if(event.getSource()==buttons[3][0])
                {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",cosh(Float.parseFloat(text))));
                         
                 }
                if(event.getSource()==buttons[3][1])
                 {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",sinh(Double.parseDouble(text))));
                         
                 }
                 if(event.getSource()==buttons[3][2])
                  {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%f",tanh(Double.parseDouble(text))));
                   }
                 if(event.getSource()==buttons[3][3])
                   {
                     textfield.setText(null);
                     
                   }
                 else if(event.getSource()==buttons[3][4])
                  {
                    String string;
                    double value;
                    string = textfield.getText();
                     value = Double.parseDouble(string);  
                      textfield.setText(String.format("%g",value*value*value));
                  }
                  else if(event.getSource()==buttons[3][5])
                  {
                   String string;
                   double value;
                    string = textfield.getText();
                      value = Double.parseDouble(string);
                      textfield.setText(String.format("%g",sqrt(value)));
                  }
                  else if(event.getSource()==buttons[3][6])
                  {
                    String string;
                   double value;
                    string = textfield.getText();
                      value = Double.parseDouble(string);
                      textfield.setText(String.format("%g",cbrt(value)));
                  }
                if(event.getSource()==buttons[4][0])
                {
                   text = textfield.getText();
                           
                 }
                if(event.getSource()==buttons[4][1])
                 {
                   text = textfield.getText();
                           if(!text.equals(""))
                              textfield.setText(String.format("%g",Math.pow(10,(Double.parseDouble(text)))));
                         
                 }
                 if(event.getSource()==buttons[4][2])
                  {
                    textfield.append("1");
                   }
                 if(event.getSource()==buttons[4][3])
                   {
                     textfield.append("2");
                   }
                 else if(event.getSource()==buttons[4][4])
                  {
                     textfield.append("3");
                  }
                  else if(event.getSource()==buttons[4][5])
                  {
                     textfield.append("(");
                  }
                  else if(event.getSource()==buttons[4][6])
                  {
                    textfield.append(")");
                  }
                if(event.getSource()==buttons[5][0])
                {
                   text = textfield.getText();
                           
                 }
                if(event.getSource()==buttons[5][1])
                 {
                   textfield.setText(null);   
                 }
                 if(event.getSource()==buttons[5][2])
                  {
                 textfield.append("4");
                   }
                 if(event.getSource()==buttons[5][3])
                   {
                      textfield.append("5");
                   }
                 else if(event.getSource()==buttons[5][4])
                  {
                     textfield.append("6");
                  }
                  else if(event.getSource()==buttons[5][5])
                  {
                     textfield.append("+");
                  }
                  else if(event.getSource()==buttons[5][6])
                  {
                   textfield.append("-");
                  }
             }
   }
}
                      