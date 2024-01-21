package content;

import org.junit.jupiter.api.*;

import user.User;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;


public class EventTest {
    Event event;
    LocalDate date;
    ArrayList<User> participants;
    User user;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Event tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.of(2023, 12, 13);
        event = new Event("test", date);
        participants = new ArrayList<>();
        user = new User();
    }

    @Test
    public void addParticipant(){
        int beforeParticipant = event.getParticipants().size();
        event.addParticipant(user);
        assertNotEquals(beforeParticipant, event.getParticipants().size());

        beforeParticipant = event.getParticipants().size();
        event.addParticipant(user);
        assertEquals(beforeParticipant, event.getParticipants().size());
    }

    @Test
    public void removeParticipant(){
        event.addParticipant(user);
        int beforeParticipant = event.getParticipants().size();
        event.removeParticipant(user);
        assertNotEquals(beforeParticipant, event.getParticipants().size());

        beforeParticipant = event.getParticipants().size();
        event.removeParticipant(user);
        assertEquals(beforeParticipant, event.getParticipants().size());
    }

    @Test
    public void searchParticipant(){
        event.addParticipant(user);
        boolean participantFound = event.searchParticipant(user);
        assertEquals(true, participantFound);

        event.removeParticipant(user);
        participantFound = event.searchParticipant(user);
        assertEquals(false, participantFound);
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Event testes");
    }
}
