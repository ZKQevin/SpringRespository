package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domin.Goods;
import org.example.domin.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    /*设置事务注解
    * rollbackFor：表示指定的异常一定回滚
    *   处理逻辑是：
    *       1）spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚。
    *       2)如果你的抛出异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException，如果是一定回滚。
    *   */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {
//                    NullPointerException.class,NotEnoughException.class
//            }
//    )
    /*因为上面写这么一堆都是默认的，直接用@Transactional就可以了，默认传播行为是REQUIRED，默认隔离级别是DEFAULT
    * 默认抛出的是运行时异常，回滚事务*/
    @Transactional
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
