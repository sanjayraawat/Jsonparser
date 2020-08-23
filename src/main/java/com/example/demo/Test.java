package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contentstack.sdk.Error;

import com.contentstack.sdk.*;

@Controller
public class Test {

	@GetMapping(value="/getList")
	public String showTodos(ModelMap model){
		List<NewsModel> newLits= new Test().getNewsHeadlines();
		for (NewsModel newsModel : newLits) {
			System.out.println(newsModel.getTitle());
			
		}
		model.put("todos", newLits);
		return "welcome";
	}
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "abc");
		return "welcome";
	}
	private ArrayList<NewsModel> getNewsHeadlines() {

		try {
			ArrayList<NewsModel> newsHeadlines = new ArrayList<>();
			final Stack stack = Contentstack.stack("blt7979d15c28261b93", "cs17465ae5683299db9d259cb6", "production");
			ContentType contentType = stack.contentType("news");
			Query query = contentType.query();
			query.find(new QueryResultsCallBack() {
				@Override
				public void onCompletion(ResponseType responseType, QueryResult queryresult, Error error) {
					if (error == null) {
						List<Entry> result = queryresult.getResultObjects();
						for (Entry entry : result) {
							JSONObject response = entry.toJSON();
							newsHeadlines.add(new NewsModel(response.optString("title"), response.optString("body"), ""));
						}
					}
				}
			});
			return newsHeadlines;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		List<NewsModel> newLits= new Test().getNewsHeadlines();
		for (NewsModel newsModel : newLits) {
			System.out.println(newsModel.getTitle());
			System.out.println(newsModel.getDescription());
		}

	}
}

class NewsModel {

	private String title;
	private String description;
	private String image;

	
	public NewsModel(String title, String description, String image) {
		this.title = title;
		this.description = description;
		this.image = image;
	}

	@Override
	public String toString() {
		return "NewsModel{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", image='" + image + '\'' +
				'}';
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
