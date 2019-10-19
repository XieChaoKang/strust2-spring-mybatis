package Service.BuyerService.BuyerServiceImpl;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Goods_warehouse;
import Service.BuyerService.Buyer_Goods_warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Buyer_Goods_warehouseImpl implements Buyer_Goods_warehouse {

    public Goods_WarehouseMapper getGoods_warehouseMapper() {
        return goods_warehouseMapper;
    }

    public void setGoods_warehouseMapper(Goods_WarehouseMapper goods_warehouseMapper) {
        this.goods_warehouseMapper = goods_warehouseMapper;
    }

    @Autowired
    private Goods_WarehouseMapper goods_warehouseMapper;


    @Override
    public int insert(Goods_warehouse goods_warehouse) {
        return goods_warehouseMapper.add(goods_warehouse);
    }
}
