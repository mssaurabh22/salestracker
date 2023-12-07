package com.salesmanager.sales.service;


import com.salesmanager.sales.entity.UserEntity;

import java.util.Optional;

public interface UserService {

	UserEntity validateUser (UserEntity user);

	UserEntity registerUser (UserEntity user);
}
