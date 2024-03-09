package jw.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao {

    // **�ʵ�**

    private Connection con = null;
    private PreparedStatement pStmt = null;
    private ResultSet rs = null;

    // **������**

    public UserDao() {
    }

    // **�޼ҵ�**
 // **ȸ�� ���� ���**
    public UserVO getUser(UserVO userVO) {

        try {
            // **1�ܰ�: Ŀ�ؼ� ���**
            con = this.connect();

            // **2�ܰ�: SQL ���� �غ�**
            pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id = ? AND pwd = ?");

            // **3�ܰ�: SQL ���ε�**
            pStmt.setString(1, userVO.getId());
            pStmt.setString(2, userVO.getPwd());

            // **4�ܰ�: SQL ���� �� ��� Ȯ��**
            rs = pStmt.executeQuery();

            if (rs.next()) {
                // **ȸ�� ���� ���� ���**
                userVO.setActive(true);
            } else {
                // **ȸ�� ���� ���� ���**
                System.out.println("DB�� <" + userVO.getId() + ">�� �ش��ϴ� �ڷᰡ �����ϴ�.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5�ܰ�: �ڿ� �ݱ�**
            this.close(con, pStmt, rs);
        }

        return userVO;
    }
    
    // **ȸ�� �߰�**
    public boolean addUser(UserVO userVO) {

        boolean insertResult = false;

        try {
            // **1�ܰ�: Ŀ�ؼ� ���**
            con = this.connect();

            // **2�ܰ�: SQL ���� �غ�**
            pStmt = con.prepareStatement("INSERT INTO users (no, id, pwd) VALUES (?, ?, ?)");

            // **3�ܰ�: SQL ���ε�**
            pStmt.setInt(1, userVO.getNo());
            pStmt.setString(2, userVO.getId());
            pStmt.setString(3, userVO.getPwd());

            // **4�ܰ�: SQL ���� �� ��� Ȯ��**
            if (1 == pStmt.executeUpdate()) {
                insertResult = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5�ܰ�: �ڿ� �ݱ�**
            this.close(con, pStmt);
        }

        return insertResult;
    }

    

    // **ȸ�� ��� ���**
    public ArrayList<UserVO> getUserList() {

        ArrayList<UserVO> arrayList = new ArrayList<UserVO>();

        try {
            // **1�ܰ�: Ŀ�ؼ� ���**
            con = this.connect();

            // **2�ܰ�: SQL ���� �غ�**
            pStmt = con.prepareStatement("SELECT no, id, pwd FROM users ORDER BY no ASC");

            // **3�ܰ�: SQL ���� �� ��� Ȯ��**
            rs = pStmt.executeQuery();

            // **4�ܰ�: ��� ó��**
            while (rs.next()) {
                // **�� ȸ�� ���� UserVO ��ü�� ���**
                UserVO userVO = new UserVO();
                userVO.setNo(rs.getInt("no"));
                userVO.setId(rs.getString("id"));
                userVO.setPwd(rs.getString("pwd"));

                // **ArrayList�� �߰�**
                arrayList.add(userVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **5�ܰ�: �ڿ� �ݱ�**
            this.close(con, pStmt, rs);
        }

        return arrayList;
    }
}
