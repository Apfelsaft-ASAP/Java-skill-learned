package com.sparta.hanghaeboard.service;


import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.dto.BoardResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.User;
import com.sparta.hanghaeboard.jwt.JwtUtil;
import com.sparta.hanghaeboard.repository.BoardRepository;
import com.sparta.hanghaeboard.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto, HttpServletRequest request) {
        //Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에 게시글 작성 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            //요청받은 DTO로 DB에 저장할 객체 만들기
            BoardRequestDto boardRequestDto = new BoardRequestDto();
            boardRequestDto.setTitles(requestDto.getTitles());
            boardRequestDto.setUsername(user.getUsername());
            boardRequestDto.setContents(requestDto.getContents());
            Board board = boardRepository.saveAndFlush(new Board(requestDto, user.getUsername()));

            return new BoardResponseDto(board);
        } else {
            return null;
        }
    }

//    @Transactional
//    public Long update(Long id, BoardRequestDto requestDto, HttpServletRequest request) {
//
//        User user = userInfo(request);
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
//        );
//        if (user.getUsername().equals(board.getUsername())) {
//            board.update(requestDto);
//        } else {
//            throw new IllegalArgumentException("등록한 게시물만 수정할 수 있습니다.");
//        }
//        return new BoardResponseDto(board);

//    @Transactional
//    public Long delteMemo(Long id, String password) {
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        if(!password.equals(board.getPassword())) {
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//
//        boardRepository.deleteById(id);
//        return board.getId();
//    }

//        public Board getBoardByid (Long id){
//            return boardRepository.findById(id).orElseThrow(
//                    () -> new IllegalArgumentException("해당 게시글이 없습니다.")
//            );



    private User userInfo(HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token error");
            }
            //토큰에서 가져온 사용자 정보를 사용하여 DB조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );
            return user;
        } else {
            throw new IllegalArgumentException("해당 토큰값과 일치하는 정보가 없습니다.");
        }
    }
}
