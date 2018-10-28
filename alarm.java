package text_speech;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
@ManagedBean(name="FrameA")		
@ViewScoped
public class Frame3 implements Serializable{
	ArrayList<SelectItem> pathlist;
	int ihh;
	int imm;
	String am;
	String path12;
	public  Frame3() {
		 pathlist=new DatabaseMethod().CallList();
		 ihh=0;
		 imm=0;
	}
	public void ListvalueTest() {
		for (SelectItem selectItem : pathlist) {
			System.out.println(selectItem.getValue()+"\t"+selectItem.getLabel());
		}
	}
	
	public String alarm() {
		 System.out.println("absdhbsak");
		 String Txt_Input,speakString,fAdd;
 	     Date date = Calendar.getInstance().getTime(); 
 	     System.out.println(date);
         DateFormat dateFormat = new SimpleDateFormat("mm");  
         DateFormat hhf = new SimpleDateFormat("hh");
         DateFormat sec = new SimpleDateFormat("ss");
         String mm = dateFormat.format(date);
         String hh = hhf.format(date);
         String ss=sec.format(date);
                 	 
         String shh=String.valueOf(ihh).toString();
         String smm=String.valueOf(imm).toString();
         if(ihh<10)
        	 shh=("0"+(String.valueOf(ihh).toString()));
         if(imm<10)
        	 smm=("0".concat(String.valueOf(imm).toString()));
         
         while((!hh.equals(shh))||(!mm.equals(smm))){
         	date = Calendar.getInstance().getTime();
         	mm = dateFormat.format(date);
	        hh = hhf.format(date);
	        ss=sec.format(date);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("my hour"+shh);
	        System.out.println("my minute"+smm);
	        System.out.println("time minute: " + mm);
	        System.out.println("time hour"+hh);
	        System.out.println(ss);

         }
         String speakString1 = null;
         System.out.println("hurre");
         new Frame2().valueAssign(path12);
         return"";

	}
	
	public void str(int hh,int mm){
		ihh=hh;
		imm=mm;
		alarm();
	}

	public ArrayList<SelectItem> getPathlist() {
		return pathlist;
	}
	public void setPathlist(ArrayList<SelectItem> pathlist) {
		this.pathlist = pathlist;
	}
	public int getIhh() {
		return ihh;
	}
	public void setIhh(int ihh) {
		this.ihh = ihh;
	}
	public int getImm() {
		return imm;
	}
	public void setImm(int imm) {
		this.imm = imm;
	}
	public String getPath12() {
		return path12;
	}
	public void setPath12(String path12) {
		this.path12 = path12;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
    
	
	
}
