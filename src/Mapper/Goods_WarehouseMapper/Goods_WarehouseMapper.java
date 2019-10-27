package Mapper.Goods_WarehouseMapper;

import Model.Goods_warehouse;
import Model.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface Goods_WarehouseMapper {

    int add(Goods_warehouse goods_warehouse);
    int delete(int number);
    Item QueryItemByid(int item_number);
    int UpdateItem(Item item);
}
