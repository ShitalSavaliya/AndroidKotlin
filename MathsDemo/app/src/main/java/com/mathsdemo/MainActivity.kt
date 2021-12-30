package com.mathsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mathsdemo.sqliteDB.DBHandler
import com.mathsdemo.sqliteDB.DemoData.addDummyData

class MainActivity : AppCompatActivity() {
    private lateinit var mETUserName: EditText
    private lateinit var mBtnRegister: Button

    private lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        setListener()
        initSQLiteDB()
    }

    private fun initSQLiteDB() {
        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = DBHandler(this)
        if (dbHandler.readCourses().size < 1) {
            // on below line we are calling a method to add new
            // question to sqlite data and pass all our values to it.
            var data = addDummyData(this)
            for (item in data) {
                dbHandler.addNewCourse(item)
            }
        }
    }

    private fun setListener() {
        mBtnRegister.setOnClickListener {
            if (mETUserName.text.isNullOrEmpty()) {
                mETUserName.error = getString(R.string.username_empty)
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("NAME", mETUserName.text.toString().trim())
                startActivity(intent)
                finish()
            }
        }
    }

    private fun initUI() {
        mETUserName = findViewById(R.id.et_username)
        mBtnRegister = findViewById(R.id.btn_register)
    }
}