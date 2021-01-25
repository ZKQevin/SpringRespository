package org.example.dao;

import org.example.domin.Sale;

public interface SaleDao {
    //增加销售记录
    int insertSale(Sale sale);
}
