package com.example.myapplication.core

/**
 * Author: Dzhaparov Bekmamat
 */
sealed class UIState<T>(
    val data: T? = null, val message: String? = null
) {
    class Loading<T> : UIState<T>()//класс обработки состояния загрузки
    class Success<T>(data: T?) :
        UIState<T>(data = data)//класс обработки успешного состояния и доступа к данным

    class Error<T>(message: String) :
        UIState<T>(message = message)//класс обработки состояния ошибки и доступ к сообщению об ошибке
}
