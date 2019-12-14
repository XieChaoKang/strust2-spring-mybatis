package Service.BuyerService.BuyerServiceImpl;

import Mapper.BuyerMapper.BuyerMapper;
import Model.Buyer;
import Service.BuyerService.BuyerRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/13 16:32
 */
@Service
public class BuyerRegisterImpl implements BuyerRegister {

    @Autowired
    BuyerMapper buyerMapper;

    public BuyerMapper BuyerRegist() {
        return buyerMapper;
    }

    public void setBuyerMapperr(BuyerMapper buyerMapper) {
        this.buyerMapper = buyerMapper;
    }

    @Override
    public int BuyerRegist(Buyer buyer) {
        return buyerMapper.BuyerRegister(buyer);
    }
}
