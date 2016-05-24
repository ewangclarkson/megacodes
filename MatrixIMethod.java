/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;
 import java.io.PrintStream;
 import java.io.File;
 import java.io.IOException;
 import java.io.FileNotFoundException;
 import java.util.NoSuchElementException;
 import java.util.Scanner;

/**
 *
 * @author EWANG CLARKSON
 */
public class MatrixIMethod 
{
    public static PrintStream stream;
    public static  File file;
       //open a file output stream
   public static void openFile()
   {
       try{
          stream = new  PrintStream("MatrixResult");
          file = new File("MatrixInput");
         if(file.isFile())
             System.setOut(stream);
       }
       catch(IOException ioexception)
       {
           System.err.println(ioexception);
           System.exit(1);
       }
   }
    /**
  * The jacobi method is one of the most important methods of the calculating systems of linear equations
  * it provides more flexibility and even thoug long it very efficient
  * /
     * @param row
     * @param column
     * @param num_approx
     * @throws java.io.FileNotFoundException
  */
   public static void jacobiMethod(int row,int column,int num_approx) throws FileNotFoundException
     {
      try{
          openFile();
          try (Scanner scanInput = new Scanner(file)) {
              int i,j,k;
              float array_A[][] = new float[row][column];
              float array_N[][] = new float[row][column];
              float array_M[][] = new float[row][column];
              float b[] = new float[row];
              float approximate[] = new float[row];
              float approximat[] = new float[row];
              //prompts the user to enter the matrix elements
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      array_A[i][j]=scanInput.nextFloat();
                  }
              } //creats the matrix M of the jacobi system
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      if(i==j)
                          array_M[i][j]=array_A[i][j];
                      else
                          array_M[i][j]=0.000000f;
              }
              } //the following creats the the matrix N of the jacobi sequence
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      array_N[i][j]=array_M[i][j]-array_A[i][j];
                  }
              }   //prompts the user to enter the vector
              for(k=0;k<row;k++)
                  b[k]=scanInput.nextFloat();
              System.out.printf("\n\n");
              //the following displays the matrices M ,N and A of the jacobi system
              System.out.printf("The following represent the matrices A N and M in the jacobi sequence\n\n");
              System.out.printf("The matrix A\t\tThe matrix M\t\tThe matrix N\n\n");
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_A[i][j]);
                  }
                  System.out.printf("\t");
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_M[i][j]);
                  }
                  System.out.printf("\t");
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_N[i][j]);
                  }
                  System.out.printf("\n\n");
              }   System.out.printf("\n");
              //the following displays the matrix in the form of a linear system
              System.out.printf("The jacobi system of equations\n\n");
              for(i=0;i<row;i++)
              {
                  System.out.printf(" y%d=",i+1);
                  for(j=0;j<column;j++)
                  {
                      if(array_N[i][j]==0.000000f||array_N[i][j]==-0.000000f)
                          System.out.printf("          ");
                      else
                          System.out.printf("+ %.2fx%d ",array_N[i][j]/array_M[i][i],j+1);
                  }
                  System.out.printf("+%.2f-----------%d",b[i]/array_M[i][i],i+1);
                  System.out.printf("\n\n");
              }  System.out.printf("\n");
              //ask the user to enter the first approximate of the jacobi sequence
              for(i=0;i<row;i++)
              {
                  approximate[i]=scanInput.nextFloat();
              } System.out.printf("x^=(");
              for(i=0;i<row;i++)
              {
                  System.out.printf("%.2f ",approximate[i]);
              }  System.out.printf(")\n\n");
              //prints the result of the calculations to the user
              System.out.printf("The jacobi's iterations\n\n");
              for(i=0;i<num_approx;i++)
              {
                  for(j=0;j<row;j++)
                  {
                      for(k=0;k<column;k++)
                      {
                          approximat[j]+=((array_N[j][k]*approximate[k])/array_M[j][j]);
                      }
                      approximat[j]+=(b[j]/array_M[j][j]);
                  }
                  System.out. printf("x^%d=(",i+1);
                  for(k=0;k<row;k++)
              {
               System.out.printf("%.4f ",approximat[k]);
              }
             System.out.printf(")\n\n");
             for(j=0;j<row;j++)
              approximate[j]=approximat[j];
             for(j=0;j<row;j++)
              approximat[j]=0.000000f;
          }   System.out.printf("\n");
          }
      }
    finally{
           closeFile();
           System.gc();
       }
   }
   
  /**
  * The gauss seidel method is another  one  important indirect methods of the calculating systems of linear equations
  * it provides more flexibility and even thoug long it very efficient
     * @param row
     * @param column
     * @param num_approx
     * @throws java.io.FileNotFoundException
  */
   public static void gaussSeidelMethod(int row,int column,int num_approx) throws FileNotFoundException
     {
       try{
           openFile();
           try (Scanner input = new Scanner(file)) {
               float array_A[][] = new float[row+1][column];
               float array_N[][] = new float[row+1][column];
               float array_M[][] = new float[row+1][column];
               float sum[] = new float[row+1];
               float multiplier[] = new float[row+1];
               float b[] = new float[row+1];
               float approximate[] = new float[row+1];
               float approximat[] = new float[row+1];
               int i,j,k,d;
               //the follwings prompts the user to enter the matrix
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       array_A[i][j]=input.nextFloat();
                   }
               } //creating the matrix M
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       if(i>=j)
                           array_M[i][j]=array_A[i][j];
                       else
                           array_M[i][j]=0.000000f;
                   }
               }//creating the matrix N
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       array_N[i][j]=array_M[i][j]-array_A[i][j];
                   }
               }  //prompts the user to enter the vector
               for(k=0;k<row;k++)
                   b[k]=input.nextFloat();
               System.out.printf("\n\n");
               //displays the three forms of the matrices to the user
               System.out.printf("The following represent the matrices A N and M in the jacobi sequence\n\n");
               System.out. printf("The matrix A\t\tThe matrix M\t\tThe matrix N\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_A[i][j]);
                   }
                   System.out.printf("\t");
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_M[i][j]);
                   }
                   System.out.printf("\t");
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_N[i][j]);
                   }
                   System.out.printf("\n\n");
               }   System.out.printf("\n");
               System.out.printf("The Gauss seidel system of equations\n\n");
               for(i=0;i<row;i++)
               {
                   for(k=0;k<row;k++)
                   {
                       if(array_M[i][k]==0.000000f||array_M[i][k]==-0.000000f)
                           ;
                       else
                           System.out.printf(" +%.2fy%d",array_M[i][k],k+1);
                   }
                   System.out.printf("=");
                   for(j=0;j<column;j++)
                   {
                       if(array_N[i][j]==0.000000f||array_N[i][j]==-0.000000f)
                           ;
                       else
                           System.out.printf("+ %.2fx%d ",array_N[i][j],j+1);
                   }
                   System.out.printf("+%.2f-----------%d",b[i],i+1);
                   System.out.printf("\n\n");
               }  System.out.printf("\n");
               //ask for the first approximation of the the gauss seidel indirect mathod
               System.out.printf("Enter the first approximations\n");
               for(i=0;i<row;i++)
               {
                   approximate[i]=input.nextFloat();
               } System.out.printf("x^0=(");
               for(i=0;i<row;i++)
               {
                   System.out.printf("%.2f ",approximate[i]);
               }System.out.printf(")\n\n");
               System.out.printf("The Gauss seidel's iterations\n\n");
               for(d=0;d<num_approx;d++)
               {
                   for(i=0;i<row;i++)
                   {
                       for(k=0;k<column;k++)
                       {
                           approximat[i]+=((array_N[i][k]*approximate[k]));
                       }
                       approximat[i]+=b[i];
                       
                       for(j=0;j<column;j++)
                       {
                           if(i>j)
                               sum[j]=(array_M[i][j]*multiplier[j]);
                       }
                       for(j=0;j<column;j++)
                       {
                           if(i>j)
                               approximat[i]=approximat[i]-sum[j];
                       }
                       approximat[i]/=array_M[i][i];
                       multiplier[i]=approximat[i];
                   }
                   System.out.printf("x^%d=(",d+1);
                   for(k=0;k<row;k++)
               {
                System.out.printf("%.4f ",approximat[k]);
               }
              System.out.printf(")\n\n");
     
             for(j=0;j<row;j++)
               approximate[j]=approximat[j];
             for(j=0;j<row;j++)
             approximat[j]=0.000000f;
           }   System.out.printf("\n");
           }
       }
    finally{
           closeFile();
           System.gc();
       }
     }
   public static void closeFile()
   {
       stream.close();
   }
 }

