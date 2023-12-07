package com.salesmanager.sales.serviceImpl;

import com.salesmanager.sales.entity.UserEntity;
import com.salesmanager.sales.repository.UserRepository;
import com.salesmanager.sales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired(required = true)
    private UserRepository userRepo;

    @Override
    public UserEntity  validateUser(UserEntity user) {
      Optional<UserEntity> userDetail = userRepo.findByEmail(user.getEmail());
      return (userDetail.isPresent() && userDetail.get().getPassword().equals(user.getPassword())) ? userDetail.get() : null;
    }
    @Override
    public UserEntity registerUser(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).get();
    }

//
//    @Override
//    public List<UserEntity> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public Optional<UserEntity> getById(long id) {
//        return Optional.empty();
//    }
}
