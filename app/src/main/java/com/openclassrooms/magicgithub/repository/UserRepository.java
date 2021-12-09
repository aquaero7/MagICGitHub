package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

public class UserRepository {

    private final ApiService apiService; // TODO: A utiliser

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        //Doit renvoyer la liste d'utilisateurs, en utilisant apiService
        
        return apiService.getUsers();
        }

    public void generateRandomUser() {
        // TODO: A modifier
        // Doit prendre un utilisateur aléatoirement dans la liste FAKE_USERS_RANDOM et l'ajouter à la liste d'utilisateurs, en utilisant apiService
        
        apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        // Doit supprimer l'utilisateur spécifié de la liste d'utilisateurs, en utilisant apiService
        
        apiService.deleteUser(user);
    }
}
