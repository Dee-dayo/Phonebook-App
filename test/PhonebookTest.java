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
        String menu = "\nPHONEBOOK\n1. Save a contact\n2. View Saved Contacts\n3. Search Saved Contacts\n4. Delete a contact\n5. Exit";
        assertEquals(menu, phoneBook.welcomePage());
    }


    @Test
    public void testThatTheApplicationCanCreateContact(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.createContact("dayo", "08172581627");
        

    }
}