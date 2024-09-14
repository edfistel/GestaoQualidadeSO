package controller;

import model.User;
import repository.UserRepository;
import view.ListView;
public class UserController {
    private UserRepository userRepo = new UserRepository();
    public void addUser(User user){
        userRepo.addUser(user);

    }
    public  void listAll(){
       for (User usuario  :  userRepo.getUserList()) {
            ListView.listar(usuario.getName(), usuario.getUserName(), usuario.getId());
        }
    }
    public User searchUserRep(String username){
        return this.userRepo.searchUser(username);
    }
    public boolean remove(String username){
        return  this.userRepo.removeUser(username);
    }
    public boolean alter(User user){
        return this.userRepo.alterUser(user);
    }
}