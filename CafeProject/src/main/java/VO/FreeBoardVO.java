package VO;

import java.util.Objects;

// 1. 값을 저장할 수 있는 프로퍼티 정의 + 캡슐화(private)
public class FreeBoardVO {
	 private int boardNo; // 글번호
	 private String boardTitle; // 제목
	 private String boardContent; // 게시글 내용
	 private String boardDate; // 작성일
	 private int boardHits; // 조회수
	 private String memId; // 회원ID

// 2. 캡슐화된 프로퍼티에 접근 가능한 인터페이스 메소드 정의
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardHits() {
		return boardHits;
	}

	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
// 3. 객체의 상태를 비교할수있는 메소드 정의 (DB 기본키)
	@Override
	public int hashCode() {
		return Objects.hash(boardNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreeBoardVO other = (FreeBoardVO) obj;
		return boardNo == other.boardNo;
	}

// 4. 상태를 확인할 수 있는 메소드 정의
	@Override
	public String toString() {
		return "FreeBoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardHits=" + boardHits + ", memId=" + memId + "]";
	}
}
