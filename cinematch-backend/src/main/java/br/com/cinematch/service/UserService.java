package br.com.cinematch.service;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.cinematch.model.User;
import br.com.cinematch.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;
    public UserService(UserRepository repository,BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public boolean registerUser(String name,String email,String password,String bio,String pictureUrl){
        if(name==null || email == null || password == null){
            System.out.println("Alguma informação veio nula");
            return false;
        }else{
            if(name.isBlank() || email.isBlank() || password.isBlank()){
                System.out.println("Alguma informação veio vazia");
                return false;
            }else{
                String emailNormalized = email.trim().toLowerCase(Locale.ROOT);   
                if (repository.existsByEmail(emailNormalized)){
                    System.out.println("Email ja existente");
                    return false;
                }else{
                    LocalDateTime created = LocalDateTime.now();
                    String passwordHash= encoder.encode(password);   
                    User user = new User(name,emailNormalized,passwordHash,bio,pictureUrl,created);
                    repository.save(user);
                    System.out.println("Usuario criado!");
                    return true;
                }
            }
        }
    }

    public User getUserById(Long id){
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            User findeduser = user.get();
            return findeduser;
        }else{
            System.out.println("Id não encontrado");
            return null;
        }
    }


    public User getUserByEmail(String email){
        if(email == null || email.isBlank()){
            System.out.println("email invalido");
            return null;
        }

        String emailNormalized = email.trim().toLowerCase(Locale.ROOT); 
        Optional<User> user = repository.findByEmail(emailNormalized);
        if(user.isPresent()){
            User findeduser = user.get();
            return findeduser;
        }else{
            System.out.println("email não encontrado");
            return null;
        }
    }

    public boolean updateUser(Long id,String name,String bio,String pictureUrl){
        if(id == null || name == null || name.isBlank()){
        System.out.println("Dados invalidos");
        return false;
        }
        
        if(repository.existsById(id)){
            User user = getUserById(id);

            user.setName(name);

            if(bio != null){
                user.setBio(bio);
            }

            if(pictureUrl != null){
                user.setProfilePictureUrl(pictureUrl);
            }

            user.setUpdatedAt(LocalDateTime.now());

            repository.save(user);
            System.out.println("Dados atualizados");
            return true;
        }else{
            System.out.println("Id inexistente");
            return false;
        }
    }

    public boolean deleteUser(Long id){
        if(repository.existsById(id)){
            User user = getUserById(id);
            repository.delete(user);
            System.out.println("Usuario removido");
            return true;
        }else{
            System.out.println("id inexistente");
            return false;
        }

    }
}
