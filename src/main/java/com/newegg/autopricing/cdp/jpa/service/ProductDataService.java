package com.newegg.autopricing.cdp.jpa.service;

import com.newegg.autopricing.cdp.jpa.entity.Article;
import com.newegg.autopricing.cdp.jpa.entity.DimProduct;
import com.newegg.autopricing.cdp.jpa.entity.FactSales;
import com.newegg.autopricing.cdp.jpa.entity.Person;
import com.newegg.autopricing.cdp.jpa.entity.Post;

public interface ProductDataService {
    public void saveFactSales(FactSales sales);
    public void saveProduct(DimProduct product);
    public void savePost(Post post);
    public void savePerson(Person person);
    public void saveArticle(Article article);
}
