package mvcBoard;

public class BoardFactory {
	
	private BoardFactory() {
	}
	
	private static BoardFactory instance =
							new BoardFactory();
	public static BoardFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if(cmd.equals("/list_board.do")) {
			cmdIf = new ListBoardCommand();
		}else if(cmd.equals("/index_board.do")) {
			cmdIf = new IndexBoardCommand();
		}else if(cmd.equals("/writeForm_board.do")) {
			cmdIf = new WriteFormBoardCommand();
		}else if(cmd.equals("/writePro_board.do")) {
			cmdIf = new WriteProBoardCommand();
		}else if(cmd.equals("/content_board.do")) {
			cmdIf = new ContentBoardCommand();
		}else if(cmd.equals("/deleteForm_board.do")) {
			cmdIf = new DeleteFormBoardCommand();
		}else if(cmd.equals("/deletePro_board.do")) {
			cmdIf = new DeleteProBoardCommand();
		}else if(cmd.equals("/updateForm_board.do")) {
			cmdIf = new UpdateFormBoardCommand();
		}else if(cmd.equals("/updatePro_board.do")) {
			cmdIf = new UpdateProBoardCommand();
		}
		
		return cmdIf;
	}

}
