package com.mycompany.view;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Table;
import com.lowagie.text.Cell;
import com.mycompany.dao.BookingDAO;
import com.mycompany.pojo.Booking;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TicketPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookingDAO bookingDAO = new BookingDAO();

		List<Booking> list = bookingDAO.list();
		

		Table table = new Table(6);
		table.setBorderWidth(1);
		table.setPadding(5);
		table.setSpacing(5);
		Cell cell1 = new Cell("MOVIE");
		cell1.setHeader(true);
		cell1.setColspan(1);
		table.addCell(cell1);
		Cell cell2 = new Cell("SCREEN");
		cell2.setHeader(true);
		cell2.setColspan(1);
		table.addCell(cell2);
		Cell cell3 = new Cell("TIME");
		cell3.setHeader(true);
		cell3.setColspan(1);
		table.addCell(cell3);
		Cell cell4 = new Cell("SEATS");
		cell4.setHeader(true);
		cell4.setColspan(1);
		table.addCell(cell4);
		Cell cell5 = new Cell("TYPE");
		cell5.setHeader(true);
		cell5.setColspan(1);
		table.addCell(cell5);
		Cell cell6 = new Cell("CODE");
		cell6.setHeader(true);
		cell6.setColspan(1);
		table.addCell(cell6);
		table.endHeaders();

		for (Booking b : list) {
			table.addCell(b.getMovietitle());
			table.addCell(String.valueOf(b.getScreen()));
			table.addCell(b.getTime());
			table.addCell(String.valueOf(b.getNumberOfPpl()));
			table.addCell(b.getSeatType());
			table.addCell(String.valueOf(Math.round(Math.random()*100000)));
		}

		document.add(table);
		
		document.close();
	}

}