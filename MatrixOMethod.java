/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.ubeau.clarks;
/*
 *the lines of codes below  includes class libraries from the java API
 *needed for our program proper functioning
*/
import static cm.ubeau.clarks.MatrixDMethod.closeFile;
import static cm.ubeau.clarks.MatrixDMethod.file;
import static cm.ubeau.clarks.MatrixDMethod.openFile;
 import java.io.PrintStream;
 import java.io.File;
 import java.io.IOException;
 import java.io.FileNotFoundException;
 import java.util.Scanner;

/**
 *
 * @author EWANG CLARKSON
 */
public class MatrixOMethod 
{
  /**
    * The following method performs the inverse of a matrix
    * This includes any dimension of matrix
    */
    private static int pivotal=0;
   public static PrintStream stream;
   public static File file;
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
     *
     * @param row
     * @param column
     * @throws FileNotFoundException
     */
    public static void matrixInverse(int row,int column) throws FileNotFoundException
     {
       try{
           openFile();
           Scanner input = new Scanner(file);
        
            int i,j,k,c,pivotal=0,d,incre,increment,pivote = 0,h;
            int row1=2,p,y,diagonal=0;
            float divisor;
            float inverse[][] = new float [row+1][column];
            float identity[][] = new float [row+1][column];
            float store[] = new float [row+1];
            float multiplier[] = new float [row+1];
            float swap[] = new float[row+1];

     //folowing checks whether the matrix is a square matrix or not
       if(row==column){
         //prompts the user to entr the matrix
          for(i=0;i<row;i++)
            {
             for(j=0;j<column;j++)
               {
                inverse[i][j]=input.nextFloat();
               }
            }
    //creats an identity matrix
          for(i=0;i<row;i++)
            {
             for(j=0;j<column;j++)
              {
               if(i==j)
                 identity[i][j]=1.0f;
               else
                 identity[i][j]=0.0f;
              }
            }
    /*the operations below makes row interchanges */
          for(i=0;i<row;i++)
           {
            for(j=diagonal;j<row;j++)
               {
                  if (i==row-1)
                    {
                     if(i==row-1&&inverse[i][i]==0&&inverse[i-1][i]!=0)
                         {
                          for(k=0;k<row;k++)
                           {
                            swap[k]=inverse[i][k];
                            inverse[i][k]=inverse[i-1][k];
                            inverse[i-1][k]=swap[k];
                           }
                          for(k=0;k<row;k++)
                           {
                            swap[k]=identity[i][k];
                            identity[i][k]=identity[i-1][k];
                            identity[i-1][k]=swap[k];
                           }
                         }
                     }
                   if(inverse[i][i]==0&&inverse[j+1][i]!=0)
                    {
                     for(k=0;k<row;k++)
                       {
                        swap[k]=inverse[i][k];
                        inverse[i][k]=inverse[j+1][k];
                        inverse[j+1][k]=swap[k];
                      }
                     for(k=0;k<row;k++)
                      {
                       swap[k]=identity[i][k];
                       identity[i][k]=identity[j+1][k];
                       identity[j+1][k]=swap[k];
                      }
                   }
                }
              diagonal++;
            }
    //the following prints the matrix to the user
           System.out.printf("The user entered the matrix\n\n");
           for(i=0;i<row;i++)
             {
              for(j=0;j<column;j++)
                {
                 System.out.printf("%.2f  ",inverse[i][j]);
                }
               System.out.printf("\n\n");
             }
            System.out.printf("The identity matrix\n\n");
            for(i=0;i<row;i++)
             {
              for(j=0;j<column;j++)
               {
                System.out.printf("%.2f  ",identity[i][j]);
               }
               System.out.printf("\n\n");
             }
   //the following operations perform the reduction to the matrix
            System.out.printf("\t\t\t\b\bThe row reduction of the matrix \tthe identity matrix\n\n");
            for(i=0;i<row;i++)
              {
               System.out.printf("\t\t\t\b\b");
               for(j=0;j<column;j++)
                {
                 System.out.printf("%.2f  ",inverse[i][j]);
                } 
                System.out.printf("\t");
               for(j=0;j<column;j++)
                {
                 System.out.printf("%.2f  ",identity[i][j]);
                }
               System.out.printf("\n\n");
             }
            System.out.printf("\n\n");
            for(k=0;k<row;)
             {
              incre=0;               
              increment=0;
              divisor=inverse[pivotal][pivotal]; 
              for(c=0;c<column;c++)
                {
                 inverse[k][c]/=divisor;
                 identity[k][c]/=divisor;
                }
             for(d=pivotal;d<row;d++)
               {
                store[increment]=inverse[d+1][k];
                increment++;
               }
             for(i=pivotal;i<row-1;i++)
               {
                for(j=pivotal;j<column;j++)
                 {
                  inverse[i+1][j]=((-store[incre])*inverse[k][j])+inverse[i+1][j];
                 }
                for(j=0;j<column;j++)
                 {
                  identity[i+1][j]=((-store[incre])*identity[k][j])+identity[i+1][j];
                 }
                 incre++;
               }
             if(k>0){
                for(p=0;p<pivotal;p++)
                  {
                   multiplier[p]=inverse[p][k];
                  }
              for(y=0;y<pivotal;y++)
               {
                for(d=pivotal;d<column;d++)
                  {
                    inverse[y][d]=(-multiplier[y])*inverse[pivotal][d]+inverse[y][d];
                  }
                for(d=0;d<column;d++)
                  {
                   identity[y][d]=(-multiplier[y])*identity[pivotal][d]+identity[y][d];
                  }
              }
           }
          System.out.printf("\t\t\t\b\bReductiion of the matrix\t Reduction of the identity matrix\n\n");
          for(i=0;i<row;i++)
           {
            if(i<pivote&&i<=1)
              System.out.printf(" 1/%.2fR%d,%.2fR%d+R%d  ",divisor,k+1,-store[incre],k+1,i+k+2);
            else if(i<pivote&&i>1)
              System.out.printf("\t%.2fR%d+R%d  ",-multiplier[i],i+k+1,k+1);
            else
              System.out.printf("\t\t\t\b\b");
   
            for(j=0;j<column;j++)
              {
               if(inverse[i][j]==-0.000000f)
                   inverse[i][j]=0.000000f;
               
                 System.out.printf("%.2f   ",inverse[i][j]);
              }
              System.out.printf("\t");
            for(j=0;j<column;j++)
             {
              if(identity[i][j]==-0.000000f)
                 identity[i][j]=0.000000f;
               System.out.printf("%.2f  ",identity[i][j]);
             }
            System.out.printf("\n\n");
          }
         System.out.printf("\n\n\n");
         pivotal++;k++;pivote--;row1++;
         input.close();
      }
 //displays the inverse of the matrix to the user view
      System.out.printf("The inverse of the matrix\n\n");
      for(i=0;i<column;i++)
       {
        for(j=0;j<column;j++)
         {
          System.out.printf("%.2f  ",identity[i][j]);
         }
         System.out.printf("\n\n");
       }
    }
    else
      System.out.printf("The matrix must be a square matrix\n");
       
     
    }
    finally{
           closeFile();
           System.gc();
       }
   }
 //performs the addition of matrixes
   public static void matrixAddition(int number,int length) throws FileNotFoundException
    {
     
      try{
           openFile();
           Scanner input = new Scanner(file);
        

           int i,j,k,c;
           float matrix[][] = new float [number+1][length];
           float matrics[][] = new float [number+1][length];
           float add[][] = new float [number+1][length];

           
       //prompts the user to enter the first matrix
         for(i=0;i<number;i++)
           {
            for(j=0;j<number;j++)
               matrix[i][j]=input.nextFloat();
           }
      //prompts the user to enter the second matrix
        for(i=0;i<length;i++)
          {
           for(j=0;j<length;j++)
              matrics[i][j]=input.nextFloat();
          }
     //displays the matrix to the user to check for errors
        System.out.printf("the matrix A:\n");
        for(i=0;i<number;i++)
         { 
          for(j=0;j<number;j++)
           {
            System.out.printf("%.2f  ",matrix[i][j]);
           }
          System.out.printf("\n\n");
        }

       System.out.printf("the matrix B:\n\n");
       for(k=0;k<length;k++)
        {
         for(c=0;c<length;c++)
           {
            System.out.printf("%.2f  ",matrics[k][c]);
           }
         System.out.printf("\n\n");
        }
        System.out.printf("\n");
       if(number==length)
         {
          for(i=0;i<number;i++)
           {
            for(j=0;j<length;j++)
             {
              add[i][j]=matrix[i][j] + matrics[i][j];
             }
           }
         }
  //displays the addition results
       System.out.printf("the addition of the matrices A and B\n\n");
        for(i=0;i<number;i++)
         {
          for(j=0;j<length;j++)
             System.out.printf("%.2f  ",add[i][j]);
          
            System.out.printf("\n\n");
         }
        input.close();
      }
    finally{
           closeFile();
           System.gc();
       }
  }
   //performs the addition of matrixes
   public static void matrixSubstraction(int number,int length) throws FileNotFoundException
    {
     try{
         openFile();
         Scanner input = new Scanner(file);

         int  i,j,k,c;
         float matrix[][] = new float [number][length];
         float matrics[][] = new float [number][length];
         float substract[][] = new float [number][length];

      //the folowing prompts the user to enter the first matrix
        for(i=0;i<number;i++)
         {
          for(j=0;j<number;j++)
            matrix[i][j]=input.nextFloat();
         }
     //prompts the user to enter the second matrix
        
        for(i=0;i<length;i++)
          {
           for(j=0;j<length;j++)
               matrics[i][j]=input.nextFloat();
          }
    //displays the two matrices to the user to check if is that which was entered
       System.out.printf("the matrix A:\n\n");
       for(i=0;i<number;i++)
        {
         for(j=0;j<number;j++)
          {
           System.out.printf("%.2f  ",matrix[i][j]);
          }
          System.out.printf("\n\n");
        }
        System.out.printf("\n");
       System.out.printf("the matrix B:\n");
       for(k=0;k<length;k++)
         {
          for(c=0;c<length;c++)
           {
            System.out.printf("%.2f  ",matrics[k][c]);
           }
          System.out.printf("\n\n");
        }
      if(number==length)
        {
         for(i=0;i<number;i++)
          {
           for(j=0;j<length;j++)
            {
             substract[i][j]=matrix[i][j] - matrics[i][j];
            }
         }
        }
      if(number==length)
        {
         System.out.printf("the substraction of the matrices A and B:\n\n");
         for(k=0;k<number;k++)
          {
           for(i=0;i<length;i++)
             System.out.printf("%.2f  ",substract[k][i]);
           System.out.printf("\n\n");
         }
       }
      input.close();
    }
    finally{
           closeFile();
           System.gc();
    }
  }
//performs the addition of matrixes

    /**
     *
     * @param row
     * @param column
     */
    public static void matrixMultiplication(int row,int column) throws FileNotFoundException
    {
     try{
         openFile();
          Scanner input = new Scanner(file);
 
          int  i,j,k,c,d=0,h=0,x=0,y=0;
          float matrix[][] = new float [row][column];
          float matrics[][] = new float [row][column];
          float multi[][] = new float [row][column];

       
     //prompts the user to enter the first matrix
        for(i=0;i<row;i++)
         {
          for(j=0;j<row;j++)
            matrix[i][j]=input.nextFloat();
         }
    //prompts the user to enter the second matrix
        for(i=0;i<column;i++)
         {
          for(j=0;j<column;j++)
             matrics[i][j]=input.nextFloat();
         }
  
        multi[0][0]=0;
       System.out. printf("the matrix A:\n");
       for(i=0;i<row;i++)
         {
          for(j=0;j<row;j++)
            {
             System.out.printf("%.2f  ",matrix[i][j]);
             x=j;
            }
            y=i;
           System.out.printf("\n\n");
        }
        System.out.printf("\n");
        System.out.printf("the matrix B:\n");
        for(k=0;k<column;k++)
          {
           for(c=0;c<column;c++)
           {
            System.out.printf("%.2f  ",matrics[k][c]);
            h=c;
           }
           d=k;
          System.out.printf("\n\n");
         }
         System.out.printf("\n");
       if(x==d)
         {
          for(i=0;i<row;i++)
           {
            for(j=0;j<column;j++)
             {
              for(k=0;k<row;k++)
               {
                multi[i][j]=multi[i][j]+matrix[i][k]*matrics[k][j];
               }
             }
          }
        }

        else if (y==h)
          {
           for(k=0;k<column;k++)
            {
             for(c=0;c<row;c++)
              {
               for(j=0;j<row;j++)
                 multi[k][c]=multi[k][c]+ (matrix[k][j]*matrics[j][c]);
             }
           }
         }
      //displays the matrix to the user's view
       if(x==d)
         {
          System.out.printf("the multiplication of the matrices A and B:\n");
          for(i=0;i<row;i++)
           {
            for(j=0;j<row;j++)
             {
              System.out.printf("%.2f  ",multi[i][j]);
             }
            System.out.printf("\n\n");
           }
          System.out.printf("\n");
         }
        else if(y==h)
          {
           System.out.printf("the multiplication of the matrices A and B:\n\n");
           for(i=0;i<row;i++)
            {
             for(j=0;j<column;j++)
               {
                System.out.printf("%.2f  ",multi[j][j]);
               }
               System.out.printf("\n\n");
            }
         }
       input.close();
      }
    finally{
           closeFile();
           System.gc();
       }
  }
//performs the addition of matrixes
   public void matrixTranspose(int row,int column) throws FileNotFoundException
    {
     try{
         openFile();
         Scanner input = new Scanner(file);

          int i,j;
          float matrix[][] = new float [row][column];

      //the following lines of code prompts the user to enter the matrix
        System.out.printf("enter the %d elements of the first matrix\n",row*column);
        for(i=0;i<row;i++)
         {
          for(j=0;j<column;j++)
             matrix[i][j]=input.nextFloat();
         }
     //displays the matrix to the users to check is it's the entered one
      System.out.printf("the matrix A:\n\n");
      for(i=0;i<row;i++)
        {
         for(j=0;j<column;j++)
          {
           System.out.printf("%.2f  ",matrix[i][j]);
          }
         System.out.printf("\n\n");
       }
      System.out.printf("\n");
      System.out.printf("the tranpose of the matrix A:\n\n");
      for(i=0;i<row;i++)
        {
         for(j=0;j<column;j++)
          {
           System.out.printf("%.2f  ",matrix[j][i]);
          }
          System.out.printf("\n\n");
       }
      input.close();
     }
    finally{
           closeFile();
           System.gc();
       }
     }
   public static void matrixDeterminant(int row,int column) throws FileNotFoundException
     {
        try{
           openFile();
           try (Scanner input = new Scanner(file)) {
               int i,j,k,c;
               int d,incre,increment,pivote;
               float divisor,det=1;
               float array_u[][]=new float[row+1][column];
               float store[]=new float[row+1];
               float sum[]= new float[row];
               float determinant[] = new float[row+1];
              
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
               //displays the matrix entered by the matrix and carries out the calculations
               System.out.printf("The user entered the matrix\n\n");
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\n\n");
               }
              /*performs the calculations and operations*/
               System.out.println("THE ROW REDUCTION OF THE MATRIX\n\n");
               for(i=0;i<row;i++)
               {
                   System.out.printf("\t\t");
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\n\n");
               }   //reinitializes pivotal to be zero
               pivotal=0;
               for(k=0;k<row;)
               {
                 
                   incre=0;
                   increment=0;
                   
                   divisor=array_u[pivotal][pivotal];
                   det*=divisor;
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
                       }
                     
                       incre++;
                   }
                   incre=0;
                   for(i=0;i<row;i++)
                   {
                           System.out.printf("\t\t");
                       for(j=0;j<column;j++)
                       {
                           if(array_u[i][j]==-0.000000f)
                               array_u[i][j]=0.000000f;
                           System.out.printf("%.2f  ",array_u[i][j]);
                       }
                       System.out.printf("\n\n");
                       incre++;
                   }
                   System.out.printf("\n\n\n");
                   ++pivotal;++k;pivote--;
               }    
               System.out.printf("THE ROW REDUCED MATRIX\n\n");
         
               for(i=0;i<row;i++)
               {
                   for(j=0;j<column;j++)
                   {
                       System.out.printf("%.2f  ",array_u[i][j]);
                   }
                   System.out.printf("\n\n");
              }  
               
              System.out.printf("THE DETERMINANT OF THE MATRIX:%f\n\n",det);
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
}//ends the class
