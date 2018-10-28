package text_speech;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name="Loginbean")
//@Component("alwar")
@ViewScoped
public class Login1 implements Serializable {
	String name; String usid ; String paswd,idpaswd,cid;
	
	
	public String createAccount(){
		int n1=	new DatabaseMethod().createAccount( name, cid ,  idpaswd);
		if(n1==56){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account Created"));
			return "Frame1.xhtml?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User id exist"));
			return "Frame1.xhtml?faces-redirect=true";
		}	
	
	}
	
	public String login() {
		int n1=new DatabaseMethod().loginF(usid,paswd);
		if(n1==56){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("correct password"));
			return "audio.xhtml?faces-redirect=true";
		}	
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Insert correct user/password"));
			return "login.xhtml?faces-redirect=true";
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPaswd() {
		return paswd;
	}
	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}
	public String getIdpaswd() {
		return idpaswd;
	}
	public void setIdpaswd(String idpaswd) {
		this.idpaswd = idpaswd;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
	
}
        
