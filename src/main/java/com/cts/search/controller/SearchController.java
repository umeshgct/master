package com.cts.search.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.search.model.SearchRequest;
import com.cts.search.model.SearchResponse;

@RequestMapping("/content")
public interface SearchController {	
		@RequestMapping(value = "/search", 
				produces = { "application/json" }, 
	            consumes = { "application/json" },method = RequestMethod.POST)
		public @ResponseBody List<SearchResponse> getFiles( @RequestBody SearchRequest searchRequest
				) throws IOException;
		
	}
