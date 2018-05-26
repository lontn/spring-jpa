package com.newegg.autopricing.cdp.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.newegg.autopricing.cdp.jpa.entity.Post;
import com.newegg.autopricing.cdp.jpa.entity.Tag;
import com.newegg.autopricing.cdp.jpa.service.ProductDataService;

public class ApplicationManyToMany {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("1111111111111");
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:com/newegg/autopricing/cdp/jpa/spring-config.xml");
        System.out.println("ac:" + ac);
        ProductDataService service = ac.getBean(ProductDataService.class);
        Tag tag1 = new Tag();
        tag1.setName("5555");
        Tag tag2 = new Tag();
        tag2.setName("22sfdsfsf222");
        Tag tag3 = new Tag();
        tag3.setName("33rewrwer333");

        Post post = new Post();
        post.setTitle("NNerereNN....");
        post.setContentText("FFFfdfdfs232FF...");
        post.getTags().add(tag1);
        post.getTags().add(tag2);
        post.getTags().add(tag3);
        service.savePost(post);
    }
}
