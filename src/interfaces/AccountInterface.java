package interfaces;

import model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountInterface {
    public Account create(UUID userId);
    public List<Account> getAll();
}

