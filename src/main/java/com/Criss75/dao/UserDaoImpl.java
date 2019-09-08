package cm.Criss75.dao;

import com.Criss75.user.UserAccount;

public class UserDaoImpl implements UserDao {
    @Override
    public int registerUser(UserAccount userAccount) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO account" +
                "  (user_id, username, email, password) VALUES " +
                " (?, ?, ?, ?   );";
        int result = 0;
    }
}
