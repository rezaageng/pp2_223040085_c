import controller.PlayerController;
import model.MyBatisUtil;
import model.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import view.PlayerView;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        PlayerMapper mapper = session.getMapper(PlayerMapper.class);

        PlayerView view = new PlayerView();
        new PlayerController(view, mapper);

        view.setVisible(true);
    }
}
