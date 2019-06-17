//////////////////////////////////////////////////////////////////////
// Housing Application Part B (CS331)
// By Andrew Frantsuzov
// Currently all the types are stored in one file, there are following
// sections in the document:
// Section A: Object model and interface to talk to UI layer (Cobi this section is WORTH reviewing)
// Section B. Design/Implementation for reading the object model from SQL (This is the internal implementation)
/////////////////////////////////////////////////////////////////////
package backend;

import javax.management.InvalidApplicationException;
import java.sql.*;
import java.util.ArrayList;

//////////////////////////////////////////////////////////////////////
// Following is the object model for the Housing Application Part B
/////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
// Section B. Following is the design/implementation for the Housing Application Part B
/////////////////////////////////////////////////////////////////////
public class SqlAdapter implements IDataAdapter
{
    public static String schemaName = "housing1";

    // delete app template
    public static String DeleteApplication = "DELETE FROM " + schemaName + ".Application where studentId=?;";

    // update suite template
    public static String UpdateSuite = "UPDATE " + schemaName + ".Suite SET noOfBeds = ?, status = ? where suite_id = ?;";


    // submit app template VALUES
    // (?,?,?,?,?,?,?,?);
    public static String SubmitApplicationQueryTemplate = "INSERT INTO " + schemaName + ".Application VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    // insert into resident table
    public static String InsertIntoResidentTemplate = "INSERT INTO " + schemaName + ".Resident" +
            "(id, " +
            "name, " +
            "sex, " +
            "moneyPaid, " +
            "isMarried, " +
            "phone_no, " +
            "address, " +
            "family_head, " +
            "suite_id, " +
            "movingDate) " +
            "VALUES" +
            "(?," + // id
            "?," + // name
            "?," + // sex
            "?," + //moneyPaid
            "?," + //isMarried
            "?," + //phoneNo
            "?," + //new Address
            "?," + //family_head
            "?," + //suite_id
            "?);"; //movingDate

    // Resident view
    // IN - id
    // OUT
    // id - INT
    // address - STRING
    // moveOutDate - DATETIME
    // moneyPaid - DOUBLE
    public static String ResidentViewTemplate = "SELECT id, movingDate, address, moneyPaid FROM " + schemaName + ".Resident where id=?;";

    // Applicant view
    // IN idNo - int
    // OUT
    // id - int
    // Application_referenceNo - int
    public static String ApplicantViewTemplate = "SELECT id_no,Application_referenceNo,name,sex,address,marital,phone,college,familyhead_ssn,dept,degree,yearsOfStudy,isAlumni,roomMateId,firstPref,secondPref,thirdPref,village,housing_type FROM " + schemaName + ".Application as A JOIN " + schemaName + ".Applicant as A1 ON A.studentId = A1.id_no where id_no=?;";

    // Admin view
    // IN ssn - string
    // OUT
    // ssn - string
    // name - STRING
    // job - DATETIME
    public static String AdminViewTemplate = "SELECT ssn, name, job FROM " + schemaName + ".Admin where ssn=? and password=?;";

    // Maintenance requests by date
    public static String MaintenanceRequestsTemplate = "SELECT completionDate,address,status,ticketId FROM " + schemaName + ".MaintenanceRequest where completionDate = ?;";

    // Availability - View
    // TODO: Join on all suites - (resident, suite) (?? What about moving date)
    public static String AvailabilityViewTemplate = "SELECT COUNT(*),housing_type,village FROM " + schemaName + ".Suite where status = 1 and housing_type = ? and village=?;";

    // Find Suite
    public static String SuiteTemplate = "SELECT suite_id,address,noOfBeds,status FROM " + schemaName + ".Suite where status = 1 and apartment_type = ? and housing_type = ? and village=? and noOfBeds>=?;";

    // Finds and assigns rooms to applicants who didnt get one yet
    public static String AssignRoom = "SELECT firstPref, secondPref, thirdPref " +
            "from Application as A, Suite as S " +
            "where ( A.firstPref = S.housing_type or " +
            "A.secondPref = S.housing_type or " +
            "A.thirdPref = S.housing_type) and " +
            "        A.village = S.village " +
            "and A.studentId = ? " +
            "ORDER BY referenceNo;";

    private Connection conn;

    public SqlAdapter() throws InvalidApplicationException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:sqlite:C:/sqllite/db";
            String user = "student";
            String pass = "password";
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException cnf)
        {
            throw new InvalidApplicationException("Fatal exception, could not intiialize SQL driver.");
        }
        catch (SQLException se)
        {
            throw new InvalidApplicationException("Connecting to SQL failed check that it is running");
        }
    	
    }

/*
    // Gets the application view
    public ApplicantView GetApplicationView(int applicantId) throws InvalidApplicationException {
        try {
            PreparedStatement p = conn.prepareStatement (ApplicantViewTemplate);
            p.clearParameters();
            p.setInt(1,applicantId);
            ResultSet r = p.executeQuery();
            while (r.next ()) {
                ApplicantView av = new ApplicantView();
                av.LoadFrom(r);
                return av;
            }
        }
        catch (SQLException se)
        {
        }

        throw new InvalidApplicationException("Application not found");
    }

    // get resident view
    public ResidentView GetResidentView(int residentId) throws InvalidApplicationException {
        try {
            PreparedStatement p = conn.prepareStatement (ResidentViewTemplate);
            p.clearParameters();
            p.setInt(1,residentId);
            ResultSet r = p.executeQuery();

            while (r.next ()) {
                ResidentView rv = new ResidentView();
                rv.LoadFrom(r);
                return rv;
            }
        }
        catch (SQLException se)
        {
        }

        throw new InvalidApplicationException("Resident not found");
    }

    // get admin view
    public AdminView GetAdminView(String  ssn, String password) throws InvalidApplicationException {

        try {
            PreparedStatement p = conn.prepareStatement(AdminViewTemplate);
            p.clearParameters();
            p.setString(1, ssn);
            p.setString(2, password);

            ResultSet r = p.executeQuery();

            while (r.next()) {
                AdminView av = new AdminView();
                av.LoadFrom(r);
                return av;
            }
        }
        catch (SQLException se)
        {
        }

        throw new InvalidApplicationException("Admin not found or password incorrect");
    }

    public LoginView SubmitApplication(Application app) throws InvalidApplicationException {
        try {
            PreparedStatement p = conn.prepareStatement(SubmitApplicationQueryTemplate);
            p.clearParameters();
            app.InsertInto(p);
            p.execute();
        }
        catch (SQLException se)
        {
        }

        // Initialize driver and execute query
        ApplicantView av = GetApplicationView(app.applicantId);

        if (!av.getIsAlumni()) {
            av.AllocateSuite(conn);
            return GetResidentView(app.applicantId);
        }

        return av;
    }

    public ResidentView ProcessApplication(int studentId) throws InvalidApplicationException
    {
        ApplicantView av = GetApplicationView(studentId);
        av.AllocateSuite(conn);
        return GetResidentView(av.getApplicantId());
    }

    public boolean CheckAvailability(Suite s) throws InvalidApplicationException {
        try {
            PreparedStatement p = conn.prepareStatement(AvailabilityViewTemplate);
            p.clearParameters();
            p.setString(1, s.getHousingType());
            p.setString(2, s.getVillage());
            ResultSet r = p.executeQuery();

            while (r.next()) {
                SuiteAvailabilityView av = new SuiteAvailabilityView();
                av.LoadFrom(r);

                if (av.getCount() > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        catch (SQLException se)
        {
            System.out.println(se);
        }

        throw new InvalidApplicationException("Availability of suite could not be determined");
    }

    public ArrayList<MaintenanceRequest> GetMaintenanceRequests(String  dueDate) throws InvalidApplicationException{
        try {
            PreparedStatement p = conn.prepareStatement(MaintenanceRequestsTemplate);
            p.clearParameters();
            p.setString(1, dueDate);

            ResultSet r = p.executeQuery();

            ArrayList<MaintenanceRequest> maintenanceRequestsList = new ArrayList<MaintenanceRequest>();
            while (r.next()) {
                MaintenanceRequest mr = new MaintenanceRequest ();
                mr.LoadFrom(r);
                maintenanceRequestsList.add(mr);
            }

            return maintenanceRequestsList;
        }
        catch (SQLException se)
        {
        }

        throw new InvalidApplicationException("Admin not found or password incorrect");
    }

    // retrieve the login info
    public LoginView Login(String id, String password, int loginType) throws InvalidApplicationException
    {
        switch (loginType)
        {
            case 1:
            {
                if (!password.equals("password"))
                {
                    throw new InvalidApplicationException("Password is invalid.");
                }

                // resident login
                return GetResidentView(Integer.parseInt(id));
            }
            case 2:
            {
                // applicant login, password is not checked
                return GetApplicationView(Integer.parseInt(id));
            }
            case 3:
            {
                // admin login
                return GetAdminView(id, password);
            }
        }

        throw new InvalidApplicationException("Invalid login option selected");
    }
    */
}
