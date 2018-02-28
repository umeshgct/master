package com.cts.search.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.search.model.SearchRequest;
import com.cts.search.model.SearchResponse;
import com.cts.search.service.FileContentSearchService;

@RestController
public class SearchControllerImpl implements SearchController {


	@Autowired
	private FileContentSearchService searchService;

	/**
	 * To get list of files using given search request input
	 */
	@Override
	public @ResponseBody List<SearchResponse> getFiles(  @RequestBody SearchRequest searchRequest) throws IOException {

		return searchService.getFilesBySearchType(searchRequest);
	}
}
