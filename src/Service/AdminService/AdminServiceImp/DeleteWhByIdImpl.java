package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Service.AdminService.DeleteWhById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/12/11/011.
 */
@Service
public class DeleteWhByIdImpl implements DeleteWhById {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int de_GW(int id) {
        return adminMapper.de_Wh(id);
    }
}
