package main;

import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		ConnectionBBDD conectionOra = new ConnectionBBDD("","","","","");
		ConnectionBBDD conectionMySQL = new ConnectionBBDD("","","","","");
		ConnectionBBDD conectionMySQLite = new ConnectionBBDD("","","","","");
		try {
			Statement staOra = conectionOra.driverOracle();
			Statement staMyS = conectionMySQL.driverMySQL();
			Statement staSLi = conectionMySQLite.driverMySQLite();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
