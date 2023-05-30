package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.Instructions;
import db.Provider;

public class InstructionsDao{

	public static boolean insertInstruction(Instructions ist){
		boolean status = false;
		
		try{
			Connection con = Provider.getOracleConnection();
			String sql = "insert into instructiontable values(?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,ist.getInstruction());
	
			int val = pst.executeUpdate();
			
			if(val > 0){
				status = true;
			}else{
				status = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static ArrayList<Instructions> getAllRecords(){
        ArrayList<Instructions>  samp =new ArrayList<Instructions>();
        
		try{
		   samp.clear();
		   Connection con = Provider.getOracleConnection();
		   String sql = "select * from instructiontable";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   
		   while(rs.next()){
			  Instructions i = new Instructions();
			   i.setInstruction(rs.getString(1));
			   samp.add(i);
		   }
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
		return samp;
	}
}