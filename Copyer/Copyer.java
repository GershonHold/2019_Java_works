/**本段程序实现将一个完整的文件夹及其里面的内容复制到目标路径
 * 
 */
package com.banyuan0921;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 
 * @version 2019年9月22日上午12:32:37
 * @author Gershon
 *
 * 
 */
public class Copy {

	/**
	 * @param args
	 */
	
	
	private String direct;
	private static String distin="E:/资料库/";
	private static String rootFile="F:/资料库/";
	private static File[] farr;
	
	public static void main(String[] args) {
		
		File file=new File(rootFile);
		showDirectory(rootFile,distin);

	}
	
	//先在目的目录下创建好需要复制的根目录
	//再逐一将底下的所有目录创建好
	//创建同名文件，再将文件内容写入
	public static void showDirectory(String rootFile,String distin) {
		
	    File dis=new File(distin);
	        if(!dis.exists())
	             dis.mkdir();
	       
	        File sour=new File(rootFile);
	       	String[] arr=sour.list();
	       	farr=sour.listFiles();
	       	int i=0;
	        for (String s : arr) {
	        	if(s.equals("")) {
	        		break;
	        	}
	        	i++;
	        	System.out.println((rootFile+s));
	            String str=s.toString();
	            
	        	File f=new File((rootFile+s));
	        	if(f.isDirectory()) {
	        		  
	            File dis1=new File((distin+str));
	           	System.out.println(distin+str);
	           	if(!dis1.exists()) {
	    	             dis1.mkdirs();
	           	}
	           	
	           	showDirectory((rootFile+"/"+s+"/"),(distin+"/"+s+"/"));
	           	
	            }else {
	            	
	            	try {
						File af=new File(rootFile+str);
						File bf=new File(distin+str);
						FileInputStream is = null;
						FileOutputStream os = null;
						
						 if(!bf.exists()){
							 bf.createNewFile();
						 }
						
						 is = new FileInputStream(af);
						 os = new FileOutputStream(bf);
						 byte b[] = new byte[1024];
						 int len;
						 len = is.read(b);
						    while (len != -1) {
						     os.write(b, 0, len);
						     len = is.read(b);
						    }
						
						    if(is != null) is.close();
						    if(os != null) os.close();
			
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
	        }
}
