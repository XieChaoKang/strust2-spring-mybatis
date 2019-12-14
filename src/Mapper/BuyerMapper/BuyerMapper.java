package Mapper.BuyerMapper;

import Model.Buyer;
import Model.Item;
import Model.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerMapper {
    Buyer BuyerLogin(Buyer buyer);
    int Insert_new_Item(Item item);
    int BuyerRegister(Buyer buyer);
    List<Item> buyer_QueryAllItem();
    List<Warehouse> buyer_selectAllWarehouse();
}
