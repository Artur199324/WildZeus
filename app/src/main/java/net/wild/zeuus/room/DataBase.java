package net.wild.zeuus.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entity.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract DaoInterface daoBase();
}
