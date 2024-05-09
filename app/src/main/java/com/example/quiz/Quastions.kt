package com.example.quiz

class Quastions {
    var quastions = ArrayList<Answer>()
    var answer1 = Answer("а. Бутусов", "б. Кормильцев", "в. Шахрин", "г. Балабанов")
    var answer2 = Answer("а. Егор", "б. Андрей", "в. Джаред", "г. Игорь")
    var answer3 = Answer("а. Сталин", "б. Хрущев", "в. Микоян", "г. Брежнев")
    var rightAnswers = ArrayList<Int>()
    var myAnswer = mutableListOf(7, 7, 7)
    fun addAnswwer(){
        quastions.add(answer1)
        quastions.add(answer2)
        quastions.add(answer3)
    }

    fun addRightAnswer(){
        rightAnswers.add(1)
        rightAnswers.add(0)
        rightAnswers.add(2)
    }

}