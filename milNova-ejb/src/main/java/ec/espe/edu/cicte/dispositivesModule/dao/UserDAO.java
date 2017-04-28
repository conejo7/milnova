/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.dispositivesModule.dao;

import ec.espe.edu.cicte.dispositivesModule.model.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import java.util.List;
/**
 *
 * @author esteb
 */
public class UserDAO extends BasicDAO<User, ObjectId> 
{
    private Datastore ds;

    public UserDAO(Datastore ds) 
    {
        super(User.class, ds);
        this.ds = ds;
    }

 
    public String insert(User usuario) 
    {
        Key<User> key = this.save(usuario);
        return key.toString();
    }

    public List<User> getUsuarios() 
    {
        List<User> usuarios = this.find().asList();
        return usuarios;
    }

    /*public void deleteUsuario(User usuario) 
    {
        Query<Usuario> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(usuario.getContrasena())
        );
        this.deleteByQuery(query);
    }
    
    public Boolean updateNombreUsuario(User usuario) 
    {
        Query<Usuario> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(usuario.getContrasena())
        );
        UpdateOperations<Usuario> updateNombre = this.createUpdateOperations();
        updateNombre.set("nombre", usuario.getNombre()).set("estado",usuario.getEstado());
        UpdateResults results = this.update(query, updateNombre);
        return results.getUpdatedExisting();
    }*/

}
