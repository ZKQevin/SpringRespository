package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domin.Goods;
import org.example.domin.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("======buy方法的开始======");
        //记录销售信息，想sqle表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            //商品不存在
            throw new NullPointerException("编号是：" + goodsId + "，商品不存在");

        } else if (goods.getAmount() < nums) {
            //商品库存不足
            throw new NotEnoughException("编号是：" + goodsId + "，商品库存不足");
        }
        //修改库存
        Goods buygoods = new Goods();
        buygoods.setId(goodsId);
        buygoods.setAmount(nums);
        goodsDao.updateGoods(buygoods);
        System.out.println("======buy方法的结束======");

    }



    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
