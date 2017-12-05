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
 *the following lines of code includes classes from the java API
 */
 import java.io.PrintStream;
 import java.io.IOException;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 import java.io.FileInputStream;

public class MatrixDMethod  
{
     //declaration of instance variable
    private static int pivotal=0;
   /**
    * gaussian elimination is one of the most important direct methods of solving systems of equations
    * involving matrices
    */
    public static PrintStream stream;
    public static FileInputStream file;
       //open a file output stream

    /**
     *openFile
     */
   public static void openFile()
   {
       try{
          stream = new  PrintStream("MatrixResult");
          file = new FileInputStream("MatrixInput");
             System.setOut(stream);
       }
       catch(IOException ioexception)
       {
           System.err.println(ioexception);
           System.exit(1);
       }
   }
    public static void gaussElimination(int row,int column) throws FileNotFoundException
      {
       try{
           openFile();
           try (Scanner input = new Scanner(file)) {
               int i,j,k,c;
               int d,incre,increment,pivote;
               float divisor;
               float array_u[][]=new float[row+1][column];
               float store[]=new float[row+1];
               float b[]=new float[row+1];
               float sum[]= new float[row];
               float multiplier[]=new float[row+1];
               //assigns a decremented row number to a pivote variable
               pivote=row-1;
               //prompts the user to enter the matrix and the column vector
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       array_u[i][j]=input.nextFloat();
                   }
               }
               for(i=0;i<row;i++)
                   b[i]=input.nextFloat();
               //displays the matrix entered by the matrix and carries out the calculations
               System.out.printf("The user entered the matrix\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\n\n");
               } //dispalys the matri in the form of a linear equation
               System.out.printf("Ax=b\n");
               System.out.printf("The matrix and vector b has the system of equations below\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       if(array_u[i][j]==0.000000f)
                           System.out.printf("          ");
                       else
                           System.out.printf("+ %.2fx%d ",array_u[i][j],j+1);
                   }
                   System.out.printf("=%.2f-----------%d",b[i],i+1);
                   System.out.printf("\n\n");
               }  /*performs the calculations and operations*/
               System.out.printf("The reduction of the matrix using Gaussian elimination\n\n");
               System.out.printf("\t\t\t\b\bThe reduction of  A\tThe vector b\n\n");
               for(i=0;i<row;i++)
               {
                   System.out.printf("\t\t\t\b\b");
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\t");
                   System.out.printf("%.2f",b[i]);
                   System.out.printf("\n\n");
               }   //reinitializes pivotal to be zero
               pivotal=0;
               for(k=0;k<row;)
               {
                   System.out.printf(" \t\t\t\b\bThe reduction of A\tThe vector b\n\n");
                   incre=0;
                   increment=0;
                   
                   divisor=array_u[pivotal][pivotal];
                   for(c=pivotal;c<column;c++)
                   {
                       array_u[k][c]=array_u[k][c]/divisor;
                   }
                   b[k]=b[k]/divisor;
                   for(d=pivotal;d<row;d++)
                   {
                       if(array_u[d+1][k]==-0.000000f)
                           array_u[d+1][k]=0.000000f;
                       
                       store[increment]=array_u[d+1][k];
                       increment++;
                   }
                   for(i=pivotal;i<row-1;i++)
                   {
                       for(j=pivotal;j<column;j++)
                       {
                           array_u[i+1][j]=((-store[incre])*array_u[k][j])+array_u[i+1][j];
                       }
                       b[i+1]=((-store[incre])*b[k])+b[i+1];
                       incre++;
                   }
                   incre=0;
                   for(i=0;i<row;i++)
                   {
                       if(i<pivote)
                           System.out.printf(" 1/%.2fR%d,%.2fR%d+R%d  ",divisor,k+1,-store[incre],k+1,i+k+2);
                       else
                           System.out.printf("\t\t\t\b\b");
                       for(j=0;j<column;j++)
                       {
                           if(array_u[i][j]==-0.000000f)
                               array_u[i][j]=0.000000f;
                           System.out.printf("%.2f  ",array_u[i][j]);
                       }
                       System.out.printf("\t");
                       System.out.printf("%.2f  ",b[i]);
                       System.out.printf("\n\n");
                       incre++;
                   }
                   System.out.printf("\n\n\n");
                   ++pivotal;++k;pivote--;
               }     System.out.printf("Gaussian Elimination of the matrix A\n\n");
               System.out.printf("Gaussian Elimination\tReduced vector b\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\t");
                   System.out.printf("%.2f",b[i]);
                   System.out.printf("\n\n");
               }       System.out.printf("Consider system  of equtions below\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       if(array_u[i][j]==0.000000f||array_u[i][j]==-0.000000f)
                           System.out.printf("          ");
                       else
                           System.out.printf("+ %.2fx%d ",array_u[i][j],j+1);
                   }
                   System.out.printf("=%.2f-----------%d",b[i],i+1);
                   System.out.printf("\n\n");
               }        System.out.printf("Solutions of x\n\n");
               for(i=row-1;i>=0;i--)
        {
         for(j=column-1;j>=0;j--)
           {
            if(i<j)
               sum[j]=(array_u[i][j]*multiplier[j]);
           }
         for(j=column-1;j>=0;j--)
           {
            if(i<j)
              b[i]=b[i]-sum[j]; 
           }
        System.out.printf("x%d=%.2f ",i+1,b[i]);
        System.out.printf("\n\n");
        multiplier[i]=b[i];
      }    }
    }
    finally{
           closeFile();
           System.gc();
       }  
    }
   /**
    * gaussian elimination is one of the most important direct methods of solving systems of equations
    * involving matrices
     * @param row
     * @param column
     * @throws java.io.FileNotFoundException
     */
   public static void luDecomposition(int row,int column) throws FileNotFoundException
     {
      try{
          openFile();
          try (Scanner scan = new Scanner(file)) {
              int i,j,k,c;
              int d,incre,increment,pivote;
              float divisor;
              float array_u[][] = new float [row+1][column];
              float array_l[][] = new float [row+1][column];
              float store[] = new float [row+1];
              float b[] = new float [row+1];
              float sum[]= new float [row];
              float multiplier[] = new float [row+1];
              //initialises the pivote operator to a decremented row variable
              pivote=row-1;
              //the following lines of text prompts the user to enter the matrix and the vector
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      array_u[i][j]=scan.nextFloat();
                  }
              }   
              for(i=0;i<row;i++)
                  b[i]=scan.nextFloat();
              //creats an upper triangular matrix
              for(i=0;i<row;i++)
              {
                  for(j=0;j<row;j++)
                  {
                      if(i>=j)
                          array_l[i][j]=1.0f;
                      else
                          array_l[i][j]=0.0f;
                  }
              }  //displays the matrix to the user view
              System.out.printf("The user entered the matrix\n\n");
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_u[i][j]);
                  }
                  System.out.printf("\n\n");
              }      //displays the matrix as a system of linear equations
              System.out.printf("Ax=b\n\n");
              System.out.printf("The matrix A and vector b has the system of equations below\n");
              for(i=0;i<row;i++)
              {
                  for(j=0;j<column;j++)
                  {
                      if(array_u[i][j]==0.000000f)
                          System.out.printf("          ");
                      else
                          System.out.printf("+ %.2fx%d ",array_u[i][j],j+1);
                  }
                  System.out.printf("=%.2f-----------%d",b[i],i+1);
                  System.out. printf("\n\n");
              }      //the lines of codes below perform the reduction of the matrix
              System.out.printf("The reduction of the matrix A and the lower triangular matrix to U and L\n\n");
              System.out.printf("\t\t\t\b\bThe reduction of A\tThe triangular matrix L\n\n");
              for(i=0;i<row;i++)
              {
                  System.out.printf("\t\t\t\b\b");
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_u[i][j]);
                  }
                  System.out.printf("\t");
                  for(j=0;j<row;j++)
                  {
                      System.out.printf("%.2f  ",array_l[i][j]);
                  }
                  System.out.printf("\n\n");
              }     //reinitializes the pivotal variable to zero
              pivotal=0;
              for(k=0;k<row;)
              {
                  System.out.printf(" \t\t\t\b\bThe reduction of A\tThe triangular matrix L\n\n");
                  incre=0;
                  increment=0;
                  if(array_u[pivotal][pivotal]==0.000000f||array_u[pivotal][pivotal]==-0.000000f)
                      divisor=1.000000f;
                  else
                      divisor=array_u[pivotal][pivotal];
                  if(k==0){
                      array_l[0][0]=array_u[0][0];
                      for(c=0;c<row;c++)
                          array_l[c+1][0]=array_u[c+1][0];
                  }
                  
                  for(c=pivotal;c<pivotal+1;c++)
                  {
                      if(k>0&&k>=c)
                      {
                          array_l[k][k]=array_u[k][k];
                      }
                  }
                  for(c=pivotal;c<column;c++)
                  {
                      array_u[k][c]=array_u[k][c]/divisor;
                  }
                  for(d=pivotal;d<row;d++)
                  {
                      if(array_u[d+1][k]==-0.000000f)
                          array_u[d+1][k]=0.000000f;
                      
                      store[increment]=array_u[d+1][k];
                      increment++;
                  }
                  for(i=pivotal;i<row-1;i++)
                  {
                      for(j=pivotal;j<column;j++)
                      {
                          array_u[i+1][j]=((-store[incre])*array_u[k][j])+array_u[i+1][j];
                          if(i>=j)
                              array_l[i+1][j]=store[incre];
                      }
                      incre++;
                  }
                  incre=0;
                  for(i=0;i<row;i++)
                  {
                      if(i<pivote)
                          System.out.printf(" 1/%.2fR%d,%.2fR%d+R%d  ",divisor,k+1,-store[incre],k+1,i+k+2);
                      else
                          System.out.printf("\t\t\t\b\b");
                      for(j=0;j<column;j++)
                      {
                          if(array_u[i][j]==-0.000000f)
                              array_u[i][j]=0.000000f;
                          System.out.printf("%.2f  ",array_u[i][j]);
                      }
                      System.out.printf("\t");
                      for(j=0;j<row;j++)
                      {
                          System.out.printf("%.2f  ",array_l[i][j]);
                      }
                      System.out.printf("\n\n");
                      incre++;
                  }
                  System.out.printf("\n\n\n");
                  ++pivotal;++k;pivote--;
              }         //Displays the result of the calculations to the user on the screen
              System.out.printf("The LU decomposition of the matrix A\n\n");
              System.out.printf("The triangular matrix L\tThe reduced matrix U\n\n");
              for(i=0;i<row;i++)
              {
                  for(j=0;j<row;j++)
                  {
                      System.out.printf("%.2f  ",array_l[i][j]);
                  }
                  System.out.printf("\t");
                  for(j=0;j<column;j++)
                  {
                      System.out.printf("%.2f  ",array_u[i][j]);
                  }
                  System.out.printf("\n\n");
              }        System.out.printf("LUx=b\n");
              System.out.printf("Let Ux=y\n");
              System.out.printf("=>Ly=b\n");
              System.out.printf("Consider the system Ly=b\n\n");
              for(i=0;i<row;i++)
              {
                  for(j=0;j<row;j++)
                  {
                      if(array_l[i][j]==0.000000||array_l[i][j]==-0.000000)
                          System.out.printf("          ");
                      else
                          System.out.printf("+ %.2fy%d ",array_l[i][j],j+1);
                  }
                  System.out.printf("=%.2f-----------%d",b[i],i+1);
                  System.out.printf("\n\n");
              }       //this displlays the solutions of the equations to the user
     System.out.printf("Solutions of Y\n\n");
              for(i=0;i<row;i++)
       {
        for(j=0;j<column;j++)
          {
           if(i>j)
             sum[j]=(array_l[i][j]*multiplier[j]); 
          }
        for(j=0;j<column;j++)
         {
          if(i>j)
            b[i]=b[i]-sum[j]; 
         }
        b[i]/=array_l[i][i];
        System.out.printf("y%d=%.2f ",i+1,b[i]);
        System.out.printf("\n\n");
        multiplier[i]=b[i];
       }      System.out.printf("Consider system Ux=y\n\n");
              for(i=0;i<row;i++)
        {
         for(j=0;j<column;j++)
           {
            if(array_u[i][j]==0.000000||array_u[i][j]==-0.000000)
               System.out.printf("          ");
            else
               System.out.printf("+ %.2fx%d ",array_u[i][j],j+1);
           }
         System.out.printf("=%.2f-----------%d",b[i],i+1);
         System.out. printf("\n\n");
        }     System.out.printf("Solutions of x\n\n");
              for(i=row-1;i>=0;i--)
         {
          for(j=column-1;j>=0;j--)
           {
            if(i<j)
              sum[j]=(array_u[i][j]*multiplier[j]);
           }
          for(j=column-1;j>=0;j--)
           {
            if(i<j)
              b[i]=b[i]-sum[j];
           }
          System.out.printf("x%d=%.2f ",i+1,b[i]);
          System.out.printf("\n\n");
          multiplier[i]=b[i];
        } }
    }
    finally{
           closeFile();
           System.gc();
       }

  }//ends the class

    /**
     *  closeFile 
     */
    public static void closeFile()
   {
       stream.close();
   }
}