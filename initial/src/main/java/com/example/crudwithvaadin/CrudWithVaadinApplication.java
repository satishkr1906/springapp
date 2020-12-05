package com.example.crudwithvaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudWithVaadinApplication {

  private static final Logger log = LoggerFactory.getLogger(CrudWithVaadinApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudWithVaadinApplication.class);
    }
    /*
    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Satishkumar", "Rathe"));
            repository.save(new Customer("Chloe", "Bannet"));
            repository.save(new Customer("Kim", "Bone"));
            repository.save(new Customer("David", "Milller"));
            repository.save(new Customer("Michelle", "Johnson"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L).get();
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository
                    .findByLastNameStartsWithIgnoreCase("Satish")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
    */
    @Bean
    public CommandLineRunner loadData(ContactsRepository repository) {
        return (args) -> {
        	repository.save(new Contact("satish.rathe@gmail.com", "Satishkumar", "Rathe", 9665462383L, true));
        	repository.save(new Contact("ram.rathe@gmail.com", "Ram", "Suryavanshi", 9665432383L, true));
        	repository.save(new Contact("shyam.rathe@gmail.com", "Shyam", "Yadav", 9665466576L, true));
        	repository.save(new Contact("ghanshyam.rathe@gmail.com", "Ghanshyam", "yadav", 9665463454L, true));
        	repository.save(new Contact("raghuram.rathe@gmail.com", "Raghuram", "Raghuwanshi", 9665462343L, true));
        	
        	
        	 // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Contact customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Contact contact = repository.findById(1L).get();
            log.info("Customer found with findByEmailId(satish.rathe@gmail.com):");
            log.info("--------------------------------");
            log.info(contact.toString());
            log.info("");
        	
        };
    }

}
