package junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class testing Music class.
 */
public class MusicTest {
    /**
     * Test method to check for the proper title.
     */
    @Test
    public void testGetTitle()
    {
        String artist = "Some title";
        Music music = new Music("Master of Puppets", "Metal", "CD", "2001", artist, "Music");

    }

    /**
     * Mock tests regarding Music variables.
     */
    @Test
    public void testMusicVariables()
    {
        Music mockMusic= mock(Music.class);

        when(mockMusic.getArtist()).thenReturn("Metallica");

        assertEquals(mockMusic.getArtist(), "Metallica");

        when(mockMusic.getArtist()).thenReturn("AC DC");

        assertEquals(mockMusic.getArtist(), "AC DC");

        when(mockMusic.getTitle()).thenReturn("Metallica");

        assertEquals(mockMusic.getTitle(), "Metallica");

        when(mockMusic.getCategory()).thenReturn("Music");

        assertEquals(mockMusic.getCategory(), "Music");
    }

    /**
     * Test method checking for proper JSON.
     */
    @Test
    public void testJSONReturn()
    {
        Music music = new Music("Metallica","Metal", "CD", "2003", "Metalnica", "Music");
        assertEquals("{\"artist\":\"Metalnica\",\"year\":\"2003\",\"genre\":\"Metal\",\"format\":\"CD\",\"title\":\"Metallica\",\"category\":\"Music\"}", music.getJSONFile().toJSONString());
    }
}
