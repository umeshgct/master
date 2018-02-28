package com.cts.search.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.search.model.SearchRequest;
import com.cts.search.model.SearchResponse;

/**
 * @author Umesh
 *
 */
@Service("searchService")
public class FileContentSerachServiceImpl implements FileContentSearchService {

	private static final Logger logger = LoggerFactory.getLogger(FileContentSerachServiceImpl.class);

	/**
	 * To search and get the files based on the given input keyword
	 */

	@Override
	public List<SearchResponse> getFilesBySearchType(SearchRequest searchRequest) throws IOException {

		List<SearchResponse> searchResponses = new ArrayList<>();

		return listFiles(searchRequest, searchResponses);
	}

	private List<SearchResponse> listFiles(SearchRequest searchRequest, List<SearchResponse> searchResponses)
			throws IOException {

		File directory = new File(searchRequest.getLocation());

		// get all the files from a directory
		File[] fList = directory.listFiles();

		if (null != fList) {
			for (File file : fList) {
				if (file.isFile()) {

					BufferedReader reader = new BufferedReader(new FileReader(file));

					String line;

					while ((line = reader.readLine()) != null) {

						SearchResponse response = new SearchResponse();

						for (String search : searchRequest.getListSearchKey()) {

							if (line.equals(search)) {
								response.setFile(file);
								int index = line.indexOf(search);
								searchResponses.add(response);
								logger.info("absolute Path :" + file.getAbsolutePath());
								logger.info("Got a match of " + search + " at line " + index);
							}
						}

					}
					reader.close();

				} else if (file.isDirectory()) {
					searchRequest.setLocation(file.getAbsolutePath());
					listFiles(searchRequest, searchResponses);
				}
			}
		}

		removeDuplicates(searchResponses);

		return searchResponses;

	}

	private void removeDuplicates(List<SearchResponse> searchResponses) {
		Set<SearchResponse> searchRespSet = new HashSet<>();
		searchRespSet.addAll(searchResponses);
		searchResponses.clear();
		searchResponses.addAll(searchRespSet);
	}

}