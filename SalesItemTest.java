import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }
    
    @Test
    public void testDuplicateComment(){
        SalesItem item = new SalesItem("Cool Item", 10);
        item.addComment("author", "comment", 3);
        assertEquals(false, item.addComment("author", "Other comment", 4));
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }
    
    @Test
    public void testNegativeRatingRangeBoundaries(){
        SalesItem i = new SalesItem("Cheap Item", 1);
        assertEquals(false, i.addComment("firstAuthor", "cmmnt", 0));
        assertEquals(false, i.addComment("secondAuthor", "cmmnt", 6));
    }
    
    @Test
    public void testFindMostHelpfulComment(){
        SalesItem item = new SalesItem("Item", 10);
        
        // Initialise comments
        item.addComment("Auth1", "Text", 1);
        item.addComment("Helpful", "Text", 4);
        item.addComment("Auth3", "Text", 2);
        
        for (int i=0; i<10; i++){
            item.upvoteComment(1);
        }
        for(int i = 0; i<3; i++){
            item.downvoteComment(2);
        }
        
        assertEquals(item.getComment(1), item.findMostHelpfulComment());
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
}
