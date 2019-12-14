package action.AdminAction;

import Service.AdminService.AdminServiceImp.DeleteWhByIdImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/11/011.
 */
//删除仓库信息
@Controller
public class De_Wh extends ActionSupport {

    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }


    @Autowired
    DeleteWhByIdImpl de;

    public DeleteWhByIdImpl getDe() {
        return de;
    }

    public void setDe(DeleteWhByIdImpl de) {
        this.de = de;
    }


    @Override
    public String execute() throws Exception {
        int count = de.de_GW(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);
        System.out.println(json);
        return SUCCESS;
    }
}
