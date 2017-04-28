/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.webUtils;

/**
 *
 * @author Andilin
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView3 {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 3; i <= 4; i++) {
            images.add("g" + i + ".JPG");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
