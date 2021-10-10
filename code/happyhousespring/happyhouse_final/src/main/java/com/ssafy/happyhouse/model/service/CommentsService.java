package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Comments;

public interface CommentsService {
	List<Comments> commentsSelect(int qna_num);

	boolean commentsCreate(Comments comments);

	boolean commentsModify(Comments comments);

	boolean commentsDelete(int num);
}
