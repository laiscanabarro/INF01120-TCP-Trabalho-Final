package content;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import utils.Location;

public class LocationTest {
    Location location;
    
    @BeforeAll
    public static void start(){
        System.out.println("Initiating Location tests");
    }
    
    @BeforeEach
    public void init(){
        location = new Location("Brazil", "POA", "RS", "Maua", 13);
    }
    
    @Test
    public void displayLocation(){
        String locationString = "Brazil, POA, RS, Maua, 13";
        assertEquals(locationString, location.displayLocation());        
    }
    
    @Test
    public void verifyLocation(){
        boolean value = location.verifyLocation();
        assertEquals(value, true);

        location.setNumber(0);
        value = location.verifyLocation();
        assertEquals(value, false);
    }
    
    @Test
    public void isNonEmpty(){
        String city = " ";
        assertEquals(false, location.isNonEmpty(city));

        city = "POA";
        assertEquals(true, location.isNonEmpty(city));
    }
    
    @AfterAll
    public static void close(){
        System.out.println("Finalizing Location testes");
    }
    
}
