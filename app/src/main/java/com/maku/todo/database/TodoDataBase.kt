package com.maku.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
* create an abstract class that extends RoomDatabase
* */

@Database(entities = [Todo::class], version = 1,  exportSchema = false)
abstract class TodoDataBase: RoomDatabase() {

    /*
    * Declare an abstract value that returns the SleepDatabaseDao:
    * */
    abstract val todoDao: TodoDao

    /*
    * define a companion object, allows clients to access the methods for creating or getting the DB without instantiating the class
    * */
    companion object {

        /*
        * declare a private nullable variable INSTANCE for the database.
        * */
        @Volatile
        private var INSTANCE: TodoDataBase? = null

        /*
        * define the getInstance()method with a Context parameter, which will return a reference to the TodoDataBase:
        * */

        fun getInstance(context: Context): TodoDataBase {

            /*
            * add a synchronized{}
            * */
            synchronized(this) {
                var instance = INSTANCE

                /*
                * if there is already a database stored in instance, If instance is null, use the database builder to get a database:
                * */
                if (instance == null) {

                    /*
                    * Invoke Room’s databaseBuilder and supply the context that we passed in, the database class, and a name for the database
                    * */
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDataBase::class.java,
                        "todo_database"
                    )

                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }

}