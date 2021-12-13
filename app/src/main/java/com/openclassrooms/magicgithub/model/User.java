package com.openclassrooms.magicgithub.model;

import java.util.Objects;
import java.util.Random;
import androidx.annotation.Nullable;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

public class User {

    //PH> Crée la structure des données représentant l'utilisateur (id, login, avatarUrl)...
    private String id;
    private String login;
    private String avatarUrl;

    public User(String id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    // --- GETTERS ---
    //PH> Crée les méthodes pour accéder aux données représentant l'utilisateur.
    public String getId() { return id; }
    public String getLogin() { return login; }
    public String getAvatarUrl() { return avatarUrl; }

    /**
     * Generate random user
     */
    public static User random(){
        //PH> Crée la méthode 'random' qui renvoie aléatoirement un utilisateur de la liste FAKE_USERS_RANDOM.
        return FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        return (((User) obj).avatarUrl == this.avatarUrl && ((User) obj).login == this.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, avatarUrl);
    }
}