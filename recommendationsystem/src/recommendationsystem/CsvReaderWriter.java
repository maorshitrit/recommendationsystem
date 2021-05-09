package recommendationsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CsvReaderWriter {
 
   static Map<Integer,movie>  map = new Hashtable<Integer,movie>();
   Map<Integer,user> map1 = new Hashtable<Integer,user>();
   Map<Integer,Integer> mapidmovie = new Hashtable<Integer,Integer>();
  static user userr1 = new user(0, 0, 0, null, null, null);
 /*public static void writeCsv(String filePath) {
  List<user> users = new ArrayList<user>();
  
  //create demo Users
  user user = new user();
  user.setId(1);
  users.add(user);
  
  user = new user();
  user.setId(2);
  users.add(user);
  
  user = new user();
  user.setId(3);
 
  users.add(user);
  
  FileWriter fileWriter = null;
  try {
   fileWriter = new FileWriter(filePath);
   
   fileWriter.append("Id, First Name, Last Name\n");
   for(user u: users) {
    fileWriter.append(String.valueOf(u.getId()));
    fileWriter.append(",");
    fileWriter.append(",");
    fileWriter.append("\n");
   }
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   try {
    fileWriter.flush();
    fileWriter.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }
 
 
 public static int readCsv(String file) {

	  BufferedReader reader = null;
	  String line = "";
	  
	  try {
	   reader = new BufferedReader(new FileReader(file));
	   while((line = reader.readLine()) != null) {
	    
	    String[] row = line.split(",");

	    for(String index : row) {
	     System.out.printf("%-10s", index);
	    }
	    System.out.println();
	   }
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  finally {
	   try {
	    reader.close();
	   } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	  return 1;
 */
    public  void ReadFiletoHashmapUser(String userfile)
    {
    	//Map<Integer,Integer> mapofrates = new Hashtable<Integer,Integer>();
    	
    	
    	user u1= new user(0, 0, 0, null, null, null);
    	//System.out.println("hey1");
		BufferedReader reader = null;
		  String line = "";
		  int count =0;
		  try {
		   reader = new BufferedReader(new FileReader(userfile)); // פתיחת קובץ
		   line = reader.readLine(); // ביטול קריאת כותרת
		   while((line = reader.readLine()) != null) { // עובר על הקובץ
		    String[] row = line.split(",");// הפרדה בין הפסיקים
		    row[0] = row[0].replaceAll("^\"|\"$", "");
		    u1.setId(Integer.parseInt(row[0]));// הכנסת המזהה לעצם
		    u1.setMovieid(Integer.parseInt(row[1]));// הכנסת המזהה של הסרט לעצם
		    u1.setRating(Integer.parseInt(row[2]));// הכנסת הדירוג לעצם
	    	map1.put(count,new user(u1.getId(),u1.getMovieid(),u1.getRating(),u1.getGeners(),u1.getMap_of_rate(),u1.getMoviesisaw()));
		    // הכנסת האיברים לתוך המפה
	    	count++;  
		    
		 }
		   
	 }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
    }
    public boolean
    onlyDigits(String str, int n)
    {
        for (int i = 0; i < n; i++) {
  
            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
        
        
    }
    public String returnnewstring(String st)
    {
    	if(st.charAt(0) == '"' || st.charAt(0)==' ') // בודק האם התו הראשון הוא גרשיים או רוווח
    	{
    		st = st.substring(1);  // אם כן מחסר
    	}
    	if(st.charAt(st.length()-1)=='"' ||st.charAt(st.length()-1)== ' ')// בודק אם התו האחרון גרשיים או רווח
    		st = st.substring(0,st.length()-1); // אם כן מחסר
    	return st;
    }
    public boolean  checkifitisagener(String gener)
    {
    	gener = returnnewstring(gener);
    	List<String> l1 = Arrays.asList("Action","Short","N/A","Adventure","Comedy","Crime ","Fantasy","Drama",
    			"Horror","Romance","Satire","Thriller","Western","Sci-Fi","Music","Biography","Animation",
    			"Documentary","Mystery","War","Sport","History","Family","Film-Noi","Musical");
    	for(String s :l1)
    	{
    		if(s.equalsIgnoreCase(gener)) // בודק האם הז'אנר נמצא ברשימה
    			return true;
    	}
    	return false;
    }
 
	public  void ReadfiletoHashmapMovies(String moviesfiles)
	{
		int i =0;
		movie mv = new movie(0, moviesfiles, null, 0, moviesfiles, 0, moviesfiles, null); // בניית עצם
		BufferedReader reader = null;
		  String line = "";
		  int count =0;
		  try {
		   reader = new BufferedReader(new FileReader(moviesfiles)); // קריאת קובץ
		   line = reader.readLine(); // דילוג על השורה הראשונה
		   while((line = reader.readLine()) != null) {
		    
		    String[] row = line.split(","); // פיצול בפסיקים
		    row[i] = row[i].replaceAll("^\"|\"$", "");
		    mv.setId(Integer.parseInt(row[i])); // הכנסת מזהה לעצם
			//System.out.println(mv.getId());
		    mv.setName(returnnewstring(row[i+1])); // הכנסת שם לעצם
	    	//System.out.println(mv.getName());
		    while(!onlyDigits(row[i+2],row[i+2].length())) //בודק שהגענו לתא הבא
		    {
		    	i++;
		    }
		    	 mv.setYear(Integer.parseInt(row[i+2]));// הכנסת השנה
		    
		    ArrayList<String> listcountry = new ArrayList<String>();
		    while(!checkifitisagener(row[i+3])) { // מכניס את המדינות לעצם
				    	listcountry.add(returnnewstring(row[i+3]));
				    	i++;
				    } 
		    mv.setCountry(listcountry);
		    ArrayList<String> list = new ArrayList<String>();
		    while(checkifitisagener(row[i+3])) // מכניס ז'אנרים לעצם
		    {
		    	list.add(returnnewstring(row[i+3]));
		    	i++;
		    }
		    mv.setGeners(list);
		    map.put(count,new movie(mv.getId(),mv.getName(),mv.getGeners(),mv.getYear(),mv.getdirector(),mv.getMinutes(),mv.getPoster(),mv.getCountry()));
	    	// מכניס את כל הנתונים למפה
		    mapidmovie.put(mv.getId(), count); // מכניס את הנתונים למפה בה המפתח הוא המזהה והתוכן הוא המפתח של המפה הקודמת
		    count++;
		    i=0; 
		   
		 }
	 }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		
	}
	public static int Checkifthemovieexist(String file,String movie) {

		  BufferedReader reader = null;
		  String line = "";
		  
		  try {
		   reader = new BufferedReader(new FileReader(file)); // 
		   while((line = reader.readLine()) != null) { // 
		    
		    String[] row = line.split(",");  // 
		    row[1] = row[1].replaceAll("^\"|\"$", "");
		   if(row[1].equalsIgnoreCase(movie)) {  // 
		     return Integer.parseInt(row[0]);  // 
		   }
		 }
	   }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  return -1; //
	 }
 public static ArrayList<String> Checkifthemovieexist1(String file) {

	  BufferedReader reader = null;
	  String line = "";
	  ArrayList<String> movies = new ArrayList<String>();
	  
	  try {
	   reader = new BufferedReader(new FileReader(file)); // קורא את הקובץ
	   line = reader.readLine();
	   while((line = reader.readLine()) != null) { // בודק שהקובץ לא נגמר
	    
	    String[] row = line.split(",");  // מפצל למערך שמופרד בפיסיקים
	    row[1] = row[1].replaceAll("^\"|\"$", "");
	    movies.add(row[1]);
	 //  if(row[1].equalsIgnoreCase(movie)) {  // בודק האם השם של הסרט נמצא במאגר
	   //  return Integer.parseInt(row[0]);  // מחזיר את המזהה של הסרט
	  // }
	 }
	    return movies;

   }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  finally {
	   try {
	    reader.close();
	   } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	  return null; // לא מצא את הסרט
 }
 public void AddUser(ArrayList<String> geners,int id1,int id2,int id3,int id4, int id5) {
	// TODO Auto-generated method stub
	 userr1.setGeners(geners); // הוספת רשימת ז'אנרים לעצם
	 Map<Integer,Integer> mapofrates = new Hashtable<Integer,Integer>();
	 mapofrates.put(id1, 10);
	 mapofrates.put(id2, 10);
	 mapofrates.put(id3, 10);
	 mapofrates.put(id4, 10);
	 mapofrates.put(id5, 10); 
	 // הוספת המזהים של המשתמש והדירוג לתוך המפה של העצם
	 userr1.setMap_of_rate(mapofrates);
}
 /*
public static void print2D(int mat[][])
 {
     // Loop through all rows
     for (int[] row : mat)

         // converting each row as string
         // and then printing in a separate line
         System.out.println(Arrays.toString(row));
 }*/
 
 
 public  ArrayList<String> algorithem(String ratersfile, String moviesfiles,user u1)
 {
	 int countraters = Howmanyraters(ratersfile); // כמות המדרגים
	 int countmovies = Howmanymovies(moviesfiles);// כמות הסרטים
	 ArrayList<String> l = new ArrayList<String>(); 
	 int [][] dataset = new int [countmovies][countraters]; 
	 int t=0; // כמות הדירוגים
	 for(int i=0;i<countmovies;i++) { // i = movies ... j = user map1 = user , map = movie
		 for(int j=0;j<countraters;j++)
		 {
			int id = map1.get(t).getId();//מקבל את המזהה של המדרג הראשון
			
				while( t<9999 && map1.get(t).getMovieid() != map.get(i).getId() && id == map1.get(t).getId())
			 { // הלולאה עוצרת כאשר עברנו על כל המשתמשים או או שעברנו למשתמש אחר או שמצאנו סרט  שהמשתמש דירג
					t++;
			 }
				
			if(map1.get(t).getMovieid() ==map.get(i).getId())
			{
				dataset[i][j]=map1.get(t).getRating();// מכניס את הדירוג למטריצה
				t++;	
			}
	
		 } 
	 t=0;
	 }
	l = findsimilarusers(u1,dataset); // מחזיר את חמשת הסרטים להמלצה
	return l;
	 
 }
 /*private double [] intitalize(double [] arr)
 {
	 for(int i=0;i<arr.length;i++)
	 {
		 arr[i]=0;
	 }
	 return arr;
 }*/
 private ArrayList<String>  findsimilarusers(user u1,int dataset[][]) {
	// TODO Auto-generated method stub
	 double [] arraydegree = new double[dataset[0].length]; // מערך של הזוויות שנוצרו
	 int i=0; // משתנה בוליאני
	 double [] userarray = new double[2]; // מערך של שני דירוגים של המשתמש
	 int movierow=0,movie2row=0;
	 //System.out.println("test");
	 //arraydegree = intitalize(arraydegree);
	 double [] temp = new double[dataset[0].length]; // מערך מעבר
	 Iterator hmIterator = u1.getMap_of_rate().entrySet().iterator();
	 for(int j=0;j<temp.length;j++)
		 temp[j]=0;
	 //Map.Entry mapElement = (Map.Entry)hmIterator.next();
	  while (hmIterator.hasNext()) {
		  Map.Entry mapElement = (Map.Entry)hmIterator.next();
		  if(i==0)
		  {
	         movierow=(int)mapElement.getKey(); // קבלת מזהה ואת הדירוג של הסרטים שהמשתמש החדש בחר
	         userarray[0]= (int)mapElement.getValue();
	         //hmIterator.remove();
	         i++;
		  }
		  else
	         if(i==1)
	         {
	        	 movie2row=(int)mapElement.getKey(); // קבלת מזהה
		         userarray[1]= (int)mapElement.getValue();// דירוג שני
		         movierow = mapidmovie.get(movierow);// מציאת המספר שורה
		   	     movie2row = mapidmovie.get(movie2row);// מציאת המספר שורה

		   	     temp = findSimilarsUser( dataset,movierow,movie2row,userarray); // קבלת מערך עם הזוויות שנוצרו
		   	  for(int j=0;j<arraydegree.length;j++)
				 {
					 arraydegree[j]=arraydegree[j]+temp[j];
				 }
		   	     i=0;
	         }
	  }
	 
	 Arrays.sort(arraydegree); // מיון המערך
	 return findthemin(arraydegree,dataset); //מחזיר חמישה סרטים להמלצה

}
public  ArrayList<movie> tenmoviestoshow(ArrayList<String> geners)
{
	 ArrayList<movie> movietoshow = new ArrayList<movie>();
	 Random rand = new Random(); //instance of random class
	 int lastrandom=0;
	 int upperbound = map.size();
	 while(true)
	 {
	 //System.out.println(map.size());
       //generate random values
     int j=0;
     int int_random = rand.nextInt(upperbound);  // שימוש במספרים רנדומלים
     if(int_random>=upperbound-100) // אם מתקרבים לסוף מחסר את המספר ב 100
    	 int_random = int_random-100;
     for(int i=0;i<geners.size();i++)
     {
    	 if(geners.get(i).equalsIgnoreCase(map.get(int_random).getGeners().get(j)) && !movietoshow.contains(map.get(int_random).getName())) 
    	 { // בודק האם הז'אנרים שהשמתמש בחר נמצאים בסרט הנוכחי אם לא עובר לסרט הבא
    		 movietoshow.add(map.get(int_random));
    	 }
    	 if(movietoshow.size()==10)// אם הגענו לעשר סרטים מפסיק ומחזיר את הרשימה
    		 return movietoshow;
     }   
     j++;
	 }
}
public void addtomoviestohashmap(int [] rating, ArrayList<movie> movienames)
{
	Map<Integer,Integer> mapofrates = new Hashtable<Integer,Integer>();
	mapofrates =userr1.getMap_of_rate();
	for(int i=0;i<rating.length;i++)
	{
		mapofrates.put(movienames.get(i).getId(), rating[i]); // מוסיף את הנתונים למפה
	}
	 userr1.setMap_of_rate(mapofrates);// מעדכן את המפה של העצם
}
 
public ArrayList<String> listofreccomendmovies(double [] arrdegree ,int [] arrofusersid,int [][] dataset)
{
	ArrayList<String> list = new ArrayList<String>();
	int t=0;
	for(int i=0;i<dataset.length;i++)
	{
		if(dataset[i][arrofusersid[0]]>=8  || dataset[i][arrofusersid[1]]>=9 || dataset[i][arrofusersid[2]]>=9||dataset[i][arrofusersid[3]]>=9 || dataset[i][arrofusersid[4]]>=9 || dataset[i][arrofusersid[5]]>9)
		{  // בודק איזה סרטים המשתמש יאהב יותר על פי המשתמשים הדומים ביותר
			if(list.size()<5)
			{
			//System.out.println(map.get(i).getName());
			list.add(map.get(i).getName()); // חמישה סרטים מומלצים
			}
			else
				break;
		}
	}
	return list;
}
 
private ArrayList<String> findthemin(double[] arraydegree, int [][]dataset) {
	double [] arr = new double[10]; 
	int [] arrofusersid = new int [10];
	int count =0;
	for(int i=0;i<arraydegree.length;i++)
	{
		if(arraydegree[i]!=0) // בודק שקיים זווית
		{
		arr[count]=arraydegree[i];// 
		arrofusersid[count]=i;
		//System.out.println(arr[count]);
		count++;
		if(count==10) // כשמוצא עשר עם הזווית הקטנה ביותר מפסיק
		{
		 return listofreccomendmovies(arr,arrofusersid,dataset); // מחזיר את הסרטים המומלצים
		}
	}
	}
	return null;
}
/*public static int [] convertmaptoarray(Map<Integer,Integer> mapp,int movie1Id,int movie2Id)
 {
	 int []arr = new int[mapp.size()];
	 int i=0;
	 Iterator hmIterator = mapp.entrySet().iterator();
	    while (hmIterator.hasNext()) {
         Map.Entry mapElement = (Map.Entry)hmIterator.next();
         if((int) mapElement.getKey()==movie1Id)
         {
        	 arr[0]=(int) mapElement.getValue();
        	 i++;
        	 if(i==2)
        		 return arr;
         }
         if((int) mapElement.getKey()==movie2Id)
         {
        	 arr[1]=(int) mapElement.getValue();
        	 i++;
        	 if(i==2)
        		 return arr;
         }
         }
	 return null;
 }*/
public double findtheaveragerating(int dataset[][],int userrow) 
{
	double sum =0; // sum 
	int count =0;// count
	for(int i=0;i<dataset.length;i++)
	{
		if(dataset[i][userrow]!=0)
		{
			sum = dataset[i][userrow]; // אם קיים דירוג מכניס לסכום	
			count++;
		}
	}
	return sum/(double)count; // מחשב ממוצע
}
 
 public double [] findSimilarsUser(int dataset[][],int movierow,int movierow2, double []userarray)
 {    
      int firstrating,secondrating;
      double [] arraydegree = new double[dataset[0].length]; // מערך הזוויות
      double [] vecarray = new double[2]; // דירוג של שני הסרטים
      double [] solovecarray = new double[1]; // דירוג של סרט אחד
      double [] solouserarray = new double [1];// דירוג של סרט אחד מהמשתמש
      double averagerating;
      solouserarray[0]=userarray[0];
	  int rating;
	    for(int i=0;i<dataset[0].length;i++)
	    {
	    	if(dataset[movierow2][i]!=0 && dataset[movierow][i]==0)
	    	{
	    		averagerating= findtheaveragerating(dataset,i); // מציאת הדירוג הממוצע
	    		solovecarray[0]=dataset[movierow2][i]-averagerating;
	    		solouserarray[0]=userarray[1];
	    		arraydegree[i] =cosineSimilarity(solovecarray,solouserarray);// חישוב הזווית
	    		
	    	}
	    	else {
	    	if(dataset[movierow][i]!=0)
	    	{
	    		averagerating=findtheaveragerating(dataset,i);// מציאת הדירוג הממוצע
	    		firstrating =dataset[movierow][i];
	    		if(dataset[movierow2][i]!=0) // במידה והמשתמש דירג את שני הסרטים
	    		{
	    			vecarray[0]=firstrating-averagerating;
	    			vecarray[1]=dataset[movierow2][i]-averagerating;
	    		//	 System.out.println(map1.get(i).getId());
	    			arraydegree[i] =cosineSimilarity(vecarray,userarray);// מציאת הזווית
	    		 //	System.out.println(arraydegree[i]);

	    		}
	    		else
	    		{
	    			solovecarray[0]=firstrating-averagerating;
	    			arraydegree[i] =cosineSimilarity(solovecarray,solouserarray);
	    		}
	    	}
	    	}
 
	    }
   
	    return arraydegree; // מחזיר את מערך הזוויות
	  
 }


 public double cosineSimilarity(double[] vectorA, double[] vectorB) {
	 // הפונקציה פועלת רק עם הוקטורים באותו גודל
	    double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    for (int i = 0; i < vectorA.length; i++) {
	        dotProduct += vectorA[i] * vectorB[i];
	        normA += Math.pow(vectorA[i], 2);
	        normB += Math.pow(vectorB[i], 2);
	    }   
	    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB)); //חישוב הזווית
	}
	
private int Howmanymovies(String moviesfiles) {
	
	
	int count = 0;
	BufferedReader reader = null;
	  String line = "";
	  
	  try {
	   reader = new BufferedReader(new FileReader(moviesfiles));
	   line = reader.readLine();
	   while((line = reader.readLine()) != null) {
	    
	    String[] row = line.split(",");
	    row[0] = row[0].replaceAll("^\"|\"$", "");
	    count++;
	 }
 }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  finally {
	   try {
	    reader.close();
	   } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	return count;
}


private int Howmanyraters(String file) {
	
	// TODO Auto-generated method stub
	String count = null;
	BufferedReader reader = null;
	  String line = "";
	  
	  try {
	   reader = new BufferedReader(new FileReader(file));
	   while((line = reader.readLine()) != null) {
	    
	    String[] row = line.split(",");
	    row[0] = row[0].replaceAll("^\"|\"$", "");
	    count = row[0];
	 }
 }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  finally {
	   try {
	    reader.close();
	   } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	return Integer.parseInt(count);
	}
}

