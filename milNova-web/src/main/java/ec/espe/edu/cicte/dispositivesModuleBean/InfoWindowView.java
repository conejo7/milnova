package ec.espe.edu.cicte.dispositivesModuleBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;
 
@ManagedBean
@ViewScoped
public class InfoWindowView implements Serializable {
     
    private MapModel advancedModel;
    private String temperature;
    private String hearRate;
    private String pressure;
    private Marker marker;
 
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
         
        //Shared coordinates
        LatLng coord1 = new LatLng(3.601142,-72.729492);
        LatLng coord2 = new LatLng(6.3152997,-65.236816);
        LatLng coord3 = new LatLng(-7.623887,-56.57959);
        LatLng coord4 = new LatLng(-33.100745 ,-63.259277);
         
        
        temperature="Temperatura: 10 C";
        hearRate="Ritmo Cardiaco: 10";
        pressure="Presion: 30";
        
        //Icons and Data
        advancedModel.addOverlay(new Marker(coord1, "TNTE HIDALGO", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        advancedModel.addOverlay(new Marker(coord2, "TNTE HIDALGO", "ataturkparki.png"));
        advancedModel.addOverlay(new Marker(coord4, "TNTE HIDALGO", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        advancedModel.addOverlay(new Marker(coord3, "TNTE HIDALGO", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
        
        //Polyline
        Polyline polyline = new Polyline();
        polyline.getPaths().add(coord1);
        polyline.getPaths().add(coord2);
        polyline.getPaths().add(coord3);
        polyline.getPaths().add(coord4);
          
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);
          
        advancedModel.addOverlay(polyline);
    }
 
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
     
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
     
    public Marker getMarker() {
        return marker;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHearRate() {
        return hearRate;
    }

    public void setHearRate(String hearRate) {
        this.hearRate = hearRate;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
    
}
      