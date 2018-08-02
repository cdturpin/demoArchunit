package com.keyholesoftware.demo.archunit.persistence.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.keyholesoftware.demo.archunit.DemoArchUnitApplication;
import com.keyholesoftware.demo.archunit.domain.DomainObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoArchUnitApplication.class)
public class DomainObjectRepositoryTest {

    @Autowired
    private DomainObjectRepository<DomainObject, Long> doRepo;

    @Test
    public void testContext() {
        assertNotNull(doRepo);
    }

    @Test
    public void givenAnyDomainObjectRepository_whenSaveAndRetreiveEntity_thenOK() {

        DomainObject domainObject = doRepo.save(new DomainObject(123456L));
        DomainObject foundEntity = doRepo.findOne(domainObject.getId());

        assertNotNull(foundEntity);
        assertEquals(domainObject.getId(), foundEntity.getId());
       
    }

}
