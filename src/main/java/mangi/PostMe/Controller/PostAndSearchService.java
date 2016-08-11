package mangi.PostMe.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mysql.jdbc.Connection;

@Configuration
@Import({DataSourceBean.class})
public class PostAndSearchService {

	// For Posting into the DB[Insert Operation]
	
	private DataSourceBean con = new DataSourceBean();
	private Connection mycon;
//	
//	private String searchId;
//	public void setSearch(String search){
//		this.searchId = search;
//	}
	
	public String hashcodegen(String P){
		return P.substring(2,4)+(P.length()*23)+P.substring(P.length()-2,P.length()-1);
	}
	public void insertPost(String Post){
		String id= hashcodegen(Post);
		try {
			mycon = (Connection) con.getConnection();
			PreparedStatement insert = mycon.prepareStatement("call insertpost(?,?)");
			insert.setString(1,id);
			insert.setString(2,Post);
			insert.execute();
			insert.close();
			mycon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap<String,String> getSearch(String ids)
	{
		System.out.println(ids);
		HashMap<String,String> searchPostResult = new HashMap<>();
		try {
			mycon =(Connection)con.getConnection();
			PreparedStatement search = mycon.prepareStatement("call searchPost(?)");
			search.setString(1,ids);
			ResultSet queryResult = search.executeQuery();
			while(queryResult.next()){
				String id = queryResult.getString("id");
				String Post = queryResult.getString("Post");
				searchPostResult.put(id, Post);
				System.out.println("Coming here");
			}
			search.close();
			mycon.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchPostResult;
		
	}
	
	@Bean
	public PostAndSearchService PandSBean()
	{
		return new PostAndSearchService();
	}
	
}
