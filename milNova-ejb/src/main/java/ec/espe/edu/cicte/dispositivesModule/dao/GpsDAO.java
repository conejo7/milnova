/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.dispositivesModule.dao;
import ec.espe.edu.cicte.dispositivesModule.model.Gps;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import java.util.List;
/**
 *
 * @author esteb
 */
public class GpsDAO extends BasicDAO<Gps, ObjectId> 
{
    private Datastore ds;

    public GpsDAO(Datastore ds) 
    {
        super(Gps.class, ds);
        this.ds = ds;
    }

 
    public String insert(Gps gps) 
    {
        Key<Gps> key = this.save(gps);
        return key.toString();
    }

    public List<Gps> getGpss() 
    {
        List<Gps> gpss = this.find().asList();
        return gpss;
    }

    /*public void deleteGps(Gps gps) 
    {
        Query<Gps> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(gps.getContrasena())
        );
        this.deleteByQuery(query);
    }
    
    public Boolean updateNombreGps(Gps gps) 
    {
        Query<Gps> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(gps.getContrasena())
        );
        UpdateOperations<Gps> updateNombre = this.createUpdateOperations();
        updateNombre.set("nombre", gps.getNombre()).set("estado",gps.getEstado());
        UpdateResults results = this.update(query, updateNombre);
        return results.getUpdatedExisting();
    }*/

}
