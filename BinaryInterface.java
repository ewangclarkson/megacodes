/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;

/**
 *
 * @author  EWANG CLARKSON
 */
import cm.ubeau.clarks.MainCalculatorFrame;
import cm.ubeau.clarks.Calculator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class BinaryInterface 
{
  private static Font font;
  private final static int maximumButSize =15;
  private static JButton button[] = new JButton[maximumButSize],button1,button2;
  private static Box hbox[]=new Box[7];
  private static JTextField  textfield;
  private static String binary[]={"Binary-to-Decimal  ","Binary-to-Octal   ","Binary-to-Hex  ",
                                  "Decimal-to-Binary  ","Decimal-to-Octal ","Decimal-to-Hex ",
                                  "Octal-to-Decimal    ","Octal-to-Binary   ","Octal-to-Hex     ",
                                  " Hex-to-Binary       ","Hex-to-Octal       ","Hex-to-decimal ",
                                  "Decimal-to-BCD    ","BCD-to-Decimal  ","Decimal-to-Ex-3-code  "
                                 };
  
 //displays the main interface for the binary conversions 
  public static void mainBinaryInterface()
  {
      int loop=0;
     //creats the textfield where to enter the number to be converted
     textfield = new JTextField(10);
     textfield.setAutoscrolls(true);
     
     font = new Font("sans",Font.PLAIN,50);
     
     textfield.setFont(font);
     //calls an inner class to perform the action listener
      EventHandler handler = new EventHandler();
     //creats containers for packing (buttons and horizontal boxes
     
     for(int i=0;i<maximumButSize;i++)
     {
          button[i] = new JButton(binary[i]);
          button[i].setFont(new Font("serif",Font.BOLD,15));
          button[i].addActionListener(handler);
     }
      for(int k=0;k<7;k++)
          hbox[k] = Box.createHorizontalBox();
      
      hbox[0].add(textfield);
 
     button1 = new JButton("        LOAD THE  MAIN  WINDOW                ");
     button1.setFont(new Font("sans",Font.PLAIN,14));
     button2 = new JButton("                         CLEAR                              ");
     button2.setFont(new Font("sans",Font.PLAIN,14));
      
      for(int j=1;j<6;j++)
      {
          for ( int count=0;count<3;count++)
          {
              hbox[j].add(button[loop++]);
          }
      }
      hbox[6].add(button1);
      hbox[6].add(button2);
      
      //calls an ananymous class to perform required actions
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
        button2.addActionListener(
                                  new ActionListener()
                                  {
                                      @Override
                                      public void actionPerformed(ActionEvent event)
                                      {
                                           textfield.setText(null);
                                      }
                                  }
        );
      
       MainCalculatorFrame.vbox.removeAll();
       for(int i=0;i<7;i++)
           MainCalculatorFrame.vbox.add(hbox[i]);
      
      Calculator.app.setTitle("NUMBER SYSTEM CONVERSIONS");
      Calculator.app.setSize(525,280);
  }
  /*
   *the following three functions converts decimal  numbers to others  bases
   */
   public static String decimalToBinary(long decimal)
     {
      StringBuilder buildBinary =  new StringBuilder();
      long remainder;
      
       while(decimal!=0)
       {
         remainder = decimal % 2;
         buildBinary.append(String.format("%d",remainder));
         decimal/=2;
       }
       buildBinary = buildBinary.reverse();
       return buildBinary.toString();
    }
   public static String decimalToOctal(long decimal)
     {
      StringBuilder buildOctal =  new StringBuilder();
      long remainder;
      
       while(decimal!=0)
       {
         remainder = decimal % 8;
         buildOctal.append(String.format("%d",remainder));
         decimal/=8;
       }
       buildOctal = buildOctal.reverse();
       return buildOctal.toString();
     }
   public static String decimalToHex(long decimal)
     {
       StringBuilder buildHex =  new StringBuilder();
      long remainder;
      
       while(decimal!=0)
       {
         remainder = decimal % 16;
         switch((int)remainder)
         {
             case 10:
                 buildHex.append("A");break;
             case 11:
                 buildHex.append("B");break;
             case 12:
                 buildHex.append("C");break;
             case 13:
                 buildHex.append("D");break;
             case 14:
                 buildHex.append("E");break;
             case 15:
                 buildHex.append("F");break;
             default:
                buildHex.append(String.format("%d",remainder));break;
         }
         decimal/=16;
       }
       buildHex = buildHex.reverse();
       return buildHex.toString();
     }
/**
 *The methods below  are used for the conversions from octal hex to binary
     * @param decimal
     * @return 
 */
 

   public static long binary_decim(long binary)
     {
        long remainder,power=1,decimal=0,return_val;
         while(binary!=0)
         {
            remainder=binary%10;
            decimal+=(remainder*power);
            power*=2;
            binary/=10;
         }
        return_val=decimal;
        return return_val;
     }
   //decimal for hexadecimal conversion

 /**
  *The next methods converts binary numbers to the other bases
     * @param bin
     * @return 
  */
  //reverse conversions
    public static String binaryToDecimal(String bin)
     {
        final int STRINGLENGTH=bin.length();
        int multiple=1,trace=0;
        long power=1,decimal=0,binary;
        String string=bin;
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          binary=Long.parseLong(charSet);
            decimal+=(binary*power);
            power*=2;
           multiple++;
           trace++;
        }
        return String.format("%d", decimal);
    }
   public  static String binaryToOctal(String bin)
    { 
       final int MAXIMUMLENGTH=1000,STRINGLENGTH=bin.length();
        int multiple=3,trace=0,length,rem;
        long remainder,pivot=MAXIMUMLENGTH,octal,binary;
        StringBuilder temporary = new StringBuilder();
        StringBuilder builder =  new StringBuilder();
        String string;
        builder.append(bin);
        builder = builder.reverse();
         length = STRINGLENGTH;
         rem =(3-(length % 3));
         switch(rem)
         {
            case 1:
                  builder.append("0");break;
            case 2:
                  builder.append("00");break;
        } 
         builder = builder.reverse();
         string = builder.toString();
        //the following converts a string to an integer 
        for(int k=0;k<Math.ceil((STRINGLENGTH / 3));k++)
        {
       String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          binary=Long.parseLong(charSet);
            remainder=binary%pivot;
            octal=binary_decim(remainder);
            switch((int)octal)
             {
              case 0:
                 temporary.append("0");break;
              case 1:
                 temporary.append("1");break;
              case 2:
                 temporary.append("2");break;
              case 3:
                 temporary.append("3");break;
              case 4:
                 temporary.append("4");break;
              case 5:
                 temporary.append("5");break;
              case 6:
                 temporary.append("6");break;
              case 7:
                temporary.append("7");break;
            }
           binary/=pivot;
           multiple+=3;
           trace+=3;
         }
        
         temporary = temporary.reverse();
        return temporary.toString();
      }
    public static  String binaryToHex(String bin)
      {
        final int MAXIMUMLENGTH=10000,STRINGLENGTH=bin.length();
        int multiple=4,trace=0,length,rem;
        long remainder,pivot=MAXIMUMLENGTH,hex,binary;
        StringBuilder temporary = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        String string;
        builder.append(bin);
        builder = builder.reverse();
         length = STRINGLENGTH;
         rem =(4-(length % 4));
         switch(rem)
         {
            case 1:
                  builder.append("0");break;
            case 2:
                  builder.append("00");break;
            case 3:
                  builder.append("000");break;
        } 
        builder = builder.reverse();
         string = builder.toString();
        //the following converts a string to an integer 
        for(int k=0;k<Math.ceil((STRINGLENGTH / 4));k++)
        {
       String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          binary=Long.parseLong(charSet);
            remainder=binary%pivot;
            hex=binary_decim(remainder);
            switch((int)hex)
             {
              case 0:
                 temporary.append("0");break;
              case 1:
                 temporary.append("1");break;
              case 2:
                 temporary.append("2");break;
              case 3:
                 temporary.append("3");break;
              case 4:
                 temporary.append("4");break;
              case 5:
                 temporary.append("5");break;
              case 6:
                 temporary.append("6");break;
              case 7:
                temporary.append("7");break;
              case 8:
                temporary.append("8");break;
              case 9:
                  temporary.append("9");break;
              case 10:
                temporary.append("A");break;
              case 11:
                temporary.append("B");break;
              case 12:
                 temporary.append("C");break;
              case 13:
               temporary.append("D");break;
              case 14:
               temporary.append("E");break;
             case 15:
               temporary.append("F");break;
            }
           binary/=pivot;
           multiple+=4;
           trace+=4;
         }
        
         temporary = temporary.reverse();
        return temporary.toString();
     }
    /*
     * the next methods converts octal numbers to other bases
    */
   public static String octalToDecimal(long octal)
     {
       long remainder,power=1,decimal=0;
       StringBuilder builder,temporary;
       long reversal;
       
         builder = new StringBuilder();
         temporary = new StringBuilder();
         
         while(octal!=0)
           {
            remainder=octal%10;
            temporary.append(String.format("%d",remainder));
            octal/=10;
          }
        reversal = Long.parseLong(temporary.toString());
        System.out.println(reversal);
        while(reversal!=0)
           {
            remainder = reversal%10;
            builder.append(decimalToBinary(remainder));
            reversal/=10;
          }
        return binaryToDecimal(builder.toString());
    }
   public static String octalToBinary(long octal)
   {
       long remainder,power=1,decimal=0;
       StringBuilder builder,temporary;
       long reversal;
       
         builder = new StringBuilder();
         temporary = new StringBuilder();
         
         while(octal!=0)
           {
            remainder=octal%10;
            temporary.append(String.format("%d",remainder));
            octal/=10;
          }
        reversal = Long.parseLong(temporary.toString());
        System.out.println(reversal);
        while(reversal!=0)
           {
            remainder = reversal%10;
            builder.append(decimalToBinary(remainder));
            reversal/=10;
          }
        return builder.toString();
   }
   public static String octalToHex(long octal)
   {
       long remainder,power=1,decimal=0;
       StringBuilder builder,temporary;
       long reversal;
       int length,rem;
       
         builder = new StringBuilder();
         temporary = new StringBuilder();
         
         while(octal!=0)
           {
            remainder=octal%10;
            temporary.append(String.format("%d",remainder));
            octal/=10;
          }
        reversal = Long.parseLong(temporary.toString());
        while(reversal!=0)
           {
            remainder = reversal%10;
            builder.append(decimalToBinary(remainder));
            reversal/=10;
          }
     
        builder = builder.reverse();
         length = builder.toString().length();
         rem =(4-(length % 4));
         switch(rem)
         {
            case 1:
                  builder.append("0");break;
            case 2:
                  builder.append("00");break;
            case 3:
                  builder.append("000");break;
        } 
             
        return binaryToHex(builder.toString());
   }
   //the lines of codes below converts hexadecimal numbers to the other bases
   public static String hexToDecimal(String hex)
     {
        final int STRINGLENGTH=hex.length();
        int multiple=1,trace=0;
        StringBuilder builder;
        builder = new StringBuilder();
        
        String string=hex;
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          StringBuilder temporary = new StringBuilder();
          
            switch (charSet) {
                case "0":
                    temporary.append(decimalToBinary(0));
                    builder.append(temporary.reverse().toString());
                    break;
                case "1":
                    temporary.append(decimalToBinary(1));
                    builder.append(temporary.reverse().toString());
                    break;
                case "2":
                    temporary.append(decimalToBinary(2));
                    builder.append(temporary.reverse().toString());
                    break;
                case "3":
                    temporary.append(decimalToBinary(3));
                    builder.append(temporary.reverse().toString());
                    break;
                case "4":
                    temporary.append(decimalToBinary(4));
                    builder.append(temporary.reverse().toString());
                    break;
                case "5":
                    temporary.append(decimalToBinary(5));
                    builder.append(temporary.reverse().toString());
                    break;
                case "6":
                    temporary.append(decimalToBinary(6));
                    builder.append(temporary.reverse().toString());
                    break;
                case "7":
                    temporary.append(decimalToBinary(7));
                    builder.append(temporary.reverse().toString());
                    break;
                case "8":
                    temporary.append(decimalToBinary(8));
                    builder.append(temporary.reverse().toString());
                    break;
                case "9":
                    temporary.append(decimalToBinary(9));
                    builder.append(temporary.reverse().toString());
                    break;
                case "A":
                    temporary.append(decimalToBinary(10));
                    builder.append(temporary.reverse().toString());
                    break;
                case "B":
                    temporary.append(decimalToBinary(11));
                    builder.append(temporary.reverse().toString());
                    break;
                case "C":
                    temporary.append(decimalToBinary(12));
                    builder.append(temporary.reverse().toString());
                    break;
                case "D":
                    temporary.append(decimalToBinary(13));
                    builder.append(temporary.reverse().toString());
                    break;
                case "E":
                    temporary.append(decimalToBinary(14));
                    builder.append(temporary.reverse().toString());
                    break;
                case "F":
                    temporary.append(decimalToBinary(15));
                    builder.append(temporary.reverse().toString());
                    break;
            }
            multiple++;
            trace++;
        }
        builder = builder.reverse();
        System.out.println(builder.toString());
        return binaryToDecimal(builder.toString());
   }
   public static String hexToBinary(String hex)
   {
        final int STRINGLENGTH=hex.length();
        int multiple=1,trace=0;
        StringBuilder builder;
        builder = new StringBuilder();
        
        String string=hex;
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          StringBuilder temporary = new StringBuilder();
          
            switch (charSet) {
                case "0":
                    temporary.append("0000");
                    builder.append(temporary.reverse().toString());
                    break;
                case "1":
                    temporary.append("0001");
                    builder.append(temporary.reverse().toString());
                    break;
                case "2":
                    temporary.append("0010");
                    builder.append(temporary.reverse().toString());
                    break;
                case "3":
                    temporary.append("0011");
                    builder.append(temporary.reverse().toString());
                    break;
                case "4":
                    temporary.append("0100");
                    builder.append(temporary.reverse().toString());
                    break;
                case "5":
                    temporary.append("0101");
                    builder.append(temporary.reverse().toString());
                    break;
                case "6":
                    temporary.append("0110");
                    builder.append(temporary.reverse().toString());
                    break;
                case "7":
                    temporary.append("0111");
                    builder.append(temporary.reverse().toString());
                    break;
                case "8":
                    temporary.append(decimalToBinary(8));
                    builder.append(temporary.reverse().toString());
                    break;
                case "9":
                    temporary.append(decimalToBinary(9));
                    builder.append(temporary.reverse().toString());
                    break;
                case "A":
                    temporary.append(decimalToBinary(10));
                    builder.append(temporary.reverse().toString());
                    break;
                case "B":
                    temporary.append(decimalToBinary(11));
                    builder.append(temporary.reverse().toString());
                    break;
                case "C":
                    temporary.append(decimalToBinary(12));
                    builder.append(temporary.reverse().toString());
                    break;
                case "D":
                    temporary.append(decimalToBinary(13));
                    builder.append(temporary.reverse().toString());
                    break;
                case "E":
                    temporary.append(decimalToBinary(14));
                    builder.append(temporary.reverse().toString());
                    break;
                case "F":
                    temporary.append(decimalToBinary(15));
                    builder.append(temporary.reverse().toString());
                    break;
            }
            multiple++;
            trace++;
        }
        builder = builder.reverse();
        return builder.toString();
   }
   public static String hexToOctal(String hex)
   {
       final int STRINGLENGTH=hex.length();
        int multiple=1,trace=0;
        int length,rem;
        StringBuilder builder;
        builder = new StringBuilder();
        
        String string=hex;
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          StringBuilder temporary = new StringBuilder();
          
            switch (charSet) {
                case "0":
                    temporary.append(decimalToBinary(0));
                    builder.append(temporary.reverse().toString());
                    break;
                case "1":
                    temporary.append(decimalToBinary(1));
                    builder.append(temporary.reverse().toString());
                    break;
                case "2":
                    temporary.append(decimalToBinary(2));
                    builder.append(temporary.reverse().toString());
                    break;
                case "3":
                    temporary.append(decimalToBinary(3));
                    builder.append(temporary.reverse().toString());
                    break;
                case "4":
                    temporary.append(decimalToBinary(4));
                    builder.append(temporary.reverse().toString());
                    break;
                case "5":
                    temporary.append(decimalToBinary(5));
                    builder.append(temporary.reverse().toString());
                    break;
                case "6":
                    temporary.append(decimalToBinary(6));
                    builder.append(temporary.reverse().toString());
                    break;
                case "7":
                    temporary.append(decimalToBinary(7));
                    builder.append(temporary.reverse().toString());
                    break;
                case "8":
                    temporary.append(decimalToBinary(8));
                    builder.append(temporary.reverse().toString());
                    break;
                case "9":
                    temporary.append(decimalToBinary(9));
                    builder.append(temporary.reverse().toString());
                    break;
                case "A":
                    temporary.append(decimalToBinary(10));
                    builder.append(temporary.reverse().toString());
                    break;
                case "B":
                    temporary.append(decimalToBinary(11));
                    builder.append(temporary.reverse().toString());
                    break;
                case "C":
                    temporary.append(decimalToBinary(12));
                    builder.append(temporary.reverse().toString());
                    break;
                case "D":
                    temporary.append(decimalToBinary(13));
                    builder.append(temporary.reverse().toString());
                    break;
                case "E":
                    temporary.append(decimalToBinary(14));
                    builder.append(temporary.reverse().toString());
                    break;
                case "F":
                    temporary.append(decimalToBinary(15));
                    builder.append(temporary.reverse().toString());
                    break;
            }
            multiple++;
            trace++;
        }
              
          length = builder.toString().length();
         rem =(3-(length % 3));
         switch(rem)
         {
            case 1:
                  builder.append("0");break;
            case 2:
                  builder.append("00");break;
           
        } 
        builder = builder.reverse();
        System.out.println(builder.toString());
        return binaryToOctal(builder.toString());
   }
/*
 *the following are converts decimals to BCD and Excess-3-codes
  */
   public static String decimalToBCD(String decimal)
   {
      StringBuilder builder;
       builder = new StringBuilder();
       
        final int STRINGLENGTH=decimal.length();
        int multiple=1,trace=0;
        long binary;
        int length,rem;
        String string =decimal;
        
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          StringBuilder temporary = new StringBuilder();
          binary=Long.parseLong(charSet);
          temporary.append(decimalToBinary(binary));
          temporary = temporary.reverse();
         length = temporary.toString().length();
         rem =(4-(length % 4));
         switch(rem)
         {
            case 1:
                  temporary.append("0");break;
            case 2:
                  temporary.append("00");break;
            case 3:
                  temporary.append("000");break;
        }         
        
          builder.append(temporary.toString());
           multiple++;
           trace++;
        }
        builder = builder.reverse();
        return builder.toString();   
   }
   
   public static String bcdToDecimal(String bcd)
   {
     final int MAXIMUMLENGTH=10000,STRINGLENGTH=bcd.length();
        int multiple=4,trace=0;
        long remainder,pivot=MAXIMUMLENGTH,octal,binary;
        StringBuilder temporary = new StringBuilder();
        String string=bcd;
        //the following converts a string to an integer 
        for(int k=0;k<Math.ceil((STRINGLENGTH / 4));k++)
        {
        String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          binary=Long.parseLong(charSet);
            remainder=binary%pivot;
            octal=binary_decim(remainder);
            switch((int)octal)
             {
              case 0:
                 temporary.append("0");break;
              case 1:
                 temporary.append("1");break;
              case 2:
                 temporary.append("2");break;
              case 3:
                 temporary.append("3");break;
              case 4:
                 temporary.append("4");break;
              case 5:
                 temporary.append("5");break;
              case 6:
                 temporary.append("6");break;
              case 7:
                temporary.append("7");break;
              case 8:
                  temporary.append("8");break;
              case 9:
                  temporary.append("9");break;
            }
           binary/=pivot;
           multiple+=4;
           trace+=4;
         }
        
         temporary = temporary.reverse();
        return temporary.toString();
   }
   public static String decimalToExcess3Code(String decimal)
   {
       StringBuilder builder;
       builder = new StringBuilder();
       
        final int STRINGLENGTH=decimal.length();
        int multiple=1,trace=0;
        long binary;
        int length,rem;
        String string =decimal;
        
        //the following converts a string to an integer 
        for(int k=0;k<STRINGLENGTH;k++)
        {
          String charSet=string.substring(STRINGLENGTH-multiple,STRINGLENGTH-trace);
          StringBuilder temporary = new StringBuilder();
          binary=Long.parseLong(charSet);
          binary+=3;
          temporary.append(decimalToBinary(binary));
          temporary = temporary.reverse();
         length = temporary.toString().length();
         rem =(4-(length % 4));
          switch(rem)
         {
            case 1:
                  temporary.append("0");break;
            case 2:
                  temporary.append("00");break;
            case 3:
                  temporary.append("000");break;
        } 
          builder.append(temporary.toString());
           multiple++;
           trace++;
        }
        builder = builder.reverse();
        return builder.toString(); 
   }
//the following is an inner class that performs a series of operations when the buttons of the interface are pressed
    private static class EventHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Object testBut = event.getSource(); 
            String text;
            
            if(testBut == button[0]){
                text =textfield.getText();
                textfield.setText(binaryToDecimal(text));
            }
            else if(testBut == button[1]){
                text =textfield.getText();
                textfield.setText(binaryToOctal(text));
            }
            else if(testBut == button[2]){
                text =textfield.getText();
               textfield.setText(binaryToHex(text));
            }
            else if(testBut == button[3]){
                text =textfield.getText();
                textfield.setText(decimalToBinary(Long.parseLong(text)));
            }
            else if(testBut == button[4]){
                text =textfield.getText();
               textfield.setText(decimalToOctal(Long.parseLong(text)));
            }
            else if(testBut == button[5]){
                text =textfield.getText();
                textfield.setText(decimalToHex(Long.parseLong(text)));
            }
            else if(testBut == button[6]){
                text =textfield.getText();
                textfield.setText(octalToDecimal(Long.parseLong(text)));
            }
             else if(testBut == button[7]){
                text =textfield.getText();
                textfield.setText(octalToBinary(Long.parseLong(text)));
            }
            else if(testBut == button[8]){
                text =textfield.getText();
                textfield.setText(octalToHex(Long.parseLong(text)));
            }
            else if(testBut == button[9]){
                text =textfield.getText();
                textfield.setText(hexToBinary(text));
            }
            else if(testBut == button[10]){
                text =textfield.getText();
                textfield.setText(hexToOctal(text));
            }
            else if(testBut == button[11]){
                text =textfield.getText();
                textfield.setText(hexToDecimal(text));
            }
            else if(testBut == button[12]){
                text =textfield.getText();
                textfield.setText(decimalToBCD(text));
            }
            else if(testBut == button[13]){
                text =textfield.getText();
                textfield.setText(bcdToDecimal(text));
            }
            else if(testBut == button[14]){
                text =textfield.getText();
                textfield.setText(decimalToExcess3Code(text));
            }
            }
                
        }
    }

