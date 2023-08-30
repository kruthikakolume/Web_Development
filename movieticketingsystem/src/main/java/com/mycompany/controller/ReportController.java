package com.mycompany.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mycompany.view.ShowXlsView;
import com.mycompany.view.TicketPdfView;

@Controller
@ResponseBody
public class ReportController extends AbstractController {
	
	public ReportController() {
		
	}

	@GetMapping("/user/bookShow/ticket.pdf")
	protected ModelAndView handleRequestPDF(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		View view = new TicketPdfView();
		return new ModelAndView(view);
	}
	
	@GetMapping("/admin/show/report.xls")
	protected ModelAndView handleRequestEXCEL(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		View view = new ShowXlsView();
		return new ModelAndView(view);
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}