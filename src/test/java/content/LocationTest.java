package content;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import utils.Location;

public class LocationTest {
    Location location;
    String country;
    String city;
    String state;
    String street;
    int number;
    
    @BeforeAll
    public static void start(){
        System.out.println("Initiating Location tests");
    }
    
    @BeforeEach
    public void init(){
        location = new Location();
        country = "Brazil";
        city = "POA";
        state = "RS";
        street = "Maua";
        number = 13;
    }
    
    @Test
    public void displayLocation(){
        //
    }
    
    @Test
    public void verifyLocation(){
        
    }
    
    @Test
    public void isNonEmpty(){
        
    }
    
    @AfterAll
    public static void close(){
        System.out.println("Finalizing Location testes");
    }
    
}
