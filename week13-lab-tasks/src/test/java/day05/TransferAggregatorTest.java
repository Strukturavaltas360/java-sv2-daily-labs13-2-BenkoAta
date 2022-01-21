package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferAggregatorTest {
    TransferAggregator transferAggregator = new TransferAggregator();

    @Test
    void readTransfers() {
        List<TransferPerClient> actual = transferAggregator.readTransfers(Path.of("src/test/resources/day05/transfers.csv"));
        assertEquals(20, actual.size());
        TransferPerClient t0 = actual.get(0);
        assertEquals("067d6428-d42e-47fa-b427-1213737105ae", t0.getClientId());
        assertEquals(7493941, t0.getSum());
        assertEquals(113, t0.getNumberOfTransactions());
        TransferPerClient t19 = actual.get(19);
        assertEquals("f131bc8d-7762-4cae-968c-25190234735a", t19.getClientId());
        assertEquals(4111358, t19.getSum());
        assertEquals(103, t19.getNumberOfTransactions());
        actual.stream().forEach(transferPerClient -> System.out.println(String.format("%s %,12d %10d",
                transferPerClient.getClientId(),
                transferPerClient.getSum(),
                transferPerClient.getNumberOfTransactions())));

    }
}