package ec.espe.edu.cicte.dispositivesModuleBean;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class MegaMenuView 
{
     private String orientation = "horiontal";
 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
   
}
      