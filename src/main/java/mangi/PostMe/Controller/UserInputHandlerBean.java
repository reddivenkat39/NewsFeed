package mangi.PostMe.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PostAndSearchService.class})
public class UserInputHandlerBean {

	private String search;
	
	private String post;
	public void setSearch(String search){
		this.search = search;	
	}	

	public String getSearch(){
		return search;
	}
	
	public void setPost(String post){
		this.post= post;
	}
	
	public String getPost(){
		return post;
	}
	
}
