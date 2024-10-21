package org.plexus.starship.domain.ports.out;

public interface DeleteStarshipByIdRepositoryPort {
    void execute(long id);
}
