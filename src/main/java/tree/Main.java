package tree;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml")) {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            try (SqlSession session = factory.openSession()) {
                List<Map<String, Object>> result = session.selectList("tree.selectNaive");

                result.forEach(row -> {
                    System.out.println(row);
                });
            }
        }
    }
}