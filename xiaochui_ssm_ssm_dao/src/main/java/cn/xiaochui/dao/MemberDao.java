package cn.xiaochui.dao;


import cn.xiaochui.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String MemberId);
}
