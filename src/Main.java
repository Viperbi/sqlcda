import com.adrar.sqlcda.db.Bdd;
import com.adrar.sqlcda.model.User;
import com.adrar.sqlcda.repository.UserRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //User newUser = new User("Mathieu","Mithridate","mathieu@gmail.com","123456");
        //UserRepository.save(newUser);
        System.out.println(UserRepository.findAll());
    }
}
