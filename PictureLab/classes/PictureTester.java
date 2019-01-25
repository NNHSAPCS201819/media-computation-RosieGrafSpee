/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    collage1("tower.jpg");
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
  
  public static void collage1(String input)
  {
      Picture tower = new Picture(input);
      //Picture tower = new Picture(tower_raw.getHeight() / 2, tower_raw.getWidth() / 2);
      //tower.zoomOut(tower_raw, 2);
      
      Picture canvas = new Picture(2 * tower.getHeight(), 2 * tower.getWidth());
      
      Picture tower2 = new Picture(tower);
      
      Picture tower4 = new Picture(tower2);
      tower2.cropAndCopy(tower, tower.getHeight() / 2, tower.getHeight(), 0, tower.getWidth() / 2, 0, 0);
      tower2.mirrorVertical();
      tower2.sepia();
      
      Picture tower3 = new Picture(tower);
      tower3.keepOnlyBlue();
      tower3.negate();
      tower3.mirrorBottomToTop();
      
      tower4.sepia();
      tower4.negate();
      tower3.mirrorBottomToTop();
      
      canvas.cropAndCopy(tower, 0, tower.getHeight(), 0, tower.getWidth(), 0, 0);
      canvas.cropAndCopy(tower2, 0, tower.getHeight(), 0, tower.getWidth(), 0, tower.getWidth());
      canvas.cropAndCopy(tower3, 0, tower.getHeight(), 0, tower.getWidth(), tower.getHeight(), 0);
      canvas.cropAndCopy(tower4, 0, tower.getHeight(), 0, tower.getWidth(), tower.getHeight(), tower.getWidth());
      canvas.explore();
  }
}