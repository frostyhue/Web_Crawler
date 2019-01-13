package junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MusicTest {
    @Test
    public void testGetTitle()
    {
        String artist = "Some title";
        Music music = new Music("Metal", "CD", "2001", artist, "Music");
        assertEquals("{\"artist\":\"Metalnica\",\"year\":\"2003\",\"genre\":\"Metal\",\"format\":\"CD\",\"category\":\"Music\"}", music.getJSONFile().toJSONString());
    }

    @Test
    public void testJSONReturn()
    {
        Music music = new Music("Metal", "CD", "2003", "Metalnica", "Music");
        System.out.println(music.getJSONFile().toJSONString());
    }
}
