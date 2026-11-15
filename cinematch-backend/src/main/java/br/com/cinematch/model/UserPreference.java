package br.com.cinematch.model;
import jakarta.persistence.*;
@Entity
@Table(name = "usersPreference")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne 
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String genre;
    private int preferenceWeight;

    public UserPreference(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getPreferenceWeight() {
        return preferenceWeight;
    }
    public void setPreferenceWeight(int preferenceWeight) {
        this.preferenceWeight = preferenceWeight;
    }

    

}
