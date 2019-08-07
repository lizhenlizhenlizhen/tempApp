package account;

import java.util.List;

import org.aspectj.weaver.IUnwovenClassFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;

import config.TestConfig;
import entity.Account;
import service.prototype.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestAccountService {

	@Autowired
	private IAccountService accountService;
	
	@Test
	public void testTransaction(){
		accountService.testTransaction();
	}
	@Test
	public void testFindUsers(){
		List<Account> findAccounts = accountService.findAccounts(12432, 3);
		for (Account account : findAccounts) {
			System.out.println(account);
		}
		
		//页数
		int pages = ((Page<Account>)findAccounts).getPages();
		System.out.println(pages);
		//总页数
		long total = ((Page<Account>)findAccounts).getTotal();
		System.out.println(total);
	}
}
