package com.maku.todo

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.maku.todo.database.Todo
import com.maku.todo.database.TodoDao
import com.maku.todo.database.TodoDataBase
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/*
* when building the Room, it is helpful to make sure it works before
 * adding the UI.
* */

//@RunWith(AndroidJUnit4::class)
//class TodoDatabaseTest {
//
//
//    private lateinit var todoDao: TodoDao
//    private lateinit var db: TodoDataBase
//
//    @Before
//    fun createDb() {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//        // Using an in-memory database because the information stored here disappears when the
//        // process is killed.
//        db = Room.inMemoryDatabaseBuilder(context, TodoDataBase::class.java)
//            // Allowing main thread queries, just for testing.
//            .allowMainThreadQueries()
//            .build()
//        todoDao = TodoDao
//    }
//
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun insertAndGetNight() {
//        val todo = Todo()
//        todoDao.insert(todo)
//        val tonight = todoDao.get()
//        assertEquals(tonight?.sleepQuality, -1)
//    }
//
//}