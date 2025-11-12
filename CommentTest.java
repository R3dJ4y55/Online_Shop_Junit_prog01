

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
        
    }
    
    /**
     * Tests to see if the values for author and rating are stored correctly
     */
    @Test
    public void testFieldValues(){
        Comment c = new Comment("Bon Jovi", "Great product!", 4);
        assertEquals("Bon Jovi", c.getAuthor());
        assertEquals(4, c.getRating());
    }
    
    @Test
    public void testUpvotes(){
        Comment c = new Comment("Helpful Customer", "Helpful Description", 4);
        assertEquals(0, c.getVoteCount());
        c.upvote();
        assertEquals(1, c.getVoteCount());
    }
    
    @Test
    public void testDownvotes(){
        Comment c = new Comment ("Unhelpful customer", "unhelpful comment", 4);
        assertEquals(0, c.getVoteCount());
        c.downvote();
        assertEquals(-1, c.getVoteCount());
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}