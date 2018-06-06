package guru.springframework.repositories;

import guru.springframework.entities.Ingrediant;
import guru.springframework.entities.UnitOfMesure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMesureRepositoryIT {
    @Autowired
    UnitOfMesureRepository unitOfMesureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByDescription() throws Exception {
        Optional<UnitOfMesure> units = unitOfMesureRepository.findByDescription("Gramme");
        assertEquals("Gramme", units.get().getDescription());
    }
    @Test
    public void findByDescription_kilo() throws Exception {
        Optional<UnitOfMesure> units = unitOfMesureRepository.findByDescription("cuillière");
        assertEquals("cuillière", units.get().getDescription());
    }

}