package af.faghid;

/*
class shoghl
getteer setter va constructor
esm shoghl, esm karmand ,esm karmand daraye shoghl (magham)
 */

public class Job {
    public Bank bank = new Bank();
    public String[] jobName;
    public String[] jobEmployeesName;
    public String[] employeesName;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String[] getJobName() {
        return jobName;
    }

    public void setJobName(String[] jobName) {
        this.jobName = jobName;
    }

    public String[] getJobEmployeesName() {
        return jobEmployeesName;
    }

    public void setJobEmployeesName(String[] jobEmployeesName) {
        this.jobEmployeesName = jobEmployeesName;
    }

    public String[] getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String[] employeesName) {
        this.employeesName = employeesName;
    }

    public void jobAndEmployee(String jobName, String employeeName) {

    }
}
