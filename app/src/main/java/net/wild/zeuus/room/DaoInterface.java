package net.wild.zeuus.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DaoInterface {

    @Insert
    void insert(Entity entity);

    @Query("SELECT * FROM profile ORDER BY ID DESC LIMIT 1")
    Entity getlastWeDao();

    @Query("SELECT COUNT (*) FROM profile")
    int gethowMuchWeHaveDao();
}
