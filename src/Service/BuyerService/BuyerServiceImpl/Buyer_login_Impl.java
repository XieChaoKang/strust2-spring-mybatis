package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Buyer;
import Service.BuyerService.Buyer_login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//采购员登录
@Service
public class Buyer_login_Impl implements Buyer_login {

    @Autowired
    private BuyerMapper buyerMapper;

    public BuyerMapper getBuyerMapper() {
        return buyerMapper;
    }

    public void setBuyerMapper(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }

    @Override
    public Buyer Buyer_login(Buyer buyer) {
        return buyerMapper.BuyerLogin(buyer);
    }
}
