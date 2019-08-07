package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import dao.prototype.IAccountDao;
import entity.Account;
import mapper.AccountMapper;
import service.prototype.IAccountService;
@Service("accountService")
public class AccountServiceDaoImpl implements IAccountService{

	/*private IAccountDao actDao=new AccountDaoJdbcImpl();*/
	@Autowired
	private IAccountDao actDao;
	@Autowired
	private AccountMapper actMapper;
	@Override
	public void openAccount(Account act) {
		
		
	}

	@Override
	public void cancelAccount(int id) {
		//1.先查询出该账户
		Account act = actDao.findById(id);
		//2.修改账户的可用性
		if(act!=null){
			act.setEnable(false);
			actDao.saveOrupdate(act);
		}
		
	}
/*
	@Override
	public boolean transfer(int fromId, int toId, double money) {
		
		boolean flag=false;
		//1.获取账户
		Account from=actDao.findById(fromId);
		Account to = actDao.findById(toId);
		//2.内存转账
		
		from.setBalance(from.getBalance()-money);
		to.setBalance(to.getBalance()+money);
		Connection conn=null;
		try {
			
			
			//3.
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//开启事务
			actDao.update(conn,from);
			actDao.update(conn,to);
			//模拟异常
			//int n=3/0;
			conn.commit();
			flag=true;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}finally {
			JdbcUtil.close(conn);
		}
		return flag;
		
	}*/
	/*public boolean transfer(int fromID, int toID, double money) {
		Connection con = JdbcUtil.getConnection();
		
		boolean flag= false;
		
		try {
			
			//1.获取账户
			Account from = actDao.findById(fromID);
			Account to = actDao.findById(toID);
			//2.内存转账
			from.setBalance(from.getBalance()-money);
			to.setBalance(to.getBalance()+money);
			//3.更新
			con.setAutoCommit(false);
			actDao.update(con,from);
			//int i=3/0; //--模拟异常
			actDao.update(con,to);
			int i=3/0; //--模拟异常
			con.commit();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(con!=null){
					con.rollback();
					con.setAutoCommit(true);
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(con!=null){
				JdbcUtil.close(con);
			}	
		}
		return flag;
	}
*/

	@Override
	@Transactional //-- 加事务处理标注表示该方法是告诉Spring框架需要事务处理的
	public void testTransaction() {
		//step1
		Account account = new Account("mapper02","123456",false,new Date(),9500);
		actMapper.save(account);
		//模拟异常
		int i=3/0;
		
		//step2
		actMapper.delete(2323);
		
		
	}

	@Override
	public List<Account> findAccounts(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Account> users=actMapper.findAll();
		return users; 
	}

	@Override
	public boolean transfer(int fromId, int toId, double money) {
		// TODO Auto-generated method stub
		return false;
	}

}
