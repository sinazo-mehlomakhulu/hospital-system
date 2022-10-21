package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Doctor;
import za.ac.cput.service.impl.SecretaryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecretaryControllerTest {

    @Autowired
    private SecretaryController secretaryController;

    @Autowired
    private SecretaryService secretaryService;

    private Secretary secretary = new Secretary();

    @Test
    void save()
    {
        secretary = new Secretary("01Parker31", "Peter", "Parker");
        secretaryService.save(secretary);
        assertNotNull(secretary);
    }

    @Test
    void read()
    {
        String secretaryId = "06mJulia21";
        Secretary sec = secretaryService.get(secretaryId);
        assertSame(secretaryId, sec.getSecID());
    }

    @Test
    void delete()
    {
        Secretary secretaryId = new Secretary("03aNissa13", "", "");
        boolean deleted = secretaryService.delete(secretaryId.getSecID());
        assertTrue(deleted);
    }

    @Test
    void findAll()
    {
        List<Secretary> allSecretaries = secretaryService.listSecretaries();
        System.out.println(allSecretaries);
        assertNotNull(allSecretaries);
    }
}