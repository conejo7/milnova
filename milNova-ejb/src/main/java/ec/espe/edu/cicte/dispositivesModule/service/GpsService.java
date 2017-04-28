/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.dispositivesModule.service;

import com.mongo.persistance.MongoPersistence;
import ec.espe.edu.cicte.dispositivesModule.dao.GpsDAO;
import ec.espe.edu.cicte.dispositivesModule.model.Gps;
import java.util.List;

/**
 *
 * @author esteb
 */
public class GpsService extends MongoPersistence {

    MongoPersistence mongo;

    GpsDAO gpsDAO;

    public GpsService() {
        this.mongo = new MongoPersistence();
        this.gpsDAO = new GpsDAO(mongo.context());
    }

    public String Insert(Gps gps) {
        return this.gpsDAO.insert(gps);
    }

    /*public Boolean UpdateNombre(Gps gps) {
        return this.gpsDAO.updateNombreGps(gps);
    }

    public void Delete(Gps gps) {
        this.gpsDAO.deleteGps(gps);
    }*/

    public List<Gps> ObtenerLista() {
        return this.gpsDAO.getGpss();
    }

}
