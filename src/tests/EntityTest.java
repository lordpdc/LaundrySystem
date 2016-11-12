package tests;

import business.entities.Consumable;
import business.entities.User;
import data.dao.ConsumableDao;
import data.dao.UserDao;

import java.util.List;

/**
 * Created by cesar on 21/09/16.
 */
public class EntityTest {

    public static void main(String[] args) {
        List<User> usrs = new UserDao().readAll();
        List<Consumable> cons = new ConsumableDao().readAll();

        for (User usr: usrs){
            System.out.println(" usr: "+usr.getUsername());
        }

        for (Consumable con: cons){
            System.out.println(" con: "+con.getName());
        }
    }

}
