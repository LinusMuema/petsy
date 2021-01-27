package com.moose.local

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class AppDaoTests {

    private lateinit var database: AppDatabase
    private val animal = Animal(name = "dog", fact ="A random dog fact", listOf("images"))

    @Before
    fun setUp(){
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    }

    @After
    fun tearDown(){
        runBlocking { database.clearAllTables() }
        database.close()
    }

    /**
     * Add an animal object to the db
     * Read the records of the database
     * Assert the list is not empty
     * */
    @Test
    fun add_animal_saves_data(){
        runBlocking {
            database.dao().addAnimal(animal)
            val data = database.dao().getAnimal("dog").toList()
            assert(data.isNotEmpty())
        }
    }

    /**
    * We get a random name out of two: one is valid, the other invalid
    * Populate the db with animal object with name "dog"
    * Get data from db using the random name
    * assert if object is null or not based on the name created
    * */
    @Test
    fun get_animal_returns_correct_value(){
        runBlocking {
            val testName = listOf("dog", "wrong").random()
            database.dao().addAnimal(animal)
            val data = database.dao().getAnimal(testName).first()

            if (testName == "dog") assertNotNull(data)
            else assertNull(data)
        }
    }
}