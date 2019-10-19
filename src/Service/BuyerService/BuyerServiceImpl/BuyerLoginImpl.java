package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Buyer;
import Service.BuyerService.BuyerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerLoginImpl implements BuyerLogin{

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public Buyer BuyerLogin(Buyer buyer) {
        return buyerMapper.BuyerLogin(buyer);
    }

    public BuyerMapper getBuyerMapper() {
        return buyerMapper;
    }

    public void setBuyerMapper(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }
}
