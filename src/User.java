/**
 * Created by RunningSnail on 17/2/13.
 */
public class User {
    public int lev;

    public User(int lev) {
        this.lev = lev;
    }

    @Override
    public String toString() {
        return "User{" +
                "lev=" + lev +
                '}';
    }
}
