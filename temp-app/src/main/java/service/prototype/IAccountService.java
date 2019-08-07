package service.prototype;
/**
 * 业务接口
 * @author ZhenLi
 *
 */

import java.util.List;

import entity.Account;

public interface IAccountService {
	//开户
	void openAccount(Account act);
	//2.销户
	void cancelAccount(int id);
	//3.转账
	boolean transfer(int fromId,int toId,double money);
	//4.存钱
	
	void testTransaction();//--演示事务的测试业务方法
	List<Account> findAccounts(int pageNum,int pageSize);
	
}
