package utils;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 * @author Usuario
 */
public class JsfUtil {
    public static void setErrorMessage(String idClient, String msg) {
    FacesMessage mensaje = new
FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
 FacesContext.getCurrentInstance().addMessage(idClient,
mensaje);
 }
 /*Este método permite definir un mensaje de tipo flash (mensaje que
se elimina de forma automatica en cuanto una vista lo muestre)*/
 public static void setFlashMessage(String name, String msg) {
 FacesContext.getCurrentInstance().getExternalContext()
 .getFlash().put(name, msg);
 }
 public static HttpServletRequest getRequest(){
 return (HttpServletRequest) FacesContext.getCurrentInstance()
 .getExternalContext().getRequest();
 }
}

