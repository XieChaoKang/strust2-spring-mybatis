package Mapper.AdminMapper;

import Model.Admin;
import Model.Goods_warehouse;
import Model.Item;
import Model.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    List<Admin> AllAdmin();

    Admin AdminLogin(Admin admin);
    Admin Se_AdByid(int id);
    int AdminRegister(Admin admin);
    List<Item> QueryAllItem();
    List<Item> QueryItemByName(Item item);
    List<Goods_warehouse> QueryAllGW();
    Warehouse QueryItemById(int id);
    List<Warehouse> selectAllWarehouse();
    Warehouse QueryAllItemById(int id);
    List<Item> QueryItemByW_num(int warehouse_number);
    int de_item(int id);
    int ud_item(Item item);
    int de_Wh(int id);
    int ud_Wh(Warehouse warehouse);
}
