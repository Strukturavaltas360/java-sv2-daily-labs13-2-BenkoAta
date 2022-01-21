package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TransferAggregator {
    public List<TransferPerClient> readTransfers(Path path) {
        Map<String, TransferPerClient> transfers = readLines(path);
        return mapToList(transfers);
    }

    private Map<String, TransferPerClient> readLines(Path path) {
        TreeMap<String, TransferPerClient> transfers = new TreeMap<String, TransferPerClient>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while (null != (line = reader.readLine())) {
                addTransactionToMap(transfers, line);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Can not read file!");
        }
        return transfers;
    }

    private void addTransactionToMap(Map<String, TransferPerClient> transfers, String line) {
        String parts[] = line.split(",");
        String senderId = parts[0];
        String receiverId = parts[1];
        int amount = Integer.parseInt(parts[2]);
        updateOrCreateTransfer(transfers, senderId, -amount);
        updateOrCreateTransfer(transfers, receiverId, amount);
    }

    private void updateOrCreateTransfer(Map<String, TransferPerClient> transfers, String clientId, int amount) {
        TransferPerClient transferPerClient = transfers.get(clientId);
        if (transferPerClient == null) {
            transferPerClient = new TransferPerClient(clientId, amount);
        } else {
            transferPerClient.addAmount(amount);
        }
        transfers.put(clientId, transferPerClient);
    }

    private List<TransferPerClient> mapToList(Map<String, TransferPerClient> transfers) {
        return transfers.entrySet().stream()
                .map(TransferPerClientEntry -> TransferPerClientEntry.getValue())
                .collect(Collectors.toList());
    }
}
