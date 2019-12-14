package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Item;
import Service.BuyerService.Buyer_QueryAllItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13/013.
 */
@Service
public class Buyer_QueryAllItemImpl implements Buyer_QueryAllItem {

    @Autowired
    BuyerMapper buyerMapper;

    public BuyerMapper getBuyerMapper() {
        return buyerMapper;
    }

    public void setBuyerMapper(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }

    @Override
    public List<Item> buyer_QueryAllItem() {
        return buyerMapper.buyer_QueryAllItem();
    }
}
