package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SeedAction;
import service.SeedActionForward;
import service.free.FreeAddAction;
import service.free.FreeDetailAction;
import service.free.FreeListAction;
import service.free.FreeModify;
import service.free.FreeModifyAction;
import service.live.LiveAddAction;
import service.live.LiveDelete;
import service.live.LiveDetailAction;
import service.live.LiveListAction;
import service.live.LiveModify;
import service.live.LiveModifyAction;
import service.main.MainAction;
import service.main.MainWeeklyBestList;
import service.member.IdCheckAction;
import service.member.LoginAction;
import service.member.MyPageForm;
import service.member.NameCheckAction;
import service.member.SignOutMemberCourse2;
import service.member.SignOutMemberCourse3;
import service.member.SignUpAction;
import service.member.UpdateMemberInfoCourse2;
import service.member.UpdateMemberInfoCourse3;
import service.news.NewsAddAction;
import service.news.NewsDelete;
import service.news.NewsDetailAction;
import service.news.NewsListAction;
import service.news.NewsModify;
import service.news.NewsModifyAction;
import service.news.NewsReAddAction;
import service.news.NewsReListAction;
import service.qna.AddAction;
import service.qna.CommentAddAction;
import service.qna.CommentDeleteAction;
import service.qna.CommentModifyAction;
import service.qna.DeleteAction;
import service.qna.DetailAction;
import service.qna.HateDownUpdate;
import service.qna.HateUpdate;
import service.qna.LikeDownUpdate;
import service.qna.LikeUpdate;
import service.qna.ListAction;
import service.qna.ModifyAction;
import service.qna.ModifyFormAction;
import service.share.ShareAddAction;
import service.share.ShareDetailAction;
import service.share.ShareListAction;
import service.tip.TipAddAction;
import service.tip.TipDelete;
import service.tip.TipDetailAction;
import service.tip.TipListAction;
import service.tip.TipModify;
import service.tip.TipModifyAction;


/**
 * Servlet implementation class SeedFrontController
 */
@WebServlet("*.seed")
public class SeedFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("requestURI :" + requestURI);
		System.out.println("contextPath :" + contextPath);
		System.out.println("command :" + command);

		SeedAction action = null;
		SeedActionForward forward = null;

		// main 화면 컨트롤러
		if (command.equals("/MainAction.seed")) {
			try {
				action = new MainAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// weekly best (ajax)
		} else if (command.equals("/MainWeeklyBestList.seed")) {
			try {
				action = new MainWeeklyBestList();
				forward = action.execute(request, response);
				// ajax 구현이라 forward == null
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Member (수환)

		if (command.equals("/MemberLogInForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_login_form.jsp");

		} else if (command.equals("/LoginAction.seed")) {
			try {
				action = new LoginAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.contentEquals("/MemberFormAction.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/signup_form.jsp");

		} else if (command.equals("/SignUpAction.seed")) {
			try {
				action = new SignUpAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/IdcheckAction.seed")) {
			try {
				action = new IdCheckAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/MemberLogout.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_logout.jsp");

		} else if (command.equals("/MyPageForm.seed")) {
			try {
				action = new MyPageForm();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/MyPageAction.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_mypage.jsp");

		} else if (command.equals("/UpdateMemberInfoCourse1.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_UpdateMemberInfoCourse1.jsp");

		} else if (command.equals("/UpdateMemberInfoCourse2.seed")) {
			try {
				action = new UpdateMemberInfoCourse2();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/UpdateMemberInfoCourse3.seed")) {
			try {
				action = new UpdateMemberInfoCourse3();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/NameCheckAction.seed")) {
			try {
				action = new NameCheckAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/SignOutMemberCourse1.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_SignOutMemberCourse1.jsp");

		} else if (command.equals("/SignOutMemberCourse2.seed")) {
			try {
				action = new SignOutMemberCourse2();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/SignOutMemberCourse3.seed")) {
			try {
				action = new SignOutMemberCourse3();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// tip ( 승국님 )
		// 글작성

		if (command.equals("/TipAddAction.see"
				+ "d")) {
			try {
				action = new TipAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글작성 폼

		} else if (command.equals("/TipWriteForm.seed")) {

			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("/tip/board_tip_write.jsp");

			// 글 목록
		} else if (command.equals("/TipListAction.seed")) {
			try {
				action = new TipListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 상세 페이지
		} else if (command.equals("/TipDetailAction.seed")) {
			try {
				action = new TipDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정 폼
		} else if (command.equals("/TipModifyAction.seed")) {
			try {
				action = new TipModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정
		} else if (command.equals("/TipModify.seed")) {
			try {
				action = new TipModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 삭제 폼
		} else if (command.equals("/TipDeleteAction.seed")) {
			try {
				forward = new SeedActionForward();
				forward.setRedirect(false);// param 사용하기위해서 false
				forward.setPath("./tip/board_tip_delete.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 삭제
		} else if (command.equals("/TipDelete.seed")) {
			try {
				action = new TipDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// free ( 혜영님 )

		// free write 
		if (command.equals("/FreeAddAction.seed")) {
			try {
				action = new FreeAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// free write form
		} else if (command.equals("/FreeWriteForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./free/free_board_write.jsp");

			// free list
		} else if (command.equals("/FreeListAction.seed")) {
			try {
				action = new FreeListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// free view 
		} else if (command.equals("/FreeDetailAction.seed")) {
			try {
				action = new FreeDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// free modify form 
		} else if (command.equals("/FreeModifyAction.seed")) {
			try {
				action = new FreeModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
			// free modify
		} else if (command.equals("/FreeModify.seed")) {
			try {
				action = new FreeModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		// live ( 유중님 )
		// 글작성 폼	
		if(command.equals("/LiveAddActionForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("/live/live_board_write.jsp");
		if(command.equals("/LiveAddActionForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("/live/live_board_write.jsp");
		// 글작성		
		}else if(command.equals("/LiveAddAction.seed")) {
			try {
				action = new LiveAddAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 글목록	
		}else if(command.equals("/LiveListAction.seed")) {
			try {
				action = new LiveListAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 상세 페이지	
		}else if(command.equals("/LiveDetailAction.seed")) {
			try {
				action = new LiveDetailAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
		}
		//수정 폼	
			
		  }else if(command.equals("/LiveModifyAction.seed")) { 
			 try { action = new LiveModifyAction(); 
			 	 forward = action.execute(request, response);
		  
		  }catch(Exception e) { 
			    e.printStackTrace(); 
		  }
		 
		  // 수정 
		  }else if(command.equals("/LiveModify.seed")) {
		  	 try { action = new LiveModify(); 
		  		 forward = action.execute(request, response); 
		  
		  	 } catch(Exception e) { 
		  		 e.printStackTrace(); 
		  	}
		  	 // 삭제 폼
		  }else if(command.equals("/LiveDeleteAction.seed")) { 
				 try { action = new LiveModifyAction(); 
				 	 forward = action.execute(request, response);
			  
			  }catch(Exception e) { 
				    e.printStackTrace(); 
			  }	 
		  
		  // 삭제 
		  }else if(command.equals("/LiveDelete.seed")) { 
			  try { action = new LiveDelete(); 
			  forward = action.execute(request, response); 
			  
			  } catch(Exception e) { 
				  e.printStackTrace(); }
		  }
			// 글작성		
		}else if(command.equals("/LiveAddAction.seed")) {
				try {
					action = new LiveAddAction();
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			
				
			// 글목록	
			}else if(command.equals("/LiveListAction.seed")) {
				try {
					action = new LiveListAction();
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			// 상세 페이지	
			}else if(command.equals("/LiveDetailAction.seed")) {
				try {
					action = new LiveDetailAction();
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
			}
			//수정 폼	
				
			  }else if(command.equals("/LiveModifyAction.seed")) { 
				 try { action = new LiveModifyAction(); 
				 	 forward = action.execute(request, response);
			  
			  }catch(Exception e) { 
				    e.printStackTrace(); 
			  }
			 
			  // 수정 
			  }else if(command.equals("/LiveModify.seed")) {
			  	 try { action = new LiveModify(); 
			  		 forward = action.execute(request, response); 
			  
			  	 } catch(Exception e) { 
			  		 e.printStackTrace(); 
			  	}
			  	 // 삭제 폼
			  }else if(command.equals("/LiveDeleteAction.seed")) { 
					 try { action = new LiveModifyAction(); 
					 	 forward = action.execute(request, response);
				  
				  }catch(Exception e) { 
					    e.printStackTrace(); 
				  }	 
			  
			  // 삭제 
			  }else if(command.equals("/LiveDelete.seed")) { 
				  try { action = new LiveDelete(); 
				  forward = action.execute(request, response); 
				  
				  } catch(Exception e) { 
					  e.printStackTrace(); }
			 
			  }	
		

		
		
		// share ( 승국님 ) 

		// 글 목록
		if(command.equals("/ShareListAction.seed")) {
			try {
				action = new ShareListAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 글작성 폼
		}else if(command.equals("/ShareWriteForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("/share/board_share_write.jsp");
			
		
		// 글 작성
		}else if(command.equals("/ShareAddAction.seed")) {
			try {
				action = new ShareAddAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 링크	
		}else if(command.equals("/ShareDetailAction.seed")) {
			try {
				action = new ShareDetailAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
		
		
		
		
		// live ( 유중님 ) 
		
    
		// qa ( 수환님 ) 
		if(command.equals("/AddAction.seed")) {

			try {
				action = new AddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/CommentAddAction.seed")) {
			try {
				action = new CommentAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardWrite.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./qna/qna_board_write.jsp");

		} else if (command.equals("/ListAction.seed")) {
			try {
				action = new ListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/DetailAction.seed")) {
			try {
				action = new DetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ModifyFormAction.seed")) {
			try {
				action = new ModifyFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ModifyAction.seed")) {
			try {
				action = new ModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentModifyAction.seed")) {
			try {
				action = new CommentModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/LikeUpdate.seed")) {
			try {
				action = new LikeUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/LikeDownUpdate.seed")) {
			try {
				action = new LikeDownUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/HateUpdate.seed")) {
			try {
				action = new HateUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/HateDownUpdate.seed")) {
			try {
				action = new HateDownUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentDeleteAction.seed")) {
			try {
				action = new CommentDeleteAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/DeleteAction.seed")) {
			try {
				action = new DeleteAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------

		// news 게시판 ( ys )

		// news 게시판 ( 영식 )

		// news write form
		if (command.equals("/NewsAddActionForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./news/board_news_write.jsp");
			// news write
		} else if (command.equals("/NewsAddAction.seed")) {
			try {
				action = new NewsAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// news list
		} else if (command.equals("/NewsListAction.seed")) {
			try {
				action = new NewsListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// news view
		} else if (command.equals("/NewsDetailAction.seed")) {
			try {
				action = new NewsDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// news modify form
		} else if (command.equals("/NewsModifyAction.seed")) {
			try {
				action = new NewsModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {

			}
			// news modify
		} else if (command.equals("/NewsModify.seed")) {
			try {
				action = new NewsModify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// news delete form
		} else if (command.equals("/NewsDeleteAction.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./news/board_news_delete.jsp");
			// news delete
		} else if (command.equals("/NewsDelete.seed")) {
			try {
				action = new NewsDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// news re_write
		} else if (command.equals("/NewsReAddAction.seed")) {
			try {
				action = new NewsReAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// news_re_list
		} else if (command.equals("/NewsReListAction.seed")) {
			try {
				action = new NewsReListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doProcess(request, response);
	}

}
