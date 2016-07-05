
package ar.com.rizoma.tiposcompcliente.mb;

import ar.com.rizoma.tiposcompcliente.wsExt.Persona;
import ar.com.rizoma.tiposcompcliente.wsExt.TiposComplejosWs;
import ar.com.rizoma.tiposcompcliente.wsExt.TiposComplejosWs_Service;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Administrador
 */
public class MbPersonaCliente implements Serializable{

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TiposComplejosWs/TiposComplejosWs.wsdl")
    private TiposComplejosWs_Service service;

    private Persona persona;

    public MbPersonaCliente() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @PostConstruct
    public void init(){
        persona = new Persona();
    }
    
    public void createPersona(){
        Persona per = persona;

        try {
            TiposComplejosWs port = service.getTiposComplejosWsPort();
            port.insertarPersona(persona);
        } catch (Exception ex) {
            System.out.println("Hubo un error ejecutando el método remoto desde el cliente: " + ex.getMessage());
        }

        //Persona per = persona;
    }
    
}
