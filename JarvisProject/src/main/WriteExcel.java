package main;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class WriteExcel 
{
  private WritableCellFormat timesBoldUnderline;
  private WritableCellFormat times;
  private String inputFile;
  
public void setOutputFile(String inputFile) {
  this.inputFile = inputFile;
  }

  public void write(int i, int j, String content) throws IOException, WriteException, BiffException 
  {
    File file = new File(inputFile);
    WorkbookSettings wbSettings = new WorkbookSettings();
    wbSettings.setLocale(new Locale("en", "EN"));
    Workbook workbook = Workbook.getWorkbook(file);
    WritableWorkbook copy = Workbook.createWorkbook(new File("src/setting/setupsetting.xls"), workbook);
    WritableSheet excelSheet = copy.getSheet(0); 

    createLabel(excelSheet);
    createContent(excelSheet, i,  j,  content);
    copy.write(); 
    copy.close();
    workbook.close();
  }

  private void createLabel(WritableSheet sheet)
      throws WriteException {
    // Lets create a times font
    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
    // Define the cell format
    times = new WritableCellFormat(times10pt);
    // Lets automatically wrap the cells
    times.setWrap(true);

    // create create a bold font with unterlines
    WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
        UnderlineStyle.SINGLE);
    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
    // Lets automatically wrap the cells
    timesBoldUnderline.setWrap(true);

    CellView cv = new CellView();
    cv.setFormat(times);
    cv.setFormat(timesBoldUnderline);
    
  }

  private void createContent(WritableSheet sheet, int i2, int j2, String content2) throws WriteException,
      RowsExceededException 
  {

      addLabel(sheet, i2, j2, content2);
  }

  public void addLabel(WritableSheet sheet, int column, int row, String s)
      throws WriteException, RowsExceededException {
    Label label;
    label = new Label(column, row, s, times);
    sheet.addCell(label);
  }

  public static void main(String[] args) throws WriteException, IOException, BiffException {
    //WriteExcel test = new WriteExcel();
    //test.setOutputFile("src/setting/setupsetting.xls");
    //test.write(0,0,"haha");
  }

public void main(int i, int j, String content) throws WriteException, BiffException, IOException 
{
	WriteExcel test = new WriteExcel();
    test.setOutputFile("src/setting/setupsetting.xls");
    test.write(i,j,content);	
}
} 