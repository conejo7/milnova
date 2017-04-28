/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.cicte.dispositivesModuleBean;

import ec.espe.edu.cicte.dispositivesModule.model.User;
import ec.espe.edu.cicte.dispositivesModule.service.UserService;
import ec.espe.edu.cicte.webUtils.BaseBean;
import ec.espe.edu.cicte.webUtils.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.beanutils.BeanUtils;


/**
 *
 * @author esteb
 */
@Named
@ViewScoped
public class UserBean  extends BaseBean implements Serializable 
{
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());
    private List<User> usuarios;
    private User usuario;
    private User usuarioSelected;
    private UserService usuarioServicio=new UserService();
    
    @PostConstruct
    public void postConstructor()
    {
        this.usuarios=this.usuarioServicio.ObtenerLista();
    }
    public void agregar()
    {
        super.startAdd();
        this.usuario=new User();
        this.usuarios=this.usuarioServicio.ObtenerLista();
    }
    public void modificar()
    {
        super.setAdd(add); 
        this.usuario=new User();
       try {
            BeanUtils.copyProperties(this.usuario, this.usuarioSelected);
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Error al copiar las propiedades.");
            LOG.log(Level.SEVERE, "Error al copiar propiedades: ", e);
        }
    }
    public void eliminar()
    {
        this.usuarioServicio.Delete(this.usuarioSelected);
        this.usuarios = this.usuarioServicio.ObtenerLista();
    }
    public void guardar()
    {
        if(super.isAdd())
        {
            this.usuarioServicio.Insert(usuario);
            FacesUtil.addMessageInfo("Se ha creado el usuario: "+usuario.getNombre());
        }
        else
        {
           // this.usuarioServicio.UpdateNombre(usuario);
            FacesUtil.addMessageInfo("Se ha modificado el usuario: "+usuario.getNombre());
        }
        this.usuarios = this.usuarioServicio.ObtenerLista();
        super.reset();
        this.usuario = null;

    }
    public void cancelar()
    {
        super.reset();
        this.usuario=null;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }
    
    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public User getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(User usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }
   
}
