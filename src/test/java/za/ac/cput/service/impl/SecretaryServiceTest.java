package za.ac.cput.service.impl;

//Sinenhlanhla Zondi

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Secretary;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest
public class SecretaryServiceTest {

    @Autowired
    private SecretaryService secretaryService;

    @Test
    void save()
    {
        Secretary secretary = new Secretary("06mJulia21", "Julia", "Montague");
        Secretary s = secretaryService.save(secretary);

        String createSecretaryID = "06"
                +secretary.getSecLastName().toLowerCase().charAt(0)
                +secretary.getSecFirstName()+"21";

        assertSame(secretary.getSecID(), createSecretaryID);
    }

    @Test
    void read()
    {
        Secretary secretary = new Secretary("03aNissa13", "Nissa", "Al-Ghul");
        Secretary s = secretaryService.save(secretary);
        assertNotSame("Scarlett", s.getSecFirstName());
    }

    @Test
    void delete()
    {
        Secretary secretary = new Secretary("02sFelicity15", "Felicity", "Smoak");
        Secretary s = secretaryService.save(secretary);
        assertNotNull(s);
    }

    @Test
    void get()
    {
        assertNull(secretaryService.listSecretaries());
    }
}
