package com.itwill.steam.review;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.steam.game.Game;
import com.itwill.steam.user.LoginCheck;
import com.itwill.steam.user.User;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	//게임리뷰작성
	@PostMapping("review-write")
	public String review_write_action(@RequestParam String uNo,
									  @RequestParam String gNo,
									  @RequestParam String rate,
									  @RequestParam String comment,
									  HttpSession session,
									  RedirectAttributes redirectAttributes) {
		// 로그인 체크
		User user = (User) session.getAttribute("loginUser");//????????문제 생겼었음
		if (user == null) {
			return "redirect:main";
		}
		
		System.out.println(">>>>>>>>review-write>>>>>>>>>>>>>>>>");
		
		Review review = Review.builder().user(User.builder().uNo(Integer.parseInt(uNo)).build())
										.game(Game.builder().gNo(Integer.parseInt(gNo)).build())
										.reviewRecommend(Integer.parseInt(rate))
										.reviewComment(comment)
										.build();
		reviewService.insertGameReview(review);
		redirectAttributes.addAttribute("gNo", gNo);
		
		return "redirect:store-product";
	}
	
	//리뷰수정
	@RequestMapping(value = "/review_update", method = RequestMethod.POST)
	public String review_modify_action(@ModelAttribute("review") Review review, Model model, HttpSession session) {
		
		// 로그인 체크
	    User user = (User) session.getAttribute("loginUser");
	    if (user == null) {
	        return "redirect:main";
	    }
		
		//해당 리뷰의 사용자 정보 가져오기
		User reviewUser = review.getUser();
		
		//로그인한 사용자와 해당 리뷰의 사용자 정보가 동일여부 확인
		if(user.getUNo() != reviewUser.getUNo()) {
			model.addAttribute("msg", "수정 권한이 없습니다.");
			return "";
		}
		//리뷰 수정
		int result = reviewService.updateGameReview(review);
		//리뷰 수정 결과값에 따라 메시지 전송
		if(result == 1) {
			model.addAttribute("msg", "리뷰가 수정되었습니다.");
		} else {
			model.addAttribute("msg", "리뷰가 수정을 실패하였습니다.");		
		}
		return "redirect:store-product";
	}
	
	//리뷰삭제
	@PostMapping("/review_delete")
	public String review_delete_action(@RequestParam("reviewNo") int reviewNo, HttpSession session, Model model) {
		
		// 로그인 체크
	    User user = (User) session.getAttribute("loginUser");
	    if (user == null) {
	        return "redirect:main";
	    }
		

		Review review = new Review();
		review.setReviewNo(reviewNo);
		review.setUser(user);
		
		//유저의 리스트를 가져와서 해당 유저의 리스트에 해당 리뷰가 없다면 오류 메시지 요청
		List<Review> reviews = reviewService.selectByUserNo(user);		
		if (!reviews.contains(review)) {
			model.addAttribute("msg", "삭제 권한이 없습니다.");
			return "redirect:/store-product";
		}
		
		//리뷰 삭제
		int result = reviewService.deleteGameReview(reviewNo);
		if(result == 1) {			
			model.addAttribute("msg", "리뷰 삭제에 성공하였습니다.");
			return "redirect:";
		} else {
			model.addAttribute("msg", "리뷰 삭제에 실패하였습니다.");
			return "redirect:";
		}
	}
	
	//회원번호로 리뷰 찾기
	//userNo는 path variable로 받아옴
	@GetMapping("/review/user/{uNo}")
	//userNo를 변수로 받고 리뷰 조회 결과를 담은 모델을 반환
	public String review_find_user_no(@PathVariable("uNo") int uNo, Model model, HttpSession session) {
		
		// 로그인 체크
		User checkUser = (User) session.getAttribute("loginUser");
	    if (checkUser == null) {
	        return "redirect:main";
	    }
		
	    User user = new User();
	    user.setUNo(uNo);
	    
	    //회원이 작성한 리뷰 목록 조회
	    List<Review> reviews = reviewService.selectByUserNo(user);
	    
	    model.addAttribute("reviews", reviews);
	    
	    return "review_find_user_no";
	}
	
	
	//게임번호로 리뷰 찾기
	@GetMapping("/review/game/{gNo}")
	private String review_find_game_no(@PathVariable("gNo") int gNo, Model model) {
		Game game = new Game();
		game.setGNo(gNo);
		
		List<Review> reviews = reviewService.selectByGameNo(game);
		model.addAttribute("reviews", reviews);
		
		return "review_find_game_no";
	}
	
	//리뷰 최신등록순으로 정렬보기
	@GetMapping("reviews/date-desc")
	public String review_find_date_desc(Model model) {
		
		Game game = new Game();
		game.setGNo(1);
		
		// 최신 등록순 리뷰 목록 조회
	    List<Review> reviews = reviewService.selectByDateDesc(game);
		// 모델에 리뷰 목록 추가
		model.addAttribute("reviews", reviews);
		
		return "";
	}
	
	//리뷰 추천수 내림차순 정렬보기
	private String review_find_like_desc(Model model) {
		Game game = new Game();
	    game.setGNo(1);
	    List<Review> reviews = reviewService.selectByLikeDesc(game);
	    model.addAttribute("reviews", reviews);
	    
		return "store-product";
	}
	
	//리뷰글 좋아요
	public Review updateReviewLike(@PathVariable int reviewNo) {
		// 리뷰글 정보 조회
		Review review = reviewService.selectByReviewNo(reviewNo); 
		// 좋아요 수 증가
		review.setReviewLike(review.getReviewLike() + 1); 
		// DB에 저장
		reviewService.updateGameReview(review); 
		return review;
	}
	
	//리뷰글 싫어요
	public Review updateReviewDislike(@PathVariable int reviewNo) {
		Review review = reviewService.selectByReviewNo(reviewNo); 
		review.setReviewDisLike(review.getReviewDisLike() + 1); 
		reviewService.updateGameReview(review); 
		return review;
	}
}
