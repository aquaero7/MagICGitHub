package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;
import java.util.List;
import androidx.annotation.Nullable;

public interface ApiService {
    //PH> Interface qui déclare les méthodes 'getUsers', 'generateRandomUser' et 'deleteUser'.
    //PH> Ces méthodes seront définies dans une classe fille qui implémentera cette interface (FakeApiService).
    List<User> getUsers();
    void generateRandomUser();
    void deleteUser(User username);
}
