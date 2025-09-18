package interfaces;

import model.Account;

import java.util.UUID;

public interface AccountInterface {
    public Account create(UUID userId);
}
