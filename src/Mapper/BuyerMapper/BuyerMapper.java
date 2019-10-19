package Mapper.BuyerMapper;

import Model.Buyer;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerMapper {
    Buyer BuyerLogin(Buyer buyer);
}
