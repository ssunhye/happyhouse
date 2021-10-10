package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;


public interface QnARepo {
	List<QnA> qnaList();
	List<QnA> searchqnaList(String word);
	QnA qnaSelect(int num);

	int qnaCreate(QnA qna);

	int qnaModify(QnA qna);

	int qnaDelete(int num);
}
