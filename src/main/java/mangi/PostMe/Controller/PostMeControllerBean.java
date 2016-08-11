package mangi.PostMe.Controller;

import java.util.HashMap;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Import({PostAndSearchService.class})
public class PostMeControllerBean {

	
	private PostAndSearchService PandSBean =new PostAndSearchService();
@RequestMapping("/home")
public ModelAndView HomePage(){
	/*
	 * Binded a Model and View - Model is UserInputHandler and view is home
	 */
return new ModelAndView("home","command",new UserInputHandlerBean());
}

@RequestMapping("/searchLink")
public String SearchPage(@ModelAttribute("outputmodel")UserInputHandlerBean outputmodel,
		ModelMap mymodel){
	HashMap<String,String> result;
	System.out.println(outputmodel.getSearch());
	result = PandSBean.getSearch(outputmodel.getSearch());
	System.out.println(result.get("google"));
	mymodel.addAttribute("result1","Hello");
	mymodel.addAttribute("result2",result.get("google"));
	return "search";
}

}
