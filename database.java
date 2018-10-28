package text_speech;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.sun.org.apache.xml.internal.resolver.readers.OASISXMLCatalogReader;



public class DatabaseMethod {

	public LoginSor login(String id, String pswd) {
		// TODO Auto-generated method stub
		return null;
	}

	public int loginF(String id, String pswd) {

		int n1=0;
        try{
        	System.out.println("nucliya");
        	System.out.println("id "+id+" pswd "+pswd);
            
        	Connection cnt= myConnection.getDefaultConnection();
            Statement stt= cnt.createStatement();
            String s1= "select * from user where id ='"+id+"' and password = '"+pswd+"'";
            ResultSet rr = stt.executeQuery(s1);
            if(rr.next())
               {
            	n1=56;
               }
    }
        catch(Exception e){
        	e.printStackTrace();
              }
        System.out.println("n1="+n1);
        return n1; 
	
		// TODO Auto-generated method stub
		
	}

	public int createAccount(String name, String id, String paswd) {
		// TODO Auto-generated method stub
		 int n1 =0;     
		 
		 try
			{
				Connection cnt= myConnection.getDefaultConnection();
				Statement stt1= cnt.createStatement();
				String s2="select * from user where ID='"+id+"' ";
				ResultSet rr= stt1.executeQuery(s2);
				if(rr.next())
				{
					n1= 5;
				}
		
				else	
		            {
		    	  String s1="insert into user (Name,ID,Password) values ('"+name+"','"+id+"','"+paswd+"')";
		    	  stt1.executeUpdate(s1);
		          n1=56;
		            }
				}
				catch(Exception e){
					e.printStackTrace();
				}
		 return n1;
		
	}

	public int txtFilePath(String location) {
		// TODO Auto-generated method stub
		int n1 =0;     
		 
		 try
			{
				Connection cnt= myConnection.getDefaultConnection();
				Statement stt1= cnt.createStatement();
				String s1="insert into path (location) values ('"+location+"')";
				System.out.println(s1);
				stt1.executeUpdate(s1);
				n1=56;
	        }
		catch(Exception e){
					e.printStackTrace();
				}
		return 0;
	}

	public ArrayList<SelectItem> CallList() {
		// TODO Auto-generated method stub
		int n1 =0;     
		 ArrayList<SelectItem> list1 = new ArrayList<>();
		 try
			{
				Connection cnt= myConnection.getDefaultConnection();
				Statement stt=cnt.createStatement();
				String s1= "select * from path";
				  
				Statement stt1= cnt.createStatement();
				ResultSet rr= stt.executeQuery(s1);
		          while(rr.next())
		          {
		        	  SelectItem obj = new SelectItem();
		        	  obj.setValue(rr.getString("location"));
		        	  obj.setLabel(rr.getString("location"));
		        	 
		        	  list1.add(obj); 
		          
		          }  
			  }
		catch(Exception e){
					e.printStackTrace();
				}
		return list1;
	}

}
 
