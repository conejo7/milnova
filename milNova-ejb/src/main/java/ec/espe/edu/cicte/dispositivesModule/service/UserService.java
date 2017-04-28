/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.dispositivesModule.service;

import com.mongo.persistance.MongoPersistence;
import ec.espe.edu.cicte.dispositivesModule.dao.UserDAO;
import ec.espe.edu.cicte.dispositivesModule.model.User;
import java.util.List;

/**
 *
 * @author esteb
 */
public class UserService extends MongoPersistence {

    MongoPersistence mongo;

    UserDAO usuarioDAO;

    public UserService() {
        this.mongo = new MongoPersistence();
        this.usuarioDAO = new UserDAO(mongo.context());
    }

    public String Insert(User usuario) {
        return this.usuarioDAO.insert(usuario);
    }

    
    public void Delete(User usuario) {
        this.usuarioDAO.delete(usuario);
    }

    public List<User> ObtenerLista() {
        return this.usuarioDAO.getUsuarios();
    }

}
