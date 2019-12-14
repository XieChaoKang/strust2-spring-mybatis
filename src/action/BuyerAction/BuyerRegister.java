package action.BuyerAction;

import Model.Buyer;
import Service.BuyerService.BuyerServiceImpl.Buyer_login_Impl;
import Service.BuyerService.BuyerServiceImpl.BuyerRegisterImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/6/006.
 */

@Controller
public class BuyerRegister extends ActionSupport {
    //返回json数据的映射
    private JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    Buyer buyer = new Buyer();

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Autowired
    BuyerRegisterImpl buyerRegistlmpl;

    public BuyerRegisterImpl getBuyerRegistlmpl() {
        return buyerRegistlmpl;
    }

    public void setBuyerRegistlmpl(BuyerRegisterImpl buyerRegistlmpl) {
        this.buyerRegistlmpl = buyerRegistlmpl;
    }

    @Autowired
    Buyer_login_Impl buyerLoginImpl;

    public Buyer_login_Impl getBuyerLoginImpl() {
        return buyerLoginImpl;
    }

    public void setBuyerLoginImpl(Buyer_login_Impl buyerLoginImpl) {
        this.buyerLoginImpl = buyerLoginImpl;
    }

    @Override
    public String execute() throws Exception {

        int count;
       // buyer = buyerLoginImpl.Buyer_login(buyer);
        System.out.println("buyer:"+buyer);
        if (buyerLoginImpl.Buyer_login(buyer) == null ) {
            count = buyerRegistlmpl.BuyerRegist(buyer);
        }
        else {
            count = 0;
       }
        System.out.println("a: "+count);
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        json = new JSONObject(map);

        return SUCCESS;
    }
}