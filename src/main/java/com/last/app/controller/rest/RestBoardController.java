package com.last.app.controller.rest;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.last.app.domain.Board;
import com.last.app.model.board.BoardService;


//Rest 형식으로 들어오는 요청을 처리하는 컨트롤러
@RestController
public class RestBoardController {
   private static Logger logger = LoggerFactory.getLogger(RestBoardController.class);
   
   @Inject
   private BoardService boardService;
   
   //게시판 목록 요청
   //요청 URL에는 더이상 동사적 표현은 하지 않는다.
   // rest/board + GET = 게시판 목록 요청
   
   //하나의 컴퓨터에서 여러대의 서버를 서로 접근하려고 할때, 아래의 설정을 해주면 테스트가 가능하다
   @CrossOrigin("http://localhost:3000")
   @RequestMapping(value="/rest/board" , method = RequestMethod.GET, produces = "application/json;charset=utf-8")
   @ResponseBody
   public List<Board> getList(){
      logger.info("요청 테스트");
      
      List boardList = boardService.selectAll();
      
      //결과를 jsp보여주는것이 아니라, 외부의 시스템에서 중립적인 형태의 
      //데이터 제공을 원하므로, json or xml형태로 제공해준다.
      //이때, json문자열 처리를 개발자가 일일이하지않고 spring 프레임웍이
      //자동으로 변환(convert)해주는 기능이 있다.
      //@ResponseBody 이용하면 자동으로 json, xml를 포멧으로 변환해줌
      
      System.out.println("요청테스트2");
      return boardList;
   }
}













