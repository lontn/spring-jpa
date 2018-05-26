package com.newegg.autopricing.cdp.jpa;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.newegg.autopricing.cdp.jpa.entity.DimDate;
import com.newegg.autopricing.cdp.jpa.entity.DimProduct;
import com.newegg.autopricing.cdp.jpa.entity.DimStore;
import com.newegg.autopricing.cdp.jpa.entity.FactSales;
import com.newegg.autopricing.cdp.jpa.service.ProductDataService;

public class ApplicationRun {
    private static final Logger L = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("1111111111111");
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:com/newegg/autopricing/cdp/jpa/spring-config.xml");
        System.out.println("ac:" + ac);
        ProductDataService service = ac.getBean(ProductDataService.class);
        DimDate date = new DimDate();
        date.setDate(new Date());
        date.setDay(28);
        date.setDayOfWeek(36);
        date.setMonth(12);
        date.setMonthName("七月");
        date.setQuarter("AA");
        date.setQuarterName("BB");
        date.setYear(2018);
        System.out.println("22222222222222");
        DimStore store = new DimStore();
        store.setStateProvince("CC");
        store.setStoreNumber("DD");
        store.setCountry("USA");
        System.out.println("33333333333333");
        DimProduct product = new DimProduct();
        product.setEanCode("AAAAAA");
        product.setProductName("BBBB");
        product.setBrand("ASER");
        System.out.println("44444444444444");
        System.out.println("service:" + service);

        FactSales fSales = FactSales.newFactSales(2800, product, date, store);
        L.info("fSales:{}", fSales);
        service.saveFactSales(fSales);
//        service.saveProduct(product);
    }

}
