<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글작성</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="./SE/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<%-- <script src="<%=request.getContextPath() %>/board/script.js"></script> --%>
	<script>
		$(() => { 
			nhn.husky.EZCreator.createInIFrame({ 
				oAppRef: editor, elPlaceHolder: 'board_content', 
				sSkinURI: '/SE/SmartEditor2Skin.html', 
				fCreator: 'createSEditor2' }); }); 
	</script>

</head>
<body>
	<form  action="<%=request.getContextPath() %>/TipAddAction.seed" method="post" ><!-- enctpye:첨부파일 사용시 추가.  enctype="multipart/form-data"-->
		<div style="width:500px;height: 400px; border: solid 1px;">
			<div>글작성</div>
			<div>
				<div id="board_category" style="display: inline-block;">카테고리</div>
				<div style="display: inline-block;">
					<select name="board_category">
						<option>Tip1</option>
						<option>Tip2</option>
					</select>
				</div>
			</div>
			<div>
				<div style="display: inline-block;">제목</div>
				<div style="display: inline-block;"><input name="board_subject" id="board_subject" type="text" size="50" maxlength="100"></div>
			</div>
			<div>
				<div style="display: inline-block;">내용</div>
				<div style="display: inline-block;"><textarea id="board_content" name="board_content" cols="60" rows="15"></textarea></div>
			</div>
			<div>
				<input type="submit" value="작성">
				<input type="reset" value="취소">
			</div>
		</div>
	</form>
</body>
</html>