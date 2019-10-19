package Mapper.AdminMapper;

import Model.Admin;
import Model.Goods_warehouse;
import Model.Item;
import Model.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    Admin AdminLogin(int id);
    List<Item> QueryAllItem();
    List<Goods_warehouse> QueryAllGW();
    Warehouse QueryItemById(int id);
    List<Warehouse> selectAllWarehouse();
    Warehouse QueryAllItemById(int id);
    List<Item> QueryItemByW_num(int warehouse_number);
}
