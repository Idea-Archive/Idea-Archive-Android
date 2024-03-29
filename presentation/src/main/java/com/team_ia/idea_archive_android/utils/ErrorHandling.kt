package com.team_ia.idea_archive_android.utils

import android.util.Log
import com.team_ia.domain.exception.*

suspend fun Throwable.errorHandling(
    badRequestAction: suspend () -> Unit = {},
    unauthorizedAction: suspend () -> Unit = {},
    forBiddenAction: suspend () -> Unit = {},
    notFoundAction: suspend () -> Unit = {},
    notAcceptableAction: suspend () -> Unit = {},
    timeOutAction: suspend () -> Unit = {},
    conflictAction: suspend () -> Unit = {},
    serverAction: suspend () -> Unit = {},
    unknownAction: suspend () -> Unit = {}
): Event =
    when (this) {
        is BadRequestException -> {
            errorLog("BadRequestException", message)
            badRequestAction()
            Event.BadRequest
        }
        is UnauthorizedException, is NeedLoginException -> {
            errorLog("UnauthorizedException", message)
            unauthorizedAction()
            Event.Unauthorized
        }
        is ForBiddenException -> {
            errorLog("ForBiddenException", message)
            forBiddenAction()
            Event.ForBidden
        }
        is NotFoundException -> {
            errorLog("NotFoundException", message)
            notFoundAction()
            Event.NotFound
        }
        is NotAcceptableException -> {
            errorLog("NotAcceptableException", message)
            notAcceptableAction()
            Event.NotAcceptable
        }
        is TimeOutException -> {
            errorLog("TimeOutException", message)
            timeOutAction()
            Event.TimeOut
        }
        is ConflictException -> {
            errorLog("ConflictException", message)
            conflictAction()
            Event.Conflict
        }
        is ServerException -> {
            errorLog("ServerException", message)
            serverAction()
            Event.Server
        }
        else -> {
            errorLog("UnKnownException", message)
            unknownAction()
            Event.UnKnown
        }
    }

private fun errorLog(tag: String, msg: String?) {
    Log.d("ErrorHandling_$tag", msg ?: "unknown")
}
