package Service.AdminService.AdminServiceImp;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Goods_warehouse;
import Service.AdminService.Admin_Goods_warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_Goods_warehouseImpl implements Admin_Goods_warehouse {

    public Goods_WarehouseMapper getGoods_warehouseMapper() {
        return goods_warehouseMapper;
    }

    public void setGoods_warehouseMapper(Goods_WarehouseMapper goods_warehouseMapper) {
        this.goods_warehouseMapper = goods_warehouseMapper;
    }

    @Autowired
    private Goods_WarehouseMapper goods_warehouseMapper;

    @Override
    public int delete(Goods_warehouse goodsWarehouse) {
        return goods_warehouseMapper.delete(goodsWarehouse.getNumber());
    }
}
