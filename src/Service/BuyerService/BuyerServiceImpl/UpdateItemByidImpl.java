/**
 * @author 谢朝康
 * @date 2019/10/26 17:56
 */
package Service.BuyerService.BuyerServiceImpl;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Item;
import Service.BuyerService.UpdateItemByid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//采购员入库物品 该物品存在于仓库
@Service
public class UpdateItemByidImpl implements UpdateItemByid {

    @Autowired
    Goods_WarehouseMapper goods_warehouseMapper;

    public Goods_WarehouseMapper getGoods_warehouseMapper() {
        return goods_warehouseMapper;
    }

    public void setGoods_warehouseMapper(Goods_WarehouseMapper goods_warehouseMapper) {
        this.goods_warehouseMapper = goods_warehouseMapper;
    }

    @Override
    public int UpdateItem(Item item) {
        return goods_warehouseMapper.UpdateItem(item);
    }
}
