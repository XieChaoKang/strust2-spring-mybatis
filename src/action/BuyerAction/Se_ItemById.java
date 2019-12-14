package action.BuyerAction;

import Model.Item;
import Service.BuyerService.BuyerServiceImpl.QueryItemByidImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 谢朝康
 * @date 2019/12/11 15:50
 */
@Controller
public class Se_ItemById extends ActionSupport {
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    @Autowired
    QueryItemByidImpl queryItemByidimpl;

    public QueryItemByidImpl getQueryItemByidimpl() {
        return queryItemByidimpl;
    }

    public void setQueryItemByidimpl(QueryItemByidImpl queryItemByidimpl) {
        this.queryItemByidimpl = queryItemByidimpl;
    }

    @Override
    public String execute() throws Exception {

        Item item = queryItemByidimpl.QueryItemByitem_id(num);
        int count ;
        if (item != null){
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

    public String sel(){
        Item item = queryItemByidimpl.QueryItemByitem_id(num);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(itemList);

        System.out.println(itemList);

        return SUCCESS;
    }
}
