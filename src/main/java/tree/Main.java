package tree;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            TreeRepository repo = new NaiveTreeRepository(factory);
            repo.addDivision(1, null);
            repo.addDivision(2, 1);
            repo.addDivision(3, 2);
            repo.addDivision(4, 2);
            System.out.println(repo.getAncestorsOf(3));
            System.out.println(repo.getChildrenOf(2));
            System.out.println(repo.getDescendantsOf(1));
            System.out.println(repo.getDescendantsOf(2));
        }
    }
}
