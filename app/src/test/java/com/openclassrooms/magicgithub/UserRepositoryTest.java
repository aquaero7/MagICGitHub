package com.openclassrooms.magicgithub;

import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator;
import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;
import java.util.stream.Collectors;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4.class)
public class UserRepositoryTest {

    //PH> Déclare et instancie la variable de classe userRepository représentant la liste des utilisateurs courante.
    private UserRepository userRepository;
    
    @Before
    public void setup() {
        userRepository = Injection.createUserRepository();
    }
    
    @Test
    public void getUsersWithSuccess() {
        //PH> Teste la méthode 'getUsers'.
        //PH> Crée la liste des utilisateurs courante.
        //PH> Vérifie que cette liste correspond bien à la liste FAKE_USERS.
        List<User> usersActual = userRepository.getUsers();
        List<User> usersExpected = FAKE_USERS;
        assertThat(usersActual, containsInAnyOrder(usersExpected.toArray()));
    }

    @Test
    public void generateRandomUserWithSuccess() {
        //PH> Teste la méthode 'generateRandomUser'.
        //PH> Vide la liste des utilisateurs courante.
        //PH> Extrait aléatoirement un utilisateur et l'ajoute à la liste courante.
        //PH> Lit le premier élément de la liste courante (donc le seul).
        //PH> Vérifie que la liste des utilisateurs courante ne contient qu'1 élément.
        //PH> Vérifie que l'utilisateur récupéré aléatoirement est bien issu de la liste FAKE_USERS_RANDOM...
        //PH> ...en comparant ses id, login et URL).
        //PH> Vérifie que l'utilisateur récupéré aléatoirement n'est pas issu de la liste FAKE_USERS...
        //PH> ...en comparant ses id, login et URL).
        userRepository.getUsers().clear();
        userRepository.generateRandomUser();
        User user = userRepository.getUsers().get(0);
        assertEquals(1, userRepository.getUsers().size());
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
        assertFalse(FAKE_USERS.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertFalse(FAKE_USERS.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertFalse(FAKE_USERS.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
    }

    @Test
    public void deleteUserWithSuccess() {
        //PH> Teste la méthode 'deleteUser'.
        //PH> Lit le premier utilisateur de la liste courante (le seul).
        //PH> Supprime cet utilisateur.
        //PH> Vérifie que la liste courante ne contient plus cet utilisateur.
        User userToDelete = userRepository.getUsers().get(0);
        userRepository.deleteUser(userToDelete);
        assertFalse(userRepository.getUsers().contains(userToDelete));
    }
}