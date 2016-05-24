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
//the lines of codes below includes classes from the java API

import cm.ubeau.clarks.MatrixDMethod;
import cm.ubeau.clarks.MatrixIMethod;
import cm.ubeau.clarks.MatrixOMethod;
import cm.ubeau.clarks.MainCalculatorFrame;
import cm.ubeau.clarks.Calculator;
import java.lang.StringBuilder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.Box;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ChooseMatrixMethodsInterface 
{
    private static JList methodList;
    private static JTextArea outputMatrix;
    private static PrintStream stream;
    private static FileInputStream file;
    private static Box hbox1,hbox2,hbox3;
    private static JLabel label1,label2,label3;
    private static JTextField textfield1,textfield2,textfield3;
    private static JTextArea inputMatrix;
    private static JButton button,button1;
    private static final String methods[]={"LU DECOMPOSITION                                     ","GAUSSIAN ELIMINATION                                  ","JACOBI INDIRECT METHODS                         ",
                              "GAUSS SEIDEL INDIRECT METHOD                                ","INVERSE OF MATRIX                                       ","ADDITION OF MATRICES                            ",
                              "SUBSTRACTION OF MATRICES                                       ","MULTIPLICATION OF MATRICES                              ","DETERMINANT     "
                             };
    public static void listInterface()
    { 
       //creates labels to prompt the user on number of rows and columns as well as approximations 
        label1 = new JLabel("Number Of Rows:");
        label1.setForeground(Color.GRAY);
        label2 = new JLabel("Number Of Columns:");
        label2.setForeground(Color.GRAY);
        label3 = new JLabel("Number Of Approximations:");
        label3.setForeground(Color.GRAY);
       //creates textentries to enter number of rows and columns and number of approximations
        textfield1 = new JTextField();
        textfield1.setForeground(Color.GRAY);
        textfield2 = new JTextField();
        textfield2.setForeground(Color.DARK_GRAY);
        textfield3 = new JTextField();
        textfield3.setForeground(Color.DARK_GRAY);
        //creates horizontal boxes to add the labels and the textfields
        hbox1 = Box.createHorizontalBox();
        hbox1.add(label1);
        hbox1.add(textfield1);
        hbox2 = Box.createHorizontalBox();
        hbox2.add(label2);
        hbox2.add(textfield2);
        hbox3 = Box.createHorizontalBox();
        hbox3.add(label3);
        hbox3.add(textfield3);
        //the next line of code resizes the window
        Calculator.app.setSize(300,253);
        //next calls MainCalculatorFrame vbox and removes all its content
        MainCalculatorFrame.vbox.removeAll();
        //creats a JList to and adds the methods to choose
        methodList = new JList(methods);
        methodList.setForeground(Color.GRAY);
        methodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        methodList.setVisibleRowCount(8);
        methodList.setSize(300,300);
        MainCalculatorFrame.vbox.add(methodList);
        MainCalculatorFrame.vbox.add(hbox1);
        MainCalculatorFrame.vbox.add(hbox2);
        MainCalculatorFrame.vbox.add(hbox3);
        MainCalculatorFrame.vbox.setVisible(true);
        Calculator.app.getContentPane().setBackground(Color.WHITE);
        Calculator.app.setTitle("METHODS OF MATRICES");
        
        methodList.addListSelectionListener(
                      new ListSelectionListener()
                      {
                        
                          @Override
                          public void valueChanged(ListSelectionEvent event)
                          {
                              final int index,rows,columns,approx;
                              if((!textfield1.getText().isEmpty()) || (!textfield2.getText().isEmpty()))
                              {
                                  index=methodList.getSelectedIndex();
                                  rows=Integer.parseInt(textfield1.getText());
                                  columns=Integer.parseInt(textfield2.getText());
                                 switch(index)
                                 {
                                     case 2:
                                         approx=Integer.parseInt(textfield3.getText());break;
                                     case 3:
                                         approx=Integer.parseInt(textfield3.getText());break;
                                     default:
                                         approx=0;break;
                                 }
                                  getInputInterface(rows,columns,approx,index);
                              }
                          
                          }
                      }
                );
     }
    public static void getInputInterface(final int ROWS, final int COLUMNS,final int APPROX,final int INDEX )
    {
      button = new JButton("ok");
      button.setForeground(Color.DARK_GRAY);
       button.setBackground(Color.WHITE);
       button.setBorderPainted(false);
       MainCalculatorFrame.vbox.removeAll();
       inputMatrix = new JTextArea();
       MainCalculatorFrame.vbox.add(inputMatrix);
       MainCalculatorFrame.vbox.add(button);
       Calculator.app.setSize(700,500);
       Calculator.app.setTitle("ENTER MATRIX AND COLUMN VECTOR IF NEEDED OR APPROXIMATION");
       button.addActionListener(
                new ActionListener()
                {
                   
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                       openFile();
                       System.out.printf("%s",inputMatrix.getText());
                       closeFile();
                       mainMatrixOperations(ROWS,COLUMNS,APPROX,INDEX);
                    }
                     public void openFile()
                     {
                      try{
                          stream = new  PrintStream("MatrixInput");
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
                         file = new  FileInputStream("MatrixResult");
                     }
    public static void mainMatrixOperations(final int ROWS,final int COLUMNS,final int APPROX,final int INDEX)
    {
      StringBuilder buffer = new StringBuilder();
      button1 = new JButton("return");
      String  text;
       try{
        switch(INDEX)
        {
            case 0:
                MatrixDMethod.luDecomposition(ROWS,COLUMNS);break;
            case 1:
                MatrixDMethod.gaussElimination(ROWS,COLUMNS);break;
            case 2:
                MatrixIMethod.jacobiMethod(ROWS, COLUMNS, APPROX);break;
            case 3:
                MatrixIMethod.gaussSeidelMethod(ROWS, COLUMNS, APPROX);break;
            case 4:
                MatrixOMethod.matrixInverse(ROWS, COLUMNS);break;
            case 5:
                MatrixOMethod.matrixAddition(ROWS, COLUMNS);break;
            case 6:
                MatrixOMethod.matrixSubstraction(ROWS, COLUMNS);break;
            case 7:
                MatrixOMethod.matrixMultiplication(ROWS, COLUMNS);break;
            case 8:
                MatrixOMethod.matrixDeterminant(ROWS,COLUMNS);break;
            default:
                System.exit(1);
        }
       openFileInput();
       Scanner input = new Scanner(file);
       while(input.hasNext())
       {
           text = input.nextLine();
           buffer.append(text);
           buffer.append("\n");
       }
       MainCalculatorFrame.vbox.removeAll();
       outputMatrix = new JTextArea();
       outputMatrix.setText(String.format("%s",buffer.toString()));
       outputMatrix.setDisabledTextColor(Color.GRAY);
       outputMatrix.setEnabled(false);
       MainCalculatorFrame.vbox.add((new JScrollPane(outputMatrix)));
       MainCalculatorFrame.vbox.add(button1);
       button1.setBorderPainted(false);
       button1.setForeground(Color.GRAY);
       button1.setBackground(Color.WHITE);
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
       Calculator.app.setSize(800,720);
       Calculator.app.setTitle("RESULTS OF THE MATRIX OPERATIONS");
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
