package ogb.customer.entite;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import ogb.selfsimswap.webservice.SelfSimSwapEntite;
import ogb.selfsimswap.webservice.Selfsimswapws;
import ogb.selfsimswap.webservice.Selfsimswapws_Service;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author OGB/DSI
 */

@ManagedBean
@SessionScoped
public class customerBean implements Serializable{
    
    private SelfSimSwapEntite selfsimswap = new SelfSimSwapEntite();
    private String msisdn;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public SelfSimSwapEntite getSelfsimswap() {
        return selfsimswap;
    }

    public void setSelfsimswap(SelfSimSwapEntite selfsimswap) {
        this.selfsimswap = selfsimswap;
    }
    
    public void showCustomer() {
       //selfsimswap = new SelfSimSwapEntite();
         selfsimswap = getCustomerWS(msisdn);
    }
    
    private SelfSimSwapEntite getCustomerWS(String numTel){
            Selfsimswapws_Service  service = new Selfsimswapws_Service();
            Selfsimswapws port = service.getSelfsimswapwsPort();
            return port.getCustomer(numTel);
    }
    
    
    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
