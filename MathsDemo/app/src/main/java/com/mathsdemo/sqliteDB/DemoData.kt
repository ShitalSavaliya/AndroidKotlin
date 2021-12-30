package com.mathsdemo.sqliteDB

import android.content.Context
import com.mathsdemo.R

object DemoData {
    fun addDummyData(context : Context): MutableList<Question>{
        val data = mutableListOf<Question>()

        //Number –number and place value
        data.add(Question(
            question = "56 = ___ ten(s) + ___ one(s)",
            answer = "5 and 6",
            option1 = "6 and 6",
            option2 = "5 and 5",
            option3 = "5 and 6",
            option4 = "5 and 10",
            option5 = "10 and 6",
            option6 = "50 and 6",
            option7 = "50 and 06",
            option8 = "6 and 5"
        ))
        data.add(Question(
            question = "___ tens = 40 ones",
            answer = "4",
            option1 = "40",
            option2 = "10",
            option3 = "14",
            option4 = "4",
            option5 = "2",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "9 tens = ___ ones",
            answer = "90",
            option1 = "90",
            option2 = "10",
            option3 = "19",
            option4 = "91",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "87 = ___ ten(s) ___ one(s)",
            answer = "8 and 7",
            option1 = "8 and 7",
            option2 = "8 and 8",
            option3 = "7 and 7",
            option4 = "8 and 70",
            option5 = "80 and 7",
            option6 = "10 and 7",
            option7 = "80 and 07",
            option8 = "8 and 7"
        ))
        data.add(Question(
            question = "8 tens = ___ ones",
            answer = "80",
            option1 = "80 ",
            option2 = "10",
            option3 = "18",
            option4 = "4",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "3 ___ = 30 ones",
            answer = "tens",
            option1 = "ones",
            option2 = "tens",
            option3 = "ten",
            option4 = "two",
            option5 = "three",
            option6 = "four",
            option7 = "five",
            option8 = "13"
        ))


        //Number – addition and subtraction
        data.add(Question(
            question = "7 = ___ – 9",
            answer = "16",
            option1 = "11",
            option2 = "12",
            option3 = "13",
            option4 = "18",
            option5 = "20",
            option6 = "16",
            option7 = "9",
            option8 = "15"
        ))
        data.add(Question(
            question = "9 + ___ = 16",
            answer = "7",
            option1 = "9",
            option2 = "7",
            option3 = "8",
            option4 = "5",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "16 – 7 = __",
            answer = "9",
            option1 = "11",
            option2 = "10",
            option3 = "12",
            option4 = "9",
            option5 = "20",
            option6 = "21",
            option7 = "14",
            option8 = "13"
        ))
        data.add(Question(
            question = "10 = 15 – ___",
            answer = "5",
            option1 = "5",
            option2 = "10",
            option3 = "7",
            option4 = "6",
            option5 = "2",
            option6 = "4",
            option7 = "9",
            option8 = "11"
        ))
        data.add(Question(
            question = "12 = 7 + ___",
            answer = "5",
            option1 = "5",
            option2 = "10",
            option3 = "7",
            option4 = "6",
            option5 = "2",
            option6 = "4",
            option7 = "9",
            option8 = "11"
        ))
        data.add(Question(
            question = "20 – 11 = __",
            answer = "9",
            option1 = "11",
            option2 = "10",
            option3 = "12",
            option4 = "9",
            option5 = "20",
            option6 = "21",
            option7 = "14",
            option8 = "13"
        ))

        //Number – multiplication and division
        data.add(Question(
            question = "5 x 7 = ___",
            answer = "35",
            option1 = "12",
            option2 = "14",
            option3 = "35",
            option4 = "25",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "6 x 1 = ___",
            answer = "6",
            option1 = "1",
            option2 = "6",
            option3 = "60",
            option4 = "12",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "2 x 3 = ___",
            answer = "6",
            option1 = "1",
            option2 = "6",
            option3 = "60",
            option4 = "12",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "8 x 1 = ___",
            answer = "8",
            option1 = "1",
            option2 = "8",
            option3 = "60",
            option4 = "12",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "12 ÷ 6 = ___",
            answer = "2",
            option1 = "1",
            option2 = "8",
            option3 = "2",
            option4 = "12",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))
        data.add(Question(
            question = "50 ÷ 5 = ___",
            answer = "10",
            option1 = "10",
            option2 = "8",
            option3 = "2",
            option4 = "12",
            option5 = "20",
            option6 = "21",
            option7 = "9",
            option8 = "13"
        ))


        //Number – fractions
        data.add(Question(
            question = "When a shape is divided into two equal parts, each part is called a ___.",
            answer = "half",
            option1 = "half",
            option2 = "quarter",
            option3 = "one third",
            option4 = "two half",
            option5 = "three half",
            option6 = "fourth",
            option7 = "fifth",
            option8 = "sixth"
        ))

        data.add(Question(
            question = "When a shape is divided into three equal parts, each part is called a ___.",
            answer = "third",
            option1 = "third",
            option2 = "quarter",
            option3 = "one third",
            option4 = "two half",
            option5 = "three half",
            option6 = "fourth",
            option7 = "fifth",
            option8 = "sixth"
        ))

        data.add(Question(
            question = "When a shape is divided into four equal parts, each part is called a ___.",
            answer = "quarter",
            option1 = "quarter",
            option2 = "whole",
            option3 = "one third",
            option4 = "two half",
            option5 = "three half",
            option6 = "third",
            option7 = "fifth",
            option8 = "sixth"
        ))

        data.add(Question(
            question = "___ =3/1",
            answer = "3",
            option1 = "3",
            option2 = "6",
            option3 = "1",
            option4 = "2",
            option5 = "4",
            option6 = "5",
            option7 = "10",
            option8 = "9"
        ))

        data.add(Question(
            question = "3 =?/2",
            answer = "6",
            option1 = "3",
            option2 = "6",
            option3 = "1",
            option4 = "2",
            option5 = "4",
            option6 = "5",
            option7 = "10",
            option8 = "9"
        ))

        data.add(Question(
            question = "? =8/2",
            answer = "4",
            option1 = "3",
            option2 = "6",
            option3 = "1",
            option4 = "2",
            option5 = "4",
            option6 = "5",
            option7 = "10",
            option8 = "9"
        ))

        //Measurement
        data.add(Question(
            question = "3.5m = ___mm",
            answer = "3500",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))
        data.add(Question(
            question = "___m = 3500mm",
            answer = "3.5",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))

        data.add(Question(
            question = "___kg = 3500gram",
            answer = "3.5",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))

        data.add(Question(
            question = "3.5kg = ___gram",
            answer = "3500",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))
        data.add(Question(
            question = "___l = 3500ml",
            answer = "3.5",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))
        data.add(Question(
            question = "3.5l = ___ml",
            answer = "3500",
            option1 = "35",
            option2 = "35000",
            option3 = "350",
            option4 = "3500",
            option5 = "530",
            option6 = "5300",
            option7 = "3.5",
            option8 = "5.3"
        ))

        //Geometry – properties of shapes
        data.add(Question(
            question = "The faces of qube look like a ___",
            answer = "square",
            option1 = "circle",
            option2 = "square",
            option3 = "triangle",
            option4 = "rectangle",
            option5 = "box",
            option6 = "coin",
            option7 = "line",
            option8 = "half circle"
        ))
        data.add(Question(
            question = "How many faces does a cube have",
            answer = "6",
            option1 = "6",
            option2 = "12",
            option3 = "8",
            option4 = "10",
            option5 = "27",
            option6 = "9",
            option7 = "12",
            option8 = "15"
        ))
        data.add(Question(
            question = "How many edges does a cube have",
            answer = "12",
            option1 = "6",
            option2 = "12",
            option3 = "8",
            option4 = "10",
            option5 = "27",
            option6 = "9",
            option7 = "12",
            option8 = "15"
        ))
        data.add(Question(
            question = "How many vertices does a cube have",
            answer = "8",
            option1 = "6",
            option2 = "12",
            option3 = "8",
            option4 = "10",
            option5 = "27",
            option6 = "9",
            option7 = "12",
            option8 = "15"
        ))
        data.add(Question(
            question = "The number of vertices in a square pyramid is ___.",
            answer = "5",
            option1 = "6",
            option2 = "12",
            option3 = "8",
            option4 = "10",
            option5 = "5",
            option6 = "9",
            option7 = "12",
            option8 = "15"
        ))
        data.add(Question(
            question = "The number of edges in a square pyramid is ___.",
            answer = "8",
            option1 = "6",
            option2 = "12",
            option3 = "8",
            option4 = "10",
            option5 = "5",
            option6 = "9",
            option7 = "12",
            option8 = "15"
        ))
        //Geometry – position and direction
        data.add(Question(
            question = "This arrow '-->' is pointing___.",
            answer = "To the right",
            option1 = "To the left",
            option2 = "To the right",
            option3 = "Straight up",
            option4 = "Straight down",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))

        data.add(Question(
            question = "This arrow '<--' is pointing___.",
            answer = "To the left",
            option1 = "To the left",
            option2 = "To the right",
            option3 = "Straight up",
            option4 = "Straight down",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))
        data.add(Question(
            question = "Identify the type of angle formed at 6 o'clock between the min and hour hands of the clock.",
            answer = "straight",
            option1 = "straight",
            option2 = "right angle",
            option3 = "acute angle",
            option4 = "obtuse angle",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))
        data.add(Question(
            question = "Identify the type of angle formed at 11:15 between the min and hour hands of the clock.",
            answer = "obtuse angle",
            option1 = "straight",
            option2 = "right angle",
            option3 = "acute angle",
            option4 = "obtuse angle",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))

        data.add(Question(
            question = "Identify the type of angle formed at 3 o'clock between the min and hour hands of the clock.",
            answer = "right angle",
            option1 = "straight",
            option2 = "right angle",
            option3 = "acute angle",
            option4 = "obtuse angle",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))
        data.add(Question(
            question = "Identify the type of angle formed at 9 o'clock between the min and hour hands of the clock.",
            answer = "left angle",
            option1 = "straight",
            option2 = "left angle",
            option3 = "acute angle",
            option4 = "obtuse angle",
            option5 = "Straight below",
            option6 = "Straight above",
            option7 = "To the down",
            option8 = "To the up"
        ))
        return  data
    }
}