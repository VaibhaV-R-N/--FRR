import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQLConnector{

    String url;
    String user;
    String paswd;
    Connection con = null;

    public SQLConnector(String url,String user,String paswd) {
        this.url = url;
        this.user= user;
        this.paswd=paswd;
    }
    public SQLConnector(){
       
    }

    public String Connect() throws Exception{
        String result = "Failed";
        
        con = DriverManager.getConnection(url, user, paswd);

        if (con!=null)
        {
            result= "Success";

        }
        return result;

        }
    public String CreateTable(String TableName){
         String Status="Failed";
        try{
            String Query="CREATE TABLE "+TableName+"(ingredient varchar(20) unique, quantity int);";
            
            Statement stmt = con.createStatement();
            stmt.executeQuery(Query);
            Status="Successful";

        }
        catch(Exception e){

            Status="Failed";
         }

        return Status;

    }

    public String AddData(String Tablename,String[] ingredients,Float[] Quantity){
        String Status="Failed";
       try{
           
           Statement stmt = con.createStatement();


           for(int i=0,j=0;i<ingredients.length && j<Quantity.length;i++,j++){
               String query = "INSERT INTO "+Tablename+" values("+"'"+ingredients[i]+"',"+Quantity[j]+");";
               stmt.executeQuery(query);

               Status="Success";
           }

          }
       catch(Exception e){
           

           Status="Failed";
        }

       return Status;

   }

   public String AddData_D(String Tablename,String ingredient,Float Quantity){
    String Status="Failed";
   try{
       
       Statement stmt = con.createStatement();


       
           String query = "INSERT INTO "+Tablename+" values("+"'"+ingredient+"',"+Quantity+");";
           stmt.executeQuery(query);

           Status="Success";
       

      }
   catch(Exception e){
       

       Status="Failed";
    }

   return Status;

}

    public String AddFoodToDatabase(Food food) throws Exception{
        String[] ara=GetAllTables();
        String Status="Failed";
        Boolean status=false;

        for(String name : ara)
        {
            if(food.getName().equals(name)){
                status=true;
            }
        }
        if(!status) {
            CreateTable(food.getName());
        }
        if(food.getIngre()!=null && food.getQuan()!=null){
            AddData_D(food.getName(),food.getIngre(),food.getQuan());
        }       
        
        
        
        Status = "Success";
        return Status;
    }

    public  ArrayList<String> RstoAl_S(ResultSet resultset,String ColumnName) throws Exception
    {   ArrayList<String> Al = new ArrayList<>();
        while(resultset.next()){
            Al.add(resultset.getString(ColumnName));
        }
        return Al;
    }

    public  ArrayList<Float> RstoAl_I(ResultSet resultset,String ColumnName) throws Exception
    {   ArrayList<Float> Al = new ArrayList<>();
        while(resultset.next()){
            String temp=resultset.getString(ColumnName);
            Al.add(Float.valueOf(temp));
            
        }
        return Al;
    }

    public String[] GetAllFood_Ingredient(String TableName) throws Exception{

        ArrayList<String> MainList = new ArrayList<>();
        Statement stmt = con.createStatement();
        String Query1 = "SELECT * FROM "+TableName+";";
       
        ResultSet Rs1 = stmt.executeQuery(Query1);
        

        MainList=RstoAl_S(Rs1,"ingredient");

        String[] Mainarray= MainList.toArray(new String[0]);
        
        return Mainarray;


    }

    public Float[] GetAllFood_Quantity(String TableName) throws Exception{

        ArrayList<Float> MainList = new ArrayList<>();
        Statement stmt = con.createStatement();
       
        String Query2 = "SELECT * FROM "+TableName+";";
       
        ResultSet Rs2 = stmt.executeQuery(Query2);

        
        MainList=RstoAl_I(Rs2,"quantity");
        

       Float[]  Mainarray= MainList.toArray(new Float[0]);
        return Mainarray;


    }

    public String DeleteFood(String TableName){
        String Status="Failed";
        try{
            Statement stmt = con.createStatement();
            String Query = "DROP TABLE "+TableName+";";
            stmt.executeQuery(Query);

            Status= "Success";

        }catch(Exception e){
              e.printStackTrace();

        }
        return Status;
        
    }
    public void  DeleteFoodColumn(String tablename,String ingredient) throws Exception{

        Statement stmt = con.createStatement();
        String Query = "DELETE FROM "+tablename
                        +" WHERE ingredient = '"+ingredient+"'";
        stmt.executeQuery(Query);

    }



    public String[] GetAllTables() throws Exception{
        Statement stmt = con.createStatement();
        List<String> lis = new ArrayList<>();
        String sql = "SELECT table_name FROM information_schema.tables"
                     +" WHERE table_schema = 'food'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        lis.add(rs.getString("table_name"));

        }

        String[] ara = lis.toArray(new String[0]);
        return ara;
    }
    
    
}
