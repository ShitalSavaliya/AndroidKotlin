package com.mathsdemo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.series.LineGraphSeries
import android.view.View
import android.widget.Button
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.Viewport
import com.jjoe64.graphview.series.DataPoint
import com.mathsdemo.sqliteDB.DBHandler
import com.mathsdemo.sqliteDB.User


class ScoreActivity : AppCompatActivity() {

    private lateinit var dbHandler: DBHandler
    private lateinit var mBtnQuit: Button
    private lateinit var mBtnStartAgain: Button
    private var user: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        initUI()
        setListener()
        initDB()
        getSQLiteData()
    }

    private fun initUI() {
        mBtnQuit = findViewById(R.id.btn_quit)
        mBtnStartAgain = findViewById(R.id.btn_start_again)
    }

    private fun setListener() {
        mBtnQuit.setOnClickListener {
            finish()
        }
        mBtnStartAgain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun getSQLiteData() {
        // on below line we are calling a method to get data
        // question to sqlite data.
        user = dbHandler.readUsers()
        addChartData()
    }

    private fun initDB() {
        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = DBHandler(this)
    }

    private fun addChartData() {
        val dataPoints : MutableList<DataPoint> = mutableListOf()
        for(item in user){
            dataPoints.add(DataPoint((user.indexOf(item)+1).toDouble(), item.score.toDouble()))
        }

        val graph = findViewById<View>(R.id.graph) as GraphView

        val series: LineGraphSeries<DataPoint> = LineGraphSeries(
            dataPoints.toTypedArray()
        )

        series.title = "Score"
        series.isDrawBackground = true
        series.color = Color.argb(255, 255, 60, 60)
        series.backgroundColor = Color.argb(100, 204, 119, 119)
        series.isDrawDataPoints = true
        series.dataPointsRadius = 15f

        graph.addSeries(series)
        graph.viewport.setMinX(0.0)
        graph.viewport.setMinY(0.0)
        graph.viewport.setMaxY(14.0)

        graph.gridLabelRenderer.gridColor = Color.argb(255, 255, 60, 60)
        graph.gridLabelRenderer.horizontalAxisTitleColor = Color.argb(255, 255, 60, 60)
        graph.gridLabelRenderer.verticalAxisTitleColor = Color.argb(255, 255, 60, 60)
        graph.gridLabelRenderer.verticalLabelsColor = Color.argb(255, 255, 60, 60)
        graph.gridLabelRenderer.horizontalLabelsColor = Color.argb(255, 255, 60, 60)
        graph.gridLabelRenderer.textSize = 50f

        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.isXAxisBoundsManual = true
        // legend
        graph.legendRenderer.isVisible = true
        graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP
    }
}