package jw.service.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

/* 
 * FileName : UserDao.java
 *  :: AbstarctDao 공유 회원관리 Service 담당 DAO
*/
public class  UserDao extends AbstractDao{
	
	///Field 
	
	///constructor
	public UserDao(){
	}

	///Method
	public void getUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try{		
			// 1단계 connection
			con = this.connect();
			
            // 2단계 statement 
			pStmt = con.prepareStatement("SELECT id , pwd FROM users WHERE id=? AND pwd=?");
			pStmt.setString(1,userVO.getId());
			pStmt.setString(2,userVO.getPwd());

			//3단계 resultset
			rs = pStmt.executeQuery();
			if(rs.next()){    
				System.out.println("db에서 확인 한 id,pwd ==>: "+userVO.getId()+" : " +userVO.getPwd());
				userVO.setActive(true);
			}else{               
            	System.out.println("db에 < "+userVO.getId()+" >에 해당하는 자료가 없습니다.");
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con, pStmt, rs);
		}
	}//end of getUser()
	
	public boolean addUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		boolean insertResult   = false;
		try{		
			//1단계 connection
			con = this.connect();
			
			//2단계 statement 
			pStmt = con.prepareStatement(	"INSERT " +
																		"INTO users ( no, id, pwd) " +
																		"VALUES( ? , ? , ? )" );
			pStmt.setInt(1,userVO.getNo());
			pStmt.setString(2,userVO.getId());
			pStmt.setString(3,userVO.getPwd());

			//3단계 결과값 확인하기
			if( 1 == pStmt.executeUpdate()){    
				insertResult = true;
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con,pStmt);
		}
		return insertResult; 
	}//end of addUser()



	public ArrayList<UserVO> getUserList(){
		
		ArrayList<UserVO> arrayList = new ArrayList<UserVO>();
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		
		try {
			
			con = this.connect();
			pStmt = con.prepareStatement("SELECT no, id, pwd FROM users ORDER BY no");
			rs = pStmt.executeQuery();
			
				while(rs.next()) {
					
					UserVO userVO = new UserVO();
					userVO.setNo(rs.getInt("no"));
					userVO.setId(rs.getString("id"));
					userVO.setPwd(rs.getString("pwd"));
					
					System.out.println(userVO);
					
					arrayList.add(userVO);
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				this.close(con, pStmt,rs);
			}
			return arrayList;
		}
	}
	
	
