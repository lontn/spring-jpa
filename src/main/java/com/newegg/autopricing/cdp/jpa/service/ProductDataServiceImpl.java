package com.newegg.autopricing.cdp.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newegg.autopricing.cdp.jpa.entity.DimProduct;
import com.newegg.autopricing.cdp.jpa.entity.FactSales;
import com.newegg.autopricing.cdp.jpa.entity.Person;
import com.newegg.autopricing.cdp.jpa.entity.Post;

/**
 * Reference:
 * http://bookmount8.blog.fc2.com/blog-date-20150219.html
 * https://stevenitlife.blogspot.tw/2016/03/hibernate-spring-jpa-configure.html
 * http://pro.ctlok.com/blog/2012/07/18/spring-integrate-jpa.html
 * @author lt22
 *
 */
@Service
public class ProductDataServiceImpl implements ProductDataService {
    private static final Logger L = LogManager.getLogger();

    //正常運作1 - 嘗試使用EntityManager進行Transactional事務控制
    @PersistenceContext
    private EntityManager entityManager;

    //正常運作2 - 從工廠類創建EntityManager的流程
//    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceProcess");
//    @PersistenceUnit(unitName="persistenceProcess")
//    private EntityManagerFactory entityManagerFactory;

    public void saveFactSales(FactSales sales) {
//        L.info("entityManager:{}", entityManagerFactory);
//        EntityManager etx = entityManagerFactory.createEntityManager();
//        try {
//            etx.getTransaction().begin();
//            etx.persist(sales);
//            etx.getTransaction().commit();
//        } finally {
//            etx.close();
//        }
        
    }

    /**
     * 註釋@Transactional註釋。首先，嘗試使用EntityManager進行事務控制。在源只有看的時候好去的可能性不大，但結果“HTTP狀態500
     * -請求處理失敗;嵌套的異常是java.lang.IllegalStateException：不允許在共享的EntityManager創建事務-使用Spring的事務或EJB
     * CMT，而不是”一個例外是發生。
     * 我認為使用實例變量使用“未管理在共享EntityManager上創建事務的實例”進行事務控制並不好，並在下面進行更改。
     * 
     */
    // 正常運作1 - 嘗試使用EntityManager進行Transactional事務控制 
    @Transactional
    public void savePost(Post post) {
        EntityManager eManager = entityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction etx = eManager.getTransaction();
        try {
            etx.begin();
            entityManager.persist(post);
            etx.commit();
        } finally {
            entityManager.close();
        }
    }

    // 正常運作2 - 從工廠類創建EntityManager的流程
//    public void savePost(Post post) {
//        EntityManager eManager = entityManagerFactory.createEntityManager();
//        EntityTransaction etx = eManager.getTransaction();
//        try {
//            etx.begin();
//            entityManager.persist(post);
//            etx.commit();
//        } finally {
//            entityManager.close();
//        }
//    }

    @Transactional
    public void savePerson(Person person) {
        EntityManager eManager = entityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction etx = eManager.getTransaction();
        try {
            etx.begin();
            entityManager.persist(person);
            etx.commit();
        } finally {
            entityManager.close();
        }
    }
//    @Transactional
    public void saveProduct(DimProduct product) {
//        L.info("entityManager:{}", entityManager.getTransaction());
//        EntityTransaction etx = entityManager.getTransaction();
//        try {
//            etx.begin();
//            entityManager.persist(product);
//            etx.commit();
//        } finally {
//            entityManager.close();
//        }
        
    }

}
