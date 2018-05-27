package com.newegg.autopricing.cdp.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.newegg.autopricing.cdp.jpa.entity.EMail;
import com.newegg.autopricing.cdp.jpa.entity.Person;
import com.newegg.autopricing.cdp.jpa.entity.Phone;
import com.newegg.autopricing.cdp.jpa.service.ProductDataService;

public class ApplicationOneToMany {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("1111111111111");
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:com/newegg/autopricing/cdp/jpa/spring-config.xml");
        System.out.println("ac:" + ac);
        ProductDataService service = ac.getBean(ProductDataService.class);
        Person person = new Person();
        person.setName("Lon");
        person.setAge(30);
        EMail eMail = new EMail();
        eMail.setMail("lontn@hotmail.com");
        EMail eMail2 = new EMail();
        eMail2.setMail("lontn.chang@hotmail.com");
        person.geteMails().add(eMail);
        person.geteMails().add(eMail2);
//        Phone phone = new Phone();
//        phone.setPhone("0936311477");
//        Phone phone2 = new Phone();
//        phone2.setPhone("0936311466");
//        person.getPhones().add(phone);
//        person.getPhones().add(phone2);
        service.savePerson(person);
        L.info("Done!!");
    }
}
