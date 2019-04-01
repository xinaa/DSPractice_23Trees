import static org.junit.Assert.*;

import org.junit.Test;


public class Tree23Tests
{

   @Test
   public void singleNodeTree()
   {
      Tree t = new Tree();
      t.insert(9);
      
      assertEquals(1, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      
      t.insert(15);
      assertEquals(2, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      assertEquals(2, t.size(15));
      assertEquals(0, t.size(18));

      t = new Tree();
      t.insert(15);
      t.insert(9);
      assertEquals(2, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      assertEquals(2, t.size(15));
      assertEquals(0, t.size(18));
   }
   
   @Test
   public void oneSplitLeft()
   {
      Tree t = new Tree();
      t.insert(9);
      t.insert(15);
      t.insert(1);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));
   }
   
   @Test
   public void oneSplitRight()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(9);
      t.insert(15);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));
   }

   @Test
   public void oneSplitMiddle()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(15);
      t.insert(9);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));
   }

   
   @Test
   public void testDuplicates()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);

      assertEquals(7, t.size(9));
      assertEquals(3, t.size(4));
      assertEquals(3, t.size(15));

      assertEquals(0, t.size(12));
      assertEquals(1, t.size(13));
      assertEquals(0, t.size(14));
      assertEquals(0, t.size(19));
      assertEquals(1, t.size(20));
      assertEquals(0, t.size(21));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));

      assertEquals(0, t.size(6));
      assertEquals(1, t.size(7));
      assertEquals(0, t.size(8));

   }
   
   @Test
    public void cascadeFarRight()
    {
        Tree t = new Tree();
        t.insert(1);
        t.insert(9);
        t.insert(15);
        t.insert(13);
        t.insert(20);
        t.insert(7);
        t.insert(4);
        t.insert(12);
        t.insert(14);
        t.insert(18); 
        t.insert(19); 
        
        
        assertEquals(11, t.size(9));
        assertEquals(11, t.size(15));
        assertEquals(3, t.size(4));

        assertEquals(1, t.size(1));
        assertEquals(1, t.size(7));
        assertEquals(3, t.size(13));
        assertEquals(1, t.size(12));
        assertEquals(1, t.size(14));
        assertEquals(3, t.size(19));

        assertEquals(1, t.size(18));
        assertEquals(1, t.size(20)); 
        
    }
   
   @Test
   public void cascadeFarLeft()
   {
	   Tree t = new Tree();
       t.insert(1);
       t.insert(9);
       t.insert(15);
       t.insert(13);
       t.insert(20);
       t.insert(7);
       t.insert(4);
       t.insert(12);
       t.insert(14);
       t.insert(18); 
       t.insert(19);  
       t.insert(8); 
       
       assertEquals(2, t.size(8));
       assertEquals(4, t.size(4)); 
//       assertEquals(12, t.size(9)); 
//       
//       t.insert(9); 
//       
//       assertEquals(12, t.size(9));
       
       t.insert(6); 
       
       assertEquals(1, t.size(8));
       assertEquals(1, t.size(6));
       assertEquals(5, t.size(4)); 
       
       t.insert(2);
       
       assertEquals(6, t.size(4)); 
       assertEquals(2, t.size(2)); 
       
       t.insert(3);
       
       assertEquals(1, t.size(1));
       assertEquals(1, t.size(3));
       assertEquals(3, t.size(2)); 
       assertEquals(7, t.size(4));
       assertEquals(15, t.size(9)); 
       assertEquals(3, t.size(13)); 
	   
   }

   @Test
   public void cascadeRandoms()
   {
	   Tree t = new Tree();
       t.insert(1);
       t.insert(9);
       t.insert(15);
       t.insert(13);
       t.insert(20);
       t.insert(7);
       t.insert(4);
       t.insert(12);
       t.insert(14);
       t.insert(18); 
       t.insert(19);  
       t.insert(8);     
       t.insert(9);  
       t.insert(6); 
       t.insert(2);
       t.insert(3);
       t.insert(21);
       t.insert(21);
       t.insert(17);
       t.insert(16);
       t.insert(27); 
       
       assertEquals(1, t.size(27));
       assertEquals(1, t.size(20));
       assertEquals(3, t.size(21)); 
       assertEquals(3, t.size(17));
       assertEquals(1, t.size(16)); 
       assertEquals(1, t.size(18)); 
       assertEquals(11, t.size(19));
       assertEquals(11, t.size(15)); 
       assertEquals(3, t.size(13)); 
       assertEquals(1, t.size(12)); 
       assertEquals(1, t.size(14)); 
     
	   
   }
   
   
}
