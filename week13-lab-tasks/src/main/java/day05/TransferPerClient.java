package day05;

import java.util.Objects;

public class TransferPerClient implements Comparable<TransferPerClient> {
    private final String clientId;
    private int sum;
    private int numberOfTransactions;

    public TransferPerClient(String clientId, int amount) {
        this.clientId = clientId;
        addAmount(amount);
    }

    public void addAmount(int amount) {
        sum += amount;
        numberOfTransactions++;
    }

    @Override
    public int compareTo(TransferPerClient o) {
        return clientId.compareTo(o.clientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferPerClient that = (TransferPerClient) o;
        return Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    @Override
    public String toString() {
        return "TransferPerClient{" +
                "clientId='" + clientId + '\'' +
                ", sum=" + sum +
                ", numberOfTransactions=" + numberOfTransactions +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public int getSum() {
        return sum;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }
}
