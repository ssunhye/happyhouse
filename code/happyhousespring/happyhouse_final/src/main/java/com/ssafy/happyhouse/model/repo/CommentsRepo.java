package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.Comments;

public interface CommentsRepo {

	List<Comments> commentsSelect(int qna_num);

	int commentsCreate(Comments comments);

	int commentsModify(Comments comments);

	int commentsDelete(int num);
}
