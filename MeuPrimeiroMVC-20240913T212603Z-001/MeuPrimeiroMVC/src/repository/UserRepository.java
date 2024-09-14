package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList;

    public UserRepository(){
        this.userList =new ArrayList<>();
    }
    public void addUser(User user){
        user.setId(this.userList.size() + 1);
        this.userList.add(user);
    }

    //ta cachorreado
    public List<User> getUserList(){
        return this.userList;
    }

    public User searchUser(String username){
        for(User user : this.userList){
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }
    public boolean removeUser(String username){
        for(int i = 0; i < this.userList.size(); i++){
            if(this.userList.get(i).getUserName().equals(username)){
                this.userList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean alterUser(User user){
        //Ta cachorreira pode dar cagada
        if (this.userList.set(user.getId() - 1,user) != null){
            return true;
        }
        return false;
    }
}
