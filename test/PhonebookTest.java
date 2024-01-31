import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {

    @Test
    public void testThatTheAppExist(){
        PhoneBook phoneBook = new PhoneBook();
        assertNotNull(phoneBook);
    }

    @Test
    public void testThatItShowsAWelcomePage(){
        PhoneBook phoneBook  = new PhoneBook();
        assertEquals("PHONEBOOK\n1. Create a contact\n2. View Saved Contacts", phoneBook.welcomePage());
    }
}