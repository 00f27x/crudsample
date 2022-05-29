package com.oof.crudsample;

import java.time.LocalDate;

import javax.transaction.Transactional;

import com.oof.crudsample.domain.Person;
import com.oof.crudsample.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class PopulateData implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person("Ivan C");
        p1.setBirthDate(LocalDate.of(1992, 10, 18));
        p1.setEmail("ivanhfc00@gmail.com");
        p1.setPhone("(81)0032-0033");
        p1.setCpf("365.966.252-66");
        
        Person p2 = new Person("Pablo Montoya");
        p2.setBirthDate(LocalDate.of(1990, 9, 2));
        p2.setEmail("pdalloglio@gmail.com");
        p2.setPhone("(81) 9.4343-4221");
        p2.setCpf("036.036.254-34");

        Person p3 = new Person("Lana Karina");
        p3.setBirthDate(LocalDate.of(1995, 2, 2));
        p3.setEmail("nana.lana@gmail.com");
        p3.setPhone("(42) 9.9033-2234");
        p3.setCpf("958.454.231-86");

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
    }
}