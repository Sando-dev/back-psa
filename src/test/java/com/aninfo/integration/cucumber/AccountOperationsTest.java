package com.aninfo.integration.cucumber;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Deposit;
import com.aninfo.model.Transaction;
import com.aninfo.model.Withdraw;
import com.aninfo.repository.TransactionRepository;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountOperationsTest extends AccountIntegrationServiceTest {

    private Account account;

    @Autowired
    private TransactionRepository transactionRepository;

    private InsufficientFundsException ife;
    private DepositNegativeSumException dnse;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    @Given("^Account with a balance of (\\d+)$")
    public void account_with_a_balance_of(int balance)  {
        account = createAccount(Double.valueOf(balance));
    }

    @Given("^Account with three deposits (\\d+), (\\d+), (\\d+)$")
    public void account_with_three_deposits(double sum1, double sum2, double sum3)  {
        account = createAccount(Double.valueOf(0));
        account = deposit(account, Double.valueOf(sum1));
        account = deposit(account, Double.valueOf(sum2));
        account = deposit(account, Double.valueOf(sum3));
    }

    @When("^Trying to withdraw (\\d+)$")
    public void trying_to_withdraw(int sum) {
        try {
            account = withdraw(account, Double.valueOf(sum));
        } catch (InsufficientFundsException ife) {
            this.ife = ife;
        }
    }

    @When("^Trying to deposit (.*)$")
    public void trying_to_deposit(int sum) {
        try {
            account = deposit(account, Double.valueOf(sum));
        } catch (DepositNegativeSumException dnse) {
            this.dnse = dnse;
        }
    }

    @When("^Trying to delete transaction number (\\d+)$")
    public void trying_to_delete_transaction_number(int position) {
        Transaction firstTransaction = transactionRepository.findAll().get(position - 1);
        transactionRepository.deleteById(firstTransaction.getId());
    }

    @When("^Trying (\\d+) times to deposit money$")
    public void trying_times_to_deposit_money(int amount) {
        for (int i = 0; i < amount; i++) {
            account = deposit(account, Double.valueOf(100));
        }
    }

    @When("^Depositing (\\d+), (\\d+), (\\d+)$")
    public void trying_to_deposit(int sum1, int sum2, int sum3) {
        account = deposit(account, Double.valueOf(sum1));
        account = deposit(account, Double.valueOf(sum2));
        account = deposit(account, Double.valueOf(sum3));
    }

    @When("^Trying to read transaction number (\\d+)$")
    public void trying_to_read_transaction_number(int position) {
        Transaction firstTransaction = transactionRepository.findAll().get(position - 1);
    }

    @Then("^Account balance should be (\\d+)$")
    public void account_balance_should_be(int balance) {
        assertEquals(Double.valueOf(balance), account.getBalance());
    }

    @Then("^Operation should be denied due to insufficient funds$")
    public void operation_should_be_denied_due_to_insufficient_funds() {
        assertNotNull(ife);
    }

    @Then("^Operation should be denied due to negative sum$")
    public void operation_should_be_denied_due_to_negative_sum() {
        assertNotNull(dnse);
    }

    @Then("^Number of transactions should be (\\d+)$")
    public void number_of_transactions_should_be(int amount) {
        assertEquals(amount, transactionRepository.findAll().size());
    }

    @Then("^Transaction number (\\d+) should be (\\d+)$")
    public void transaction_should_be(int number, double sum) {
        assertEquals(sum, transactionRepository.findAll().get(number - 1).getSum());
    }

    @Then("^Transaction should be deleted$")
    public void transaction_should_be_deleted() {
        assertEquals(8, transactionRepository.findAll().size());
    }

    @And("^Account balance should remain (\\d+)$")
    public void account_balance_should_remain(int balance) {
        assertEquals(Double.valueOf(balance), account.getBalance());
    }

    @And("^Last transaction should be deposit$")
    public void transaction_should_be_deposit() {
        List<Transaction> transactionList = transactionRepository.findAll();
        assertEquals(transactionList.get(transactionList.size() - 1).getClass(), Deposit.class);
    }

    @And("^Last transaction should be withdraw$")
    public void transaction_should_be_withdraw() {
        List<Transaction> transactionList = transactionRepository.findAll();
        assertEquals(transactionList.get(transactionList.size() - 1).getClass(), Withdraw.class);
    }

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}
