package action.AdminAction;

import Model.Money;
import Model.Warehouse;
import Service.AdminService.AdminServiceImp.QueryAllWarehouseImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 谢朝康
 * @date 2019/12/14 18:12
 */
@Controller
public class WhMoney extends ActionSupport {

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Autowired
    QueryAllWarehouseImpl queryAllWarehouse12;

    public QueryAllWarehouseImpl getQueryAllWarehouse12() {
        return queryAllWarehouse12;
    }

    public void setQueryAllWarehouse12(QueryAllWarehouseImpl queryAllWarehouse12) {
        this.queryAllWarehouse12 = queryAllWarehouse12;
    }

    @Override
    public String execute() throws Exception {

        List<Warehouse> list = queryAllWarehouse12.selectAllWarehouse();

        int sum = 0;
        int max = 0;
        int min = list.get(0).getInventory_amount();
        int average;
        int count = 0;

        for (int i = 0;i < list.size();i++){
            Warehouse warehouse = list.get(i);

            if (max < warehouse.getInventory_amount()){
                max = warehouse.getInventory_amount();
            }

            if (min > warehouse.getInventory_amount()){
                min = warehouse.getInventory_amount();
            }

            sum = sum + warehouse.getInventory_amount();
        }

        average = sum/list.size();
       // System.out.println("a:"+average+"ma:"+max+"min:"+min);

        for (Warehouse warehouse : list){
            if (warehouse.getInventory_amount() > average) count ++;
        }

        //System.out.println("\n"+count);

        Money money = new Money(average,max,min,count);
        List<Money> list1 = new ArrayList<>();
        list1.add(money);

        json = LayerResult.getJson(list1);
        System.out.println(json);

        return SUCCESS;
    }
}
