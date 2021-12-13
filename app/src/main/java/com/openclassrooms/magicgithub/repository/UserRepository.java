package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

public class UserRepository {

    //PH> Déclare et instancie la constante de classe 'apiService'.
    private final ApiService apiService; // TODO: A utiliser

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        //PH> Déclare et définit la méthode 'getUsers' en renvoyant (appelant)...
        //PH> ...la méthode 'getUsers' de l'instance de classe 'apiService'.
        
        return apiService.getUsers();
        }

    public void generateRandomUser() {
        // TODO: A modifier
        //PH> Déclare et définit la méthode 'generateRandomUser' en renvoyant (appelant)...
        //PH> ...la méthode 'generateRandomUser' de l'instance de classe 'apiService'.
        
        apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        //PH> Déclare et définit la méthode 'deleteUser' en renvoyant (appelant)...
        //PH> ...la méthode 'deleteUser' de l'instance de classe 'apiService'...
        //PH> ... et en passant l'utilisateur à supprimer en paramètre.
        
        apiService.deleteUser(user);
    }
}
