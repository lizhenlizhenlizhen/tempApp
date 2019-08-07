package dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAccountDao;
import entity.Account;

@Repository
public class AccountDaoSpringImpl implements IAccountDao {

	
	@Autowired
	private JdbcTemplate jt;
	
	
	@Override
	public void saveOrupdate(Account act) {
		int id = act.getId();
		String sql=null;
		if(id==0){
			sql="insert into t_account(act_no,password,enable,create_date,balance)" 
					+"values(?,?,?,?,?)";
			jt.update(sql,new Object[]{act.getActNo(),act.getPassword(),
					act.isEnable(),act.getCreateDate(),act.getBalance()});
		}else{
			sql="update t_account set act_no=?,password=?,enable=?"
					+ ",create_date=?,balance=? where id=?";
			jt.update(sql,new Object[]{act.getActNo(),act.getPassword(),
					act.isEnable(),act.getCreateDate(),act.getBalance(),act.getId()});
		}
		
	}

	

	@Override
	public void delete(int id) {
		jt.update("delete from t_account where id=?",new Object[]{id});
		
	}

	@Override
	public void update(Account act) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, Account act) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAccounts(List<Account> acts) {
		String sql="insert into t_account(act_no,password,enable,create_date,balance)" 
				+"values(?,?,?,?,?)";
		List<Object[]>params=new ArrayList<Object[]>();
		for (Account act : acts) {
			Object[] o=new Object[5];
			o[0]=act.getActNo();
			o[1]=act.getPassword();
			o[2]=act.isEnable();
			o[3]=act.getCreateDate();
			o[4]=act.getBalance();
			params.add(o);
		}
		jt.batchUpdate(sql, params);
		
	}

/*	public void saveAccounts2(List<Account> acts) {
		String sql = "insert into t_ebank_account(actNo,password,enable,createDate,balance)"
					+ "values(?,?,?,?,?)";
		jt.batchUpdate(sql,new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, acts.get(i).getActNo());
				ps.setString(2, acts.get(i).getPassword());
				ps.setBoolean(3, acts.get(i).isEnable());
				ps.setString(4, DateUtil.formatDate(acts.get(i).getCreateDate(), "yyyy-MM-dd HH:mm:ss"));
				ps.setDouble(5, acts.get(i).getBalance());
			}
			
			@Override
			public int getBatchSize() {
				return acts.size();
			}
		});
	}*/


	@Override
	public Account findById(int id) {
		return jt.queryForObject("select * from t_account where id=?",
				new Object[]{id},
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public Account findByActNo(String ActNo) {
		return jt.queryForObject("select * from t_account where act_no=?"
				, new Object[]{ActNo},
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findAll() {
		return jt.query("select * from t_account", 
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findPaged(int offset, int pageSize) {
		return jt.query("select * from t_account limit ?,?"
				,new Object[]{offset,pageSize},
				new BeanPropertyRowMapper<Account>(Account.class));
	}
	
	public int totalPages(int pageSize){
		
		return 0;
		
	}

}
