package VO;

import java.util.Objects;

// 1. 값을 저장할 수 있는 프로퍼티 정의 + 캡슐화(private)
public class freeBaordVO {
	 private int boardNo;
	 private String boardTitle;
	 private String boardContent;
	 private int boardHits;
	 private String memId;

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
		freeBaordVO other = (freeBaordVO) obj;
		return boardNo == other.boardNo;
	}

// 4. 상태를 확인할 수 있는 메소드 정의
	@Override
	public String toString() {
		return "freeBaordVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardHits=" + boardHits + ", memId=" + memId + "]";
	}
	
	
	
	 
	 
}
