package com.cts.search.service;

import java.io.IOException;
import java.util.List;

import com.cts.search.model.SearchRequest;
import com.cts.search.model.SearchResponse;


public interface FileContentSearchService {		
	
	List<SearchResponse> getFilesBySearchType( SearchRequest searchRequest) throws IOException;

}