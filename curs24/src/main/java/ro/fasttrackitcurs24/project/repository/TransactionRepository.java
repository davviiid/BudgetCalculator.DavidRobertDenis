package ro.fasttrackitcurs24.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackitcurs24.project.transaction.Transaction;
import ro.fasttrackitcurs24.project.transaction.TransactionType;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("select t from Transaction t where t.description like ?1")
    List<Transaction> findAllByDescriptionLike(String pattern);
    // -> SELECT * from transaction where description LIKE '%pattern%'

    //JPQL
    @Query("Select tran from Transaction tran where tran.type=:type")
    List<Transaction> byTypeCustom(@Param("type") TransactionType type);
    //Select tran from Transaction tran where tran.type=:type -> SELECT * from transaction WHERE type=:type

    //Native SQL Query
    @Query(value = "SELECT * FROM transaction t WHERE t.id=:id AND t.description LIKE :pattern", nativeQuery = true)
    Transaction byIdAndDescriptionCustom(@Param("id") int id, @Param("pattern") String pattern);
    //SELECT * transaction t WHERE t.id=7 AND t.description LIKE '%ceva%
}

