package mapper;

import model.JenisMember;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface JenisMemberMapper {
    @Insert("insert into jenis_member (id, nama) values (#{id}, #{nama})")
    public int insert(JenisMember jenisMember);

    @Update("update jenis_member set nama = #{nama} where id = #{id}")
    public int update(JenisMember jenisMember);

    @Delete("delete from jenis_member where id = #{id}")
    public int delete(JenisMember jenisMember);


    @Select("select *  from jenis_member")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nama", column = "nama")
    })
    List<JenisMember> findAll();
}
