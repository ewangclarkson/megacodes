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
import cm.ubeau.clarks.Calculator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainGPAInterface 
{
   public final static int SIX=6;
   public static JButton button,button1; 
   private static String courseTitle;
   public static  StringBuilder temporary;
   private static JLabel label1,label2,label3;
   private static JTextField textfield1,textfield2,textfield3;
   private static final JTextArea gpaResult = new JTextArea();
   private static ButtonGroup addSpace;
   private static double GPA,Grade,total;
   private static int totalCreditValue,checkNumCourses=1,numberCourses,creditValue;
   private static JRadioButton radioBut1,radioBut2,radioBut3,radioBut4,radioBut5,radioBut6,radioBut7,radioBut8;
   private final static  Box hbox[] = new Box[SIX+1];
   
   public static void initialize()
   {
       temporary.append("\nUNIVERSITY OF BUEA\n\n\n");
       temporary.append("COURSE TITLE\t\t\t\tGRADE\t\t\tCREDIT VALUE\n\n");
   }

   public static void gpaGUI()
   {
     //creates labels to be added to the interfaces
     label1 = new JLabel("NUMBER OF COURSES");
     label2 = new JLabel("COURSE TITTLE     ");
     label3 = new JLabel("CREDIT VALUE       ");
     
     label1.setBackground(Color.WHITE);
     label1.setForeground(Color.GRAY);
     label1.setFont(new Font("serif",Font.BOLD,15));
     
     label2.setBackground(Color.WHITE);
     label2.setForeground(Color.GRAY);
     label2.setFont(new Font("serif",Font.BOLD,15));
     
     label3.setBackground(Color.WHITE);
     label3.setForeground(Color.GRAY);
     label3.setFont(new Font("serif",Font.BOLD,15));
     
     
     //the lines of codes below create three text enteries
     textfield1 = new JTextField(10);
     textfield1.setFont(new Font("sans",Font.PLAIN,17));
     textfield1.setForeground(Color.GRAY);
     textfield2 = new JTextField(10);
     textfield2.setForeground(Color.GRAY);
     textfield3 = new JTextField(10);
     textfield3.setForeground(Color.GRAY);
     //creates radiobuttons 
     radioBut1 = new JRadioButton("A\t");
     radioBut1.setBackground(Color.WHITE);
     radioBut1.setForeground(Color.GRAY);
     radioBut1.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut2 = new JRadioButton("B+");
     radioBut2.setBackground(Color.WHITE);
     radioBut2.setForeground(Color.GRAY);
     radioBut2.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut3 = new JRadioButton("B\t");
     radioBut3.setBackground(Color.WHITE);
     radioBut3.setForeground(Color.GRAY);
     radioBut3.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut4 = new JRadioButton("C+");
     radioBut4.setBackground(Color.WHITE);
     radioBut4.setForeground(Color.GRAY);
     radioBut4.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut5 = new JRadioButton("C\t");
     radioBut5.setBackground(Color.WHITE);
     radioBut5.setForeground(Color.GRAY);
     radioBut5.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut6 = new JRadioButton("D+");
     radioBut6.setBackground(Color.WHITE);
     radioBut6.setForeground(Color.GRAY);
     radioBut6.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut7 = new JRadioButton(" D ");
     radioBut7.setBackground(Color.WHITE);
     radioBut7.setForeground(Color.GRAY);
     radioBut7.setFont(new Font("serif",Font.BOLD,15));
     
     radioBut8 = new JRadioButton("F");
     radioBut8.setBackground(Color.WHITE);
     radioBut8.setForeground(Color.GRAY);
     radioBut8.setFont(new Font("serif",Font.BOLD,15));
     //creats ButtonGroup and add radioButton
     addSpace = new ButtonGroup();
     addSpace.add(radioBut1);
     addSpace.add(radioBut2);
     addSpace.add(radioBut3);
     addSpace.add(radioBut4);
     addSpace.add(radioBut5);
     addSpace.add(radioBut6);
     addSpace.add(radioBut7);
     addSpace.add(radioBut8);
     //creats the string Builder
     temporary = new StringBuilder();
     initialize();
     //creats horizntal boxes
     for(int k=0;k<=SIX;k++)
         hbox[k] = Box.createHorizontalBox();
     Calculator.app.getContentPane().setBackground(Color.WHITE);
     for(int i=0;i<=SIX;i++)
         switch(i)
         {
             case 0:
                 hbox[i].add(label1);
                 hbox[i].add(textfield1);break;
             case 1:
                 hbox[i].add(radioBut1);
                 hbox[i].add(radioBut2);
             case 2:
                 hbox[i].add(radioBut3);
                 hbox[i].add(radioBut4);break;
             case 3:
                 hbox[i].add(radioBut5);
                 hbox[i].add(radioBut6);break;
            case 4:
                 hbox[i].add(radioBut7);
                 hbox[i].add(radioBut8);break;
             case 5:
                 hbox[i].add(label2);
                 hbox[i].add(textfield2);break;
             case 6:
                 hbox[i].add(label3);
                 hbox[i].add(textfield3);break;
          }
      MainCalculatorFrame.vbox.removeAll();
      
     for (int j=0;j<=SIX;j++)
         MainCalculatorFrame.vbox.add(hbox[j]);
     
     button = new JButton("      ok       ");
     button.setForeground(Color.GRAY);
     button.setBackground(Color.WHITE);
     button1 = new JButton("return");
     button1.setForeground(Color.GRAY);
     button1.setBackground(Color.WHITE);
     button1.setBorderPainted(false);
     
     EventHandler handler = new EventHandler();
     
     radioBut1.addItemListener(handler);
     radioBut2.addItemListener(handler);
     radioBut3.addItemListener(handler);
     radioBut4.addItemListener(handler);
     radioBut5.addItemListener(handler);
     radioBut6.addItemListener(handler);
     radioBut7.addItemListener(handler);
     
     button.addActionListener(
                     new ActionListener()
                     {
                       @Override
                       public void actionPerformed(ActionEvent event)
                       {
                        if((!textfield1.getText().isEmpty()) && (textfield1.isEditable())){
                            numberCourses = Integer.parseInt(textfield1.getText());
                            textfield1.setText(" ");
                            textfield1.setEditable(false);
                        }
                        
                        if(Grade == 4)
                        {
                         courseTitle = textfield2.getText();
                         creditValue = Integer.parseInt(textfield3.getText());
                            courseTitle += ("\t\t\t" + "A" + "\t\t\t" + (String.format("%d",creditValue)));
                                temporary.append(courseTitle);
                                temporary.append("\n\n");
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 3.5)
                        {
                            courseTitle = textfield2.getText();
                            creditValue = Integer.parseInt(textfield3.getText());
                            courseTitle += ("\t\t\t" + "B+" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                         else if(Grade == 3)
                        {
                            courseTitle = textfield2.getText();
                            creditValue = Integer.parseInt(textfield3.getText());
                            courseTitle += ("\t\t\t" + "B" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 2.5)
                        {
                            courseTitle = textfield2.getText();
                             creditValue = Integer.parseInt(textfield3.getText());
                            courseTitle += ("\t\t\t" + "C+" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 2)
                        {
                            courseTitle = textfield2.getText();
                           creditValue = Integer.parseInt(textfield3.getText());
                           courseTitle += ("\t\t\t" + "C" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 1.5)
                        {
                          courseTitle = textfield2.getText();
                          creditValue = Integer.parseInt(textfield3.getText());
                           courseTitle += ("\t\t\t" + "D+" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 1)
                        {
                            courseTitle = textfield2.getText();
                           creditValue = Integer.parseInt(textfield3.getText());
                           courseTitle += ("\t\t\t" + "D" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * Grade;
                        }
                        else if(Grade == 0)
                        {
                         courseTitle = textfield2.getText();
                         creditValue = Integer.parseInt(textfield3.getText());
                            courseTitle += ("\t\t\t" + "F" + "\t\t\t" + (String.format("%d",creditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n\n"); 
                                 total+= creditValue * 1;
                        }
                        totalCreditValue += creditValue;
                        
                       if(checkNumCourses == numberCourses){
                           GPA = total/totalCreditValue;
                           courseTitle = ("\n\nGPA\t" + "\t\t\t" + (String.format("%.3f/4", GPA)) + "\t\t\t" + (String.format("%d",totalCreditValue)));
                           temporary.append(courseTitle);
                                temporary.append("\n"); 
                                
                            gpaResult.setText(String.format("%s",temporary.toString()));
                            MainCalculatorFrame.vbox.removeAll();
                            MainCalculatorFrame.vbox.add(gpaResult);
                            MainCalculatorFrame.vbox.add(button1);
                            Calculator.app.setTitle("GPA RESULTS");
                            Calculator.app.setSize(750,550);
                            gpaResult.setDisabledTextColor(Color.GRAY);
                            gpaResult.setBackground(Color.WHITE);
                            gpaResult.setFont(new Font("serif",Font.BOLD,12));
                            gpaResult.setEnabled(false);
                            button1.addActionListener( new ActionListener()
                                                        {
                                                          public void actionPerformed(ActionEvent event)
                                                          {
                                                              MainCalculatorFrame.vbox.removeAll();
                                                              MainCalculatorFrame.mainInterface();
                                                          }
                            });
                       }
                       
                       checkNumCourses++;
                       
                       textfield2.setText("");
                       textfield3.setText("");
                       }
                     });
     MainCalculatorFrame.vbox.add(button);
     Calculator.app.setSize(450,230);
     button.setBorderPainted(false);
   }
   
   public static class EventHandler implements ItemListener
   {
       public void itemStateChanged(ItemEvent event)
       {
           if((event.getSource()) == radioBut1 && (event.getSource() instanceof JRadioButton)){
               Grade=4;
           }
           else if((event.getSource()) == radioBut2 && (event.getSource() instanceof JRadioButton)){
               Grade=3.5;
           }
            else if((event.getSource()) == radioBut3 && (event.getSource() instanceof JRadioButton)){
               Grade=3;
            }
            else if((event.getSource()) == radioBut4 && (event.getSource() instanceof JRadioButton)){
               Grade=2.5;
            }
            else if((event.getSource()) == radioBut5 && (event.getSource() instanceof JRadioButton)){
               Grade=2;
            }
            else if((event.getSource()) == radioBut6 && (event.getSource() instanceof JRadioButton)){
               Grade=1.5;
            }
            else if((event.getSource()) == radioBut7 && (event.getSource() instanceof JRadioButton)){
               Grade=1;
            }
            else if((event.getSource()) == radioBut8  && (event.getSource() instanceof JRadioButton))
            {
               Grade=0;
            }
       }
   }
}