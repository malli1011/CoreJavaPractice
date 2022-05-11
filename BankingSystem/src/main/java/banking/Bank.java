package banking;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {

    private static final AtomicLong accountNumGenerator = new AtomicLong(1);
    private final LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accNum = accountNumGenerator.getAndIncrement();
        Account account = new CommercialAccount(company, accNum, pin, startingDeposit);
        accounts.put(accNum, account);
        return accNum;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accNum = accountNumGenerator.getAndIncrement();
        Account account = new ConsumerAccount(person, accNum, pin, startingDeposit);
        accounts.put(accNum, account);
        return accNum;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.validatePin(pin);
        }
        return false;
    }

    public double getBalance(Long accountNumber) {
        // complete the function
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

    public void credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.debitAccount(amount);
        }
        return false;
    }
}
