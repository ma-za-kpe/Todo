package com.maku.todo.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao{

    /*
   * Add a single item in the room database
   * */
    @Insert
    fun insert(todo: Todo)

    /*
   * Update a single item in the room database
   * */
    @Update
    fun update(todo: Todo)

    /*
    * Select a single item in the room database
    * */
    @Query("SELECT * from todo_table WHERE todoId = :key")
    fun get(key: String): Todo?

    /*
    * Delete a single item from the room database
    * */
    @Delete
    fun deleteOne(todo: Todo)

    /*
   * Delete all items from the room database
   * */
    @Query("DELETE FROM todo_table")
    fun clear()

    /*
    * in descending order. Let getAllTodos() return a list of SleepNight as LiveData. Room keeps this LiveData updated for us, and we don't have to specify an observer for it.
    * */
    @Query("SELECT * FROM todo_table ORDER BY todoId DESC")
    fun getAllTodos(): LiveData<List<Todo>>
}