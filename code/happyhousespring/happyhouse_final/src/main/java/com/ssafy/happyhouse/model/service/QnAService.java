package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	List<QnA> qnaList();
	List<QnA> searchqnaList(String word);
	QnA qnaSelect(int num);

	boolean qnaCreate(QnA qna);

	boolean qnaModify(QnA qna);

	boolean qnaDelete(int num);
}
