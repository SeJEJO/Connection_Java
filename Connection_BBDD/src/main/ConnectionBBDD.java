package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author SeJEJO
 * @version 1.0
 * @since JDK1.8.0_25
 * @see <a href="https://github.com/SeJEJO"> SeJEJO - GitHub </a>
 * 
 * ESP -- Descripción de la clase:
 * Proyecto para la conexion JDBC a distintos sistemas gestores de base de datos
 * 
 * ING -- Description of class:
 * Project for the JDBC connection to different management systems database
 * 
 */

public class ConnectionBBDD {
	
	/**
	 * ESP -- Descripción de variables:
	 * host:	Ip o DNS donde esta el servicio del SGDB. por defecto localhost
	 * port:	Puerto del servicio SGDB
	 * user:	Usuario para acceso a la base de datos
	 * pass:	Contraseña de acceso a la base de datos
	 * nameDB:	Nombre de la base de datos a acceder
	 * con:		Es el elemento de conexion de Java con el SGDB
	 * 
	 * ENG -- Description of variables:
	 * host:	Ip or DNS where are the service of SGDB. By default localhost
	 * port:	Port of SGDB service
	 * user:	User for access to database
	 * pass:	Password for access to database
	 * nameDB:	Name of database to access
	 * con:		It is the element of connection to Java with the SGDB
	 * 
	 */
	String host="localhost", port="", user="", pass="",nameDB="";
	Connection con;
	
	/**
	 * ESP -- Descripción de ConnectionBBDD:
	 * Establece todo los parametros para la conexion
	 * @see setHost(host_user)
	 * @see setPort(port_user)
	 * @see setUser(user_user)
	 * @see setPass(pass_user)
	 * @see setNameDB(namedb_user)
	 * 
	 * ENG -- Description of ConnectionBBDD:
	 * Set all parameters to connection
	 * @see setHost(host_user)
	 * @see setPort(port_user)
	 * @see setUser(user_user)
	 * @see setPass(pass_user)
	 * @see setNameDB(namedb_user)
	 *  
	 */
	public ConnectionBBDD(String host_user, String port_user, String user_user, String pass_user,String namedb_user){
		setHost(host_user);setPort(port_user);
		setUser(user_user);setPass(pass_user);
		setNameDB(namedb_user);
	}
	
	/**** DRIVER ****/
	/**
	 * ESP -- Descripcion de driverOracle():
	 * Devuelve un creador de sentencias para un driver de oracle
	 * @return Un creador de sentencias
	 * @throws ClassNotFoundException 	- Lanza errores relacionados con el driver JDBC o la base de datos no este arrancada
	 * @throws SQLException 			- Lanza errores relacionados con errores SQL o problemas con login a la base de datos
	 * 
	 * ENG -- Description of driverOracle():
	 * Return a create statements for a driver of oracle
	 * @return A create statements
	 * @throws ClassNotFoundException  	- Throws related errors JDBC driver or database does not this torn off
	 * @throws SQLException 			- Throws related errors SQL errors or problems with login to the database
	 * 
	 */
	public Statement driverOracle() throws ClassNotFoundException, SQLException{
		if(port=="")
			port="1521";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":xe",user,pass);
		return con.createStatement();
	}

	/**
	 * ESP -- Descripcion de driverMySQL():
	 * Devuelve un creador de sentencias para un driver de MySQL
	 * @return Un creador de sentencias
	 * @throws ClassNotFoundException 	- Lanza errores relacionados con el driver JDBC o la base de datos no este arrancada
	 * @throws SQLException 			- Lanza errores relacionados con errores SQL o problemas con login a la base de datos
	 * @throws NullPointerException 	- Lanza un error si no se ha definido un nombre de base de datos
	 * 
	 * ENG -- Description of driverMySQL():
	 * Return a create statements for a driver of MySQL
	 * @return A create statements
	 * @throws ClassNotFoundException  	- Throws related errors JDBC driver or database does not this torn off
	 * @throws SQLException 			- Throws related errors SQL errors or problems with login to the database
	 * @throws NullPointerException		- Throw a error if not set a name of database
	 * 
	 */
	public Statement driverMySQL() throws ClassNotFoundException, SQLException{
		if(port=="")
			port="3306";
		if(nameDB=="")
			throw new NullPointerException("NameDB no definido");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+nameDB,user,pass);
		return con.createStatement();
	}
	/**
	 * ESP -- Descripcion de driverMySQLite():
	 * Devuelve un creador de sentencias para un driver de MySQLite
	 * @return Un creador de sentencias
	 * @throws ClassNotFoundException 	- Lanza errores relacionados con el driver JDBC o la base de datos no este arrancada
	 * @throws SQLException 			- Lanza errores relacionados con errores SQL o problemas con login a la base de datos
	 * @throws NullPointerException 	- Lanza un error si no se ha definido un nombre de base de datos
	 * 
	 * ENG -- Description of driverMySQLite():
	 * Return a create statements for a driver of MySQL
	 * @return A create statements
	 * @throws ClassNotFoundException  	- Throws related errors JDBC driver or database does not this torn off
	 * @throws SQLException 			- Throws related errors SQL errors or problems with login to the database
	 * @throws NullPointerException		- Throw a error if not set a name of database
	 * 
	 */
	public Statement driverMySQLite() throws ClassNotFoundException,SQLException {
		if(nameDB=="")
			throw new NullPointerException("NameDB no definido");
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:"+nameDB);
		return con.createStatement();
	}
	
	/**** SETTER ****/
	/**
	 * ESP -- Descripcion de setHost(String host_user):
	 * Establece el valor de host_user a user
	 * @param host_user -- Es el usuario establecido por el usuario
	 * 
	 * ENG -- Description of setHost(String host_user):
	 * Set the value of host_user to user
	 * @param host_user -- It is the user set by user
	 * 
	 */
	public void setHost(String host_user){
		if(host_user!="")
			host = host_user;
	}
	/**
	 * ESP -- Descripcion de setPort(String port_user):
	 * Establece el valor de port_user a user
	 * @param port_user -- Es el puerto establecido por el usuario
	 * 
	 * ENG -- Description of setPort(String port_user):
	 * Set the value of port_user to user
	 * @param port_user -- It is the port set by user
	 * 
	 */
	public void setPort(String port_user){
		port = port_user;
	}
	/**
	 * ESP -- Descripcion de setUser(String user_user):
	 * Establece el valor de user_user a user
	 * @param user_user -- Es el usuario establecido por el usuario
	 * 
	 * ENG -- Description of setUser(String user_user):
	 * Set the value of user_user to user
	 * @param user_user -- It is the user set by user
	 * 
	 */
	public void setUser(String user_user){
		user = user_user;
	}
	/**
	 * ESP -- Descripcion de setPass(String pass_user):
	 * Establece el valor de pass_user a pass
	 * @param pass_user -- Es la contraseña establecida por el usuario
	 * 
	 * ENG -- Description of setPass(String pass_user):
	 * Set the value of pass_user to pass
	 * @param pass_user -- It is the pass set by user
	 * 
	 */
	public void setPass(String pass_user){
		pass = pass_user;
	}
	/**
	 * ESP -- Descripcion de setNameDB(String namedb_user):
	 * Establece el valor de namedb_user a nameDB
	 * @param namedb_user -- Es el nombre de la base de datos del usuario
	 * 
	 * ENG -- Description of setNameDB(String namedb_user):
	 * Set the value of namedb_user to nameDB
	 * @param namedb_user -- It is the name of database set by user
	 * 
	 */
	public void setNameDB(String namedb_user){
		nameDB = namedb_user;
	}
	
	/**** GETTER ****/
	/**
	 * ESP -- Descripcion de getHost():
	 * Devuelve el parámetro host del objeto
	 * @return el parámetro del objeto
	 * 
	 * ENG -- Description of getHost():
	 * Return the parameter host of this object
	 * @return the parameter host of this object
	 * 
	 */
	public String getHost(){
		return host;
	}
	/**
	 * ESP -- Descripcion de getPort():
	 * Devuelve el parámetro port del objeto
	 * @return el parámetro del objeto
	 * 
	 * ENG -- Description of getPort():
	 * Return the parameter port of this object
	 * @return the parameter port of this object
	 * 
	 */
	public String getPort(){
		return port;
	}
	/**
	 * ESP -- Descripcion de getUser():
	 * Devuelve el parámetro user del objeto
	 * @return el parámetro del objeto
	 * 
	 * ENG -- Description of getUser():
	 * Return the parameter user of this object
	 * @return the parameter user of this object
	 * 
	 */
	public String getUser(){
		return user;
	}
	/**
	 * ESP -- Descripcion de getPass():
	 * Devuelve el parámetro pass del objeto
	 * @return el parámetro del objeto
	 * 
	 * ENG -- Description of getPass():
	 * Return the parameter pass of this object
	 * @return the parameter pass of this object
	 * 
	 */
	public String getPass(){
		return pass;
	}
	/**
	 * ESP -- Descripcion de getNameDB():
	 * Devuelve el parámetro nameDB del objeto
	 * @return el parámetro del objeto
	 * 
	 * ENG -- Description of getNameDB():
	 * Return the parameter nameDB of this object
	 * @return the parameter nameDB of this object
	 * 
	 */
	public String getNameDB(){
		return nameDB;
	}
}
