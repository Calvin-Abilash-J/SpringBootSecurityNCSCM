package com.SecurityLoginNCSCM.Security.Login.SecurityRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SecurityLoginNCSCM.Security.Login.SecurityModel.SigninEntity;

@Repository
public interface SigninRepository extends JpaRepository<SigninEntity,Long>{

}
