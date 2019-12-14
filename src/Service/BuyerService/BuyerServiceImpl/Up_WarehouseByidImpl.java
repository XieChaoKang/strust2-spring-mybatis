package Service.BuyerService.BuyerServiceImpl;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Warehouse;
import Service.BuyerService.Up_WarehouseByid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/11 15:14
 */
@Service
public class Up_WarehouseByidImpl implements Up_WarehouseByid {

    @Autowired
    Goods_WarehouseMapper goods_warehouseMapper1;

    public Goods_WarehouseMapper getGoods_warehouseMapper() {
        return goods_warehouseMapper1;
    }

    public void setGoods_warehouseMapper(Goods_WarehouseMapper goods_warehouseMapper) {
        this.goods_warehouseMapper1 = goods_warehouseMapper;
    }

    @Override
    public int Up_WarehouseByid(Warehouse warehouse) {
        return goods_warehouseMapper1.Up_WarehouseByid(warehouse);
    }
}
