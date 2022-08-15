package com.pcc.sso.userrepository;


import java.util.Date;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcc.sso.user.SsoUser;


@Repository
public interface SsoUserRepository extends JpaRepository<SsoUser, Date>{


    
}