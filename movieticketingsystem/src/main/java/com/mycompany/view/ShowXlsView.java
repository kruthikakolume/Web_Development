package com.mycompany.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.mycompany.dao.ShowDAO;
import com.mycompany.pojo.Show;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowXlsView extends AbstractXlsView {
	
	public ShowXlsView() {
		
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ShowDAO showDAO = new ShowDAO();
		List<Show> list = showDAO.list();
		
		
		Sheet sheet = workbook.createSheet("new sheet");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("MOVIE");
		row.createCell(1).setCellValue("SCREEN");
		row.createCell(2).setCellValue("TIME");
		row.createCell(3).setCellValue("POSTED BY");
		
		for (Show s: list) {
			Row row1 = sheet.createRow(list.indexOf(s)+1);
			row1.createCell(0).setCellValue(s.getMovietitle());
			row1.createCell(1).setCellValue(s.getScreen());
			row1.createCell(2).setCellValue(s.getTime());
			row1.createCell(3).setCellValue(s.getPostedBy());
		}
		
	}
	
}