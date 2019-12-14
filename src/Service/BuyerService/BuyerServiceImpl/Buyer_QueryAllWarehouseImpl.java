package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Warehouse;
import Service.BuyerService.Buyer_QueryAllWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13/013.
 */
@Service
public class Buyer_QueryAllWarehouseImpl implements Buyer_QueryAllWarehouse {

    @Autowired
    private BuyerMapper buyerMapper;

    public BuyerMapper getBuyerMapper() {
        return buyerMapper;
    }

    public void setBuyerMapper(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }

    @Override
    public List<Warehouse> buyer_selectAllWarehouse() {
        return buyerMapper.buyer_selectAllWarehouse();
    }
}
