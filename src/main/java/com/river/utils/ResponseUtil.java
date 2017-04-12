package com.river.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ResponseUtil {

	public static void write(HttpServletResponse response,Object o){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
