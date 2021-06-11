package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Julito
 */
public interface IUserService extends UserDetailsService {
    User create(User user);

}
