package account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;

import config.AppConfig;
import config.TestConfig;

import entity.Account;
import mapper.AccountMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestAccount {

	@Autowired
	private AccountMapper actMapper;
	
	@Test
	public void testFindAll(){
		PageHelper.startPage(1, 3);
		List<Account> findAll = actMapper.findAll();
		for (Account account : findAll) {
			System.out.println(account);
		}
			}
	
	@Test
	public void testDelete(){
		actMapper.delete(3);
	}
	
	@Test
	public void saveAccounts(){
		List<Account> acts=new ArrayList<>();
		acts.add(new Account("act01","123456",false,new Date(),2000));
		acts.add(new Account("act02","123456",false,new Date(),2000));
		acts.add(new Account("act03","123456",false,new Date(),2000));
		acts.add(new Account("act04","123456",false,new Date(),2000));
		actMapper.saveAccounts(acts);
	}
	/*@Test
	public void findPaged(){
		List<Account> findPaged = actDao.findPaged(0, 4);
		for (Account account : findPaged) {
			System.out.println(account);
		}
	}*/
/*	@Test
	public void findByActNo(){
		Account account = actDao.findByActNo("zs");
			System.out.println(account);
	}*/
	@Test
	public void findById(){
		Account account = actMapper.findById(2);
			System.out.println(account);
	}
	/*@Test
	public void saveOrupdate(){
		Account account = new Account("actact01","123",true,new Date(),3000);
		account.setId(2316);
		actDao.saveOrupdate(account);
	}*/
	@Test
	public void saveMapper(){
		Account account = new Account("10017","123456",false,new Date(),9500);
		actMapper.save(account);
	}
	@Test
	public void deleteMapper(){
		actMapper.delete(2322);
	}
}
