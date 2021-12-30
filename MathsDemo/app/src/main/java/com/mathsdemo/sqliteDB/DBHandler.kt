package com.mathsdemo.sqliteDB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHandler  // creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION_COL + " TEXT,"
                + ANSWER_COL + " TEXT,"
                + OPTION1_COL + " TEXT,"
                + OPTION2_COL + " TEXT,"
                + OPTION3_COL + " TEXT,"
                + OPTION4_COL + " TEXT,"
                + OPTION5_COL + " TEXT,"
                + OPTION6_COL + " TEXT,"
                + OPTION7_COL + " TEXT,"
                + OPTION8_COL + " TEXT)")

        val query2 = ("CREATE TABLE " + USER_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DATETIME_COL + " TEXT,"
                + SCORE_COL + " TEXT)")

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query)
        db.execSQL(query2)
    }

    // this method is use to add new course to our sqlite database.
    fun addNewCourse(
        data : Question
    ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        val db = this.writableDatabase

        // on below line we are creating a
        // variable for content values.
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(QUESTION_COL, data.question)
        values.put(ANSWER_COL, data.answer)
        values.put(OPTION1_COL, data.option1)
        values.put(OPTION2_COL, data.option2)
        values.put(OPTION3_COL, data.option3)
        values.put(OPTION4_COL, data.option4)
        values.put(OPTION5_COL, data.option5)
        values.put(OPTION6_COL, data.option6)
        values.put(OPTION7_COL, data.option7)
        values.put(OPTION8_COL, data.option8)

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values)

        // at last we are closing our
        // database after adding database.
        db.close()
    }
    // this method is use to add new user to our sqlite database.
    fun addNewUser(
        data : User
    ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        val db = this.writableDatabase

        // on below line we are creating a
        // variable for content values.
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, data.name)
        values.put(DATETIME_COL, data.dateTime)
        values.put(SCORE_COL, data.score)

        // after adding all values we are passing
        // content values to our table.
        db.insert(USER_TABLE_NAME, null, values)

        // at last we are closing our
        // database after adding database.
        db.close()
    }

    // we have created a new method for reading all the courses.
    fun readCourses(): MutableList<Question> {
        // on below line we are creating a
        // database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorQuestions: Cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

        // on below line we are creating a new array list.
        val questionList: MutableList<Question> = mutableListOf()

        // moving our cursor to first position.
        if (cursorQuestions.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                questionList.add(
                    Question(
                        cursorQuestions.getString(1),
                        cursorQuestions.getString(2),
                        cursorQuestions.getString(3),
                        cursorQuestions.getString(4),
                        cursorQuestions.getString(5),
                        cursorQuestions.getString(6),
                        cursorQuestions.getString(7),
                        cursorQuestions.getString(8),
                        cursorQuestions.getString(9),
                        cursorQuestions.getString(10)
                    )
                )
            } while (cursorQuestions.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorQuestions.close()
        return questionList
    }

    // we have created a new method for reading all the user data.
    fun readUsers(): MutableList<User> {
        // on below line we are creating a
        // database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorUsers: Cursor = db.rawQuery("SELECT * FROM " + USER_TABLE_NAME, null)

        // on below line we are creating a new array list.
        val userList: MutableList<User> = mutableListOf()

        // moving our cursor to first position.
        if (cursorUsers.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                userList.add(
                    User(
                        cursorUsers.getString(1),
                        cursorUsers.getString(2),
                        cursorUsers.getString(3)
                    )
                )
            } while (cursorUsers.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorUsers.close()
        return userList
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME)
        onCreate(db)
    }

    companion object {
        // creating a constant variables for our database.
        // below variable is for our database name.
        private const val DB_NAME = "mathdb"

        // below int is our database version
        private const val DB_VERSION = 1

        // below variable is for our table name.
        private const val TABLE_NAME = "question"
        private const val USER_TABLE_NAME = "user"

        // below variable is for our id column.
        private const val ID_COL = "id"

        // below variable is for our question column
        private const val QUESTION_COL = "question"

        // below variable for our question answer column.
        private const val ANSWER_COL = "answer"

        // below variable for our question choice columns.
        private const val OPTION1_COL = "option1"
        private const val OPTION2_COL = "option2"
        private const val OPTION3_COL = "option3"
        private const val OPTION4_COL = "option4"
        private const val OPTION5_COL = "option5"
        private const val OPTION6_COL = "option6"
        private const val OPTION7_COL = "option7"
        private const val OPTION8_COL = "option8"

        //below col for user table
        private const val NAME_COL = "name"
        private const val DATETIME_COL = "DateTime"
        private const val SCORE_COL = "score"
    }
}