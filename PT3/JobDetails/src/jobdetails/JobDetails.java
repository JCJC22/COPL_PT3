package jobdetails;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

public class JobDetails {

	public static void main(String[] args) throws SQLException { 
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:SYSTEM/root@//localhost:1521/xepdb1"); 
		Connection conn = ods.getConnection();
	
		Statement stmt=conn.createStatement();
		Statement stmt1=conn.createStatement();
		Statement stmt2=conn.createStatement();
		
		// Execute a statement - DO THIS WITH AT LEAST 3 TABLES - provide screenshot
		ResultSet rset= stmt.executeQuery("Select job_id , job_title, min_salary, max_salary from jobs");
		ResultSet rset1= stmt1.executeQuery("Select department_id , department_name, manager_id, location_id from departments");
		ResultSet rset2= stmt2.executeQuery("Select country_id , country_name, region_id from countries");
		
		
		// Iterate through the result and print the employee names and ID 
		System.out.println("Job ID" + "\t\t" +"JOB Title"+"\t\t\t"+"Min Salary"+"\t\t\t"+ "Max Salary"); 
		System.out.println();
		while (rset.next())
		System.out.println(rset.getString(1) + "\t\t" +rset.getString(2) + "\t\t\t"+rset.getString(3) + "\t\t\t"+rset.getString(4));
		//endwhile

		System.out.println();
		// Iterate through the result and print 
				System.out.println("Department ID" + "\t\t" +"Department Name"+"\t\t\t"+"Manager Id"+"\t\t\t"+ "Location Id"); 
				System.out.println();
				while (rset1.next())
				System.out.println(rset1.getString(1) + "\t\t" +rset1.getString(2) + "\t\t\t\t"+rset1.getString(3) + "\t\t\t\t"+rset1.getString(4));
				//endwhile
		System.out.println();	
		// Iterate through the result and print 
				System.out.println("Country ID" + "\t\t" +"Country Name"+"\t\t\t\t"+"Region Id"); 
				System.out.println();
				while (rset2.next())
				System.out.println(rset2.getString(1) + "\t\t\t" +rset2.getString(2) + "\t\t\t\t"+rset2.getString(3));
				//endwhile		
				
				
				rset.close();
				stmt.close();
				rset1.close();
				stmt1.close();
				rset2.close();
				stmt2.close();
//close the resources 
}//end method main
}//end class JobDetails