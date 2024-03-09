package jw.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao {

    // **필드**

    private Connection con = null;
    private PreparedStatement pStmt = null;
    private ResultSet rs = null;

    // **생성자**

    public UserDao() {
    }

    // **메소드**
 // **회원 정보 얻기**
    public UserVO getUser(UserVO userVO) {

        try {
            // **1단계: 커넥션 얻기**
            con = this.connect();

            // **2단계: SQL 실행 준비**
            pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id = ? AND pwd = ?");

            // **3단계: SQL 바인딩**
            pStmt.setString(1, userVO.getId());
            pStmt.setString(2, userVO.getPwd());

            // **4단계: SQL 실행 및 결과 확인**
            rs = pStmt.executeQuery();

            if (rs.next()) {
                // **회원 정보 있을 경우**
                userVO.setActive(true);
            } else {
                // **회원 정보 없을 경우**
                System.out.println("DB에 <" + userVO.getId() + ">에 해당하는 자료가 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5단계: 자원 닫기**
            this.close(con, pStmt, rs);
        }

        return userVO;
    }
    
    // **회원 추가**
    public boolean addUser(UserVO userVO) {

        boolean insertResult = false;

        try {
            // **1단계: 커넥션 얻기**
            con = this.connect();

            // **2단계: SQL 실행 준비**
            pStmt = con.prepareStatement("INSERT INTO users (no, id, pwd) VALUES (?, ?, ?)");

            // **3단계: SQL 바인딩**
            pStmt.setInt(1, userVO.getNo());
            pStmt.setString(2, userVO.getId());
            pStmt.setString(3, userVO.getPwd());

            // **4단계: SQL 실행 및 결과 확인**
            if (1 == pStmt.executeUpdate()) {
                insertResult = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5단계: 자원 닫기**
            this.close(con, pStmt);
        }

        return insertResult;
    }

    

    // **회원 목록 얻기**
    public ArrayList<UserVO> getUserList() {

        ArrayList<UserVO> arrayList = new ArrayList<UserVO>();

        try {
            // **1단계: 커넥션 얻기**
            con = this.connect();

            // **2단계: SQL 실행 준비**
            pStmt = con.prepareStatement("SELECT no, id, pwd FROM users ORDER BY no ASC");

            // **3단계: SQL 실행 및 결과 확인**
            rs = pStmt.executeQuery();

            // **4단계: 결과 처리**
            while (rs.next()) {
                // **각 회원 정보 UserVO 객체에 담기**
                UserVO userVO = new UserVO();
                userVO.setNo(rs.getInt("no"));
                userVO.setId(rs.getString("id"));
                userVO.setPwd(rs.getString("pwd"));

                // **ArrayList에 추가**
                arrayList.add(userVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5단계: 자원 닫기**
            this.close(con, pStmt, rs);
        }

        return arrayList;
    }
}
