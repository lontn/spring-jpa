package com.newegg.autopricing.cdp.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.newegg.autopricing.cdp.jpa.entity.Article;
import com.newegg.autopricing.cdp.jpa.entity.Type;
import com.newegg.autopricing.cdp.jpa.service.ProductDataService;

public class ApplicationManyToOne {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("1111111111111");
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:com/newegg/autopricing/cdp/jpa/spring-config.xml");
        System.out.println("ac:" + ac);
        ProductDataService service = ac.getBean(ProductDataService.class);
        Type type = new Type();
        type.setName("學術論文");

        Article article = new Article();
        article.setType(type);
        article.setName("明清時代古典小說3333");
        article.setContentText("明清時代3333...........");
        service.saveArticle(article);
        L.info("Done!!");

    }

}
