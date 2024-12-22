package model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PlayerMapper {
    @Select("SELECT * FROM players")
    List<Player> getPlayers();

    @Insert("INSERT INTO players (name, role, weapon, race, gender) VALUES (#{name}, #{role}, #{weapon}, #{race}, #{gender})")
    void insertPlayer(Player player);

    @Update("UPDATE players SET name=#{name}, role=#{role}, weapon=#{weapon}, race=#{race}, gender=#{gender} WHERE id=#{id}")
    void updatePlayer(Player player);

    @Delete("DELETE FROM players WHERE id=#{id}")
    void deletePlayer(int id);
}
