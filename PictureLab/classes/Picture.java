import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 *  
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////
  
    /**
      * Constructor that takes no arguments 
      */
     public Picture ()
     {
         /* not needed but use it to show students the implicit call to super()
          * child constructors always call a parent constructor 
          */
         super();  
        } 
  
        /**
           * Constructor that takes a file name and creates the picture 
             * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }
  
    /**
       * Constructor that takes the width and height
         * @param height the height of the desired picture
           * @param width the width of the desired picture
             */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    } 
  
    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }
  
    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */ 
    public Picture(BufferedImage image)
    {
        super(image);
    }
  
    ////////////////////// methods ///////////////////////////////////////
  
    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
        " height " + getHeight() 
        + " width " + getWidth();
        return output;
    
    }
  
    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    } 
  
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray: pixels)
        {
            for (Pixel pix : rowArray)
            {
                pix.setGreen(0);
                pix.setRed(0);
            }
        }
    }     
  
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray: pixels)
        {
            for (Pixel pix : rowArray)
            {
                pix.setBlue(255 - pix.getBlue());
                pix.setGreen(255 - pix.getGreen());
                pix.setRed(255 - pix.getRed());
            }
        }
    } 

    public void gray()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray: pixels)
        {
            for (Pixel pix : rowArray)
            {
                int avg = (pix.getBlue() + pix.getGreen() + pix.getRed()) / 3;
                pix.setBlue(avg);
                pix.setGreen(avg);
                pix.setRed(avg);
            }
        }
    }
  
    /** Method that mirrors the picture around a 
       * vertical mirror in the center of the picture
         * from left to right */
    public void mirrorVertical()
    { 
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }
  
    public void mirrorRightLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }
    
    public void mirrorTopToBottom()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width; col++)
            {
                leftPixel = pixels[row][col]; 
                rightPixel = pixels[pixels.length - 1 - row][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorBottomToTop()
    { 
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[pixels.length - 1 - row][col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    } 
  
    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    { 
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        
        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
        
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    } 
  
    public void mirrorArms()
    {
        int mirrorPoint = 170;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        
        // loop through the rows
        for (int row = 165; row < 190; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 105; col < mirrorPoint; col++)
            {
                
                leftPixel = pixels[row][col];      
                rightPixel = pixels[2 * 170 - row + 25]                       
                     [col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }   
    
        for (int row = 170; row < 210; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 237; col < 293; col++)
            {
                
                leftPixel = pixels[row][col];      
                rightPixel = pixels[2 * 190 - row]                       
                [col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
  
    public void mirrorGull()
    { 
        int mirrorPoint = 170;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
    
        for (int row = 165; row < 190; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 105; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];      
                rightPixel = pixels[2 * mirrorPoint - row + 25]                       
                [col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        
        for (int row = 235; row < 320; row++)
        {
            for (int col = 239; col < 342; col++)
            {
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
            [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {    
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                leftPixel.setColor(Color.BLACK);
                else
                leftPixel.setColor(Color.WHITE);
            }
        }
    }   
  
    public void cropAndCopy(Picture source, int startRow, int endRow, int startCol, int endCol, int thisRow, int thisCol)
    {
        Pixel pixels[][] = this.getPixels2D();
        Pixel origin[][] = source.getPixels2D();
        for (int i = 0; i < endRow - startRow; i++)
        {
            for (int j = 0; j < endCol - startCol; j++)
            {
                pixels[i + thisRow][j + thisCol].setColor(origin[i + startRow][j + startCol].getColor());
            }
        }
    }
  
    public void sepia()
    {
        Pixel pixels[][] = this.getPixels2D();
        for (int i = 0; i < pixels.length; i++)
        {
            for (int j = 0; j < pixels[0].length; j++)
            {
                int red = (int)(pixels[i][j].getRed() * 0.393 + pixels[i][j].getGreen() * 0.769 + pixels[i][j].getBlue() * 0.189);
                int green = (int)(pixels[i][j].getRed() * 0.349 + pixels[i][j].getGreen() * 0.686 + pixels[i][j].getBlue() * 0.168);
                int blue = (int)(pixels[i][j].getRed() * 0.272 + pixels[i][j].getGreen() * 0.534 + pixels[i][j].getBlue() * 0.131);
                pixels[i][j].setRed(red);
                pixels[i][j].setGreen(green);
                pixels[i][j].setBlue(blue);
            }
        }
    }
    
    public void zoomOut(Picture inp, int degree)
    {
        Pixel pixels[][] = this.getPixels2D();
        Pixel source[][] = inp.getPixels2D();
        for (int i = 0; i < source.length / degree; i++)
        {
            for (int j = 0; j < source[0].length / degree; j++)
            {
                int sumRed = 0, sumBlue = 0, sumGreen = 0;
                
                for (int k = 0; k < degree; k++)
                {
                    for (int l = 0; l < degree; l++)
                    {
                        sumRed += source[degree * i + k][degree * j + l].getRed();
                        sumGreen += source[degree * i + k][degree * j + l].getGreen();
                        sumBlue += source[degree * i + k][degree * j + l].getBlue();
                    }
                }
                
                pixels[i][j].setRed((int)(sumRed / (degree * degree)));
                pixels[i][j].setGreen((int)(sumGreen / (degree * degree)));
                pixels[i][j].getBlue((int)(sumBlue / (degree * degree)));
            }
        }
    }
    
    /* Main method for testing - each class in Java can have a main 
    * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.zoomOut(beach, 2);
        beach.sepia();
        beach.explore();
        Picture beach2 = new Picture(beach);
        beach2.cropAndCopy(beach, 30, 160, 20, 180, 180, 100);
        beach2.explore();
    }  
} // this } is the end of class Picture, put all new methods before this
