package cn.xiaochui.dao;

import cn.xiaochui.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    //select * from role where id in (select roleId from users_role where userId=#{userId})
    //select * from role where id in(select roleId from users_role where userId =#{userId})
    @Select("select * from role where id in(select roleId from users_role where userId =#{userId})")
    public List<Role> findByUserId(String userId);
}
