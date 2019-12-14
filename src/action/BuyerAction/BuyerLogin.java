package action.BuyerAction;

import Model.Buyer;
import Service.BuyerService.BuyerServiceImpl.Buyer_login_Impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//采购员登录 数据接口
@Controller
public class BuyerLogin extends ActionSupport{

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
        buyer = buyerLoginImpl.Buyer_login(buyer);
        System.out.println(buyer);

        if (buyer != null)
        {
            count = 1;
        }
        else {
            count = 0;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        json = new JSONObject(map);

       return SUCCESS;
    }


}
