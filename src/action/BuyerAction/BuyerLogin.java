package action.BuyerAction;

import Model.Buyer;
import Service.BuyerService.BuyerServiceImpl.BuyerLoginImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BuyerLogin extends ActionSupport{

    //返回json数据的映射
    private JSONObject jsonObject;
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }

    Buyer buyer = new Buyer();

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Autowired
    BuyerLoginImpl buyerLoginImpl;

    public BuyerLoginImpl getBuyerLoginImpl() {
        return buyerLoginImpl;
    }

    public void setBuyerLoginImpl(BuyerLoginImpl buyerLoginImpl) {
        this.buyerLoginImpl = buyerLoginImpl;
    }

    @Override
    public String execute() throws Exception {

        buyer = buyerLoginImpl.BuyerLogin(buyer);
        System.out.println(buyer);
        jsonObject = JSON.parseObject(JSON.toJSONString(buyer));
        if (jsonObject != null)
        {
            ServletActionContext.getRequest().getSession().setAttribute("buyer",buyer.getId());
        }

       return SUCCESS;
    }

    @RequestMapping("/getBuyer")
    public void getSession(HttpServletRequest request, HttpServletResponse response) {
        //编码规范
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取session值
        HttpSession session = request.getSession();
        Object user = session.getAttribute("buyer");
        try {
            PrintWriter out = response.getWriter();
            out.write((String) user);
        } catch (Exception e) {
            System.out.println("Nothing session");
        }
    }

}
