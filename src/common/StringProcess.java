package common;

import model.bean.dichvu;
import model.bo.DichVuBO;

/**
 * StringProcess.java
 * 
 * Date: Aug 13, 2018
 * 
 * DATE AUTHOR DESCRIPTION ------------------------------------------------- Aug
 * 13, 2018 DanTT Create
 */
public class StringProcess {
	
	public static String tendichvu(String s) {
	DichVuBO dvbo= new  DichVuBO();
	dichvu a =	dvbo.laydichvuTheoSoDienThoai(s);
		return a.getTendichvu();
	}
}
