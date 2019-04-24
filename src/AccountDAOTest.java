import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sh.account.AccountDAO;
import com.sh.account.AccountDTO;
import com.sh.util.DBConnector;

public class AccountDAOTest {

	private AccountDAO accountDAO;
	
	@BeforeClass
	public static void start() {
		
	}
	
	@AfterClass
	public static void end() {
		
	}
	@Before
	public void makeDAO() {
		accountDAO = new AccountDAO();
		
	}
	@Test
	public void test() throws Exception{
		Connection conn = DBConnector.getConnection();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNum("1");
		accountDTO.setAccountName("test");
		accountDTO.setId("iu");
		int result = accountDAO.insert(accountDTO, conn);
		
		assertEquals(1, result);
	}
	
	
	@After
	public void after() {
		
		
	}

}
