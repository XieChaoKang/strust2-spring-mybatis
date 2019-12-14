package Service.BuyerService.BuyerServiceImpl;

import Mapper.Goods_WarehouseMapper.Goods_WarehouseMapper;
import Model.Warehouse;
import Service.BuyerService.Se_WarehouseByid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 谢朝康
 * @date 2019/12/11 14:33
 */

//service层 根据id查询该仓库的库存金额
@Service
public class Se_WarehouseByidImpl implements Se_WarehouseByid {

    @Autowired
    Goods_WarehouseMapper mapper;

    public Goods_WarehouseMapper getMapper() {
        return mapper;
    }

    public void setMapper(Goods_WarehouseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Integer Se_WarehouseByid(int id) {
        return mapper.Se_WarehouseByid(id);
    }
}
