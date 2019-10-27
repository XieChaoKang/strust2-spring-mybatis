/**
 * @author 谢朝康
 * @date 2019/10/26 16:09
 */
package Service.BuyerService.BuyerServiceImpl;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Item;
import Service.BuyerService.QueryItemByid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//查询物品信息 根据id
@Service
public class QueryItemByidImpl implements QueryItemByid {

    @Autowired
    Goods_WarehouseMapper goods_warehouseMapper;

    public Goods_WarehouseMapper getGoods_warehouseMapper() {
        return goods_warehouseMapper;
    }

    public void setGoods_warehouseMapper(Goods_WarehouseMapper goods_warehouseMapper) {
        this.goods_warehouseMapper = goods_warehouseMapper;
    }

    @Override
    public Item QueryItemByitem_id(int item_number) {
        return goods_warehouseMapper.QueryItemByid(item_number);
    }
}
