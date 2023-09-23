package pl.umcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.dao.AuthorityDAO;
import pl.umcs.entity.Authority;

import javax.transaction.Transactional;

@Service
public class AuthorityService {
    @Autowired
    public AuthorityDAO authorityDAO;

    @Transactional
    public void saveAuthority(Authority authority){

        authorityDAO.saveAuthority(authority);
    }
}
