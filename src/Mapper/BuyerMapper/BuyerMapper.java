package Mapper.BuyerMapper;

import Model.Buyer;
import Model.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerMapper {
    Buyer BuyerLogin(Buyer buyer);
    int Insert_new_Item(Item item);
}
