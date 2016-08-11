package mangi.PostMe.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsFeed {

	HashMap<String,String> newsfeed = new HashMap<>();
	PostAndSearchService PandSBean = new PostAndSearchService();
	/*
	 * No need of Model Binding as I am doing a generic search on the DB
	 */
	@RequestMapping("/NewsFeed")
	public ModelAndView PostedPage(){
		newsfeed = PandSBean.getSearch("");
		Set<String> keys = newsfeed.keySet();
		List<String> outputlist = new ArrayList<>();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
		outputlist.add(newsfeed.get(it.next()));
		}
		ModelAndView model = new ModelAndView("NewsFeed");
		model.addObject("ouplist",outputlist);
		return model;
	}
}
