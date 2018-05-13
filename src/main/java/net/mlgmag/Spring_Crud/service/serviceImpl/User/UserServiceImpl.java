package net.mlgmag.Spring_Crud.service.serviceImpl.User;

import com.google.common.collect.ImmutableSet;
import net.mlgmag.Spring_Crud.model.Authority;
import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.repository.AuthorityRepository;
import net.mlgmag.Spring_Crud.repository.UserRepository;
import net.mlgmag.Spring_Crud.service.genericService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userDao, AuthorityRepository authorityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userDao;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAuthorities(ImmutableSet.of(authorityRepository.getOne(user.getAuthorityId())));
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAuthorities(ImmutableSet.of(authorityRepository.getOne(user.getAuthorityId())));
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public User findById(UUID uuid) {
        System.out.println(userRepository.getOne(uuid));
        return userRepository.getOne(uuid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean validate(User user, Model model) {
        boolean Error = false;
        if (findByUsername(user.getUsername()) != null) {
            Error = true;
            model.addAttribute("DuplicateUsername", "Username already exist");
        }
        if (findByEmail(user.getEmail()) != null) {
            Error = true;
            model.addAttribute("DuplicateEmail", "Email already exist");
        }
        return Error;
    }

    @Override
    public List<Authority> findAllAuthority() {
        return authorityRepository.findAll();
    }
}
