package cinebro.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinebro.common.controller.SuperClass;



public class PayController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/filmwatch/payForm.jsp";
		super.GotoPage(gotopage);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		System.out.println("dopost");
		String gotopage = "/filmwatch/payConfirm.jsp";
		super.GotoPage(gotopage);
			
	}
}