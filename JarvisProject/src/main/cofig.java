package main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class cofig 
{
	public String[] name; //= new String[];
	public String[] path; //= new String[];  
	private FollowFocus cdM;
	private WriteExcel cdW;
	private Interface cdI;


  public void read(int jj) throws IOException, URISyntaxException  
  {	  
	  String inputFile="src/setting/setupsetting.xls";
	  File file = new File(inputFile); 
	  //File inputWorkbook = new File(getClass().getResource("/setting/setting.xls").toURI());
	  //File WritableWorkbook= new File(getClass().getResource("/setting/setting.xls").toURI());
    Workbook w;
    
    try 
    {
      w = Workbook.getWorkbook(file);
      Sheet sheet = w.getSheet(0);
      int j=0,l=sheet.getRows();
      name = new String[l];
      path = new String[l];
      
      	j=1;
        for (int i = 0; i < sheet.getRows(); i++) 
        {
          Cell cell = sheet.getCell(j, i);
          name[i]=cell.getContents();
          
        }
        
        j=3;
        for (int i = 0; i < sheet.getRows(); i++) 
        {
          Cell cell = sheet.getCell(j, i);
          path[i]=cell.getContents();
        }
        if(jj==0)
        {
        cdM = new FollowFocus();
        cdM.nameandpath(name, path);
        }
        if(jj==1)
        {
        cdI = new Interface();
        cdI.nameandpath(name, path);
        }
               
        
    } catch (BiffException e) 
    {
      e.printStackTrace();
    }
  }
  
  
  
  public void Write(int i,int j, String content) throws IOException, URISyntaxException, RowsExceededException, WriteException, BiffException  
  {

	  //i = 5;j=0;content="sssss";
      cdW = new WriteExcel();
      cdW.main(i, j, content);
      //cdW.write(i, j, content);
      

  }
  
  

  
  

  public static void main(String[] args) throws IOException, URISyntaxException, RowsExceededException, WriteException, BiffException 
  {
		//cofig test = new cofig();
		//test.Write(5, 0, "sssss");

  }



public void main(int i,int j) throws IOException, URISyntaxException 
{
	if(i==0&&j==0)
	{
	cofig test = new cofig();
	test.read(j);
	}
	if(i==0&&j==1)
	{
	cofig test = new cofig();
	test.read(j);
	}
	
}



public void main(int i, int j, String string) throws RowsExceededException, WriteException, BiffException, IOException, URISyntaxException 
{
	cofig test = new cofig();
	test.Write(i,j,string);
	
}

}