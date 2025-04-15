package com.springboottutorial.starterproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.websocket.server.PathParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DBController {

	PreparedStatement ps;
	Connection con;
	String sql;

	@GetMapping("/dist")
	@CrossOrigin
	public String saylistDistrict() throws SQLException
	{
		 PreparedStatement ps;
		ResultSet myRs;
		JSONArray districtlist = new JSONArray();
		try {
			// Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres?allowPublicKeyRetrieval=true",
				"postgres", "pass");
			sql = "SELECT distcode, name FROM district";
			ps = con.prepareStatement(sql);
			myRs = ps.executeQuery();
			System.out.println(myRs.toString());

			while (myRs.next()) {
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("districtcode",
							myRs.getString("distcode")
								.toString()
								.trim());
				jsonobj.put("districtname",
							myRs.getString("name")
								.toString()
								.trim());
				districtlist.add(jsonobj);
			}
			System.out.println("districtlist"
							+ districtlist.size());
			close(con, ps, myRs);
		}
		catch (Exception e) {
			System.out.println("getservice Exception==>"
							+ e);
		}

		return (districtlist.toString());
	}

	@RequestMapping(value = "/taluk",
					method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String ListTaluk(@RequestParam String Discode) throws ParseException
	{
		 String districtcode = Discode;
		JSONArray taluklist = new JSONArray();
		try {
			// Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres?allowPublicKeyRetrieval=true",
				"postgres", "pass");
			sql = " select * from taluk where distcode=?";
			ps = con.prepareStatement(sql);
			 ps.setString(1, districtcode);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				JSONObject jsontaluk = new JSONObject();
				jsontaluk.put("districtcode",
							res.getString("distcode")
								.toString()
								.trim());
				jsontaluk.put("talukcode",
							res.getString("talukcode")
								.toString()
								.trim());
				jsontaluk.put("talukname",
							res.getString("name")
								.toString()
								.trim());
				taluklist.add(jsontaluk);
			}
			System.out.println("taluklist"
							+ taluklist.size());
			close(con, ps, res);
		}
		catch (Exception e) {
			System.out.println(
				"getservice Edistid1xception==>" + e);
		}
		return (taluklist.toString());
	}

	@RequestMapping(value = "/village",
					method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public String
	Listvillage(@RequestParam String Discode,
				@RequestParam String Talukcode)
		throws ParseException
	{
		String districtcode = Discode;
		String talukcode = Talukcode;
		JSONArray villagelist = new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres?allowPublicKeyRetrieval=true",
				"postgres", "pass");
			sql = "select * from village where distcode=? and talukcode=?";
			ps = con.prepareStatement(sql);
			 ps.setString(1, districtcode);
			ps.setString(2, talukcode);
			ResultSet resl = ps.executeQuery();

			while (resl.next()) {
				JSONObject jsonvillage = new JSONObject();
				jsonvillage.put("districtcode",
								resl.getString("distcode")
									.toString()
									.trim());
				jsonvillage.put("talukcode",
								resl.getString("talukcode")
									.toString()
									.trim());
				jsonvillage.put(
					"villagecode",
					resl.getString("villagecode")
						.toString()
						.trim());
				jsonvillage.put("villagename",
								resl.getString("name")
									.toString()
									.trim());
				villagelist.add(jsonvillage);
			}
			System.out.println("villagelist"
							+ villagelist.size());
			close(con, ps, resl);
		}
		catch (Exception e) {
			System.out.println("getservice Exception==>"
							+ e);
		}
		return (villagelist.toString());
	}

	private static void close(Connection myConn,
							Statement myStmt,
							ResultSet myRs)
	{
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}

