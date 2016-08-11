package mangi.PostMe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchControllerBean {
PostAndSearchService PandSBean =new PostAndSearchService();
	@RequestMapping("/postLink")
	public String PostedPage(@ModelAttribute("input")UserInputHandlerBean input,
			ModelMap inpmodel){
		String post = input.getPost();
		PandSBean.insertPost(post);
		return "PostThreads";
	}
}
