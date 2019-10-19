package action.AdminAction;

import Model.Warehouse;
import Service.AdminService.AdminServiceImp.QueryItemByidImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//根据仓库id查询该仓库内物品信息（一对一关联查询）
@Controller
public class QueryItemByid extends ActionSupport {


    Warehouse warehouse = new Warehouse();

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Autowired
    QueryItemByidImpl queryItemByidImpl;

    public QueryItemByidImpl getQueryItemByidImpl() {
        return queryItemByidImpl;
    }

    public void setQueryItemByidImpl(QueryItemByidImpl queryItemByidImpl) {
        this.queryItemByidImpl = queryItemByidImpl;
    }

    @Override
    public String execute() throws Exception {
        String result;
        warehouse = queryItemByidImpl.QueryItemById(warehouse);
        if (warehouse != null)
        {
            result = SUCCESS;
            ServletActionContext.getRequest().getSession().setAttribute("warehouse",warehouse);
        }

        else
        {
            String msg = "登录失败！！"+"\n"+"请检查账号或密码是否正确！！";
            result = ERROR;
            ServletActionContext.getRequest().getSession().setAttribute("msg",msg);
        }

        return result;

    }
}
