package tree;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tree.NaiveDivisionRepository;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            DivisionRepository repo = new NaiveDivisionRepository(factory);
            repo.addDivision(1, null);
            repo.addDivision(2, 1);
            repo.addDivision(3, 2);
            repo.addDivision(4, 2);
            System.out.println(repo.getAncestorsOf(3));
            System.out.println(repo.getChildsOf(2));
        }
    }
}
