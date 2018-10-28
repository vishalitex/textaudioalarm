# textaudioalarm
First convert text to audio file then set alarm and run that audio file
package text_speech;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

@ManagedBean(name="Frame2")
//@Component("alwar")
@ViewScoped

public class Frame2 implements Serializable {
	String text;
	ArrayList<SelectItem> pathlist;
	String path12;
	VoiceManager vm;
    Voice v; 
    public Frame2(){
    	System.out.println("let her go");
    	pathlist=new DatabaseMethod().CallList();
    	for (SelectItem selectItem : pathlist) {
			System.out.println(selectItem.getValue()+"\t"+selectItem.getLabel());
		}
    }
	public void assignValue(String text) {
		this.path12=text;
		//speak();
		readData();
	}
	public String location(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
  		LocalDateTime now = LocalDateTime.now();  
  		String str=dtf.format(now)+".txt";
  		str=str.replaceAll(":","");
  		str=str.replaceAll("/","");
  		String fileName = str.replaceAll("\\s+","");
  		return fileName;
        
	}
	public void speak() {
		 System.setProperty("mbrola.base","C:/Users/vishal sharma/workspace/text_speech/mbrola");
	     vm = VoiceManager.getInstance();
	     v =vm.getVoice("mbrola_us1");
	     v.allocate();
	     v.speak(text);
	}
	public void speak(String str) {
		 System.setProperty("mbrola.base","C:/Users/vishal sharma/workspace/text_speech/mbrola");
	     vm = VoiceManager.getInstance();
	     v =vm.getVoice("mbrola_us1");
	     v.allocate();
	     v.speak(str);
	}
	public String test() {
        FileWriter fileWriter;
			try{
				  fileWriter = new FileWriter("C:/Users/vishal sharma/workspace/text_speech/"+location());
	              // Always wrap FileWriter in BufferedWriter.
	              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	              // Note that write() does not automatically
	              // append a newline character.
	              bufferedWriter.write(text);
	              // Always close files.
	              
	              bufferedWriter.close();
	              int n1=new DatabaseMethod().txtFilePath(location());
	              if(n1==56){
	            	  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File successfully saved"));
	            	  pathlist=new DatabaseMethod().CallList();
	            	  return "audio.xhtml?faces-redirect=true";
	              }
	              else {
	            	  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File not saved"));
		        }
	              return "Frame2.xhtml?faces-redirect=true";
			 } 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
	}
	
	public String readData(){
		String str1="";
		
		String line=null;
		System.out.println(path12+" sdbjsahdjbh");
		 System.out.println(str1+" phly nasha");
		 try {
	         // FileReader reads text files in the default encoding.
	         FileReader fileReader = 
	             new FileReader("C:/Users/vishal sharma/workspace/text_speech/"+path12);
	         System.out.println(str1+" phly wala    "+path12);
	         // Always wrap FileReader in BufferedReader.
	         BufferedReader bufferedReader = 
	             new BufferedReader(fileReader);
	         while((line = bufferedReader.readLine()) != null) {
	             //System.out.println(line);
	             str1=str1.concat(" ").concat(line);
	             
	         }   
	         
	         System.out.println(str1+"");
	         // Always close files.
	    
	     }
	     
	     catch(IOException ex) {
	         System.out.println(
	             "Error reading file '" 
	             + path12 + "'");                  
	           
	          ex.printStackTrace();
	     }

		
		System.out.println(path12);
		speak(str1);
		return str1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame2().assignValue("20181024151214.txt");
	//	new Frame2().speak("vishal sharma");
	//	new Frame2().test();

	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<SelectItem> getPathlist() {
		return pathlist;
	}
	public void setPathlist(ArrayList<SelectItem> pathlist) {
		this.pathlist = pathlist;
	}
	public VoiceManager getVm() {
		return vm;
	}
	public void setVm(VoiceManager vm) {
		this.vm = vm;
	}
	public Voice getV() {
		return v;
	}
	public void setV(Voice v) {
		this.v = v;
	}
	public String getPath12() {
		return path12;
	}
	public void setPath12(String path12) {
		this.path12 = path12;
	}
	
	
	
}  
